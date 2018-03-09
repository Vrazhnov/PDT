package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class DeleteContactFromGroupTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        if (app.db().groups().size() == 0) {
            app.goTo().groupPage();
            app.group().create(new GroupData().withName("test1"));
        }
        if (app.db().contacts().size() == 0) {
            app.goTo().contactPage();
            app.contact().create(new ContactData().withFirstname("test2").withLastname("test3")
                            .withAddress("address").withHomePhone("111").withMobilePhone("222")
                            .withWorkPhone("333").withEmail("email").withEmail2("test5").withEmail3("test6")
                    , true);
        }
    }

    @Test
    public void testDeleteContactFromGroup() {
        ContactData delContact = app.db().contacts().iterator().next();
        Groups before = delContact.getGroups();
        GroupData fromGroup;

        if (before.isEmpty()) {
            fromGroup = app.db().groups().iterator().next();
            app.goTo().contactPage();
            app.contact().addContactToGroup(delContact, fromGroup);
        }
        else {
            fromGroup = before.iterator().next();
        }

        app.goTo().contactPage();
        app.contact().deleteContactFromGroup(delContact, fromGroup);
        Groups after = app.db().contactsId(delContact.getId()).iterator().next().getGroups();
        assertThat(after, equalTo(
                before.withoutContact(delContact, fromGroup)));
    }

}
