import edu.princeton.cs.algs4.In;

public class Day07 {

    private static final String FILE_PATH =
            "./input_files/day07ex.txt";

    public static void main(String[] args) {
        In in = new In(FILE_PATH); // input file
        System.out.println("Iterative result: " + part1I(in));
;
    }

    public static long part1I(In in) {
        long total = 0;

        while (in.hasNextLine()) {
            String line = in.readLine();
            String[] parts = line.split(": ");

            long target = Long.parseLong(parts[0]);
            String[] numStrings = parts[1].split(" ");

            long[] numbers = new long[numStrings.length];
            for (int i = 0; i < numStrings.length; i++) {
                numbers[i] = Long.parseLong(numStrings[i]);
            }

            if (isParseable(numbers, target)) {
                total += target;
            }
        }
        return total;
    }

    private static boolean isParseable(long[] numbers, long target) {
        int n = numbers.length;
        int combinations = (int) Math.pow(2, n - 1); 

        for (int i = 0; i < combinations; i++) {
            long result = numbers[0];
            for (int j = 0; j < n - 1; j++) {
               
                if ((i & (1 << j)) == 0) {
                    result += numbers[j + 1];
                } else {
                    result *= numbers[j + 1];
                }
            }
            if (result == target) {
                return true; 
            }
        }
        return false; 
    }

    public static long part1R(In in) {
        while (in.hasNextLine()) {
            String lineIn = in.readLine();
            // TODO: the magic happens here...recursively. 
        }
        return 0;
    }
}
