public class Test{
public static void quadratic2(double a, double b, double c) {
	double d = b*b - 4.0*a*c;
	System.out.println (a + "*x^2 + " + b + "*x + " + c + " = 0");
	if (d >= 0) {
		double a2 = 2.0*a;
		double dq = Math.sqrt(d);
		double x1 = (-b + dq) / a2;
		if (d == 0) System.out.println ("Eine doppelte Nullstelle: x=" + x1 + ".");
		else {
			double x2 = (-b - dq) / a2;
			System.out.println ("Zwei Nullstellen: x=" + x1 + ", x=" + x2 + ".");
		}
	} else
		System.out.println ("Keine reelle Nullstelle!");
}
}
