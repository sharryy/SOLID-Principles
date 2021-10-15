/*
In this example, the interface contains many methods which are futile
to other classes. This breaks Interface-Segregation Principle, Open-Closed
Principle as we are type checking and also Liskov Substitution principle.
Since we are introducing exceptions in child classes. So we can't safely
replace Abstraction with Implementations.
 */

public class broken {
    public static void main(String[] args) {
        Customer customer = new Customer();

        /*
        Now this BurgerOrderService shouldn't have access to orderFries
        method. Since this order doesn't involve ordering fries. So we
        have to apply Interface-Segregation Principle.
         */
        customer.order(new BurgerOrderService().orderFries());
    }
}


interface OrderService {
    void orderBurger(int quantity);

    void orderFries(int fries);

    void orderCombo(int quantity, int fries);
}

class BurgerOrderService implements OrderService {

    @Override
    public void orderBurger(int quantity) {
        System.out.println("Received order of " + quantity + " burgers");
    }

    @Override
    public void orderFries(int fries) {
        throw new UnsupportedOperationException("No fries in burger only order"); // <---- Client Don't Need Methods of the Interface
    }

    @Override
    public void orderCombo(int quantity, int fries) {
        throw new UnsupportedOperationException("No combo in burger only order"); // <---- Client Don't Need Methods of the Interface
    }
}

class FriesOrderService implements OrderService {

    @Override
    public void orderBurger(int quantity) {
        throw new UnsupportedOperationException("No burgers in fries only order"); // <---- Client Don't Need Methods of the Interface
    }

    @Override
    public void orderFries(int fries) {
        System.out.println("Received order of " + fries + " fries");
    }

    @Override
    public void orderCombo(int quantity, int fries) {
        throw new UnsupportedOperationException("No combo in fries only order"); // <---- Client Don't Need Methods of the Interface
    }
}

class ComboOrderService implements OrderService {

    @Override
    public void orderBurger(int quantity) {
        throw new UnsupportedOperationException("No burger only in combo order"); // <---- Client Don't Need Methods of the Interface
    }

    @Override
    public void orderFries(int fries) {
        throw new UnsupportedOperationException("No fries only in combo order"); // <---- Client Don't Need Methods of the Interface
    }

    @Override
    public void orderCombo(int quantity, int fries) {
        System.out.println("Served Burger and Fries");
    }
}

class Customer {
    public void order(OrderService orderService) {

        /*
        Breaking Open-Closed Principle
         */
        if (orderService instanceof BurgerOrderService) {
            //Handle Exceptions Accordingly.
        } else if (orderService instanceof FriesOrderService) {
            //Handle Exceptions Accordingly
        }
    }
}
