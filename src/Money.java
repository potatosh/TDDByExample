
class Money implements Expression{

	protected int amount;	//サブクラスから変数が見えるようにprotectedにする
	protected String currency;

	Money(int amount, String currency) {
		this.amount = amount;
		this.currency = currency;
	}

	@Override
	public boolean equals(Object object) {
		Money money = (Money)object;
		//amountが等しくて且つクラス名が等しければtrue
		return this.amount == money.amount && currency().equals(money.currency());
	}

	static Money dollar(int amount) {
		return new Money(amount, "USD");
	}

	Money times(int mul) {
		return new Money(amount * mul, currency);
	}

	static Money franc(int amount) {
		return new Money(amount, "CHF");
	}

	String currency() {
		return currency;
	}

	public String toString() {
		return amount + " " + currency;
	}

	Expression plus(Money addend) {
		return new Sum(this, addend);
	}

	public Money reduce(String to) {
		return this;
	}
}
