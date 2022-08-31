package model;

public class FactoryProducer 
{

    public static AbstractFactory getFactory(String option) 
    {       
        if (option.equalsIgnoreCase("Guest")) 
        {          
        	return new FactoryGuest();
           
        } 
        else if (option.equalsIgnoreCase("Admin")) 
        {
        	return new FactoryAdmin();
        }
        return null;
    }
}
