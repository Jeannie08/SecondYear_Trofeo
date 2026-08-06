public class GradeChecker {

    public static void main(String[] args) {
        int[] grades = {60, 85, 90, 70, 76};
        System.out.println("Passing grades:");
        printPassing(grades);
    }

    // Utility method to print passing grades
    public static void printPassing(int[] arr) {
        for (int grade : arr) {
            if (grade >= 75) { // condition: passing
                System.out.println(grade);
            }
        }
    }
}