
interface Expression {
	Money reduce(Bank bank, String to);

	Expression plus(Expression tenFrancs);

	Expression times(int mul);
}
