package neuralNet;

import java.util.Random;
import java.lang.*;

public class NeuralNet {

  	// node[i][j]
	protected double[][] node; // the output value of the j-th node of the i-th layer
      
  	// weight[i][j][k] -- weight[layer][neuron-position left][neuron-position right]
	protected double[][][] weight; // the synopsys from j-th node of i-th layer to k-th node of (i+1)-th layer

	protected IActivationFunction af;



  	public NeuralNet(int[] layerSize, IActivationFunction af) throws Exception {
  		
  		if (layerSize.length < 2)
  			throw new Exception("Cannot have less than 2 layers");
  		
  		this.af = af;
  		
  		node = new double[layerSize.length][];        // allocates memory for layer array
    	for (int i = 0; i < layerSize.length; i++)  
        	node[i] = new double[layerSize[i]];
      
    	weight = new double[layerSize.length-1][][];
    	for (int i = 0; i < layerSize.length-1; i++)   // allocates memory for weight array
          	weight[i] = new double[layerSize[i]][layerSize[i+1]];      
      	
      	for (int i = 0; i < weight.length; i++)          // allocate random weight to each synopsys
          	for (int j = 0; j < weight[i].length; j++)
              	for (int k = 0; k < weight[i][j].length; k++)
              		weight[i][j][k] = this.RandomWeight();
    }

    public void DoTraining(double[] input, double[] output) {
      	
      	SetInputNeurons(input);     // set input neurons according to input data
      
  		DoForwardPropagation();
      	DoBackwardPropagation();
  	}


  
	protected void SetInputNeurons(double[] values) {
      	for (int i = 0; i < values.length; i++) {
      		node[0][i] = values[i];
      	}
	}

	protected void DoForwardPropagation() {
    	
	}
  
	protected void DoBackwardPropagation() {
    	
	}

	protected double RandomWeight() {
		Random rand = new Random();
		return rand.nextDouble();
	}
}
