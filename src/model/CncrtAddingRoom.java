package model;

public class CncrtAddingRoom implements Cmnd 
{   
    private String operator;
    private Admin admin;
    @Override
    public void execute() 
    {
        admin.addRoom(operator);        
    }
    CncrtAddingRoom(Admin admin, String operation) 
    {      
        this.operator = operation;
        this.admin = admin;
    }
    
    
}
