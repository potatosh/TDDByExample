
abstract class Money {

	protected int amount;	//サブクラスから変数が見えるようにprotectedにする

	@Override
	public boolean equals(Object object) {
		Money money = (Money)object;
		//amountが等しくて且つクラス名が等しければtrue
		return this.amount == money.amount && getClass().equals(money.getClass());
	}

	static Money dollar(int amount) {
		// TODO 自動生成されたメソッド・スタブ
		return new Dollar(amount);
	}

	abstract Money times(int multiplier);

	static Money franc(int amount) {
		// TODO 自動生成されたメソッド・スタブ
		return new Franc(amount);
	}

}
