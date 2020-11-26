package com.epam.array.main;


import com.epam.array.entity.IntArray;
import com.epam.array.entity.Matrix;
import com.epam.array.entity.SearchParam;
import com.epam.array.exception.SearchingServiceException;
import com.epam.array.exception.ArrayCreationException;
import com.epam.array.exception.IndexingException;
import com.epam.array.generator.Generator;
import com.epam.array.service.SortingService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileNotFoundException;

public class Main {

    public static final Logger logger = LogManager.getLogger(Math.class);

    public static void main(String[] args) {
        Generator generator = new Generator();
        try {
            Matrix matrix = generator.generateMatrixWithRandom(5, 4, 0, 10);
            SortingService sortingService = new SortingService();
            Matrix result = sortingService.matrixBubbleSort(matrix, true, SearchParam.FIND_SUM);
            System.out.println(matrix);
            IntArray array = generator.generateArrayFormFile("res/data/array.txt");
            System.out.println(array);
        } catch (SearchingServiceException | IndexingException | ArrayCreationException | FileNotFoundException e) {
            logger.error(e.getMessage());
        }
    }
}
