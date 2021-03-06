package neuralNet;

import java.nio.ByteBuffer;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.lang.*;

public class NeuralNet {

    protected int layerNum;   // number of layers (incl. input and output)
    protected int[] layerSize;  // sizes of layers

	protected double[][] out; // out[i][j] -- the output value of the j-th node of the i-th layer
    protected double[][] net; // net[i][j] -- the input (sum) value of j-th node of the i-th layer (for 0 layer does not matter)
    protected double[][] delta; // delta[i][j] -- the values of partial derivatives of error over net[i][j] (for 0 layer does not matter)

	protected double[][][] weight;   // weight[i][j][k] -- weight[left layer][neuron-position left][neuron-position right]
    protected double[][][] newWeight; // newWeight[i][j][k] -- weight[left layer][neuron-position left][neuron-position right]

    protected double[][] bias, newBias; // bias[i][j] -- bias from i-th layer to i+1-th layer, j-th node

	protected IActivationFunction af; // arbitrary activation function
    protected double learningRate;



  	public NeuralNet(int[] layerSize, IActivationFunction af, double learningRate) throws Exception {
  		if (layerSize.length < 2)
  			throw new Exception("Cannot have less than 2 layers");
  		
  		this.af = af;
  		this.layerNum = layerSize.length;
  		this.layerSize = layerSize;
  		this.learningRate = learningRate;
  		
  		out = new double[layerNum][];        // allocates memory for node input, output arrays
        net = new double[layerNum][];
        delta = new double[layerNum][];
    	for (int i = 0; i < layerSize.length; i++) {
            out[i] = new double[layerSize[i]];
            net[i] = new double[layerSize[i]];
            delta[i] = new double[layerSize[i]];
        }
      
    	weight = new double[layerNum-1][][];      // allocates memory for weight array
        newWeight = new double[layerNum-1][][];
    	for (int i = 0; i < layerNum-1; i++) {
            weight[i] = new double[layerSize[i]][layerSize[i + 1]];
            for (int j = 0; j < weight[i].length; j++)
                for (int k = 0; k < weight[i][j].length; k++)
                    weight[i][j][k] = randomWeight();

            newWeight[i] = new double[layerSize[i]][layerSize[i + 1]];
        }

        bias = new double[layerNum-1][];              // allocates memory for the bias nodes weights
        newBias = new double[layerNum-1][];
    	for (int i = 0; i < layerNum-1; i++) {
    	    bias[i] = new double[layerSize[i+1]];
            newBias[i] = new double[layerSize[i+1]];

    	    for (int j = 0; j < layerSize[i+1]; j++)
    	        bias[i][j] = randomWeight();
        }
    }

    public void DoTraining(double[] input, double[] output) throws Exception {
  		doForwardPropagation(input);
      	doBackwardPropagation(output);
  	}

  	public double[] GetOutput(double[] input) throws Exception {
  	    doForwardPropagation(input);
  	    return Arrays.copyOf(out[layerNum-1], layerSize[layerNum-1]);
    }




	protected void setInputNeurons(double[] input) throws Exception {
        if (input.length != layerSize[0])
            throw new Exception("Input size mismatch");

        out[0] = Arrays.copyOf(input, input.length);
	}

	protected void doForwardPropagation(double[] input) throws Exception {
        setInputNeurons(input);

    	for (int i = 1; i < layerNum; i++) {
    	    for (int j = 0; j < layerSize[i]; j++) {
                double sum = 0.0;

                for (int k = 0; k < layerSize[i-1]; k++)
                    sum += out[i - 1][k] * weight[i - 1][k][j];

                sum += bias[i-1][j];

                net[i][j] = sum;
                out[i][j] = af.Function(sum);
            }
        }
	}
  
	protected void doBackwardPropagation(double[] output) {
        for (int i = 0; i < layerSize[layerNum-1]; i++)  // calculate deltas for the last output layer
            delta[layerNum-1][i] = (out[layerNum-1][i] - output[i]) * af.Derivative(net[layerNum-1][i]);

        for (int i = layerNum-2; i>=0; i--) {          // for every layer but the output
            for (int j = 0; j < layerSize[i]; j++) {
                double deltaSum = 0.0;

                for (int k = 0; k < layerSize[i+1]; k++) {
                    newWeight[i][j][k] = weight[i][j][k] - learningRate * delta[i+1][k] * out[i][j];
                    deltaSum += delta[i+1][k] * out[i][j];
                }

                deltaSum *= af.Derivative(net[i][j]);
                delta[i][j] = deltaSum;
            }

            for (int k = 0; k < layerSize[i+1]; k++)
                newBias[i][k] = bias[i][k] - learningRate * delta[i+1][k];
        }

        double[][][] swapWeight = weight;
        weight = newWeight;
        newWeight = swapWeight;

        double[][] swapBias = bias;
        bias = newBias;
        newBias = swapBias;

	}

	// method to debug
	public void showWeights() {
  	    for (int i = 0; i < weight.length; i++) {
  	        for (int j = 0; j < weight[i].length; j++) {
  	            for (int k = 0; k < weight[i][j].length; k++) {
  	                System.out.println("Layer " + i + " position " + j + " to layer " + (i+1) + " at position " + k + " weight: " + weight[i][j][k]);
                }
            }
            for (int k = 0; k < bias[i].length; k++) {
                System.out.println("Bias Layer " + i + " to layer " + (i+1) + " at position " + k + " weight: " + bias[i][k]);
            }
        }
    }

	protected double randomWeight() {
		Random rand = new Random();
		return rand.nextDouble() * 2 - 1;
	}

	// encode weights into a List of byte[]
	public List<byte[]> getWeightsInByteList() {
  	    List<byte[]> list = new ArrayList<byte[]>();
        for (int i = 0; i < weight.length; i++) {
            for (int j = 0; j < weight[i].length; j++) {
                for (int k = 0; k < weight[i][j].length; k++) {
                    // Layer i position j to layer (i+1) at position k weight: weight[i][j][k]);
                    list.add(toByteArray(weight[i][j][k]));
                }
            }
            for (int k = 0; k < bias[i].length; k++) {
                //Bias Layer i to layer (i+1) at position k weight: bias[i][k]);
                list.add(toByteArray(bias[i][k]));
            }
        }
  	    return list;
    }

    // take list of byte[] and replace the weights in the NN by it
    public void setWeightsFromByteList(List<byte[]> list){
  	    int listIndex = 0;
        for (int i = 0; i < weight.length; i++) {
            for (int j = 0; j < weight[i].length; j++) {
                for (int k = 0; k < weight[i][j].length; k++) {
                    // Layer i position j to layer (i+1) at position k weight: weight[i][j][k]);
                    weight[i][j][k] = toDouble(list.get(listIndex));
                    listIndex++;
                }
            }
            for (int k = 0; k < bias[i].length; k++) {
                //Bias Layer i to layer (i+1) at position k weight: bias[i][k]);
                bias[i][k] = toDouble(list.get(listIndex));
                listIndex++;
            }
        }
    }

    // Transforms a List<byte[8]> into a byte[]
    public static byte[] byteListToByteArray(List<byte[]> list) {
        byte[] byteArr = new byte[list.size()*8];
        int dnaCounter = 0;
        for (byte[] b : list) {
            for (int i = 0; i < 8; i++) {
                byteArr[dnaCounter] = b[i];
                dnaCounter++;
            }
        }
        return byteArr;
    }

    // Transforms a byte Array into a List<byte[8]>
    public static List<byte[]> byteArrayToByteList(byte[] byteArray) {
        List<byte[]> byteList = new ArrayList<byte[]>();
        for (int i = 0; i < byteArray.length/8 ; i++) {
            byte[] newByteArr = new byte[8];
            for (int j = 0; j < 8; j++) {
                newByteArr[j] = byteArray[i*8 + j];
            }
            byteList.add(newByteArr);
        }
        return byteList;
    }

    public static byte[] toByteArray(double value) {
        byte[] bytes = new byte[8];
        ByteBuffer.wrap(bytes).putDouble(value);
        return bytes;
    }

    public static double toDouble(byte[] bytes) {
        return ByteBuffer.wrap(bytes).getDouble();
    }
}
