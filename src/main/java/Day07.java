import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;

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
		while (in.hasNextLine()) {
			String lineIn = in.readLine();
			// TODO: the magic happens here...iteratively
		}
		return 0;
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
