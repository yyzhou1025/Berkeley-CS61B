package hw2;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    //create a grid
    private boolean word[][];
    //instance value for N
    private int dimension;
    //number of open sites
    private int openSites;
    //connect to top, not bottom
    private WeightedQuickUnionUF unionTop;
    //connect to top and bottom
    private WeightedQuickUnionUF unionTopBottom;


    /**
     * create N-by-N grid, with all sites initially blocked.
     * @param N the length of the side
     */
    public Percolation(int N) {
        if (N <= 0) {
            throw  new java.lang.IllegalArgumentException("The value of N is illegal");
        }
        this.dimension = N;
        this.word = new boolean[N][N];
        for (int i = 0; i < N - 1; i ++) {
            for (int j = 0; j < N - 1; j++ ) {
                word[i][j] = false;
            }
        }
        this.openSites = 0;
        this.unionTop = new WeightedQuickUnionUF(N * N + 1);
        this.unionTopBottom = new WeightedQuickUnionUF(N * N + 2);

    }

    /**
     * open the site (row, col) if it is not open already.
     * @param row in which row
     * @param col in which column
     */
    public void open(int row, int col) {
         if (row < 0 || col < 0 || row >= dimension || col >= dimension) {
             throw new java.lang.IndexOutOfBoundsException ("The value of row or col is illegal");
         }
         if (word[row][col]) {
             return;
         } else{
             openSites++;
             word[row][col] = true;
             int index1D = xyTo1D(row, col);

             if (row > 0 && isOpen(row - 1, col)) {                  //up
                 int up = xyTo1D(row - 1, col);
                 unionTopBottom.union(index1D, up);
                 unionTop.union(index1D, up);

             }

             if (row < dimension - 1 && isOpen(row + 1, col)) {          //down
                 int down = xyTo1D(row + 1, col);
                 unionTopBottom.union(index1D, down);
                 unionTop.union(index1D, down);
             }

             if (col > 0 && isOpen(row, col - 1)) {                //left
                   int left = xyTo1D(row, col - 1);
                   unionTop.union(index1D, left);
                   unionTopBottom.union(index1D, left);
             }

             if (col < dimension - 1 && isOpen(row, col + 1)) {          //right
                 int right = xyTo1D(row, col + 1);
                 unionTopBottom.union(index1D, right);
                 unionTop.union(index1D, right);
             }

             if (row == 0) {
                 unionTop.union(index1D, dimension * dimension);
                 unionTopBottom.union(index1D, dimension * dimension);

             }

             if (row == dimension - 1 ) {
                 unionTopBottom.union(index1D, dimension * dimension + 1);
             }

         }


    }

    /**
     * change (x,y) 2D dimension to a single int.
     * @param row in which row
     * @param col  in which column
     * @return int the single value to represent position
     */
    public int xyTo1D(int row, int col) {
        return dimension * row + col;
    }

    /**
     * is the site (row, col) open?
     * @param row in which row
     * @param col in which column
     * @return true if the site is open, return false otherwise
     */
    public boolean isOpen(int row, int col) {
        if (row < 0 || col < 0 || row >= dimension || col >= dimension) {
            throw new java.lang.IndexOutOfBoundsException("The value of row or col is illegal");
        }
        return word[row][col];

    }

    /**
     * is the site (row, col) full?
     * @param row in which row
     * @param col in which column
     * @return true if the site is full, return false otherwise
     */
    public boolean isFull(int row, int col) {
        if (row < 0 || col < 0 || row >= dimension || col >= dimension) {
            throw new java.lang.IndexOutOfBoundsException ("The value of row or col is illegal");

        }
        int index1D = xyTo1D(row, col);
        return unionTop.connected(index1D, dimension * dimension);


    }

    /**
     * number of open sites.
     * @return the numbers of the sites which are open
     */
    public int numberOfOpenSites() {
        return openSites;
    }

    /**
     * does the system percolate?
     * @return true if the system percolate, return false otherwise
     */
    public boolean percolates() {
        return unionTopBottom.connected(dimension * dimension, dimension * dimension + 1);

    }

    /**
     * use for unit testing (not required)
     * @param args
     */
    public static void main(String[] args) {
        Percolation p = new Percolation(5);
        p.open(0,3);
        System.out.println(p.isOpen(0,3));
        System.out.println(p.isOpen(0,0));

    }

}
