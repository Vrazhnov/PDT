package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class ContactModificationTests extends TestBase {

    @Test
    public void testContactModification() {
        app.getNavigationHelper().gotoContactPage();
        if (! app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createContact(new ContactData("test2", "test3", null, null, "test1"), true);
        }
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getContactHelper().selectContact(before.size() - 1);
        app.getContactHelper().initContactModification();
        ContactData contact = new ContactData(before.get(before.size() - 1).getId(), "name", "lastname", "adress", "email", null);
        app.getContactHelper().fillContactForm(contact, false);
        app.getContactHelper().submitContactModification();
        app.getContactHelper().returnToHomePage();
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size());

        before.remove(before.size() - 1);
        before.add(contact);
        Comparator<? super ContactData> byID = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
        before.sort(byID);
        after.sort(byID);
        Assert.assertEquals(before, after);
    }
}
