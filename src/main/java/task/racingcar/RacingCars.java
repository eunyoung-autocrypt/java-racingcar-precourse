package task.racingcar;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class RacingCars {
	private final List<RacingCar> racingCars;
	private final int tryCount;

	public RacingCars(String carNames, int tryCount) {
		List<String> splitNames = Arrays.stream(carNames.split(","))
				.map(String::trim)
				.collect(Collectors.toList());

		if (splitNames.isEmpty()) {
			throw new IllegalArgumentException(ErrorMessage.EMPTY_NAMES.getMessage());
		} else if (hasInvalidCarName(splitNames)) {
			throw new IllegalArgumentException(ErrorMessage.OVER_NAME_LENGTH.getMessage());
		}

		this.racingCars = splitNames.stream().map(RacingCar::new).collect(Collectors.toList());
		this.tryCount = tryCount;
	}

	private boolean hasInvalidCarName(List<String> splitNames) {
		Optional<String> overNameLimit = splitNames.stream().filter(name -> name.length() > 5).findFirst();
		return overNameLimit.isPresent();
	}

	public List<RacingCar> getRacingCars() {
		return racingCars;
	}

	public int getTryCount() {
		return tryCount;
	}
}
