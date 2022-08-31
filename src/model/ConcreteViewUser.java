package model;

public class ConcreteViewUser implements Cmnd 
{   
    private String type;
    private Admin admin;

    @Override
    public void execute() 
    {
        admin.viewUsers(type);        
    }
    ConcreteViewUser(Admin admin, String type) 
    {
        
        this.type = type;
        this.admin = admin;
    }
    
}
