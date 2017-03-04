package neuralNet;

import java.util.Random;
import java.lang.*;

public class NeuralNet {

    protected int layerNum;   // number of layers (incl. input and output)
    protected int[] layerSize;  // sizes of layers

	protected double[][] out; // out[i][j] -- the output value of the j-th node of the i-th layer
    protected double[][] net; // net[i][j] -- the input (sum) value of j-th node of the i-th layer (for 0 layer does not matter)

	protected double[][][] weight;   // weight[i][j][k] -- weight[left layer][neuron-position left][neuron-position right]
    protected double[][][] newWeight; // newWeight[i][j][k] -- weight[left layer][neuron-position left][neuron-position right]

    protected double[][] bias; // bias[i][j] -- bias from i-th layer to i+1-th layer, j-th node

	protected IActivationFunction af; // arbitary activation function




  	public NeuralNet(int[] layerSize, IActivationFunction af) throws Exception {
  		if (layerSize.length < 2)
  			throw new Exception("Cannot have less than 2 layers");
  		
  		this.af = af;
  		this.layerNum = layerSize.length;
  		this.layerSize = layerSize;
  		
  		out = new double[layerNum][];        // allocates memory for node input, output arrays
        net = new double[layerNum][];
    	for (int i = 0; i < layerSize.length; i++) {
            out[i] = new double[layerSize[i]];
            net[i] = out[i] = new double[layerSize[i]];
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
    	for (int i = 0; i < layerNum-1; i++) {
    	    bias[i] = new double[layerSize[i+1]];

    	    for (int j = 0; j < layerSize[i+1]; j++)
    	        bias[i][j] = randomWeight();
        }
    }

    public void DoTraining(double[] input, double[] output) {
      	setInputNeurons(input);     // set input neurons according to input data
      
  		doForwardPropagation();
      	doBackwardPropagation();
  	}

  	public double[] GetOutput(double[] input) {
  	    setInputNeurons(input);
  	    doForwardPropagation();

  	    return null; // TO-FINISH
    }




	protected void setInputNeurons(double[] values) {
      	for (int i = 0; i < values.length; i++) {
      		out[0][i] = values[i];
      	}
	}

	protected void doForwardPropagation() {
    	
	}
  
	protected void doBackwardPropagation() {
    	
	}

	protected double randomWeight() {
		Random rand = new Random();
		return rand.nextDouble();
	}
}
