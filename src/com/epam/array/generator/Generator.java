package com.epam.array.generator;

import com.epam.array.entity.IntArray;
import com.epam.array.entity.Matrix;
import com.epam.array.exception.IndexingException;
import com.epam.array.exception.ArrayCreationException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Generator {

    private final static Logger logger = LogManager.getLogger(Generator.class);

    public Generator() {}

    public IntArray generateArrayFormFile(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        Scanner scanner = new Scanner(file);
        IntArray array = new IntArray();
        try {
            while (scanner.hasNextInt()) {
                array.add(scanner.nextInt());
            }
        } finally {
            scanner.close();
        }
        logger.info("Generate new array from file");
        return array;
    }

    public IntArray generateArrayWithRandom(int size, int left, int right) throws ArrayCreationException, IndexingException, ArrayCreationException {
        if(left >= right) {
            throw new ArrayCreationException("The left border of the random should be smaller than the right");
        }
        if(size < 0) {
            throw new ArrayCreationException("Array size can not be negative");
        }
        IntArray array = new IntArray(size);
        for (int i = 0; i < size; i++) {
            int item = (int)((Math.random() * (right - left)) + left);
            array.set(i, item);
        }
        logger.info("Generate new array with random");
        return array;
    }

    public Matrix generateMatrixWithRandom(int n, int m, int left, int right) throws ArrayCreationException, ArrayCreationException, IndexingException {
        if(left >= right) {
            throw new ArrayCreationException("The left border of the random should be smaller than the right");
        }
        if(n <= 0 || m <= 0) {
            throw new ArrayCreationException("Matrix size can not be negative");
        }
        Matrix matrix = new Matrix(n, m);
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                int value = (int)((Math.random() * (right - left)) + left);
                matrix.setValue(i, j, value);
            }
        }
        logger.info("Generate new matrix with random");
        return matrix;
    }
}
