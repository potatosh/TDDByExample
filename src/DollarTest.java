import junit.framework.TestCase;

public class DollarTest extends TestCase {
	//$5に2をかけたら10に、3をかけたら15になる
	public void testTimes() {
		Dollar dollar = new Dollar(5);		//5ドルを作る
		assertEquals(new Dollar(10), dollar.times(2));	//5ドルを2倍すれば10ドルのはず
		assertEquals(new Dollar(15), dollar.times(3));	//5ドルを3倍すれば15ドルのはず
	}

	//$5と別の$5は等しい（バリューオブジェクト）
	public void testEquality() {
		assertTrue(new Dollar(5).equals(new Dollar(5)));	//$5と$5は等しい
		assertFalse(new Dollar(5).equals(new Dollar(6)));	//$5と$6は等しくいない
	}
}