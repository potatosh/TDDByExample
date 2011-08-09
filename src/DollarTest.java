import junit.framework.TestCase;

public class DollarTest extends TestCase {
	//$5に2をかけたら10に、3をかけたら15になる
	public void testTimes() {
		Money five = Money.dollar(5);		//5ドルを作る（Moneyクラスで）
		assertEquals(Money.dollar(10), five.times(2));	//5ドルを2倍すれば10ドルのはず
		assertEquals(Money.dollar(15), five.times(3));	//5ドルを3倍すれば15ドルのはず
	}

	//5フランに2をかけたら10に、3をかけたら15になる
	public void testFrancTimes() {
		Money five = Money.franc(5);		//5ドルを作る
		assertEquals(Money.franc(10), five.times(2));	//5フランを2倍すれば10フランのはず
		assertEquals(Money.franc(15), five.times(3));	//5フランを3倍すれば15フランのはず
	}

	//$5と別の$5は等しい（バリューオブジェクト）
	public void testEquality() {
		assertTrue(Money.dollar(5).equals(Money.dollar(5)));	//$5と$5は等しい
		assertFalse(Money.dollar(5).equals(Money.dollar(6)));	//$5と$6は等しくない
		assertTrue(Money.franc(5).equals(Money.franc(5)));		//5フランと5フランは等しい
		assertFalse(Money.franc(5).equals(Money.franc(6)));		//5フランと6フランは等しくない
		assertFalse(Money.dollar(5).equals(Money.franc(5)));
	}

	public void testCurrency() {
		assertEquals("USD", Money.dollar(1).currency());	//$1の通貨の文字列表現は"USD"である
		assertEquals("CHF", Money.franc(1).currency());		//1フランの通貨の文字列表現は"CHF"である
	}

	public void testDifferentClassEquality() {
		assertTrue(new Money(10, "CHF").equals(new Franc(10, "CHF")));	//Money型の10フランはFranc型の10フランと等しい
	}
}