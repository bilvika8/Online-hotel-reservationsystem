package model;

public class CncrteBrwseRooms implements Cmnd {

    private Admin admin;
    @Override
    public void execute() {
        admin.browseRooms();        
    }
    CncrteBrwseRooms(Admin admin) {
        this.admin = admin;
    }
    
}
