/*
    An enhanced queue class for characters.
 */

class EnhancedQueue {
    private char[] q;  // this array holds the queue
    private int putloc, getloc;  // the put and get indices

    EnhancedQueue(int size) {
        q = new char[size];  //allocate memory for queue
        putloc = getloc = 0;
    }

    // put a character into the queue
    void put(char ch) {
        if (putloc == q.length) {
            System.out.println(" - Queue is full.");
            return;
        }

        q[putloc++] = ch;
    }

    // get a character from the queue
    char get() {
        if (getloc == putloc) {
            System.out.println(" - Queue is empty.");
            return (char) 0;
        }

        return q[getloc++];
    }
}

// Demonstrate the Queue class.
class EnhancedQDemo {
    public static void main(String[] args) {
        EnhancedQueue bigQ = new EnhancedQueue(100);
        EnhancedQueue smallQ = new EnhancedQueue(4);
//        EnhancedQueue test = new EnhancedQueue(10);
        char ch;
        int i;

//        test.q[0] = 99;  // Wrong!
//        test.putloc = -100;  // Won't work!

        System.out.println("Using bigQ to store the alphabet.");
        // put some numbers into bigQ
        for (i = 0; i<26; i++)
            bigQ.put((char) ('A'+i));

        //retrieve and display elements from bigQ
        System.out.print("Contents of bigQ: ");
        for (i=0; i<26; i++) {
            ch = bigQ.get();
            if (ch != (char) 0) System.out.print(ch);
        }
        System.out.println();

        // Using smallQ to generate errors.
        System.out.println("Using smallQ to generate errors. ");
        for (i=0; i<5; i++) {
            System.out.print("Attempting to store " + (char) ('Z' - i));
            smallQ.put((char) ('Z' - i));
            System.out.println();
        }

        // more errors on smallQ
        System.out.print("Contents of smallQ: ");
        for (i=0; i<5; i++) {
            ch = smallQ.get();
            if (ch != (char) 0) System.out.print(ch);
        }
    }
}