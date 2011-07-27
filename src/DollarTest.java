import junit.framework.TestCase;

/*
 * まず、5ドルを2倍すると10ドルになるというストーリーがある
 * ・クラスがない→作る
 * ・関数や変数がない→実装する
 * ・テストは通るが失敗する（10にならない）→とりあえずグリーンにするためにどっかで10をこじつける
 * ・
 */
public class DollarTest extends TestCase {
	public void testTimes() {
		Dollar dollar = new Dollar(5);		//5ドルを作る
		Dollar product = dollar.times(2);			//2倍する
		assertEquals(10, product.amount);	//値を取り出したら10になってるはず
		product = dollar.times(3);			//3倍する
		assertEquals(15, product.amount);	//値を取り出したら15になってるはず
	}
}