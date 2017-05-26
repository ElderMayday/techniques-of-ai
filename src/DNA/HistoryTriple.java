package DNA;

/**
 * Created by root on 5/26/17.
 */
public class HistoryTriple {
    private double avg;
    private double highest;
    private double lowest;

    public HistoryTriple(double avg, double highest, double lowest){
        this.avg = avg;
        this.highest = highest;
        this.lowest = lowest;
    }

    public double getAvg() {
        return this.avg;
    }

    public double getHighest(){
        return this.highest;
    }

    public double getLowest() {
        return this.lowest;
    }
}
