package neuralNet;

public class Sigmoid implements IActivationFunction {

	protected double sharpness;



	public Sigmoid(double sharpness) {
		this.sharpness = sharpness;
	}

	public double Function(double x) {
		return 1.0 / (1.0 + Math.exp(- sharpness * x));
	}

	public double Derivative(double x) {
		return Function(x) * (1.0 - Function(x));
	}
}
