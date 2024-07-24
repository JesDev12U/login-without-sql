package methods;

import db.DbManager;
import users.User;

public class Login {
    public static boolean login(String username, String password) {
        DbManager db = new DbManager();
        User user = db.getUser(username);
        return user != null && user.getPassword().equals(password);
    }

    public static User getUser(String username) {
        DbManager db = new DbManager();
        return db.getUser(username);
    }
}
