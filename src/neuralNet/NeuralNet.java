package neuralNet;

import java.util.Random;
import java.lang.*;

public class NeuralNet {

	private int inputNum, hiddenNum, outputNum; // number of nodes of the layers
	private double[][] weightIH, weightHO;      // weights of input-hidden and hidden-output layers
	private IActivationFunction af;             // activation function
	private double[] input, hiddenSum, hiddenOut, outputSum, output; // nodes values
	
	
  	public NeuralNet(int inputNum, int hiddenNum, int outputNum, IActivationFunction af) throws Exception {
  		this.inputNum = inputNum;
  		this.hiddenNum = hiddenNum;
  		this.outputNum = outputNum;
  		this.af = af;
  		
  		input = new double[inputNum+1];
  		input[0] = 1.0;
  		
  		hiddenSum = new double[hiddenNum];
  		
  		hiddenOut = new double[hiddenNum+1];
  		hiddenOut[0] = 1.0;
  		
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
  
  
    public void DoTraining(double[] inputValues, double[] outputValues) throws Exception {    	
    	if ((inputValues.length != inputNum) || (outputValues.length != outputNum))
    		throw new Exception("Input/output size mismatch");
    	
      	SetInputNeurons(inputValues);     // set input neurons according to input data
      
  		DoForwardPropagation();
      	DoBackwardPropagation();
  	}
  
	protected void SetInputNeurons(double[] inputValues) {
		for (int i = 0; i < inputNum; i++)
			input[i+1] = inputValues[i];
	}

	protected void DoForwardPropagation() {
    	for (int i = 0; i < hiddenNum; i++)
    	{
    		double s = 0.0;
    		
    		for (int j = 0; j <= inputNum; j++)
    			s += input[j] * weightIH[j][i];
    		
    		hiddenSum[i] = s;
    		hiddenOut[i+1] = this.af.Function(hiddenSum[i]);
    	}
    	
    	for (int i = 0; i < outputNum; i++)
    	{
    		double s = 0.0;
    		
    		for (int j = 0; j <= hiddenNum; j++)
    			s += hiddenOut[j] * weightHO[j][i];
    		
    		outputSum[i] = s;
    		output[i] = this.af.Function(outputSum[i]);
    	}
	}
  
	protected void DoBackwardPropagation() {
    	
	}


	protected double RandomWeight() {
		Random rand = new Random();
		return rand.nextDouble();
	}
}
