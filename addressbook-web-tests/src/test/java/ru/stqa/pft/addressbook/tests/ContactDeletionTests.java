package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactDeletionTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        if (app.db().contacts().size() == 0) {
            app.goTo().contactPage();
            app.contact().create(new ContactData().withFirstname("test2").withLastname("test3")
                    .withAddress("address").withHomePhone("111").withMobilePhone("222")
                    .withWorkPhone("333").withEmail("email").withEmail2("test5").withEmail3("test6")
                    .withGroup("test1"), true);
        }
    }

    @Test
    public void testContactDeletion() {
//        Contacts before = app.contact().all();
        Contacts before = app.db().contacts();
        ContactData deletedContact = before.iterator().next();
        app.contact().delete(deletedContact);
        app.goTo().contactPage();
        assertThat(app.contact().count(), equalTo(before.size() - 1));
//        Contacts after = app.contact().all();
        Contacts after = app.db().contacts();
        assertThat(after, equalTo(before.without(deletedContact)));
        verifyContactListInUI();
    }

}
