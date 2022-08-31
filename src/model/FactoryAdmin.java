package model;

public class FactoryAdmin extends AbstractFactory 
{
    @Override
    Guest getUser(String user) 
    {
        return null;
    }  
    
    @Override
    Admin getAdmin(String admin) 
    {
        if(admin == null)
            return null;
        if(admin.equalsIgnoreCase("Admin"))
            return new ConcrtAdmin();          
        return null;
    }
    
}
