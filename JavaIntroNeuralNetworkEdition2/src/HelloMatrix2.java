import com.heatonresearch.book.introneuralnet.neural.matrix.Matrix;

public class HelloMatrix2 
{
	public static void main(String[] args) 
	{
		double matrixData[][] = 
			{
					{1.0, 2.0, 3.0},
					{4.0, 5.0, 6.0}
			};
		
		Matrix m = new Matrix(matrixData);
		System.out.println("Hello Matrix");
	}
}
