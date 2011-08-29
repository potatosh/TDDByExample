
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

	public Expression times(int mul) {
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

	public Expression plus(Expression addend) {
		if(addend instanceof Money) {
			Money money = (Money) addend;
			if(this.currency.equals(money.currency)) {
				return new Money(this.amount + money.amount, this.currency);
			}
		}
		return new Sum(this, addend);
	}

	public Money reduce(Bank bank, String to) {
		int rate = bank.rate(currency, to);
		return new Money(amount / rate, to);
	}
}
