package DNA;

import Car.GeneticCar;
import Car.Map;
import Car.RandomCollection;
import neuralNet.NeuralNet;
import neuralNet.Sigmoid;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 3/23/17.
 */
public class Population {

    private double mutationRate;
    private List<GeneticCar> population;

    private int generation;

    // new population
    private int iteration;
    public static int MAX_ITERATIONS = 2000;

    private Map map;

    public static int[] neuralNetworkLayerSize = new int[]{5, 5, 1};
    public static double neuralNetworkAcceptanceRate = 0.05;

    public Population(int populationSize, double mutationRate, int map) {
        this.mutationRate = mutationRate;
        this.population = new ArrayList<GeneticCar>();
        this.generation = 1;
        this.iteration = 0;

        this.map = new Map(map);

        // Initialize the random population
        for (int i = 0; i < populationSize; i++) {
            GeneticCar geneticCar = new GeneticCar(this.map.getStartX(), this.map.getStartY(), this.map.getStartDegree(),
                    neuralNetworkLayerSize, neuralNetworkAcceptanceRate).randomiseNeuralNetwork();
            geneticCar.addCheckpoints(this.map.getCheckpoints());

            this.population.add(geneticCar);
        }

    }

    public void doMoves() {
        this.iteration++;
        boolean carsAreSimulating = false;
        for (GeneticCar geneticCar : this.population) {
            if (!geneticCar.isCrashed()) {
                geneticCar.update(this.map);
                geneticCar.checkWallIntersection(this.map.getLines());
                geneticCar.checkCheckpointIntersection(this.map.getCheckpoints());
                geneticCar.makeNNdecision();
                carsAreSimulating = true;
            }
        }

        // No car is moving anymore -> new population
        // Simulation ran too long -> new population
        if (!carsAreSimulating || this.iteration > Population.MAX_ITERATIONS) {
            doSelectionProcess();
        }
    }

    // Create new population with Crossover and Mutation
    private void doSelectionProcess() {
        this.iteration = 0;
        List<GeneticCar> newPopulation = new ArrayList<GeneticCar>();

        // Elitism -> always take the fittest element without change
        newPopulation.add(fittestCar(this.population));

        // Make collection of GeneticCars and their fitness, which will be their probability of being chosen for
        // next population
        RandomCollection<GeneticCar> randomCarCollection = new RandomCollection<GeneticCar>();
        for (GeneticCar geneticCar : this.population) {
            randomCarCollection.add(geneticCar.getFitness(), geneticCar);
        }

        // now chose populationSize-1 times 2 parents and combine their dna
        while(newPopulation.size() < this.population.size()) {
        //for (int i = 0; i < this.population.size()-1; i++) {

            // chose 2 parents at random with their fitness as probability
            DNA parent1 = new DNA(randomCarCollection.next());
            DNA parent2 = new DNA(randomCarCollection.next());

            // apply bitwise crossover and mutation
            DNA child = DNA.bitwiseCrossover(parent1, parent2, 0.5);
            child.applyMutation(this.mutationRate);

            // DNA class to List<byte[]>
            List<byte[]> childByteList = NeuralNet.byteArrayToByteList(child.getDNA());

            // Create the NeuralNetwork with the resulting DNA
            NeuralNet childNeuralNetwork;
            try {
                childNeuralNetwork = new NeuralNet(neuralNetworkLayerSize, new Sigmoid(1.0), 0.5);
                childNeuralNetwork.setWeightsFromByteList(childByteList);

                // Create the GeneticCar object
                GeneticCar geneticCarChild = new GeneticCar(this.map.getStartX(), this.map.getStartY(), this.map.getStartDegree(),
                        neuralNetworkLayerSize, neuralNetworkAcceptanceRate);
                geneticCarChild.addCheckpoints(this.map.getCheckpoints());

                // Give it the new DNA for the Neural Network
                geneticCarChild.setNeuralNet(childNeuralNetwork);

                // add child to new population
                newPopulation.add(geneticCarChild);

            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        this.population = newPopulation;
        this.generation++;

    }

    // Returns the GeneticCar with the highest fitness
    private GeneticCar fittestCar(List<GeneticCar> carList) {
        GeneticCar fittest = carList.get(0);

        for (GeneticCar car : carList) {
            if (car.getFitness() > fittest.getFitness()) {
                fittest = car;
            }
        }

        GeneticCar returnMe = new GeneticCar(this.map.getStartX(), this.map.getStartY(), this.map.getStartDegree(),
                neuralNetworkLayerSize, neuralNetworkAcceptanceRate);
        returnMe.addCheckpoints(this.map.getCheckpoints());

        returnMe.setNeuralNet(fittest.getNeuralNet());

        return returnMe;
    }

    public double getTotalFitnessOfPopulation() {
        double fitness = 0;
        for (GeneticCar geneticCar : this.population) {
            fitness += geneticCar.getFitness();
        }
        return fitness;
    }

    // Set coordinates and degree to starting point of map for all elements in the population
    private void initializeCoordinates() {
        for (GeneticCar geneticCar : this.population) {
            geneticCar.resetCar(this.map.getStartX(), this.map.getStartY(), this.map.getStartDegree());
        }
    }

    public List<GeneticCar> getPopulation() {
        return this.population;
    }

    public int getGeneration() {
        return this.generation;
    }

    public Map getMap() {
        return this.map;
    }

    public int getIteration() {
        return this.iteration;
    }
}
