package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.Contact;

public class TestContactDeletion extends TestBase {

    @Test
    public void shouldDeleteContact() {
        app.getContactHelper().deleteContact();
    }


}
