package neuralNet;

public interface IActivationFunction {
	public double Function(double x);
      
    public double Derivative(double x);
}