package DNA;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 3/22/17.
 */
public class DNA {

    private byte[] dna;

    public DNA(int size) {
        this.dna = new byte[size];
    }

    public DNA(byte[] dna) {
        this.dna = dna;
    }

    public DNA randomise() {
        for (int i = 0; i < this.dna.length; i++) {
            this.dna[i] = (byte)(Math.floor(Math.random()*256));
        }

        return this;
    }

    /*
    iterate through each bit of the dna with P(probability) chance
     */
    public void applyMutation(double probability) {
        for (int i = 0; i < dna.length; i++) {
            for (int bit = 0; bit < 8; bit++) {
                if (Math.random() <= probability) {
                    this.dna[i] ^= 1 << bit;
                }
            }
        }
    }

    /*
    bitwise Crossover of 2 DNA strands. dna1 has a P(probability) of being chosen over dna2
    in the resulting dna strand.
    This allows for bias in either dna1 or dna2. For equal probability -> 0.5
     */
    public static DNA bitwiseCrossover(DNA dna1, DNA dna2, double probability) {
        byte[] newDNA = new byte[dna1.getDNA().length];

        DNA currDNA;

        for (int i = 0; i < dna1.getDNA().length; i++) {
            //System.out.println(Byte.toString(currDNA.getDNA()[i]));

            for (int bit = 0; bit < 8; bit++) {

                if (Math.random() <= probability) {
                    currDNA = dna1;
                } else {
                    currDNA = dna2;
                }

                // is bit set at currDNA? -> set bit in newDNA
                if ((currDNA.getDNA()[i] & (1 << bit)) != 0) {
                    newDNA[i] |= 1 << bit;
                }
            }
        }
        return new DNA(newDNA);
    }

    public void setDNA(byte[] dna) {
        this.dna = dna;
    }

    public byte[] getDNA() {
        return this.dna;
    }

}