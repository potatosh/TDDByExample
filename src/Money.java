
abstract class Money {

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
		return this.amount == money.amount && getClass().equals(money.getClass());
	}

	static Money dollar(int amount) {
		// TODO 自動生成されたメソッド・スタブ
		return new Dollar(amount, "USD");
	}

	abstract Money times(int multiplier);

	static Money franc(int amount) {
		// TODO 自動生成されたメソッド・スタブ
		return new Franc(amount, "CHF");
	}

	String currency() {
		return currency;
	}
}
