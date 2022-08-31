
package model;

public interface Guest 
{	
    void browseRooms();
    int display(SessionRole session);
    void modifyReservation(SessionRole session);
    void cancelReservation(SessionRole session);
    void reserveRoom(SessionRole session);
}