// Use synchronize to control access
class SumArray {

    int sumArray(int[] nums) {    //synchronized
        int sum = 0;
        for (int num : nums) {
            sum += num;
            System.out.println("Running total for " + Thread.currentThread().getName() +
                    " is " + sum);
            try {
                Thread.sleep(10);
            } catch (InterruptedException exc) {
                System.out.println("Thread interrupted.");
            }
        }
        return sum;
    }
}

class MyThread implements Runnable {
    Thread thrd;
    SumArray sa = new SumArray();  // static
    int[] a;
    int answer;

    MyThread(String name, int[] nums) {
        thrd = new Thread(this, name);
        a = nums;
    }

    public static MyThread createAndStart(String name, int[] nums) {
        MyThread myThrd = new MyThread(name, nums);
        myThrd.thrd.start();
        return myThrd;
    }

    public void run() {
        System.out.println(thrd.getName() + " starting. ");
        answer = sa.sumArray(a);
        System.out.println("Sum for " + thrd.getName() + " is " + answer);
        System.out.println(thrd.getName() + " terminating.");
    }
}

class Sync {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        MyThread mt1 = MyThread.createAndStart("child #1", a);
        MyThread mt2 = MyThread.createAndStart("child #2", a);

        try {
            mt1.thrd.join();
            mt2.thrd.join();
        } catch (InterruptedException exc) {
            System.out.println("Main thread interrupted.");
        }
    }
}