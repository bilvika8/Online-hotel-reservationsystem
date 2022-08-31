package model;

public class ConcreteDelRoom implements Cmnd 
{
    private Admin admin;
    @Override
    public void execute() 
    {
        admin.deleteRoom();        
    }
    ConcreteDelRoom(Admin admin) 
    {
        this.admin = admin;
    }
    
}
