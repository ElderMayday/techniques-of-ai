package DNA;

import Car.GeneticCar;
import Car.Map;
import neuralNet.NeuralNet;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 3/23/17.
 */
public class Population {

    private double mutationRate;
    private List<GeneticCar> population;

    private int populationSize;
    private int generation;

    private Map map;

    public static int[] neuralNetworkLayerSize = new int[]{5, 5, 2};
    public static double neuralNetworkAcceptanceRate = 0.9;

    public Population(int populationSize, double mutationRate, int map) {
        this.mutationRate = mutationRate;
        this.population = new ArrayList<GeneticCar>();
        this.populationSize = populationSize;
        this.generation = 1;

        this.map = new Map(2);

        // Initialize the random population
        for (int i = 0; i < this.populationSize; i++) {
            GeneticCar geneticCar = new GeneticCar(this.map.getStartX(), this.map.getStartY(), this.map.getStartDegree(),
                    neuralNetworkLayerSize, neuralNetworkAcceptanceRate).randomiseNeuralNetwork();
            geneticCar.addCheckpoints(this.map.getCheckpoints());

            this.population.add(geneticCar);
        }

    }

    public void doMoves() {
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

        if (!carsAreSimulating) {
            System.out.println("hello");
            doSelectionProcess();
        }
    }

    // Create new population with Crossover and Mutation
    private void doSelectionProcess() {
        List<GeneticCar> newPopulation = new ArrayList<GeneticCar>();

        // Elitism -> always take the fittest element without change
        newPopulation.add(fittestCar(this.population));

        this.population = newPopulation;

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
}
