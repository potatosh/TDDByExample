import junit.framework.TestCase;

public class DollarTest extends TestCase {
	//$5に2をかけたら10に、3をかけたら15になる
	public void testTimes() {
		Dollar dollar = new Dollar(5);		//5ドルを作る
		Dollar product = dollar.times(2);	//2倍する
		assertEquals(10, product.amount);	//値を取り出したら10になってるはず
		product = dollar.times(3);		//3倍する
		assertEquals(15, product.amount);	//値を取り出したら15になってるはず
	}

	//$5と別の$5は等しい（バリューオブジェクト）
	public void testEquality() {
		assertTrue(new Dollar(5).equals(new Dollar(5)));	//$5と$5は等しい
		assertFalse(new Dollar(5).equals(new Dollar(6)));	//$5と$6は等しくいない
	}
}