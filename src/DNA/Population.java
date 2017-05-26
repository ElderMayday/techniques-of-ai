package DNA;

import Car.Car;
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

    public static int[] neuralNetworkLayerSize = new int[]{Car.degrees.size(),5, 2};//5, 2};;
    public static double neuralNetworkAcceptanceRate = 0.01;

    // defines how many iterations it takes so that a car in the list starts
    // set at 5: car1 starts at iteration 0, car 2 at 5, car 3 at 10, etc.
    public static int deferredStart = 5;

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

    // Do the movement for the whole car population
    public void doMoves() {
        this.iteration++;
        boolean carsAreSimulating = false;

        // variable needed for the deferred start
        int startCounter = 0;

        for (GeneticCar geneticCar : this.population) {
            startCounter += deferredStart + 1;
            if (this.iteration+deferredStart >= startCounter) {
                if (!geneticCar.isCrashed()) {
                    geneticCar.update(this.map);
                    geneticCar.checkWallIntersection(this.map.getLines());
                    geneticCar.checkCheckpointIntersection(this.map.getCheckpoints());
                    geneticCar.makeNNdecision();

                    // uncomment this when wanting speed factors per car
                    //if (geneticCar.getCurrSpeed() > 0) {
                    carsAreSimulating = true;
                    //}

                    // is this car fitter than the fittest car?
                    if (geneticCar.getFitness() > this.fittestGeneticCar.getFitness()) {
                        this.fittestGeneticCar = geneticCar;
                    }
                }
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

        // 1/2 of all new population is a mutated version of the fittest car
        /*
        for (int i = 0; i < this.population.size()/2; i++){
            DNA fittestDNA = new DNA(newPopulation.get(0));
            fittestDNA.applyMutation(this.mutationRate);
            newPopulation.add(createGeneticCarFromDNA(fittestDNA));
        }*/

        // Make collection of GeneticCars and their fitness, which will be their probability of being chosen for
        // next population
        RandomCollection<GeneticCar> randomCarCollection = new RandomCollection<GeneticCar>();
        RandomCollection<GeneticCar> randomCarCollectionReduced;
        for (GeneticCar geneticCar : this.population) {
            randomCarCollection.add(geneticCar.getFitness(), geneticCar);
        }

        // now chose populationSize-1 times 2 parents and combine their dna
        while(newPopulation.size() < this.population.size()) {

            // Choose first parent from whole dna pool
            GeneticCar geneticParent1 = randomCarCollection.next();

            // Make new collection without the first parent

            randomCarCollectionReduced = new RandomCollection<GeneticCar>();
            for (GeneticCar geneticCar : this.population) {
                if (!geneticCar.equals(geneticParent1)) {
                    randomCarCollectionReduced.add(geneticCar.getFitness(), geneticCar);
                }
            }

            // choose second parent from restricted dna pool
            //GeneticCar geneticParent2 = randomCarCollectionReduced.next();

            GeneticCar geneticParent2 = randomCarCollection.next();

            // transform both parents into a dna string
            DNA parent1 = new DNA(geneticParent1);
            DNA parent2 = new DNA(geneticParent2);

            // calculate weight for parent1
            //double p1weight = geneticParent1.getFitness()/(geneticParent1.getFitness() + geneticParent2.getFitness());
            //double p1weight = 0.5;

            // apply bitwise crossover and mutation
            DNA child = DNA.bitwiseCrossover(parent1, parent2, 0.5);
            child.applyMutation(this.mutationRate);

            newPopulation.add(createGeneticCarFromDNA(child));
        }

        this.population = newPopulation;
        this.generation++;

    }

    private GeneticCar createGeneticCarFromDNA(DNA dna){
        List<byte[]> byteList = NeuralNet.byteArrayToByteList(dna.getDNA());

        // Create the NeuralNetwork with the resulting DNA
        NeuralNet neuralNetwork;
        try {
            neuralNetwork = new NeuralNet(neuralNetworkLayerSize, new Sigmoid(1.0), 0.5);
            neuralNetwork.setWeightsFromByteList(byteList);

            // Create the GeneticCar object
            GeneticCar geneticCar = new GeneticCar(this.map.getStartX(), this.map.getStartY(), this.map.getStartDegree(),
                    neuralNetworkLayerSize, neuralNetworkAcceptanceRate);
            geneticCar.addCheckpoints(this.map.getCheckpoints());

            // Give it the new DNA for the Neural Network
            geneticCar.setNeuralNet(neuralNetwork);

            // add child to new population
            return geneticCar;

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

    // changing the map
    public void setMap(int mapNumber){
        this.map = new Map(mapNumber);
        this.doSelectionProcess();
    }

    public int getIteration() {
        return this.iteration;
    }
}
