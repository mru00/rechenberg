public class Test{
public static void matrixMult (
	double[][] matrix1, double[][] matrix2, double[][] matrix3
){
	int i, j, k;
	int l, m, n;
	l = matrix1.length; m = matrix2.length; n = matrix2[0].length;

	// für alle Spalten von matrix2 und matrix3
	for (i = 0; i < n; i++){

		// für alle Zeilen von matrix1 und matrix3
		for (j = 0; j < l; j++){
			matrix3[j][i] = (double) 0.0;

			// für alle Spalten von matrix1
			for (k = 0; k < m; k++){
				matrix3[j][i] = matrix3[j][i] + matrix1[j][k] * matrix2[k][i];
			}
		}
	}
}
}
