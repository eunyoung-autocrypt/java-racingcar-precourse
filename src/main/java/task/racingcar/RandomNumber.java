package task.racingcar;

import java.util.Random;

public class RandomNumber {
	private final static Random RAND = new Random();
	public final static int RANDOM_BOUND = 10; // 0~9

	public static int generate() {
		return RAND.nextInt(RANDOM_BOUND);
	}
}
