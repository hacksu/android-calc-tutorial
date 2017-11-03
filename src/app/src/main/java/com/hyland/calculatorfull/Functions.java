package com.hyland.calculatorfull;

public class Functions
{
    public static long add(long a, long b)
    {
        return a + b;
    }

    public static long subtract(long a, long b)
    {
        return a - b;
    }

    public static long multiply(long a, long b)
    {
        return a * b;
    }

    public static long divide(long a, long b) throws ArithmeticException
    {
        if(b == 0)
        {
            throw new ArithmeticException("can't divide by 0");
        }

        return a/b;
    }
}
