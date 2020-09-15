public class Detrend{
	public double[] detrend(double] sig){
		double[] res = new double[sig.length];
		double[] x = new double[sig.length];
		for(int i = 0; i < x.length; i++) {
			x[i] = i;
		}
		double mean_x = mean(x);
		double molecule = 0.0;
		double sum_pow_x = 0.0;
	        double sum_x = 0.0;													
		for(int i=0; i < sig.length; i++) {
			molecule += (sig[i] * (x[i] - mean_x));
			sum_pow_x += (x[i] * x[i]);
			sum_x += x[i];
		}
		double denomintor = sum_pow_x - sum_x * sum_x / x.length;
		double w = molecule / denomintor;
		double b = 0.0;
		double temp = 0.0;
		for(int i=0; i < sig.length; i++) {
			temp += (sig[i] - w*x[i]);
		}
		b = temp / sig.length;																												for(int i=0; i < sig.length; i++) {
			res[i] = sig[i] - (w*i + b);
		}
		return res;
	
	}

	public double mean(double[] data) {
		double sum = 0.0;
		for(int i = 0; i < data.length; i++) {
			sum += data[i];
		}
		return sum/data.length;
	}
}
