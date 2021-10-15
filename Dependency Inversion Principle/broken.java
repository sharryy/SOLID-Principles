import java.sql.SQLData;

/*
The Password Reminder class does follow Dependency Injection
as we are injecting dependencies of a class in the constructor,
but it violates Dependency Inversion Principle.
WHY THE HELL PASSWORD REMINDER CARE ABOUT DATABASE???????????
IT SHOULD JUST KNOW THAT THERE IS SOME INTERFACE FROM WHERE IT CAN
CONNECT TO DATABASE!!

ONE SINGLE QUESTION : Why password reminder have knowledge about database.
It should not know about these details.

 */

public class broken {
    public static void main(String[] args) {

    }
}


class PasswordReminder {

    public String dbConnection;

    public PasswordReminder(SQLData connection) {
        /*
        Connecting to Database and fetching data.
         */
    }
}
