package ru.stqa.pft.mantis.appmanager;

import org.openqa.selenium.By;

public class ResetPasswordHelper extends HelperBase {

    public ResetPasswordHelper(ApplicationManager app) {
        super(app);
    }

    public void adminEnters(String username, String password) {
        wd.get(app.getProperty("web.baseUrl") + "/login_page.php");
        type(By.name("username"), username);
        click(By.cssSelector("input[value='Login']"));
        type(By.name("password"), password);
        click(By.cssSelector("input[value='Login']"));
    }

    public void resetPassword(String username) {
        click(By.linkText("Manage"));
        click(By.linkText("Manage Users"));
        click(By.linkText(username));
        click(By.xpath("//input[@value='Reset Password']"));
    }

    public void finish(String resetConfirmationLink, String user_password) {
        wd.get(resetConfirmationLink);
        type(By.name("password"), user_password);
        type(By.name("password_confirm"), user_password);
        click(By.cssSelector("input[value='Update User']"));
    }
}
