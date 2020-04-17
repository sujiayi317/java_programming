package com.JiayiSu.methodReferences;

class MyIntNum {
    private int v;
    MyIntNum(int x) {
        v = x;
    }
    int getNum() {return v;}
    boolean isFactor(int n) {return v % n == 0;}
}

class MethodRefToInstanceMethod {
    public static void main(String[] args) {
        boolean result;
        MyIntNum myNum = new MyIntNum(12);
        MyIntNum myNum2 = new MyIntNum(16);

        // Here, a method reference to ifFactor() on myNum is created
        IntPredicate ip = myNum::isFactor;

        // Now, it is used to call isFactor() via test()
        result = ip.test(3);
        if (result) System.out.println("3 is a factor of "+myNum.getNum());

        // This time, a method reference to isFactor() on myNum2 is created and used to call isFactor() via test()
        ip = myNum2::isFactor;
        result = ip.test(3);
        if (! result) System.out.println("3 is not a factor of "+myNum2.getNum());
    }
}