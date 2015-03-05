package rational;

public class Rational_tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Rational r = new Rational(10, 2);
		Rational x = new Rational(10, 2);
			System.out.println(r.toString());
			r.setNumerator(400);
			r.setDenominator(2);
			System.out.println(r.add(x).toString());
			System.out.println(r.subtract(x).toString());
			System.out.println(r.multiply(x).toString());
			System.out.println("Rational: (" + r + ") / (" + x + ") = " + r.divide(x).toString());
			System.out.println("Rational: (" + r + ") as double: " + r.toDouble());
	}

}
