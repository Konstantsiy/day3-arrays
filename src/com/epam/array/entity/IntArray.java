package com.epam.array.entity;

import com.epam.array.exception.ArrayCreationException;
import com.epam.array.exception.IndexingException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public class IntArray {
    private static final Logger logger = LogManager.getLogger(IntArray.class);
    private int[] values;

    public IntArray() {
        logger.info("Creating new array");
        this.values = new int[0];
    }

    public IntArray(int length) throws ArrayCreationException {
        if(length < 0) {
            throw new ArrayCreationException("Array size cannot be negative");
        }
        this.values = new int[length];
        logger.info("Creating new array with size " + length);
    }

    public IntArray(int[] values) throws ArrayCreationException {
        if(values == null) {
            throw new ArrayCreationException("The array passed as a parameter must not be null");
        }
        this.values = values;
    }

    public int[] getValues() {
        return values;
    }

    public void setValues(int[] values) throws ArrayCreationException {
        if(values == null) {
            throw new ArrayCreationException("Can't set empty array as a field");
        }
        this.values = values;
    }

    public void setSize(int newLength) throws ArrayCreationException {
        if(newLength >= 0) {
            if(values.length > newLength){
                int[] newValues = new int[newLength];
                System.arraycopy(values, 0, newValues, 0, newLength);
                this.values = newValues;
            }
            if(values.length < newLength) {
                int[] newValues = new int[newLength];
                System.arraycopy(values, 0, newValues, 0, values.length);
                for(int i = values.length; i < newLength; i++) {
                    newValues[i] = 0;
                }
                this.values = newValues;
            }
            logger.info("New array size: " + newLength);
        } else {
            throw new ArrayCreationException("Can't set negative length");
        }
    }

    public void add(int number) {
        values = Arrays.copyOf(values, values.length + 1);
        values[values.length - 1] = number;
        logger.info("A new element has been added to the array: " + number);
    }

    public void set(int index, int value) throws IndexingException {
        if(index < 0 || index > values.length) {
            throw new IndexingException("Can't go outside the array when indexing");
        }
        values[index] = value;
    }

    public int size() {
        return values.length;
    }

    public boolean isEmpty() {
        return values.length == 0;
    }

    public boolean isSorted() {
        for(int i = 1; i < values.length; i++) {
            if(values[i - 1] > values[i]) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IntArray array = (IntArray) o;
        return Arrays.equals(values, array.values);
    }

    @Override
    public int hashCode() {
        return 31 * 17 + Arrays.hashCode(values);
    }

    @Override
    public String toString() {
        return Arrays.toString(values);
    }
}
