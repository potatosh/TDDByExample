import junit.framework.TestCase;

public class DollarTest extends TestCase {
	public void testTimes() {
		Dollar dollar = new Dollar(5);		//5ドルを作る
		Dollar product = dollar.times(2);			//2倍する
		assertEquals(10, product.amount);	//値を取り出したら10になってるはず
		product = dollar.times(3);			//3倍する
		assertEquals(15, product.amount);	//値を取り出したら15になってるはず
	}
}