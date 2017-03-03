package neuralNet;

public class Sigmoid implements IActivationFunction {
	public double Function(double x) {
		return 1 / (1 + Math.exp(-x));
	}

	public double Derivative(double x) {
		return Function(x) * (1 - Function(x));
	}
}
