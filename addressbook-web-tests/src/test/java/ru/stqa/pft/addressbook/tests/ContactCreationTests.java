package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {

    @DataProvider
    public Iterator<Object[]> validContacts() {
        List<Object[]> list = new ArrayList<Object[]>();
        File photo = new File("src/test/resources/stru.jpg");
        list.add(new Object[] {new ContactData().withFirstname("name 1").withLastname("lastname 1")
                .withAddress("address 1").withHomePhone("1111").withMobilePhone("2221")
                .withWorkPhone("3331").withEmail("email11").withEmail2("email21").withEmail3("email31")
                .withPhoto(photo).withGroup("test1")});
        list.add(new Object[] {new ContactData().withFirstname("name 2").withLastname("lastname 2")
                .withAddress("address 2").withHomePhone("1112").withMobilePhone("2222")
                .withWorkPhone("3332").withEmail("email12").withEmail2("email22").withEmail3("email32")
                .withPhoto(photo).withGroup("test1")});
        list.add(new Object[] {new ContactData().withFirstname("name 3").withLastname("lastname 3")
                .withAddress("address 3").withHomePhone("1113").withMobilePhone("2223")
                .withWorkPhone("3333").withEmail("email13").withEmail2("email23").withEmail3("email33")
                .withPhoto(photo).withGroup("test1")});
        return list.iterator();
    }

    @Test(dataProvider = "validContacts")
    public void testContactCreation(ContactData contact) {
        app.goTo().contactPage();
        Contacts before = app.contact().all();
        app.contact().create(contact, true);
        assertThat(app.contact().count(), equalTo(before.size() + 1));
        Contacts after = app.contact().all();
        assertThat(after, equalTo(
                before.withAdded(contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
    }
}


/*    @Test
    public void testBadContactCreation() {
        app.goTo().contactPage();
        Contacts before = app.contact().all();
        ContactData contact = new ContactData().withFirstname("test2'").withLastname("test3'")
                .withAddress("address").withHomePhone("111").withMobilePhone("222")
                .withWorkPhone("333").withEmail("test4").withEmail2("test5").withEmail3("test6")
                .withGroup("test1");
        app.contact().create(contact, true);
        assertThat(app.contact().count(), equalTo(before.size()));
        Contacts after = app.contact().all();
        assertThat(after, equalTo(before));
    }

    @Test
    public void testCurrentDir() {
        File currentDir = new File(".");
        System.out.println(currentDir.getAbsolutePath());
        File photo = new File("src/test/resources/stru.jpg");
        System.out.println(photo.getAbsolutePath());
        System.out.println(photo.exists());
    }
*/
//}