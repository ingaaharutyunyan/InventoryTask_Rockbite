import java.util.Random;

public class WeightedRandom {

    public int giveRandom() {
        double[] weights = {0.5, 0.25, 0.15, 0.08, 0.02};
        double[] cumulativeWeights = new double[weights.length];
        cumulativeWeights[0] = weights[0];
        for (int i = 1; i < weights.length; i++) {
            cumulativeWeights[i] = cumulativeWeights[i - 1] + weights[i];
        }

        Random random = new Random();
        double rand = random.nextDouble();

        int result = 0;
        for (int i = 0; i < cumulativeWeights.length; i++) {
            if (rand <= cumulativeWeights[i]) {
                result = i;
                break;
            }
        }

        return result;      
    }
}