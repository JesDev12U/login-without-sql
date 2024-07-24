package methods;

import db.DbManager;
import users.User;

public class Register {
    public static void register(User user) {
        DbManager db = new DbManager();
        db.addUser(user, false);
    }
}
