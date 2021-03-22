package Week2_ThrowingExceptions;

// ****************************************************************
// MathUtils.java
//
// Provides static mathematical utility functions.
//
// ****************************************************************
public class MathUtils
{
    //-------------------------------------------------------------
// Returns the factorial of the argument given
//-------------------------------------------------------------
    public static int factorial(int n)
    {
        if(n < 0)
            throw new IllegalArgumentException("Minus number");
        if(n > 16)
            throw new IllegalArgumentException("Cannot exceed 16");
        int fac = 1;
        for (int i=n; i>0; i--)
            fac *= i;
        return fac;
    }
}
