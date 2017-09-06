package main.db;

public class PasswordReminder {
    public PasswordReminder(DBConnectionInterface dbConnection) {
        dbConnection.Connect();
    }
}
