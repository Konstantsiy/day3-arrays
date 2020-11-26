package com.epam.array.service;

import com.epam.array.entity.IntArray;
import com.epam.array.exception.ArrayCreationException;
import com.epam.array.exception.IndexingException;
import com.epam.array.exception.SearchingServiceException;
import com.epam.array.generator.Generator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class SearchingServiceTest {

    private final SearchingService searchingService = new SearchingService();
    private final Generator arrayFiller = new Generator();
    private IntArray array = new IntArray();
    private static final Logger logger = LogManager.getLogger(Math.class);

    @BeforeTest
    public void initArray() throws ArrayCreationException, IndexingException {
        Generator generator = new Generator();
        array = generator.generateArrayWithRandom(12, -20, 20);
    }

    @Test
    public void testFindMin() throws SearchingServiceException {
        array.add(-30);
        Assert.assertEquals(searchingService.findMin(array), -30);
    }

    @Test
    public void testFindMax() throws SearchingServiceException {
        array.add(119);
        array.add(120);
        Assert.assertEquals(searchingService.findMax(array), 120);
    }

    @Test
    public void testFindAllPrimeNumbers() {
        try {
            IntArray test = new IntArray(new int[]{-10, 0, 3, 17, 23, 44, 55});
            IntArray result = new IntArray(new int[]{3, 17, 23});
            Assert.assertEquals(searchingService.findPrimeNumbers(test), result);
        } catch (ArrayCreationException e) {
            logger.error(e.getMessage());
        }
    }

    @Test
    public void testFindAllFibonacciNumbers() {
        IntArray test = new IntArray();
        test.add(34);
        test.add(89);
        test.add(144);
        Assert.assertEquals(searchingService.findFibonacciNumbers(test), test);
    }

    @Test
    public void testFindAll3DigitUniqueNumbers() {
        IntArray test = new IntArray();
        test.add(99);
        test.add(123);
        test.add(223);
        test.add(456);
        test.add(2345);
        IntArray result = null;
        try {
            result = new IntArray(new int[]{123, 456});
            Assert.assertEquals(searchingService.find3DigitUniqueNumbers(test), result);
        } catch (ArrayCreationException e) {
            logger.error(e.getMessage());
        }
    }

    @Test
    public void testBinarySearch() {
        try {
            IntArray test = new IntArray(new int[]{12, 24, 46, 77, 84, 98, 125});
            Assert.assertEquals(searchingService.binarySearch(test, 24), 1);
            Assert.assertEquals(searchingService.binarySearch(array, -30), -1);
        } catch (ArrayCreationException | SearchingServiceException e) {
            logger.error(e.getMessage());
        }
    }
}