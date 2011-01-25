public class Test{
public static int summands(int m, int n) {
	if (m==1 || n==1) {
		return 1;
	} else if (n >= m) {
		return summands(m,m-1) + 1;
	} else {
		return summands(m-n,n) + summands(m,n-1);
	}
}
}
