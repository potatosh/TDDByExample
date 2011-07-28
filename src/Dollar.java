
public class Dollar {

	public int amount;

	public Dollar(int amount) {
		this.amount = amount;
	}

	public Dollar times(int mul) {
		return new Dollar(amount * mul);
	}

	@Override
	public boolean equals(Object object) {
		Dollar target = (Dollar)object;
		return this.amount == target.amount;
	}

}
