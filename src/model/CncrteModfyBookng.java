package model;

public class CncrteModfyBookng implements Cmnd 
{
    private Guest guest;
    private SessionRole session;
    @Override
    public void execute() 
    { 
        guest.modifyReservation(session);        
    }
    CncrteModfyBookng(Guest guest, SessionRole session) 
    {
        this.guest = guest;
        this.session = session;
    }    
}
