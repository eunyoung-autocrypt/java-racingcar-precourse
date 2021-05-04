package task.racingcar;

public enum ErrorMessage {
	OVER_NAME_LENGTH("이름은 5자 이하만 가능합니다."),
	EMPTY_NAMES("한개 이상의 자동차 이름이 필요합니다."),
	NO_SUCH_MAX_RACE("race의 최대값을 찾을 수 없습니다.")
	;

	private final String message;

	ErrorMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
