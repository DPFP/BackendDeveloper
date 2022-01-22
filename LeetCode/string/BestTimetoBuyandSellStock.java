public class BestTimetoBuyandSellStock {

    // solution from LC discussion
    public int maxProfit(int[] prices) {
        // another two pointer problem ?
        if (prices.length == 0) {
            return 0;
        }

        int max = 0;
        int len = prices.length;
        int localMin = prices[0];

        for (int i = 0; i < len; i++) {
            if (prices[i] > localMin) {
                max = Math.max(max, prices[i] - localMin);
            } else {
                localMin = prices[i];
            }
        }

        return max;
    }

    // somehow my improved solution on 1/22/2022 (Cut memory usage to hafl)
    public int maxProfit2(int[] prices) {
        // key is to keep track of the lowest in the past and do the calculation
        int max = 0;
        int lowest = Integer.MAX_VALUE;

        for (int price : prices) {
            lowest = Math.min(lowest, price);
            max = Math.max(max, price - lowest);
        }

        return max;
    }
}
