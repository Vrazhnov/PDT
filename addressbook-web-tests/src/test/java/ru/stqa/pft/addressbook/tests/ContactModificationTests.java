package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactModificationTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        if (app.db().contacts().size() == 0) {
            app.goTo().contactPage();
            app.contact().create(new ContactData().withFirstname("test2").withLastname("test3")
                    .withAddress("address").withHomePhone("111").withMobilePhone("222")
                    .withWorkPhone("333").withEmail("email").withEmail2("test5").withEmail3("test6")
                    , true);
        }
    }

    @Test
    public void testContactModification() {
        Contacts before = app.db().contacts();
        ContactData modifiedContact = before.iterator().next();
//        app.contact().initContactModificationById(modifiedContact.getId());
        ContactData contact = new ContactData()
                .withId(modifiedContact.getId()).withFirstname("name").withLastname("lastname")
                .withAddress("SPb").withHomePhone("1111").withMobilePhone("2222")
                .withWorkPhone("3333").withEmail("email").withEmail2("email2").withEmail3("email3");
        app.goTo().contactPage();
        app.contact().modify(contact);
        Contacts after = app.db().contacts();
        assertThat(app.contact().count(), equalTo(before.size()));
        assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));
        verifyContactListInUI();
    }

}
