import java.sql.SQLData;

/*
Know Just Look at the Refactored Code.
Dependency Inversion States that :

"High-level module should depend upon Abstractions
while low-level module should also depend upon Abstractions
and they both shouldn't depend upon each other.
& Details should depend upon ABSTRACTIONS"

In this piece of code, PASSWORD REMINDER (high-level module)
depends upon CONNECTION INTERFACE (abstraction) while
DBCONNECTION (low-level module) also depends upon
CONNECTION INTERFACE (abstraction). Hence the principle is
not violated.

 */

public class DIP_1 {
}

interface ConnectionInterface {
    boolean connect();
}

class DBConnection implements ConnectionInterface {

    @Override
    public boolean connect() {
        //Implement Connect Method
        return false;
    }
}

class PasswordReminder {

    public PasswordReminder(ConnectionInterface connection) {
        /*
        Connecting to Database and fetching data.
         */
    }
}