import junit.framework.TestCase;

public class DollarTest extends TestCase {
	//$5に2をかけたら10に、3をかけたら15になる
	public void testTimes() {
		Dollar five = new Dollar(5);		//5ドルを作る
		assertEquals(new Dollar(10), five.times(2));	//5ドルを2倍すれば10ドルのはず
		assertEquals(new Dollar(15), five.times(3));	//5ドルを3倍すれば15ドルのはず
	}

	//5フランに2をかけたら10に、3をかけたら15になる
	public void testFrancTimes() {
		Franc five = new Franc(5);		//5ドルを作る
		assertEquals(new Franc(10), five.times(2));	//5フランを2倍すれば10フランのはず
		assertEquals(new Franc(15), five.times(3));	//5フランを3倍すれば15フランのはず
	}

	//$5と別の$5は等しい（バリューオブジェクト）
	public void testEquality() {
		assertTrue(new Dollar(5).equals(new Dollar(5)));	//$5と$5は等しい
		assertFalse(new Dollar(5).equals(new Dollar(6)));	//$5と$6は等しくいない
		assertTrue(new Franc(5).equals(new Franc(5)));	//$5と$5は等しい
		assertFalse(new Franc(5).equals(new Franc(6)));	//$5と$6は等しくいない
	}
}