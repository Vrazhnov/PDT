package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class AddContactToGroupTests extends TestBase {

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
    public void testAddContactToGroup() {
        ContactData newContact = app.db().contacts().iterator().next();
        Groups before = newContact.getGroups();
        GroupData inGroup;
        Groups absentGroups = app.db().groups();
        absentGroups.removeAll(before);

        if (absentGroups.isEmpty()) {
            app.goTo().groupPage();
            app.group().create(new GroupData().withName("test1"));
            Groups absentGroups2 = app.db().groups();
            absentGroups2.removeAll(before);
            inGroup = absentGroups2.iterator().next();
        } else {
            inGroup = absentGroups.iterator().next();
        }
        app.goTo().contactPage();
        app.contact().addContactToGroup(newContact, inGroup);
        Groups after = app.db().contactsId(newContact.getId()).iterator().next().getGroups();
        assertThat(after, equalTo(
                    before.withNewContact(newContact, inGroup)));
        }

}
