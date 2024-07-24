package db;

import java.io.File;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import users.User;

public class DbManager {
    private final String DB_PATH = "db/db.txt";
    private File file = new File(DB_PATH);
    private Map<String, User> users = new HashMap<>();

    public DbManager() {
        if (file.exists())
            loadUsers();
        else
            createDb();
    }

    private void createDb() {
        if (file.exists())
            return;
        try {
            PrintWriter output = new PrintWriter(new FileWriter(file));
            output.close();
        } catch (Exception e) {
            System.out.println("Error para crear el archivo " + e.getMessage());
            e.printStackTrace();
        }
    }

    private Map<String, User> loadUsers() {
        Map<String, User> usersLoaded = new HashMap<>();
        try {
            List<String> lines = Files.readAllLines(Paths.get(DB_PATH));
            for (String line : lines) {
                String[] params = line.split(",");
                User user = new User(params[0], params[1], params[2], params[3], Integer.parseInt(params[4]));
                addUser(user, true);
            }
        } catch (Exception e) {
            System.out.println("No se pudo cargar a los usuarios " + e.getMessage());
            e.printStackTrace();
        }

        return usersLoaded;
    }

    public void addUser(User user, boolean init) {
        if (users.containsKey(user.getUsername())) {
            System.out.println("El usuario ya existe!");
            return;
        }

        users.put(user.getUsername(), user);
        if (!init)
            saveUser(user);
    }

    private void saveUser(User user) {
        try {
            File file = new File(DB_PATH);
            if (!file.exists()) {
                System.out.println("No se ha creado la base de datos");
                return;
            }
            PrintWriter writer = new PrintWriter(new FileWriter(file, true));
            writer.println(
                    user.getName() +
                            "," + user.getUsername() +
                            "," + user.getPassword() +
                            "," + user.getCURP() +
                            "," + user.getAge());
            writer.close();
            System.out.println("Usuario guardado con exito");
        } catch (Exception e) {
            System.out.println("Error al tratar de almacenar al usuario " + e.getMessage());
            e.printStackTrace();
        }
    }

    public User getUser(String username) {
        return users.get(username);
    }

}