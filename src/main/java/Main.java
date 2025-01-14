import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * main
 */
public class Main {

	public static void main(String[] args) {
		
        In testIn = new In("./input_files/day07ex.txt");
//        System.out.println(3749 + " " + Day07.part1R(testIn));

        testIn = new In("./input_files/day07p1.txt");
		Stopwatch wStopwatch = new Stopwatch();
        System.out.println(1582598718861L + " " + Day07.part1R(testIn));
		System.out.println(wStopwatch.elapsedTime());
//		System.out.println(1582598718861L == Day07.part1R(testIn));
	}
}
