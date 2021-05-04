package task.racingcar;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingCarsTest {

	@Test
	@DisplayName("입력값으로 RacingCars 생성")
	void createRacingCars() {
		RacingCars racingCars = new RacingCars("car1, car2, car3", 1);

		assertThat(racingCars.getRacingCars()).hasSize(3)
				.contains(new RacingCar("car1"), new RacingCar("car2"), new RacingCar("car3"));
		assertThat(racingCars.getTryCount()).isEqualTo(1);
	}

	@Test
	@DisplayName("입력값으로 RacingCars 생성 - 이름이 없을 경우")
	void createRacingCars_emptyNames() {
		assertThatIllegalArgumentException()
				.isThrownBy(() -> new RacingCars(",", 1))
				.withMessage(ErrorMessage.EMPTY_NAMES.getMessage());

	}

	@Test
	@DisplayName("입력값으로 RacingCars 생성 - 이름의 길이가 5초과일 경우")
	void createRacingCars_overNameLength() {
		assertThatIllegalArgumentException()
				.isThrownBy(() -> new RacingCars("ccccccar1, car2", 1))
				.withMessage(ErrorMessage.OVER_NAME_LENGTH.getMessage());

	}

	@Test
	@DisplayName("우승자 확인")
	void getWinnerNames() {
		RacingCar racingCar1 = new RacingCar("car1");
		racingCar1.play(4);
		racingCar1.play(4);
		RacingCar racingCar2 = new RacingCar("car2");
		racingCar2.play(3);
		racingCar2.play(4);

		RacingCars racingCars = new RacingCars(Arrays.asList(racingCar1, racingCar2), 2);

		assertThat(racingCars.getWinnerNames()).isEqualTo("car1");
	}

	@Test
	@DisplayName("우승자 확인 - 2 이상일 경우")
	void getWinnerNames_2() {
		RacingCar racingCar1 = new RacingCar("car1");
		racingCar1.play(4);
		racingCar1.play(4);
		RacingCar racingCar2 = new RacingCar("car2");
		racingCar2.play(3);
		racingCar2.play(4);
		RacingCar racingCar3 = new RacingCar("car3");
		racingCar3.play(5);
		racingCar3.play(5);

		RacingCars racingCars = new RacingCars(Arrays.asList(racingCar1, racingCar2, racingCar3), 2);

		assertThat(racingCars.getWinnerNames()).isEqualTo("car1,car3");
	}
}
