package main.db;

public class PasswordReminder {
    public PasswordReminder(MySQLConnection dbConnection) {
        dbConnection.Connect();
    }
}
