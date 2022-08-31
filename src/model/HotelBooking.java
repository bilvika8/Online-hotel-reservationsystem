package model;

import java.rmi.RemoteException;
import java.rmi.Remote;
import java.util.List;

public interface HotelBooking extends Remote 
{   
   
    boolean adminRegister(String userName, String emailid, String passwrd) throws RemoteException;   
    boolean guestRegister(String userName, String emailid, String passwrd) throws RemoteException;
    boolean adminLogin(String userName, String passwrd) throws RemoteException;  
    boolean guestLogin(String userName, String passwrd) throws RemoteException;
    SessionRole processLogin(String userType, String userName) throws RemoteException;    
    List<String> browseRooms() throws RemoteException;   
    boolean addRoom(String operation, String roomNum, String type, String desc, String price, String rating, String noOfBeds,
    	    String typeOfBed, String isSmokingAllowed, String isAvailable) throws RemoteException;
    boolean deleteRoom(String roomNum) throws RemoteException;
    List<String> viewUsers(String type) throws RemoteException;
    boolean deleteUser(String type, String emailid) throws RemoteException;

    String checkRoomAvailability(String roomNum, int days, boolean isNew) throws RemoteException;
    boolean reserveRoom(String roomNum, String emailid, int days, String address, String mobileNum, String cardNum) throws RemoteException;
    List<String> viewBookings(String role, String emailid) throws RemoteException;
    String modifyReservation(String roomNum, String newRoonNum, String emailid, int days) throws RemoteException;
    String cancelReservation(String roomNum, String emailid) throws RemoteException;
    
    
    
   
   
    
    
    
    
}
