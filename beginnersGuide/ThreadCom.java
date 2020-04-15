class TickTock {
    String state;
    synchronized void tick(boolean running) {
        if (!running) {
            state = "ticked";
            notify();
            return;
        }
        System.out.print("Tick ");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException exc) {
            System.out.println("Thread interrupted");
        }
        state = "ticked";
        notify();
        try {
            while (!state.equals("tocked"))
                wait();  // wait for tock() to complete
        } catch (InterruptedException exc) {
            System.out.println("Thread interrupted");
        }
    }

    synchronized void tock(boolean running) {
        if (!running) {
            state = "tocked";
            notify();
            return;
        }
        System.out.println("Tock");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException exc) {
            System.out.println("Thread interrupted");

        }
        state = "tocked";
        notify();
        try {
            while (!state.equals("ticked"))
                wait(); // wait for tick() to complete

        } catch (InterruptedException exc) {
            System.out.println("Thread interrupted");
        }
    }
}

class MyThreadCom implements Runnable {
    Thread thrd;
    TickTock ttOb;

    MyThreadCom(String name, TickTock tt) {
        thrd = new Thread(this, name);
        ttOb = tt;
    }

    public static MyThreadCom createAndStart(String name, TickTock tt) {
        MyThreadCom myThrd = new MyThreadCom(name, tt);
        myThrd.thrd.start();
        return myThrd;
    }

    // entry point of thread
    public void run() {
        if (thrd.getName().compareTo("Tick") == 0) {
            for (int i = 0; i < 5; i++) ttOb.tick(true);
            ttOb.tick(false);
        }
        else {
            for (int i = 0; i < 5; i++) ttOb.tock(true);
            ttOb.tock(false);
        }
    }
}

class ThreadCom {
    public static void main(String[] args) {
        TickTock tt = new TickTock();
        MyThreadCom mt1 = MyThreadCom.createAndStart("Tick", tt);
        MyThreadCom mt2 = MyThreadCom.createAndStart("Tock", tt);

        try {
            mt1.thrd.join();
            mt2.thrd.join();
        } catch (InterruptedException exc) {
            System.out.println("Main thread interrupted");
        }
    }
}