
public class Money {

	protected int amount;	//サブクラスから変数が見えるようにprotectedにする

	@Override
	public boolean equals(Object object) {
		Money money = (Money)object;
		return this.amount == money.amount;
	}

}
