package neuralNet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
	public static void main(String[] args) throws Exception {
		NeuralNet nn = new NeuralNet(new int[]{2, 2,2, 1}, new Sigmoid(1.0), 0.5);

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
        //nn.showWeights();

        NeuralNet nn2 = new NeuralNet(new int[]{2, 2,2, 1}, new Sigmoid(1.0), 0.5);
        nn2.setWeightsFromByteList(nn.getWeightsInByteList());

        r1 = nn2.GetOutput(new double[]{1.0, 1.0});
        r2 = nn2.GetOutput(new double[]{0.0, 1.0});
        r3 = nn2.GetOutput(new double[]{1.0, 0.0});
        r4 = nn2.GetOutput(new double[]{0.0, 0.0});

        System.out.println(r1[0] + " " + r2[0] + " " + r3[0] + " " + r4[0]);


        // List<byte[]> to byte[) transformation
        byte[] nn2dna = NeuralNet.byteListToByteArray(nn2.getWeightsInByteList());
        List<byte[]> nn2dnaList = NeuralNet.byteArrayToByteList(nn2dna);

        NeuralNet nn3 = new NeuralNet(new int[]{2, 2,2, 1}, new Sigmoid(1.0), 0.5);
        nn3.setWeightsFromByteList(nn2dnaList);

        r1 = nn3.GetOutput(new double[]{1.0, 1.0});
        r2 = nn3.GetOutput(new double[]{0.0, 1.0});
        r3 = nn3.GetOutput(new double[]{1.0, 0.0});
        r4 = nn3.GetOutput(new double[]{0.0, 0.0});

        System.out.println(r1[0] + " " + r2[0] + " " + r3[0] + " " + r4[0]);

	}
}