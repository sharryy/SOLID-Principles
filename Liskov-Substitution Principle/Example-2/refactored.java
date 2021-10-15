/*
Making Post-Conditions same will abide by Liskov-Substitution principle.
 */

import java.util.HashMap;

public class refactored {
    public static void main(String[] args) {

    }
}

class Database {
    public Object selectQuery(String SQL) {
        /*
        DB Generic Code
         */
        return SQL.toString();
    }
}

class SQLiteDatabase extends Database {

    @Override
    public Object selectQuery(String SQL) {
        /*
        SQLITEDatabase Specific Code
         */

        return SQL.toString();
    }
}

class MySQLDatabase extends Database {

    @Override
    public Object selectQuery(String SQL) {
        /*
        MySQL Specific Code
         */

        return SQL.toString();
    }
}
