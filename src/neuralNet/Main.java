package neuralNet;

public class Main {
	public static void main(String[] args) throws Exception {
		NeuralNet nn = new NeuralNet(2, 2, 1, new Sigmoid(), 0.05);
		
		nn.DoTraining(new double[]{1.0, 1.0}, new double[]{-1.0});
	}
}