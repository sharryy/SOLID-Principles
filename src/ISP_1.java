/*
In the correction code, we segregated the bad interface into
different interfaces and implemented to class as their
needs. The other interface which is Manageable Interface is
there to preserve Open-Closed Principle. Since if we don't use
it we have to type check at runtime which methods to call of
which instance.
 */

public class ISP_1 {
    public static void main(String[] args) {
        Captain captain = new Captain();
        captain.manage(new HumanWorker());
        captain.manage(new AndroidWorker());
    }
}

interface WorkableInterface {
    String work();
}

interface SleepableInterface {
    String sleep();
}

interface ManageableInterface {
    void beManaged();
}

class HumanWorker implements WorkableInterface, SleepableInterface, ManageableInterface {

    @Override
    public String work() {
        return "Human Working";
    }

    @Override
    public String sleep() {
        return "Human Sleeping";
    }

    @Override
    public void beManaged() {
        this.work();
        this.sleep();
    }
}

class AndroidWorker implements WorkableInterface, ManageableInterface {
    @Override
    public String work() {
        return "Android Working";
    }

    @Override
    public void beManaged() {
        this.work();
    }
}

class Captain {
    public void manage(ManageableInterface worker) {
        worker.beManaged();
    }
}


