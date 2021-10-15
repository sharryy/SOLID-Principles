/*
Now by segregating the interface, we have abide by Interface
Segregation principle. And by introducing IOrder Interface
we have also conformed Open-Closed Principle.
 */

public class refactored {
    public static void main(String[] args) {
        Customer customer = new Customer(12);

        /*
        Now the classes have only  accessed relevant methods.
         */
        customer.order(new ComboOrderService());
        customer.order(new BurgerOrderService());
        customer.order(new FriesOrderService());
    }
}


interface IBurger {
    void orderBurger(int quantity);
}

interface IFries {
    void orderFries(int fries);
}

interface IOrder {
    void order(int quantity);
}

class BurgerOrderService implements IBurger, IOrder {

    @Override
    public void orderBurger(int quantity) {
        System.out.println("Received order of " + quantity + " burgers");
    }

    @Override
    public void order(int quantity) {
        this.orderBurger(quantity);
    }
}

class FriesOrderService implements IFries, IOrder {
    @Override
    public void orderFries(int fries) {
        System.out.println("Received order of " + fries + " fries");
    }

    @Override
    public void order(int quantity) {
        this.orderFries(quantity);
    }
}

class ComboOrderService implements IFries, IBurger, IOrder {

    @Override
    public void orderBurger(int quantity) {
        System.out.println("Received order of " + quantity + " burgers");
    }

    @Override
    public void orderFries(int fries) {
        System.out.println("Received order of " + fries + " fries");
    }

    @Override
    public void order(int quantity) {
        this.orderBurger(quantity);
        this.orderFries(quantity);
    }
}

class Customer {
    public int quantity;

    public Customer(int quantity) {
        this.quantity = quantity;
    }

    public void order(IOrder iOrder) {
        iOrder.order(this.quantity);
    }
}
