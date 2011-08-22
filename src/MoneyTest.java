import junit.framework.TestCase;

public class MoneyTest extends TestCase {
	//$5に2をかけたら10に、3をかけたら15になる
	public void testTimes() {
		Money five = Money.dollar(5);		//5ドルを作る（Moneyクラスで）
		assertEquals(Money.dollar(10), five.times(2));	//5ドルを2倍すれば10ドルのはず
		assertEquals(Money.dollar(15), five.times(3));	//5ドルを3倍すれば15ドルのはず
	}

	//$5と別の$5は等しい（バリューオブジェクト） currencyの等価性テストとamountの等価性テストをカバーする
	public void testEquality() {
		assertTrue(Money.dollar(5).equals(Money.dollar(5)));	//$5と$5は等しい	(currency:ok -> amount:ok)
		assertFalse(Money.dollar(5).equals(Money.dollar(6)));	//$5と$6は等しくない	(currency:ok -> amount:ng)
		assertFalse(Money.dollar(5).equals(Money.franc(5)));	//$5と5フランは等しくない	(currency:ng)
	}

	public void testCurrency() {
		assertEquals("USD", Money.dollar(1).currency());	//$1の通貨の文字列表現は"USD"である
		assertEquals("CHF", Money.franc(1).currency());		//1フランの通貨の文字列表現は"CHF"である
	}

	public void testSimpleAddition() {
		Money five = Money.dollar(5);			//5ドルを作る
		Expression sum = five.plus(five);		//式$5+$5を作る
		Bank bank = new Bank();				//銀行を作る
		Money reduced = bank.reduce(sum, "USD");	//銀行にsumを単位USDで計算してもらうと計算結果($10)のMoneyが返ってくる
		assertEquals (Money.dollar(10), reduced);	//reducedは$10である
	}

	public void testPlusReturnsSum() {
		Money five = Money.dollar(5);			//5ドルを作る
		Expression result = five.plus(five);		//式$5+$5を作る(Sumが返ってくる)
		Sum sum = (Sum) result;				//Sumにキャストする
		assertEquals(five, sum.augend);			//Sumインスタンスとしてaugendと
		assertEquals(five, sum.addend);			//addendパラメータを参照できる
	}

	public void testReduceSum() {
		Expression sum = new Sum(Money.dollar(3), Money.dollar(4));	//式$3+$4を作る
		Bank bank = new Bank();						//銀行を作る
		Money result = bank.reduce(sum, "USD");				//作った式を通貨USDで計算する
		assertEquals(Money.dollar(7), result);				//計算結果は$7である
	}

	public void testReduceMoney() {
		Bank bank = new Bank();					//銀行を作る
		Money result = bank.reduce(Money.dollar(1), "USD");	//$1をUSDに変換
		assertEquals(Money.dollar(1), result);			//結果は$1である
	}

	public void testArrayEquals() {
		assertFalse(new Object[]{"abc", "def"}.equals(new Object[]{"abc", "def"}));	//通貨のペア2つを比較するとして、配列でこれを実現できるか→できない
	}

	public void testReduceMoneyDifferentCurrency() {
		Bank bank = new Bank();					//銀行を作る
		bank.addRate("CHF", "USD", 2);				//CHFからUSDへ変換するときのレートを追加する
		Money result = bank.reduce(Money.franc(2), "USD");	//2フランをUSDに変換
		assertEquals(Money.dollar(1), result);			//結果は1ドルである
	}

	public void testIdentityRate() {
		assertEquals(1, new Bank().rate("USD", "USD"));		//同じ通貨の変換レートは1である
	}
}