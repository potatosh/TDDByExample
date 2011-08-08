
public class Dollar extends Money {

	Dollar(int amount, String currency) {
		super(amount, currency);
	}

	Money times(int mul) {
		return Money.dollar(amount * mul);
	}

}
