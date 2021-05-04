package task.racingcar;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

public class RacingCars {
	private final List<RacingCar> racingCars;
	private final int tryCount;

	public RacingCars(List<RacingCar> racingCars, int tryCount) {
		this.racingCars = racingCars;
		this.tryCount = tryCount;
	}

	public RacingCars(String carNames, int tryCount) {
		List<String> splitNames = Arrays.stream(carNames.split(","))
				.map(String::trim)
				.collect(Collectors.toList());

		validateCarNames(splitNames);

		this.racingCars = splitNames.stream().map(RacingCar::new).collect(Collectors.toList());
		this.tryCount = tryCount;
	}

	private void validateCarNames(List<String> carNames) {
		if (carNames.isEmpty()) {
			throw new IllegalArgumentException(ErrorMessage.EMPTY_NAMES.getMessage());
		} else if (hasInvalidCarName(carNames)) {
			throw new IllegalArgumentException(ErrorMessage.OVER_NAME_LENGTH.getMessage());
		}
	}

	private boolean hasInvalidCarName(List<String> splitNames) {
		Optional<String> overNameLimit = splitNames.stream().filter(name -> name.length() > 5).findFirst();
		return overNameLimit.isPresent();
	}

	public void play() {
		for (int count = 0; count < this.tryCount; count++) {
			for (RacingCar racingCar : this.racingCars) {
				racingCar.play(RandomNumber.generate());
				racingCar.printRaceState();
			}
			System.out.println();
		}
	}

	public String getWinnerNames() {
		int maxMove = this.racingCars.stream()
				.mapToInt(RacingCar::getMoveCount).max()
				.orElseThrow(() -> new NoSuchElementException(ErrorMessage.NO_SUCH_MAX_RACE.getMessage()));

		return this.racingCars.stream()
				.filter(car -> car.getMoveCount() == maxMove)
				.map(RacingCar::getName)
				.collect(Collectors.joining(","));
	}

	public List<RacingCar> getRacingCars() {
		return racingCars;
	}

	public int getTryCount() {
		return tryCount;
	}
}
