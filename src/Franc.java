
public class Franc extends Money{

	public Franc(int amount) {
		this.amount = amount;
	}

	Money times(int mul) {
		return new Franc(amount * mul);
	}

}
