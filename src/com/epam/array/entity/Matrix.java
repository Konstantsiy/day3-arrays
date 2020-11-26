package com.epam.array.entity;

import com.epam.array.exception.IndexingException;
import com.epam.array.exception.ArrayCreationException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public class Matrix {

    private final static Logger logger = LogManager.getLogger(Matrix.class);

    private int[][] mx;

    public Matrix(){
        this.mx = new int[0][0];
        logger.info("Create new matrix");
    }

    public Matrix(int[][] mx){
        this.mx = mx;
    }

    public Matrix(int n, int m) throws ArrayCreationException {
        if(n <= 0 || m <= 0) {
            throw new ArrayCreationException("Matrix size cannot be negative");
        }
        this.mx = new int[n][m];
        logger.info("Create new matrix with size " + n + "x" + m);
    }

    public int[][] getMx() {
        return mx;
    }

    public int getN() {
        return mx.length;
    }

    public int getM() {
        return mx[0].length;
    }

    public int[] getRow(int i) {
        return mx[i];
    }

    public void setRow(int index, int[] newRow) throws IndexingException {
        if(index < 0 || index > mx.length || newRow.length != mx[0].length) {
            throw new IndexingException("Cannot exceed matrix size");
        }
        mx[index] = newRow;
        logger.info("Set row in matrix in position: " + index);
    }

    public void setValue(int i, int j, int value) throws IndexingException {
        if(i < 0 || j < 0) {
            throw new IndexingException("Cannot exceed matrix size");
        }
        mx[i][j] = value;
        logger.info("Set value in matrix in position: (" + i + ", " + j + ")");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Matrix matrix = (Matrix) o;
        if(mx.length != matrix.getN() || mx[0].length != matrix.getM()) return false;
        for(int i = 0; i < mx.length; i++) {
            if(!Arrays.equals(mx[i], matrix.getRow(i))) return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = 31 * 17;
        for (int[] ints : mx) {
            result += Arrays.hashCode(ints);
        }
        return result;
    }

    @Override
    public String toString() {
        StringBuilder s  = new StringBuilder();
        for (int[] ints : mx) {
            for (int anInt : ints) {
                s.append(anInt).append("   ");
            }
            s.append("\n");
        }
        return s.toString();
    }
}
