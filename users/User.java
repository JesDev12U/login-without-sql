package users;

public class User {
    private String name;
    private String username;
    private String password;
    private String curp;
    private int age;

    public User(String name, String username, String password, String curp, int age) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.curp = curp;
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setCURP(String curp) {
        this.curp = curp;
    }

    public String getCURP() {
        return curp;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return """
                Nombre: %s,
                Usuario: %s,
                Password: %s,
                CURP: %s,
                Edad: %d
                """.formatted(name, username, password, curp, age);
    }
}
