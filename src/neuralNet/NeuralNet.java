package neuralNet;

import java.util.Random;

public class NeuralNet {

	public static void main(String[] args) {

		NeuralNet nn = new NeuralNet();
		nn.Initialize();
	}

	double[] inputLayer = new double[2];
	double[] hiddenLayer = new double[3];
	double outputLayer;
	double[][] weight = new double[3][3];

	public void SetInputNeurons(int one, int two) {
		inputLayer[0] = one;
		inputLayer[1] = two;
	}

	public void DoForwardPropagation() {
		// Input neuron to hidden layer neurons
		// I1 to H1
		for (int h = 0; h < 3; h++) {
			hiddenLayer[h] = inputLayer[0] * weight[0][h]; // I1
			hiddenLayer[h] = inputLayer[1] * weight[1][h]; // I2
		}
	}

	public void Initialize() {
		// initial weights to all synapses
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				weight[i][j] = RandomWeight();
			}
		}
		// Input neurons to 0, 0
		inputLayer[0] = 0;
		inputLayer[1] = 0;
		// Output neuron to 0
		outputLayer = 0;
	}

	public double RandomWeight() {
		Random rand = new Random();
		return rand.nextDouble();
	}

	public static double Sigmoid(double x) {
		return 1 / (1 - Math.exp(-x));
	}

	public static double SigmoidP(double x) {
		return Sigmoid(x) * (1 - Sigmoid(x));
	}
}
