package com.epam.array.service;

import com.epam.array.entity.IntArray;
import com.epam.array.exception.ArrayCreationException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;


public class SortingServiceTest {

    private final static Logger logger = LogManager.getLogger(SortingServiceTest.class);

    @Test
    public void testAllArraySorts() {
        SortingService sortingService = new SortingService();
        try {
            IntArray array = new IntArray(30);
            IntArray result = sortingService.shellSort(array);
            Assert.assertEquals(sortingService.arrayBubbleSort(array), result);
            Assert.assertEquals(sortingService.insertionSort(array), result);
        } catch (ArrayCreationException e) {
            logger.error(e.getMessage());
        }
    }
}