package com.epam.array.service;

import com.epam.array.entity.IntArray;
import com.epam.array.entity.Matrix;
import com.epam.array.entity.SearchParam;
import com.epam.array.exception.IndexingException;
import com.epam.array.exception.SearchingServiceException;
import com.epam.array.exception.ArrayCreationException;

import java.util.stream.IntStream;

public class SortingService {

    private final SearchingService searchingService = new SearchingService();

    public SortingService() {}

    public IntArray shellSort(IntArray array) throws ArrayCreationException {
        int[] ms = array.getValues();
        int length = ms.length;
        int i, j, temp, step;
        for (step = length / 2; step > 0; step /= 2) {
            for (i = step; i < length; i++) {
                temp = ms[i];
                for (j = i; j >= step; j -= step) {
                    if (temp < ms[j - step]) {
                        ms[j] = ms[j - step];
                    } else break;
                }
                ms[j] = temp;
            }
        }
        return new IntArray(ms);
    }

    public IntArray insertionSort(IntArray array) throws ArrayCreationException {
        int[] ms = array.getValues();
        for (int i = 1; i < ms.length; i++) {
            int current = ms[i];
            int j = i - 1;
            while(j >= 0 && current < ms[j]) {
                ms[j+1] = ms[j];
                j--;
            }
            ms[j+1] = current;
        }
        return new IntArray(ms);
    }

    public IntArray arrayBubbleSort(IntArray array) throws ArrayCreationException {
        int[] ms = array.getValues();
        for (int i = 0; i < ms.length - 1; i++) {
            for (int j = ms.length - 1; j > i; j--) {
                if (ms[j - 1] > ms[j]) {
                    int temp = ms[j - 1];
                    ms[j - 1] = ms[j];
                    ms[j] = temp;
                }
            }
        }
        return new IntArray(ms);
    }

    public Matrix matrixBubbleSort(Matrix matrix, boolean asc, SearchParam param) throws IndexingException, ArrayCreationException, SearchingServiceException {
        Matrix newMatrix = new Matrix(matrix.getMx());
        for (int i = 0; i < newMatrix.getN() - 1; i++) {
            for (int j = newMatrix.getN() - 1; j > i; j--) {
                int value1 = 0;
                int value2 = 0;
                if(param == SearchParam.FIND_SUM) {
                    value1 = IntStream.of(newMatrix.getRow(j - 1)).sum();
                    value2 = IntStream.of(newMatrix.getRow(j)).sum();
                } else {
                    IntArray a1 = new IntArray(matrix.getRow(j - 1));
                    IntArray a2 = new IntArray(matrix.getRow(j));
                    if(param == SearchParam.FIND_MAX) {
                        value1 = searchingService.findMax(a1);
                        value2 = searchingService.findMax(a2);
                    } else {
                        value1 = searchingService.findMin(a1);
                        value2 = searchingService.findMin(a2);
                    }
                }
                if(asc) {
                    if(value1 > value2) {
                        int[] temp = newMatrix.getRow(j - 1);
                        newMatrix.setRow(j - 1, newMatrix.getRow(j));
                        newMatrix.setRow(j, temp);
                    }
                } else {
                    if(value1 < value2) {
                        int[] temp = newMatrix.getRow(j - 1);
                        newMatrix.setRow(j - 1, newMatrix.getRow(j));
                        newMatrix.setRow(j, temp);
                    }
                }
            }
        }
        return newMatrix;
    }
}
