import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

public class PhoneContactsTest {
    private PhoneContacts phoneContacts = new PhoneContacts();

    @Test
    public void testAddGroup_success() {
        // given:
        String group1 = "Группа 1";
        String group2 = "Группа 2";
        String group3 = "Группа 3";

        // when:
        phoneContacts.addGroup(group1);
        phoneContacts.addGroup(group2);
        phoneContacts.addGroup(group3);

        // then:
        // Все должно добавиться
        Assertions.assertEquals(3, phoneContacts.getStorage().size());
        // Пробуем добавить существующую группу
        Assertions.assertFalse(phoneContacts.addGroup(group1));
    }

    @Test
    public void testAddContact_success() {
        // given:
        String group1 = "Группа 1";
        String group2 = "Группа 2";
        Contact contact1 = new Contact("Контакт 1", "111111");
        Contact contact2 = new Contact("Контакт 2", "222222");
        Contact contact3 = new Contact("Контакт 3", "333333");

        // when:
        phoneContacts.addGroup(group1);
        phoneContacts.addContact(group1, contact1);
        phoneContacts.addContact(group1, contact2);
        phoneContacts.addContact(group1, contact3);

        // then:
        // Все должно добавиться
        Assertions.assertEquals(3, phoneContacts.getStorage().get(group1).size());
        // Добавляем контакт в несуществующую группу
        Assertions.assertFalse(phoneContacts.addContact(group2, contact3));
        // Добавляем контакт который уже есть в группе
        Assertions.assertFalse(phoneContacts.addContact(group1, contact3));
    }

    @Test
    public void testFindByGroup_success() {
        // given:
        String group1 = "Группа 1";
        String group2 = "Группа 2";

        // when:
        phoneContacts.addGroup(group1);

        // then:
        // Проверяем поиск по группам
        Assertions.assertNotNull(phoneContacts.findByGroup(group1));
        Assertions.assertNull(phoneContacts.findByGroup(group2));
    }

    @Test
    public void testFindByTel_success() {
        // given:
        String group1 = "Группа 1";
        Contact contact1 = new Contact("Контакт 1", "111111");
        String tel1 = contact1.getPhone();
        String tel2 = "222222";
        List groups = new ArrayList();

        // when:
        phoneContacts.addGroup(group1);
        phoneContacts.addContact(group1, contact1);

        // then:
        // Проверяем поиск по телефонам
        Assertions.assertNotNull(phoneContacts.findByTel(tel1, groups));
        Assertions.assertEquals(group1, groups.get(0));
        // Тут телефон не должен быть найден
        Assertions.assertNull(phoneContacts.findByTel(tel2, groups));
    }
}
