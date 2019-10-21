package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.Contact;

public class TestContactCreation extends TestBase {

    @Test
    public void shouldCreateContactWithValidData() {
        Contact contact = new Contact()
                .setFirstName("tester")
                .setLastName("tester");
        app.getContactHelper().createContact(contact);
        Contact createdContact = app.getContactHelper().getFirstContact();
//        app.getContactHelper().deleteContact();
        Assert.assertEquals(contact, createdContact);
    }

    @Test
    public void shouldDeleteContact() {
        app.getContactHelper().deleteContact();
    }


}
