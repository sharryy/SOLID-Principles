public class OCP_2 {
    public static void main(String[] args) {
        OrderProcessor orderProcessor = new OrderProcessor();
        String result = orderProcessor.fetchOrderDetails(new RecentOrderValidator("B5.98"), new SuspendedAccountValidator(12));
        if (result.isEmpty()) System.out.println("Validation Error");
        else System.out.println(result);
    }
}

class OrderProcessor {
    public String fetchOrderDetails(Object... validators) {
        //Now we have to manually check each instance
        //and then do correspond action. Using instance of
        //in any case is a dead ringger that we are breaking
        //open-closed principle

        //This enhanced-for loop is basically breaking OCP Principle.
        for (Object validator : validators) {
            if (validator instanceof RecentOrderValidator) {
                if (!((RecentOrderValidator) validator).validate()) break;
            } else if (validator instanceof DuplicateOrderValidator) {
                if (!((DuplicateOrderValidator) validator).validate()) break;
            } else if (validator instanceof SuspendedAccountValidator) {
                if (!((SuspendedAccountValidator) validator).validate()) break;
            }
        }

        //If all  validators are passed, then go and process the order
        //and inform the user.

        return "Data";
    }
}

class RecentOrderValidator {
    public String receipt_no;

    public RecentOrderValidator(String receipt_no) {
        this.receipt_no = receipt_no;
    }

    public boolean validate() {
        System.out.println("Validating Recent Order Record..");

        //Fetching Info from DB using receipt-no. to validate recent order..
        return true;
    }
}

class DuplicateOrderValidator {
    public String receipt_no;

    public DuplicateOrderValidator(String receipt_no) {
        this.receipt_no = receipt_no;
    }

    public boolean validate() {
        System.out.println("Validating Duplicate Order Record..");

        //Fetching Info from DB using receipt-no. to validate duplicate order..
        return true;
    }
}

class SuspendedAccountValidator {
    public int user_id;

    public SuspendedAccountValidator(int user_id) {
        this.user_id = user_id;
    }

    public boolean validate() {
        System.out.println("Validating Suspended Account Record..");

        //Fetching Info from DB using receipt-no. to validate duplicate order..
        return true;
    }
}
