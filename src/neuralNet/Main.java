package neuralNet;

public class Main {
	public static void main(String[] args) throws Exception {
		NeuralNet nn = new NeuralNet(new int[]{2, 5, 1}, new Sigmoid(1.0), 0.5);

		for (int i = 0; i < 1000; i++) {
            nn.DoTraining(new double[]{1.0, 1.0}, new double[]{1.0});
            nn.DoTraining(new double[]{0.0, 1.0}, new double[]{1.0});
            nn.DoTraining(new double[]{1.0, 0.0}, new double[]{0.0});
            nn.DoTraining(new double[]{0.0, 0.0}, new double[]{0.0});
        }

        double[] r1 = nn.GetOutput(new double[]{1.0, 1.0});
        double[] r2 = nn.GetOutput(new double[]{0.0, 1.0});
        double[] r3 = nn.GetOutput(new double[]{1.0, 0.0});
        double[] r4 = nn.GetOutput(new double[]{0.0, 0.0});
	}
}