package neuralNet;

public class Sigmoid implements IActivationFunction {

	protected double sharpness;



	public Sigmoid(double sharpness) {
		this.sharpness = sharpness;
	}

	public double Function(double x) {
		return 1 / (1 + Math.exp(- sharpness * x));
	}

	public double Derivative(double x) {
		return Function(x) * (1 - Function(x));
	}
}
