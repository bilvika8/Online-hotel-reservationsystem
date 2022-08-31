package model;

public class FactoryGuest extends AbstractFactory 
{
	@Override
    Guest getUser(String user) 
    {
        if(user == null)
            return null;
        if(user.equalsIgnoreCase("Guest"))
            return new CncrtGuest();
        
        return null;
    }
	
    @Override
    Admin getAdmin(String admin) 
    {
        return null;
    }

    
    
}
