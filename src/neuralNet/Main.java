package neuralNet;

public class Main {
	public static void main(String[] args) throws Exception {
		NeuralNet nn = new NeuralNet(new int[]{2, 2, 1}, new Sigmoid(1.0), 0.5);

		for (int i = 0; i < 50000; i++) {
            nn.DoTraining(new double[]{1.0, 1.0}, new double[]{0.0});
            nn.DoTraining(new double[]{0.0, 1.0}, new double[]{1.0});
            nn.DoTraining(new double[]{1.0, 0.0}, new double[]{1.0});
            nn.DoTraining(new double[]{0.0, 0.0}, new double[]{0.0});
        }

        double[] r1, r2, r3, r4;
        r1 = nn.GetOutput(new double[]{1.0, 1.0});
        r2 = nn.GetOutput(new double[]{0.0, 1.0});
        r3 = nn.GetOutput(new double[]{1.0, 0.0});
        r4 = nn.GetOutput(new double[]{0.0, 0.0});

        System.out.println(r1[0] + " " + r2[0] + " " + r3[0] + " " + r4[0]);
        nn.showWeights();

	}
}