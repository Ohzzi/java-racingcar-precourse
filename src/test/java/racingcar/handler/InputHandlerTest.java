package racingcar.handler;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.jupiter.api.Test;

class InputHandlerTest {
	private static final String ERROR = "[ERROR]";

	@Test
	void 콤마로_시작() {
		// given
		String input = ",Kim,Lee";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);

		// when, then
		assertThatThrownBy(InputHandler::getNameInput)
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining(ERROR);
	}

	@Test
	void 콤마로_끝() {
		// given
		String input = "Kim,Lee, ";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);

		// when, then
		assertThatThrownBy(InputHandler::getNameInput)
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining(ERROR);
	}

	@Test
	void 공백_이름() {
		// given
		String input = "Kim, ,Lee";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);

		// when, then
		assertThatThrownBy(InputHandler::getNameInput)
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining(ERROR);
	}

	@Test
	void 정상_동작() {
		// given
		String input = "Kim,Lee";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);

		// when
		String[] names = InputHandler.getNameInput();

		// then
		assertThat(names.length).isEqualTo(2);
		assertThat(names[0]).isEqualTo("Kim");
		assertThat(names[1]).isEqualTo("Lee");
	}
}