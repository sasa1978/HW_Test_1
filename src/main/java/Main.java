import java.util.*;

class Main {
    public static void main(String[] args) {

        // Создаем телефонную книгу с контактами
        PhoneContacts phoneContacts = new PhoneContacts();

        // Добавляем троечку групп
        Random random = new Random();
        for (int i = 1; i <= 3; i++) {
            if (random.nextBoolean()) {
                String nameGroup = "Группа " + i;
                if (phoneContacts.addGroup(nameGroup)) {
                    System.out.println("Добавлена группа: " + nameGroup);
                }
            }
        }
        System.out.println();

        // Раскидываем по группам контакты случайным образом
        for (int i = 0; i <= 5; i++) {
            Contact contact = new Contact("Контакт " + i, Integer.toString(i).repeat(10));
            List groups = new ArrayList();
            for (String key : phoneContacts.getStorage().keySet()) {
                if (random.nextBoolean()) {
                    if (phoneContacts.addContact(key, contact)) {
                        groups.add(key);
                    }
                }
            }
            if (!groups.isEmpty()) {
                System.out.println(contact + " добавлен в группы: " + groups);
            }
        }
        System.out.println();

        // Проверка поиска по группе
        for (int i = 1; i <= 3; i++) {
            String nameGroup = "Группа " + i;
            List<Contact> contacts = phoneContacts.findByGroup(nameGroup);
            if (contacts != null) {
                System.out.println("Поиск по " + nameGroup);
                if (!contacts.isEmpty()) {
                    for (Contact contact : contacts) System.out.println(contact);
                } else {
                    System.out.println("Контакты не найдены");
                }
            } else {
                System.out.println(nameGroup + " не найдена");
            }
        }
        System.out.println();

        // Проверка поиска по контакту
        for (int i = 0; i <= 5; i++) {
            String tel = Integer.toString(i).repeat(10);
            System.out.println("Поиск по телефону " + tel);
            List groups = new ArrayList();
            Contact contact = phoneContacts.findByTel(tel, groups);
            if (contact != null) {
                System.out.println(contact + ", найден в группах: " + groups);
            } else {
                System.out.println("Контакт не найден");
            }
        }
    }
}
