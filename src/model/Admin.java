package model;

public interface Admin 
{ 
    void deleteUser(String type);
    void deleteRoom();
    void addRoom(String operation);
    void addUser(String type);
    int display(SessionRole session);
    void browseRooms();
    void viewUsers(String type);    
}
