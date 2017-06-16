package DNA;

import java.util.Arrays;

/**
 * Created by root on 3/22/17.
 */
public class testDNA {

    public static void main(String [ ] args) {
        DNA dna = new DNA(4).randomise();
        DNA dna2 = new DNA(4).randomise();

        dna.applyMutation(0.5);

        System.out.println("dna 1 : " + Arrays.toString(dna.getDNA()));
        System.out.println("dna 2 : " + Arrays.toString(dna2.getDNA()));

        DNA dna3 = DNA.bitwiseCrossover(dna, dna2, 0.5);

        System.out.println("dna crossover: " + Arrays.toString(dna3.getDNA()));
    }
}
