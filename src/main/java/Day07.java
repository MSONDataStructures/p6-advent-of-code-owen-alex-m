import edu.princeton.cs.algs4.In;

public class Day07 {

    private static final String FILE_PATH =
            "./input_files/day07ex.txt";
            // "./input_files/day07p1.txt";

    public static void main(String[] args) {
        In in = new In(FILE_PATH); // input file
        System.out.print(part1I(in));
        System.out.print(part1R(in));
        //System.out.print(part2(in));
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

	public static long targetsHit;

	public static long part1R(In in) {
		targetsHit = 0; // reset because this is a static var
		while (in.hasNextLine()) {
			String[] args = in.readLine().split("[: ]+"); //  regex 

			long target = Long.valueOf(args[0]);
			int[] nums = new int[args.length - 1];

			for (int i = 0; i < nums.length; i++) {
				nums[i] = Integer.valueOf(args[1 + i]);
			}

			targetsHit += (checkIfMakesTarget(target, nums, 0, 0)) ? target : 0;
		}

		return targetsHit;

	}

	public static boolean checkIfMakesTarget(Long target, int[] numbers, int index, long total) {
		if (index == numbers.length) {
			return target == total;
		} else if (total > target) { // no need to keep checking if we are already high enough
			return false;
		} else {
			return
				checkIfMakesTarget(target, numbers, index + 1, total + numbers[index]) ||
				checkIfMakesTarget(target, numbers, index + 1, total * numbers[index]);
		}
	}
}
