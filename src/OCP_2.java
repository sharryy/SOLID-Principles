/*
In this case if we want to add a validator
we don't need to modify existing code. Just add
a class implementing interface and everything is OK.
Class is Open for Extending but closed for
modification.
 */

public class OCP_2 {
    public static void main(String[] args) {
        OrderProcessor orderProcessor = new OrderProcessor();
        String result = orderProcessor.fetchOrderDetails(new OrderValidator(new DuplicateOrderValidator("BD-12"), new SuspendedAccountValidator(12)));
        if (result.isEmpty()) System.out.println("Validation Error");
        else System.out.println(result);
    }
}

interface ValidatorInterface {
    boolean validate();
}

class OrderProcessor {
    public String fetchOrderDetails(OrderValidator validators) {
        boolean result = validators.doValidation();
        if (result) return "DATA";
        else return null;
    }
}

class RecentOrderValidator implements ValidatorInterface {
    public String receipt_no;

    public RecentOrderValidator(String receipt_no) {
        this.receipt_no = receipt_no;
    }

    @Override
    public boolean validate() {
        System.out.println("Validating Recent Order Record..");
//
//        //Fetching Info from DB using receipt-no. to validate recent order..
        return true;
    }
}

class DuplicateOrderValidator implements ValidatorInterface {
    public String receipt_no;

    public DuplicateOrderValidator(String receipt_no) {
        this.receipt_no = receipt_no;
    }

    @Override
    public boolean validate() {
        System.out.println("Validating Duplicate Order Record..");

        //Fetching Info from DB using receipt-no. to validate duplicate order..
        return true;

    }
}

class SuspendedAccountValidator implements ValidatorInterface {
    public int user_id;

    public SuspendedAccountValidator(int user_id) {
        this.user_id = user_id;
    }

    @Override
    public boolean validate() {
        System.out.println("Validating Suspended Account Record..");

//        Fetching Info from DB using receipt -no.to validate duplicate order..
        return true;
    }
}

class OrderValidator {
    public ValidatorInterface[] validatorInterface;

    public OrderValidator(ValidatorInterface... validatorInterface) {
        this.validatorInterface = validatorInterface;
    }

    public boolean doValidation() {
        for (ValidatorInterface anInterface : this.validatorInterface) {
            boolean result = anInterface.validate();
            if (!result) return false;
        }
        return true;
    }
}
