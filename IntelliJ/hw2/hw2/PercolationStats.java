package hw2;

import java.util.Random;

public class PercolationStats {
    private Random RANDOM;
    private int[] result;
    /**
     * perform T independent experiments on an N-by-N grid.
     * @param N the dimension
     * @param T the number of experiments
     * @param pf create independent percolation
     */
    public PercolationStats(int N, int T, PercolationFactory pf) {
        this.RANDOM = new Random();
        this.result = new int[T];
        if (N <= 0 || T <= 0) {
            throw new java.lang.IllegalArgumentException("The value of N or T is illegal");
        }
        for (int i = 0; i < T; i++) {
            Percolation p = pf.make(N);
            while (!p.percolates()) {
                int row, col;
                row = RANDOM.nextInt(N);
                col = RANDOM.nextInt(N);
                p.open(row, col);
            }
            result[i] = p.numberOfOpenSites();

        }




    }

    /**
     * sample mean of percolation threshold.
     * @return double value of mean
     */
    public double mean() {
        int total = 0;
        for (int i: result) {
            total = total + i;
        }
        double m = total / result.length;
        return m;
    }

    /**
     * sample standard deviation of percolation threshold.
     * @return double value of standard deviation
     */
    public double stddev() {
        double total = 0;
        double[] container = new double[result.length];
        for (int i : result) {
            container[i] = (i - this.mean()) * (i - this.mean());

        }
        for (double i : container) {
            total = total + i;
        }

        return Math.sqrt(total / (result.length  - 1));

    }

    /**
     * low endpoint of 95% confidence interval
     * @return
     */
    public double confidenceLow() {
        return mean() - (1.96 * stddev())/Math.sqrt(result.length);

    }

    /**
     * high endpoint of 95% confidence interval.
     * @return
     */
    public double confidenceHigh() {
        return mean() + (1.96 * stddev())/Math.sqrt(result.length);

    }


}
