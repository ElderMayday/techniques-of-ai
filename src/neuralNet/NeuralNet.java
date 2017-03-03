package neuralNet;

import java.util.Random;
import java.lang.*;

public class NeuralNet {

	private int inputNum, hiddenNum, outputNum; // number of nodes of the layers
	private double[][] weightIH, weightHO;      // weights of input-hidden and hidden-output layers
	private IActivationFunction af;             // activation function
	private double[] input, hiddenSum, hiddenOutput, outputSum, output; // nodes values
	
	
  	public NeuralNet(int inputNum, int hiddenNum, int outputNum, IActivationFunction af) throws Exception {
  		this.inputNum = inputNum;
  		this.hiddenNum = hiddenNum;
  		this.outputNum = outputNum;
  		this.af = af;
  		
  		input = new double[inputNum+1];
  		input[0] = 1.0;
  		
  		hiddenSum = new double[hiddenNum];
  		
  		hiddenOutput = new double[hiddenNum+1];
  		hiddenOutput[0] = 1.0;
  		
  		outputSum = new double[outputNum];
  		output = new double[outputNum];
  		
  		weightIH = new double[inputNum+1][hiddenNum];
  		for (int i = 0; i <= inputNum; i++)
  			for (int j = 0; j < hiddenNum; j++)
  				weightIH[i][j] = this.RandomWeight();
  		
  		
  		weightHO = new double[hiddenNum+1][outputNum];
  		for (int i = 0; i <= hiddenNum; i++)
  			for (int j = 0; j < outputNum; j++)
  				weightHO[i][j] = this.RandomWeight();
    }
  
  
    public void DoTraining(double[] input, double[] output) {
      	
      	SetInputNeurons(input);     // set input neurons according to input data
      
  		DoForwardPropagation();
      	DoBackwardPropagation();
  	}
  
	protected void SetInputNeurons(double[] values) {

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
