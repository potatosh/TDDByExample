
public class Money {

	protected int amount;	//サブクラスから変数が見えるようにprotectedにする

	@Override
	public boolean equals(Object object) {
		Money money = (Money)object;
		//amountが等しくて且つクラス名が等しければtrue
		return this.amount == money.amount && getClass().equals(money.getClass());
	}

}
