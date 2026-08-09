/**
 * BigONotations.java
 *
 * A comprehensive Java class demonstrating every major Big O complexity class,
 * each with a concrete, runnable sample function and explanation.
 *
 * Complexities covered:
 *   O(1)        - Constant
 *   O(log n)    - Logarithmic
 *   O(n)        - Linear
 *   O(n log n)  - Linearithmic
 *   O(n²)       - Quadratic
 *   O(n³)       - Cubic
 *   O(2ⁿ)       - Exponential
 *   O(n!)       - Factorial
 */
public class BigONotations {

    // ─────────────────────────────────────────────────────────────────────────
    // O(1) — Constant Time
    // The operation takes the same amount of time regardless of input size.
    // Example: Accessing an element in an array by index.
    // ─────────────────────────────────────────────────────────────────────────
    public static int getFirstElement(int[] arr) {
        // No matter how large the array is, this is always one step.
        return arr[0];
    }

    public static boolean isEven(int n) {
        // Bitwise check — always one operation.
        return (n & 1) == 0;
    }


    // ─────────────────────────────────────────────────────────────────────────
    // O(log n) — Logarithmic Time
    // Input is halved (or divided) at each step. Very efficient for large n.
    // Example: Binary search on a sorted array.
    // ─────────────────────────────────────────────────────────────────────────
    public static int binarySearch(int[] sortedArr, int target) {
        int low = 0;
        int high = sortedArr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2; // avoids integer overflow

            if (sortedArr[mid] == target) {
                return mid;           // Found it
            } else if (sortedArr[mid] < target) {
                low = mid + 1;        // Search right half
            } else {
                high = mid - 1;       // Search left half
            }
        }
        return -1; // Not found
    }


    // ─────────────────────────────────────────────────────────────────────────
    // O(n) — Linear Time
    // Work grows directly proportional to input size.
    // Example: Finding the maximum value in an unsorted array.
    // ─────────────────────────────────────────────────────────────────────────
    public static int findMax(int[] arr) {
        int max = arr[0];

        // Visit every element exactly once — O(n)
        for (int num : arr) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

    public static long sumArray(int[] arr) {
        long sum = 0;
        for (int num : arr) {   // n iterations
            sum += num;
        }
        return sum;
    }


    // ─────────────────────────────────────────────────────────────────────────
    // O(n log n) — Linearithmic Time
    // Efficient sorting algorithms fall here. Divide-and-conquer with a
    // linear merge/combine step.
    // Example: Merge Sort.
    // ─────────────────────────────────────────────────────────────────────────
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;

            mergeSort(arr, left, mid);          // T(n/2)
            mergeSort(arr, mid + 1, right);     // T(n/2)
            merge(arr, left, mid, right);       // O(n) merge step
        }
    }

    // Helper: merges two sorted halves — O(n)
    private static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] leftArr  = new int[n1];
        int[] rightArr = new int[n2];

        System.arraycopy(arr, left,      leftArr,  0, n1);
        System.arraycopy(arr, mid + 1,   rightArr, 0, n2);

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k++] = leftArr[i++];
            } else {
                arr[k++] = rightArr[j++];
            }
        }
        while (i < n1) arr[k++] = leftArr[i++];
        while (j < n2) arr[k++] = rightArr[j++];
    }


    // ─────────────────────────────────────────────────────────────────────────
    // O(n²) — Quadratic Time
    // Nested loops over the same input. Gets slow fast.
    // Example: Bubble Sort / checking all pairs.
    // ─────────────────────────────────────────────────────────────────────────
    public static void bubbleSort(int[] arr) {
        int n = arr.length;

        // Two nested loops — each up to n → O(n²)
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap
                    int temp = arr[j];
                    arr[j]   = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // Find all duplicate pairs in an array — also O(n²)
    public static void printDuplicatePairs(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    System.out.println("Duplicate pair: (" + arr[i] + ", " + arr[j] + ")");
                }
            }
        }
    }


    // ─────────────────────────────────────────────────────────────────────────
    // O(n³) — Cubic Time
    // Triple nested loops. Rare in modern algorithms but appears in naive
    // matrix multiplication or 3-sum problems.
    // Example: Naive matrix multiplication.
    // ─────────────────────────────────────────────────────────────────────────
    public static int[][] multiplyMatrices(int[][] A, int[][] B) {
        int n = A.length;
        int[][] C = new int[n][n];

        // Three nested loops — O(n³)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    C[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        return C;
    }

    // Three-sum: find all triplets that add up to zero — O(n³)
    public static void threeSum(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (arr[i] + arr[j] + arr[k] == 0) {
                        System.out.println("Triplet: [" + arr[i] + ", " + arr[j] + ", " + arr[k] + "]");
                    }
                }
            }
        }
    }


    // ─────────────────────────────────────────────────────────────────────────
    // O(2ⁿ) — Exponential Time
    // Doubles with every additional input element. Only feasible for tiny n.
    // Example: Naive recursive Fibonacci / generating all subsets.
    // ─────────────────────────────────────────────────────────────────────────
    public static long fibonacciExponential(int n) {
        // Each call spawns two more — forms a binary tree of depth n
        if (n <= 1) return n;
        return fibonacciExponential(n - 1) + fibonacciExponential(n - 2);
    }

    // Print all subsets of an array (power set) — 2ⁿ subsets
    public static void printAllSubsets(int[] arr) {
        int n = arr.length;
        int total = (int) Math.pow(2, n); // 2ⁿ subsets

        for (int mask = 0; mask < total; mask++) {
            System.out.print("{ ");
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    System.out.print(arr[i] + " ");
                }
            }
            System.out.println("}");
        }
    }


    // ─────────────────────────────────────────────────────────────────────────
    // O(n!) — Factorial Time
    // The worst common complexity. Generates every possible ordering.
    // Example: Generating all permutations of an array.
    // ─────────────────────────────────────────────────────────────────────────
    public static void generatePermutations(int[] arr, int start) {
        // n! permutations are generated for n elements
        if (start == arr.length - 1) {
            printArray(arr);
            return;
        }

        for (int i = start; i < arr.length; i++) {
            swap(arr, start, i);                         // choose
            generatePermutations(arr, start + 1);        // explore
            swap(arr, start, i);                         // unchoose (backtrack)
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i]   = arr[j];
        arr[j]   = temp;
    }

    private static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) System.out.print(", ");
        }
        System.out.println("]");
    }


    // ─────────────────────────────────────────────────────────────────────────
    // BONUS: O(√n) — Square Root Time
    // Less common but appears in primality tests and some search optimisations.
    // Example: Checking if a number is prime.
    // ─────────────────────────────────────────────────────────────────────────
    public static boolean isPrime(int n) {
        if (n < 2) return false;

        // Only need to check up to √n — if no divisor found by then, it's prime
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }


    // ─────────────────────────────────────────────────────────────────────────
    // main — Quick demo of every function above
    // ─────────────────────────────────────────────────────────────────────────
    public static void main(String[] args) {

        System.out.println("=== O(1) — Constant ===");
        int[] sample = {10, 20, 30, 40, 50};
        System.out.println("First element : " + getFirstElement(sample));
        System.out.println("Is 42 even?   : " + isEven(42));

        System.out.println("\n=== O(log n) — Logarithmic ===");
        int[] sorted = {1, 3, 5, 7, 9, 11, 13};
        System.out.println("Index of 7    : " + binarySearch(sorted, 7));
        System.out.println("Index of 6    : " + binarySearch(sorted, 6));

        System.out.println("\n=== O(n) — Linear ===");
        int[] nums = {4, 2, 9, 1, 7, 3};
        System.out.println("Max value     : " + findMax(nums));
        System.out.println("Sum           : " + sumArray(nums));

        System.out.println("\n=== O(n log n) — Linearithmic ===");
        int[] toSort = {5, 3, 8, 4, 2};
        mergeSort(toSort, 0, toSort.length - 1);
        System.out.print("Merge sorted  : ");
        printArray(toSort);

        System.out.println("\n=== O(n²) — Quadratic ===");
        int[] bubbleArr = {64, 34, 25, 12, 22, 11};
        bubbleSort(bubbleArr);
        System.out.print("Bubble sorted : ");
        printArray(bubbleArr);
        System.out.println("Duplicate pairs in {1,2,3,1,2}:");
        printDuplicatePairs(new int[]{1, 2, 3, 1, 2});

        System.out.println("\n=== O(n³) — Cubic ===");
        int[][] A = {{1, 2}, {3, 4}};
        int[][] B = {{5, 6}, {7, 8}};
        int[][] C = multiplyMatrices(A, B);
        System.out.println("Matrix multiply result: [" + C[0][0] + "," + C[0][1] + "] [" + C[1][0] + "," + C[1][1] + "]");
        System.out.println("3-Sum triplets in {-1,0,1,2,-1,-4}:");
        threeSum(new int[]{-1, 0, 1, 2, -1, -4});

        System.out.println("\n=== O(2ⁿ) — Exponential ===");
        System.out.println("Fibonacci(10) : " + fibonacciExponential(10));
        System.out.println("All subsets of {1,2,3}:");
        printAllSubsets(new int[]{1, 2, 3});

        System.out.println("\n=== O(n!) — Factorial ===");
        System.out.println("All permutations of {1,2,3}:");
        generatePermutations(new int[]{1, 2, 3}, 0);

        System.out.println("\n=== BONUS O(√n) — Square Root ===");
        System.out.println("Is 97 prime?  : " + isPrime(97));
        System.out.println("Is 100 prime? : " + isPrime(100));
    }
}
