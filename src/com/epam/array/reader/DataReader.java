package com.epam.array.reader;

import com.epam.array.entity.IntArray;
import com.epam.array.exception.ArrayCreationException;

import java.util.Scanner;

public class DataReader {

    public DataReader() {}

    public IntArray readIntArray() throws ArrayCreationException {
        Scanner scanner = new Scanner(System.in);
        int[] ms;
        System.out.print("Enter array size: ");
        try {
            int size;
            boolean flag;
            do {
                flag = true;
                size = scanner.nextInt();
                if(size < 0) {
                    System.out.print("Array size can not be negative! try again: ");
                    scanner.next();
                    flag = false;
                }
            } while(!flag);
            ms = new int[size];
            for(int i = 0; i < size; i++) {
                System.out.print("ms[" + i + "]: ");
                if(scanner.hasNextInt()) {
                    ms[i] = scanner.nextInt();
                } else {
                    System.out.println("You must enter an integer!");
                    scanner.next();
                    i--;
                }
            }
        } finally {
            scanner.close();
        }
        return new IntArray(ms);
    }
}
