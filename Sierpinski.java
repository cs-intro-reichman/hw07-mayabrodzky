/** Draws ths Sierpinski Triangle fractal. */
public class Sierpinski {
	
	public static void main(String[] args) {
		sierpinski(Integer.parseInt(args[0]));
	}
	
	// Draws a Sierpinski triangle of depth n on the standard canvass.
	public static void sierpinski (int n) {
		//// Replace this comment with your code
		double x1 = 0.0, y1 = 0.0;
		double x2 = 1.0, y2 = 0.0;
		double x3 = 0.5, y3 = Math.sqrt(3)/2;

		StdDraw.line(x1, y1, x2, y2);
		StdDraw.line(x2, y2, x3, y3);
		StdDraw.line(x3, y3, x1, y1);

		if (n>0){
			sierpinski(n, x1, x2, x3, y1, y2, y3);
		}
	}
	
	// Does the actual drawing, recursively.
	private static void sierpinski(int n, double x1, double x2, double x3,
		                                 double y1, double y2, double y3) {
		if (n == 0) return;

        double m12x = (x1 + x2) / 2.0;
        double m12y = (y1 + y2) / 2.0;
        double m23x = (x2 + x3) / 2.0;
        double m23y = (y2 + y3) / 2.0;
        double m31x = (x3 + x1) / 2.0;
        double m31y = (y3 + y1) / 2.0;

        StdDraw.setPenColor(StdDraw.WHITE);
        double[] px = {m12x, m23x, m31x};
        double[] py = {m12y, m23y, m31y};
        StdDraw.filledPolygon(px, py);
        
        StdDraw.setPenColor(StdDraw.BLACK);

        sierpinski(n - 1, x1, m12x, m31x, y1, m12y, m31y);   
        sierpinski(n - 1, m12x, x2, m23x, m12y, y2, m23y);   
        sierpinski(n - 1, m31x, m23x, x3, m31y, m23y, y3);
	}
}
