package ru.stqa.pft.mantis.tests;

import com.sun.xml.internal.messaging.saaj.packaging.mime.MessagingException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.lanwen.verbalregex.VerbalExpression;
import ru.stqa.pft.mantis.model.MailMessage;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import static org.testng.Assert.assertTrue;

public class ResetPasswordTests extends TestBase {

    @BeforeMethod
    public void startMailServer() {
        app.mail().start();
    }

    @Test
    public void testResetPassword() throws IOException, MessagingException {
        long now = System.currentTimeMillis();
        String username = String.format("user%s", now);
        String user_password = "password";
        String user_email = String.format("user%s@localhost", now);
        app.registration().start(username, user_email);
        List<MailMessage> mailMessages = app.mail().waitForMail(2, 10000);
        String registrationConfirmationLink = findConfirmationLink(mailMessages, user_email);
        app.registration().finish(registrationConfirmationLink, user_password);
        String admin_username = app.getProperty("web.adminLogin").toString();
        String admin_password = app.getProperty("web.adminPassword").toString();
        app.reset().adminEnters(admin_username, admin_password);
        app.reset().resetPassword(username);
        List<MailMessage> newMailMessages = app.mail().waitForMail(2, 10000);
        String resetConfirmationLink = findResetConfirmationLink(newMailMessages, user_email);
        String new_password = "new_password";
        app.reset().finish(resetConfirmationLink, new_password);
        assertTrue(app.newSession().login(username, new_password));
    }

    private String findConfirmationLink(List<MailMessage> mailMessages, String email) {
        MailMessage mailMessage = mailMessages.stream().filter((m) -> m.to.equals(email)).findFirst().get();
        VerbalExpression regex = VerbalExpression.regex().find("http://").nonSpace().oneOrMore().build();
        return regex.getText(mailMessage.text);
    }

    private String findResetConfirmationLink(List<MailMessage> mailMessages, String user_email) {
        MailMessage mailMessage = mailMessages.stream().filter((m) -> m.to.equals(user_email)).collect(Collectors.toList()).get(1);
        VerbalExpression regex = VerbalExpression.regex().find("http://").nonSpace().oneOrMore().build();
        return regex.getText(mailMessage.text);
    }

    @AfterMethod
    public void stopMailServer() {
        app.mail().stop();
    }
}
