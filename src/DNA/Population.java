package DNA;

import Car.Car;
import Car.GeneticCar;
import Car.Map;
import Car.RandomCollection;
import neuralNet.NeuralNet;
import neuralNet.Sigmoid;

import java.util.ArrayList;
import java.util.Iterator;
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

    public static int[] neuralNetworkLayerSize = new int[]{Car.degrees.size(), 3, 1};
    public static double neuralNetworkAcceptanceRate = 0.1;

    // Pointer for the fittest car that the GA produced
    private GeneticCar fittestGeneticCar;

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

        this.fittestGeneticCar = this.population.get(0);

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

                // is this car fitter than the fittest car?
                if (geneticCar.getFitness() > this.fittestGeneticCar.getFitness()) {
                    this.fittestGeneticCar = geneticCar;
                }
            }
        }


        /*
        int addNcars = 0;
        for (Iterator<GeneticCar> iterator = this.population.iterator(); iterator.hasNext(); ){
            GeneticCar geneticCar = iterator.next();
            if (geneticCar.isCrashed()) {
                iterator.remove();
                addNcars++;
            }
        }

        for (int i = 0; i < addNcars; i++) {
            this.population.add(getNewGeneticCar());
        }*/

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

    private GeneticCar getNewGeneticCar() {

        // Make collection of GeneticCars and their fitness, which will be their probability of being chosen for
        // next population
        RandomCollection<GeneticCar> randomCarCollection = new RandomCollection<GeneticCar>();
        boolean fittestWasAdded = false;
        for (GeneticCar geneticCar : this.population) {
            randomCarCollection.add(geneticCar.getFitness(), geneticCar);
            if (geneticCar.equals(this.fittestGeneticCar)) {
                fittestWasAdded = true;
            }
        }

        if (!fittestWasAdded) {
            randomCarCollection.add(this.fittestGeneticCar.getFitness(), this.fittestGeneticCar);
        }

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
            return geneticCarChild;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
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
