public class Test{
public static void quadratic1(double a, double b, double c) {
	double x1=0, x2=0;
	double b2 = b*b;
	double ac4 = 4.0*a*c;

	System.out.println (a + "*x^2 + " + b + "*x + " + c + " = 0");		
	if (b2 >= ac4) {
		x1 = ( (-1.0) * b + Math.sqrt (b2 - ac4) ) / (2.0*a);
		x2 = ( (-1.0) * b - Math.sqrt (b2 - ac4) ) / (2.0*a);

		if (b2 == ac4) {
			System.out.println ("Eine doppelte Nullstelle: x=" + x1 + ".");
		}
		if (b2 > ac4) {
			System.out.println ("Zwei Nullstellen: x=" + x1 + ", x=" + x2 + ".");
		}
	} else
		System.out.println ("Keine reelle Nullstelle!");
}
}
