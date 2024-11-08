
#non recursive
class Fibonacci {

    static void fibo(int N) {
        int num1 = 0, num2 = 1;

        for (int i = 0; i < N; i++) {
            System.out.println(num1 + " ");
            
            int num3 = num1 + num2;  // Calculate the next Fibonacci number
            num1 = num2;             // Move num2 to num1
            num2 = num3;             // Move num3 to num2
        }
    }

    public static void main(String args[]) {
        int N = 19;  // Number of terms to print
        fibo(N);
    }
}

recursive
    class Fibonacci {

    // Recursive function to print the Fibonacci sequence up to N terms
    static int fibo(int n) {
        // Base cases
        if (n <= 1) {
            return n;
        }
        // Recursive case
        return fibo(n - 1) + fibo(n - 2);
    }

    public static void main(String args[]) {
        int N = 19; // Number of terms to print

        // Loop to print each term of the Fibonacci sequence
        for (int i = 0; i < N; i++) {
            System.out.print(fibo(i) + " ");
        }
    }
}
