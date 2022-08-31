package model;

public class CncrtResrveRoom implements Cmnd 
{   
    private SessionRole session;
    private Guest guest;

    @Override
    public void execute() 
    {
        guest.reserveRoom(session);        
    }
    CncrtResrveRoom(Guest guest, SessionRole session) 
    {
        this.guest = guest;
        this.session = session;
    }
    
}
