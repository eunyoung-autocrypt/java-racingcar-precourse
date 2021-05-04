package task.racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class RacingCarTest {

	@Test
	@DisplayName("play 1번")
	void play() {
		RacingCar racingCar = new RacingCar("car1");
		racingCar.play(4);

		assertThat(racingCar.getMoveCount()).isEqualTo(1);
		assertThat(racingCar.getRaceState()).isEqualTo("-");
	}

	@Test
	@DisplayName("play 2번(go, go)")
	void play_goGo() {
		RacingCar racingCar = new RacingCar("car1");
		racingCar.play(4);
		racingCar.play(4);

		assertThat(racingCar.getMoveCount()).isEqualTo(2);
		assertThat(racingCar.getRaceState()).isEqualTo("--");
	}

	@Test
	@DisplayName("play 2번(go, stop)")
	void play_goStop() {
		RacingCar racingCar = new RacingCar("car1");
		racingCar.play(4);
		racingCar.play(3);

		assertThat(racingCar.getMoveCount()).isEqualTo(1);
		assertThat(racingCar.getRaceState()).isEqualTo("-");
	}

	@Test
	@DisplayName("play 2번(stop, stop)")
	void play_stopStop() {
		RacingCar racingCar = new RacingCar("car1");
		racingCar.play(0);
		racingCar.play(3);

		assertThat(racingCar.getMoveCount()).isEqualTo(0);
		assertThat(racingCar.getRaceState()).isEqualTo("");
	}
}
