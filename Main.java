import java.util.Scanner;
import users.User;
import methods.*;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int option = 0;
        while (option != 3) {
            option = menu();
            options(option);
        }
    }

    private static int menu() {
        System.out.println("""
                ==== MENU ====
                1. Login
                2. Registro
                3. Salir
                \nTeclee una opcion
                """);
        return Integer.parseInt(scanner.nextLine());
    }

    private static void options(int option) {
        switch (option) {
            case 1 -> loginMethod();
            case 2 -> registerMethod();
            case 3 -> {
            }
        }
    }

    private static void loginMethod() {
        System.out.println("==== LOGIN ====");
        System.out.println("Teclee su usuario");
        String username = scanner.nextLine();
        System.out.println("Teclee su password");
        String password = scanner.nextLine();
        if (Login.login(username, password)) {
            System.out.println("Bienvenido!");
            User user = Login.getUser(username);
            System.out.println(user);
        } else
            System.out.println("Credenciales incorrectas");
    }

    private static void registerMethod() {
        System.out.println("==== REGISTRO ====");
        System.out.println("Teclee su nombre");
        String name = scanner.nextLine();
        System.out.println("Teclee un username");
        String username = scanner.nextLine();
        System.out.println("Teclee un password");
        String password = scanner.nextLine();
        System.out.println("Teclee su CURP");
        String curp = scanner.nextLine();
        System.out.println("Teclee su edad");
        int age = Integer.parseInt(scanner.nextLine());
        User user = new User(name, username, password, curp, age);
        Register.register(user);
    }
}
