public class Test{

public static double simpson3(double x[], double y[]) {
	int n = y.length-1;
	double h[] = new double[n];
	for (int i=0; i<n; ++i)
		h[i] = x[i+1] - x[i];

	double s = 0;
	for (int i=1; i<n; i+=2) {
		double a = h[i] * h[i];
		double b = h[i] * h[i-1];
		double c = h[i-1] * h[i-1];
		double d = h[i] + h[i-1];
		double alpha = (2*a+b-c) / h[i];
		double beta  = d*d*d / b;
		double gamma = (-a+b+2*c) / h[i-1];
		s += alpha*y[i+1] + beta*y[i] + gamma*y[i-1];
	}

	// Add the last slice separately for an even n+1
	if ((n+1)%2 == 0) {
		double alpha = h[n-1]*(3-h[n-1] / (h[n-1] + h[n-2]));
		double beta = h[n-1]*(3+h[n-1] / h[n-2]);
		double gamma = -h[n-1]*h[n-1]*h[n-1] / (h[n-2]*(h[n-1] + h[n-2]));
		return (s+alpha*y[n] + beta*y[n-1] + gamma*y[n-2]) / 6;
	}
	else
		return s/6;
}
}
