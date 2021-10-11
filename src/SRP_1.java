/*
In this example, there is too much responsibility on SalesReporter Class.
Why this class should care about Authentication of User or any core DB QUERY.
It should only concern with Data provided to it regardless how.
Furthermore, this class doesn't need to care about formatting as well.
So, this is breaking Single-Responsibility Principle.
 */

public class SRP_1 {
    public static void main(String[] args) throws Exception {
        SalesReporter salesReporter = new SalesReporter();
        salesReporter.between(12, 12);
    }
}

class SalesReporter {
    public String between(int startDate, int endDate) throws Exception {

        //FIRST CHECKING AUTHENTICATION OF USER
        //IF USER IS NOT AUTHENTICATED THEN THROW SOME ERROR.
        if (!Auth::check) throw new Exception("Authentication Required for Reporting");

        String data = queryDBForSalesBetween(startDate, endDate);

        //RETURN DATA TO VIEW
        return format(data);

    }

    private String queryDBForSalesBetween(int startDate, int endDate) {
        /*
        DO SOME SQL STUFF HERE.
        QUERY DATABASE FOR GIVEN DATES AND RETURN THE DATA TO USERS.
        SOME SORT OF LIKE
        SELECT * FROM <TABLE> WHERE DATE BETWEEN (STARTDATE, ENDDATE);
        */

        return "DATA";
    }

    private String format(String unformattedData) {
        /*
        FORMAT THE DATA FOR PASSING TO VIEW. LIKE FORMATTING
        DATE TO HUMAN-READABLE OR LIKE THAT..
         */

        return "FORMATTED DATA";
    }
}
