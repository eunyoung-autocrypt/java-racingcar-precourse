package task.racingcar;

import java.util.Scanner;

public class RacingCarMain {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
		String carNames = scanner.next();

		System.out.println("시도할 회수는 몇회인가요?");
		int tryCount = scanner.nextInt();

		System.out.println("\n실행결과");
		play(carNames, tryCount);
	}

	public static void play(String carNames, int tryCount) {
		RacingCars racingCars = new RacingCars(carNames, tryCount);
		racingCars.play();
		System.out.println(racingCars.getWinnerNames()+"가 최종 우승했습니다.");
	}
}
