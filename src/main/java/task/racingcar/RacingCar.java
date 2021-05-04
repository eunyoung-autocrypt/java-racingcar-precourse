package task.racingcar;

import java.util.Objects;

public class RacingCar {

	private final String name;
	private int moveCount;
	private final StringBuilder raceState;

	public RacingCar(String name) {
		this.name = name;
		this.raceState = new StringBuilder();
	}

	public void play(int randomNumber) {
		final int LIMIT_NUMBER = 4;
		if (randomNumber >= LIMIT_NUMBER) {
			this.moveCount++;
			this.raceState.append("-");
		}
	}

	public void printRaceState() {
		System.out.println(this.name + " : " + raceState.toString());
	}

	public String getName() {
		return name;
	}

	public int getMoveCount() {
		return moveCount;
	}

	public String getRaceState() {
		return raceState.toString();
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
