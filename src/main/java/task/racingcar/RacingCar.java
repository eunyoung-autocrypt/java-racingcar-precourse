package task.racingcar;

import java.util.Objects;

public class RacingCar {

	private final String name;
	private int moveCount;

	public RacingCar(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public int getMoveCount() {
		return moveCount;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		RacingCar racingCar = (RacingCar)o;
		return name.equals(racingCar.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}
}
