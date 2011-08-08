
public class Franc extends Money{

	Franc(int amount, String currency) {
		super(amount, currency);
	}

	Money times(int mul) {
		return Money.franc(amount * mul);
	}
}
