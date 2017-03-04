package neuralNet;

public class Main {
	public static void main(String[] args) throws Exception {
		NeuralNet nn = new NeuralNet(new int[]{2, 1, 1}, new Sigmoid(1.0));
		nn.DoTraining(new double[]{1.0, 1.0}, new double[]{-1.0});
	}
}