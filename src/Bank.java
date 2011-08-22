import java.util.Hashtable;


class Bank {

	private Hashtable<Pair, Integer> rates = new Hashtable<Pair, Integer>();

	Money reduce(Expression source, String to) {
		return source.reduce(this, to);
	}

	void addRate(String from, String to, int rate) {
		// TODO 自動生成されたメソッド・スタブ
		rates.put(new Pair(from, to), rate);	//昔はnew Integer(rate)って書かないといけなかったけど時代は進化しました
	}

	int rate(String from, String to) {
		if(from.equals(to)) return 1;
		return rates.get(new Pair(from, to));
	}

}
