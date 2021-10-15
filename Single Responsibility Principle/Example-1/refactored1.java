public class refactored {
    public static void main(String[] args) throws Exception {
        SalesReporter salesReporter = new SalesReporter(new SalesRepository(), new AuthChecking(12));
        System.out.println(salesReporter.between(12, 12, new JSONOutput()));
    }
}

class SalesReporter {
    public SalesRepository repo;
    public AuthChecking auth;

    public SalesReporter(SalesRepository repository, AuthChecking auth) {
        this.repo = repository;
        this.auth = auth;
    }

    public String between(int startDate, int endDate, SalesOutputInterface formatter) throws Exception {

        //FIRST CHECKING AUTHENTICATION OF USER
        //IF USER IS NOT AUTHENTICATED THEN THROW SOME ERROR.
        if (!this.auth.isUserLoggedIn()) throw new Exception("Authentication Required for Reporting");

        //SEGREGATING RESPONSIBILITIES OF CLASS
        String data = this.repo.between(startDate, endDate);

        //RETURN DATA TO VIEW
        return formatter.output(data);

    }
}

class SalesRepository {
    public String between(int startDate, int endDate) {
        /*
        DO SOME SQL STUFF HERE.
        QUERY DATABASE FOR GIVEN DATES AND RETURN THE DATA TO USERS.
        SOME SORT OF LIKE
        SELECT * FROM <TABLE> WHERE DATE BETWEEN (STARTDATE, ENDDATE);
        */

        return "DATA";
    }
}

class AuthChecking {
    public int user_id;

    public AuthChecking(int user_id) {
        this.user_id = user_id;
    }

    public boolean isUserLoggedIn() {
        /*
        Use some helpers to determine if user is logged in or not.
        LIKE Auth::check(this.user_id) and return boolean results
        based on that.
         */
        return true;
    }
}

class HTMLOutput implements SalesOutputInterface {

    @Override
    public String output(String data) {
         /*
        FORMAT THE DATA FOR PASSING TO VIEW. LIKE FORMATTING
        DATE TO HUMAN-READABLE OR LIKE THAT..
         */

        return "FORMATTED DATA";
    }
}

class JSONOutput implements SalesOutputInterface {

    @Override
    public String output(String data) {
         /*
        FORMAT THE DATA FOR PASSING TO SOME SORT OF API.
        LIKE FORMATTING
        DATE TO HUMAN-READABLE OR LIKE THAT.
         */

        return "JSON FORMATTED DATA";
    }
}

interface SalesOutputInterface {
    String output(String data);
}
