package model;

public class ConcreteAddingUser implements Cmnd 
{
    private String type;
    private Admin admin;
    @Override
    public void execute() {
        admin.addUser(type);        
    }
    ConcreteAddingUser(Admin admin, String type) {
        this.admin = admin;
        this.type = type;
    }
}
