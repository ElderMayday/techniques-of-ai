package neuralNet;

public class Main {
	public static void main(String[] args) throws Exception {
		NeuralNet nn = new NeuralNet(new int[]{2, 3, 1}, new Sigmoid());
		nn.DoTraining(new double[]{1.0, 1.0}, new double[]{-1.0});
	}
}