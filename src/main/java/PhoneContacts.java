import java.util.*;

public class PhoneContacts {
    private Map<String, List<Contact>> storage = new HashMap<>();

    public Map<String, List<Contact>> getStorage() {
        return storage;
    }

    public boolean addGroup(String nameGroup) {
        if (storage.containsKey(nameGroup)) return false;

        storage.put(nameGroup, new ArrayList<>());
        return true;
    }

    public boolean addContact(String nameGroup, Contact contact) {
        List<Contact> contacts = storage.get(nameGroup);
        if (contacts == null || contacts.contains(contact)) return false;
        return contacts.add(contact);
    }

    public List<Contact> findByGroup(String nameGroup) {
        return storage.get(nameGroup);
    }

    public Contact findByTel(String tel, List groups) {
        Contact result = null;

        for (Map.Entry<String, List<Contact>> entry : storage.entrySet()) {
            for (Contact contact : entry.getValue()) {
                if (contact.getPhone().equals(tel)) {
                    result = contact;
                    groups.add(entry.getKey());
                }
            }
        }

        return result;
    }
}