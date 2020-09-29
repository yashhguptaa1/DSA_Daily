package Unit3_Matrix.Knapsack;

public class Solution {
    public int knapsack(int[] values, int[] weights, int maxWeightConstraint) {
        int[][] cache = new int[values.length + 1][maxWeightConstraint + 1];

        for (int totalItems = 0; totalItems <= values.length; totalItems++) {
            for (int maxWeight = 0; maxWeight <= maxWeightConstraint; maxWeight++) {


                int currentItem = totalItems - 1;

                if (totalItems == 0 || maxWeight == 0) {
                    cache[totalItems][maxWeight] = 0;
                } else if (weights[currentItem] > maxWeight) {
                    cache[totalItems][maxWeight] = cache[totalItems - 1][maxWeight];
                } else {
                    int withItem = values[currentItem] + cache[totalItems - 1][maxWeight - weights[currentItem]];
                    int withoutItem = cache[totalItems - 1][maxWeight];

                    cache[totalItems][maxWeight] = Math.max(withItem, withoutItem);
                }
            }
        }

        return cache[values.length][maxWeightConstraint];
    }

}