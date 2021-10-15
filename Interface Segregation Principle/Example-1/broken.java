/*
In this silly but understandable example, we can see that
human worker needs to work as well needs proper sleep to avoid
exhaustion. But an android worker doesn't need sleep since it is
a machine but according to our design strategy, AndroidWorker class
has to implement sleep() method as respected by the Interface
contract. So this is violation of Interface-Segregation Principle
that a client shouldn't be forced to implement those methods which
is not applicable to him.
 */

public class broken {
    public static void main(String[] args) {
        Captain captain = new Captain();
        captain.manage(new HumanWorker());
        captain.manage(new AndroidWorker());
    }
}

interface WorkerInterface {
    String work();

    String sleep();
}

class HumanWorker implements WorkerInterface {
    @Override
    public String work() {
        return "Human Working";
    }

    @Override
    public String sleep() {
        return "Human Sleeping";
    }
}

class AndroidWorker implements WorkerInterface {

    @Override
    public String work() {
        return "Android Worker Working";
    }

    @Override
    public String sleep() {
        return null;        // <------- THIS IS WHERE PROBLEM BEGINS
    }
}

class Captain {
    public void manage(WorkerInterface worker) {
        worker.work();
        worker.sleep();
    }
}

