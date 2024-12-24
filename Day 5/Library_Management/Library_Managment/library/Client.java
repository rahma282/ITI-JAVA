package library;
/*
   - Create a `Client` class with properties like `id`, `name`, and `email`.
   - Add a method `getClientDetails()` to display client information.
 */
public class Client {
    private int id;
    private String email;
    private String name;

    public Client(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getClientDetails() {
        return "Client ID: " + id + ", Name: " + name + ", Email: " + email;
    }
}
