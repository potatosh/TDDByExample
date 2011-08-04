
public class Dollar extends Money {

	public Dollar(int amount) {
		this.amount = amount;
	}

	public Dollar times(int mul) {
		return new Dollar(amount * mul);
	}

}
