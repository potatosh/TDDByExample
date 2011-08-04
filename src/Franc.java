
public class Franc {

	private int amount;

	public Franc(int amount) {
		this.amount = amount;
	}

	public Franc times(int mul) {
		return new Franc(amount * mul);
	}

	@Override
	public boolean equals(Object object) {
		Franc target = (Franc)object;
		return this.amount == target.amount;
	}

}
