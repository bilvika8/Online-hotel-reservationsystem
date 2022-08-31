package model;

public abstract class AbstractFactory 
{  
    abstract Guest getUser(String user);
    abstract Admin getAdmin(String admin);
    
}
