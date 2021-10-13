/*
In this example, parent and child classes are returning different
inputs like post conditions are different. So they are not
substitutable breaking Liskov-Substitution principle.
 */

import java.util.HashMap;

public class LSP_2 {
    public static void main(String[] args) {

    }
}

class Database {
    public Object selectQuery(String SQL) {
        /*
        DB Generic Code
         */

        String[] strings = new String[10];
        strings[0] = SQL;
        return strings; // <--------- THIS IS PROBLEM
    }
}

class SQLiteDatabase extends Database {

    @Override
    public Object selectQuery(String SQL) {
        /*
        SQLITEDatabase Specific Code
         */

        return SQL.toString(); // <-------- THIS IS WHERE PROBLEM BEGINS
    }
}

class MySQLDatabase extends Database {

    @Override
    public Object selectQuery(String SQL) {
        /*
        MySQL Specific Code
         */

        HashMap<String, String> hashMap = new HashMap();
        hashMap.put("DB", SQL);
        return hashMap; // <---------- THIS CODE IS PROBLEMATIC
    }
}