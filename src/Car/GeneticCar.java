package Car;

import DNA.DNA;
import neuralNet.NeuralNet;
import neuralNet.Sigmoid;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 3/23/17.
 */
public class GeneticCar extends Car {

    private NeuralNet neuralNet;
    private double acceptanceRate;

    public GeneticCar(double x, double y, double degree, int[] NNlayerSize, double acceptanceRate) {
        super(x,y,degree);
        this.acceptanceRate = acceptanceRate;
        try {
            this.neuralNet = new NeuralNet(NNlayerSize, new Sigmoid(1.0), 0.5);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public GeneticCar randomiseNeuralNetwork() {
        //Transforming NeuralNetwork to byte[] to DNA to List<byte[]
        byte[] dnaByteArr = NeuralNet.byteListToByteArray(this.neuralNet.getWeightsInByteList());
        DNA dna = new DNA(dnaByteArr).randomise();
        dnaByteArr = dna.getDNA();
        List<byte[]> dnaList = NeuralNet.byteArrayToByteList(dnaByteArr);
        neuralNet.setWeightsFromByteList(dnaList);

        return this;
    }

    // Feed FOV distance lines to NN and make decision
    public void makeNNdecision() {
        List<Double> fovInputList = super.getFOVdata();
        double[] input = fovInputList.stream().mapToDouble(d -> d).toArray();
        try {
            double [] output = this.neuralNet.GetOutput(input);

            if (output[0] > this.acceptanceRate) {
                super.goLeft();
            }
            if (output[1] > this.acceptanceRate) {
                super.goRight();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public NeuralNet getNeuralNet(){
        return this.neuralNet;
    }

    public void setNeuralNet(NeuralNet neuralNet) {
        this.neuralNet = neuralNet;
    }
}
