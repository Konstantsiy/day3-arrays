package com.epam.array.service;

public class NumberCheckingService {

    public NumberCheckingService(){}

    boolean isFibonacci(int number) {
        int previous = 1;
        int current = 1;
        while(current < number) {
            int temp = current;
            current += previous;
            previous = temp;
        }
        return number == current;
    }

    boolean isPrime(int number) {
        if(number < 2) {
            return false;
        }
        int i = 2;
        while(Math.pow(i, 2) < number) {
            if(number % i++ == 0) {
                return false;
            }
        }
        return true;
    }

    boolean isUnique(int number) {
        String str = String.valueOf(number);
        boolean flag = true;
        int i = 0;
        while(i < str.length()) {
            int j = 0;
            while(j < str.length()) {
                if(j != i) {
                    if(str.charAt(i) == str.charAt(j)) {
                        return false;
                    }
                }
                j++;
            }
            i++;
        }
        return true;
    }
}
