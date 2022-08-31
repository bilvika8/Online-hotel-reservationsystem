package model;

public class AuthrizationException extends RuntimeException 
{
    public AuthrizationException(String methodName) 
    {
        super("Authorization is Invalid - Denined Access methodname:" + methodName + "() to function");
    }
}
