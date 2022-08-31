package model;

public class CncrtCanclBkng implements Cmnd 
{  
    private SessionRole session; 
    private Guest guest;

    @Override
    public void execute() 
    {
        guest.cancelReservation(session);        
    }
    
    CncrtCanclBkng(Guest guest, SessionRole session) 
    {
        this.guest = guest;
        this.session = session;
    }
}
