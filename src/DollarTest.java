import junit.framework.TestCase;


public class DollarTest extends TestCase {
	public void testTimes() {
		//まず、5ドルを2倍すると10ドルになる
		Dollar dollar = new Dollar(5);		//5ドル
		dollar.times(2);			//2倍
		assertEquals(10, dollar.amount);	//値を取り出したら10になってるはず
	}
}
