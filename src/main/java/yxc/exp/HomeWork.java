package yxc.exp;

public class HomeWork {
	public static void main(String[] args) {
		double d = 0.257, p = 860, v = 0.000006, L = 50000;
		double z = 30, p1 = 50 * 9.8 * 10000, p2 = 2 * 9.8 * 10000;
		double G = 9.8;
		double hw = (p1 - p2) / (p * G) - z, hf = hw;
		double delta = 0.00015;
		double A = Math.pow(10, 0.127 * Math.log10(delta / d) - 0.627);
		System.out.println("A: " + A);
		double lambda = 1 / Math.pow(2 * Math.log10(3.7 * d / delta) ,2);
		double e = 2 * delta / d;
		System.out.println("e: " + e);
		double[][] factors = {
				{4.15, 1},
				{0.0246, 0.25},
				{0.0802 * A, 0.123},
				{0.0826 * lambda, 0}
		};
		for(int i = 0; i < factors.length; i++) {
			double beta = factors[i][0], m = factors[i][1];
			double Q = Math.pow(hf * Math.pow(d, 5 - m) / beta / Math.pow(v, m) / L, 1 / (2 - m));
			System.out.println(i + " Q: " + Q);
//			double Q = Math.pow(hf * Math.pow(d, 4.877) / 0.0802 / A / L / Math.pow(v, 0.123), 1/1.877);
			double Re = 4 * Q / Math.PI / d / v;
			System.out.println(59.7 / Math.pow(e, (double)8 / 7));
			switch(i) {
			case 0:
				if(Re <= 2000)
					System.out.println("Re: " + Re);
				break;
			case 1:
				if(Re > 3000 && Re < 59.7 / Math.pow(e, 8 / 7))
					System.out.println("Re: " + Re);
				break;
			case 2:
				if(59.7 / Math.pow(e, 8 / 7) < Re && Re < (665 - 765 * Math.log10(e))/e)
					System.out.println("Re: " + Re);
				break;
			case 3:
				if(Re > (665 - 765 * Math.log10(e))/e)
					System.out.println("Re: " + Re);
				break;
			}		

		}
	}
}
