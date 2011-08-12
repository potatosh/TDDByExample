import junit.framework.TestCase;

public class DollarTest extends TestCase {
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
}