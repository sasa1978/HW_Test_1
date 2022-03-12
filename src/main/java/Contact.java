public class Contact
{
    private String name;
    private String phone;

    public String getPhone() {
        return phone;
    }

    public Contact(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Имя: " + name + ", Телефон: " + phone;
    }
}
