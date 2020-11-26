package com.epam.array.service;


import org.testng.Assert;
import org.testng.annotations.Test;

public class NumberCheckingServiceTest {

    private final NumberCheckingService numberCheckingService = new NumberCheckingService();

    @Test
    public void testIsFibonacci() {
        Assert.assertTrue(numberCheckingService.isFibonacci(34));
        Assert.assertFalse(numberCheckingService.isFibonacci(14));
    }

    @Test
    public void testIsPrime() {
        Assert.assertTrue(numberCheckingService.isPrime(17));
        Assert.assertFalse(numberCheckingService.isPrime(14));
    }

    @Test
    public void testIsUnique() {
        Assert.assertTrue(numberCheckingService.isUnique(1234));
        Assert.assertFalse(numberCheckingService.isUnique(121));
    }
}