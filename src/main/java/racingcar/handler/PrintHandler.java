package racingcar.handler;

import static racingcar.utils.Constant.*;

import racingcar.Car;

public class PrintHandler {
	public static void printInputNameMsg() {
		System.out.println(INPUT_NAME_MSG);
	}

	public static void printErrorMsg(Exception exception) {
		System.out.println(exception.getMessage());
	}

	public static void printInputNumberMsg() {
		System.out.println(INPUT_NUMBER_MSG);
	}

	public static void printCar(Car car) {
		StringBuilder sb = new StringBuilder(car.getName() + " : ");
		for (int i = 0; i < car.getPosition(); i++) {
			sb.append("-");
		}
		System.out.println(sb);
	}
}
