package model;

public class ConcrtGuestBrwseRooms implements Cmnd 
{

    private Guest guest; 
    @Override
    public void execute()
    {
        guest.browseRooms();        
    }
    
    ConcrtGuestBrwseRooms(Guest guest) 
    {
        this.guest = guest;
    }

    
}
