public class LargestFinder {
    public static void main(String[] args) {

        int a = 45, b = 78, c = 23;
        int largest;

        if (a >= b && a >= c) {
            largest = a;
        } else if (b >= a && b >= c) {
            largest = b;
        } else {
            largest = c;
        }

        System.out.println("The largest number is: " + largest);
    }
}
