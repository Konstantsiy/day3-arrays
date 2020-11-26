package com.epam.array.service;

import com.epam.array.entity.IntArray;
import com.epam.array.exception.SearchingServiceException;

public class SearchingService {

    private final NumberCheckingService numberCheckingService = new NumberCheckingService();

    public SearchingService() {}

    public int binarySearch(IntArray array, int value) throws SearchingServiceException {
        if(array.isEmpty()) {
            throw new SearchingServiceException("Array must not be empty");
        }
        if(!array.isSorted()){
            throw new SearchingServiceException("The array must be sorted before binary search");
        }
        int[] ms = array.getValues();
        int low = ms[0];
        int high = ms[ms.length - 1];
        int index = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (ms[mid] < value) {
                low = mid + 1;
            } else if (ms[mid] > value) {
                high = mid - 1;
            } else if (ms[mid] == value) {
                index = mid;
                break;
            }
        }
        return index;
    }

    public int findMin(IntArray array) throws SearchingServiceException {
        if(array.isEmpty()) {
            throw new SearchingServiceException("Array must not be empty");
        }
        int[] ms = array.getValues();
        int min = ms[0];
        for(int i = 1; i < ms.length; i++) {
            if(ms[i] < min) {
                min = ms[i];
            }
        }
        return min;
    }

    public int findMax(IntArray array) throws SearchingServiceException {
        if(array.isEmpty()) {
            throw new SearchingServiceException("Array must not be empty");
        }
        int[] ms = array.getValues();
        int max = ms[0];
        for(int i = 1; i < ms.length; i++) {
            if(ms[i] > max) {
                max = ms[i];
            }
        }
        return max;
    }

    public IntArray findPrimeNumbers(IntArray array) {
        IntArray primeNumbers = new IntArray();
        for(int number : array.getValues()) {
            if(numberCheckingService.isPrime(number)) {
                primeNumbers.add(number);
            }
        }
        return primeNumbers;
    }

    public IntArray findFibonacciNumbers(IntArray array) {
        IntArray fibonacciNumbers = new IntArray();
        for(int number : array.getValues()) {
            if(numberCheckingService.isFibonacci(number)) {
                fibonacciNumbers.add(number);
            }
        }
        return fibonacciNumbers;
    }

    public IntArray find3DigitUniqueNumbers(IntArray array) {
        IntArray uniqueNumbers = new IntArray();
        for(int number : array.getValues()) {
            if(number > 99 && number < 1000) {
                if(numberCheckingService.isUnique(number)) {
                    uniqueNumbers.add(number);
                }
            }
        }
        return uniqueNumbers;
    }
}
