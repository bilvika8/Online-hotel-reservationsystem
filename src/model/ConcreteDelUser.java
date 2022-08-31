package model;

public class ConcreteDelUser implements Cmnd 
{ 
    
    private Admin admin;
    private String type;
    @Override
    public void execute() 
    {
        admin.deleteUser(type);        
    }
    
    ConcreteDelUser(Admin admin, String type) 
    {
        this.admin = admin;
        this.type = type;
    }

    
}
