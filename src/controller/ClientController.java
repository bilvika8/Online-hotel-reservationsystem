package controller;

import java.rmi.Naming;
import java.util.ArrayList;
import model.DbEntry;
import model.BookngHotelmpl;
import java.util.List;
import java.rmi.RemoteException;
import model.SessionRole;
import model.HotelBooking;

public class ClientController 
{
	SessionRole session = null;
    static HotelBooking stubhotelbooking;
    
    public static void main(String[] args) throws RemoteException 
    {          
        FrontController frontContrller;
        frontContrller = new FrontController();
        DbEntry entry;
        entry = new DbEntry();
        try {
            String name = "//in-csci-rrpc04.cs.iupui.edu:4002/HotelBooking";
            // String name = "localhost12";
            stubhotelbooking = (HotelBooking) Naming.lookup(name);
//            stubhotelbooking = new BookngHotelmpl();
            frontContrller.dispatchRequest(entry.login());

        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }
    public boolean guestLogin(String userName, String password) 
    {
        boolean val = false;
        try 
        {         
            val = stubhotelbooking.guestLogin(userName, password);

        } catch (Exception e) 
        {
            e.printStackTrace();
        }

        return val;
    }
    
    public SessionRole processLogin(String userType, String userName) 
    {
        try 
        { 
            session = stubhotelbooking.processLogin(userType, userName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return session;
    }

    public boolean adminLogin(String userName, String passwd) {
        boolean val = true;
        try 
        {
            val = stubhotelbooking.adminLogin(userName, passwd);
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        return val;
    }

    public List<String> viewUsers(String type) 
    {
        List<String> users = new ArrayList<>();
        try
        {
            users = stubhotelbooking.viewUsers(type);
        } catch (Exception e) 
        {
            e.printStackTrace();
        }
        return users;
    }

    public List<String> browseRooms()
    {
        List<String> rooms = new ArrayList<>();
        try 
        {            
            rooms = stubhotelbooking.browseRooms();
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        return rooms;
    }
    

    
    public void deleteRoom(String roomNo) 
    {
        try 
        {         
            if (stubhotelbooking.deleteRoom(roomNo)) {
                System.out.println("Rooms deleted is:"+roomNo);
                System.out.println("============================");
            } else 
            {
                System.out.println("Rooms:" +roomNo +"is not found");
                System.out.println("===========================");
            }
        } catch (Exception e) 
        {
            e.printStackTrace();
        }
    }
    
    public void deleteUser(String type, String email) 
    {
        try 
        {       
            if (stubhotelbooking.deleteUser(type, email)) {           
                System.out.println(type + " User deleted successfully");
                System.out.println("=====================");
            } else 
            {
               
                System.out.println(type + " User not found");
                System.out.println("=====================");
            }
        } catch (Exception e) 
        {
            e.printStackTrace();
        }
    }

    public void addRoom(String operation, String roomNum, String type, String desc, String price, String rating,
            String noOfBeds,
            String typeOfBed, String isSmokingAllowed, String isAvailable) 
    {
        try 
        {        
            if (stubhotelbooking.addRoom(operation, roomNum, type, desc, price, rating, noOfBeds, typeOfBed, isSmokingAllowed,
                    isAvailable)) 
            {              
                if (operation == "Add")
                    System.out.println("Rooms :"+roomNum+"  added successfully");
                else
                    System.out.println("Rooms :"+roomNum+" updated successfully");
                System.out.println("==========================================");
            } else 
            {
                if (operation == "Add")
                    System.out.println("Rooms:"+roomNum+"  already exists");
                else
                    System.out.println("Rooms :"+roomNum+"not found");
                System.out.println("============================================");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void guestRegister(Boolean isAdmin, String userName, String emailid, String passwrd)
    {
        try 
        {
            if (stubhotelbooking.guestRegister(userName, emailid, passwrd)) 
            {                
                System.out.println("Guest registered sucesfully");
                System.out.println("=========================================");
                if (!isAdmin) 
                {
                    FrontController frontContrller;                    
                    frontContrller = new FrontController();
                    DbEntry entry;
                    entry = new DbEntry();
                    frontContrller.dispatchRequest(entry.login());
                }
            } 
            else 
            {
                System.out.println("Guest Email id already exists");
                System.out.println("=============================================");
            }
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void adminRegister(Boolean isAdmin, String userName, String emailid, String passwrd) 
    {
        try 
        { 
            if (stubhotelbooking.adminRegister(userName, emailid, passwrd)) 
            {
               
                System.out.println("Admin registered successful");
                System.out.println("============================================================");
                if (!isAdmin) {
                    FrontController frontContrller;                   
                    frontContrller = new FrontController();
                    DbEntry entry;
                    entry = new DbEntry();
                    frontContrller.dispatchRequest(entry.login());
                }
            } 
            else 
            {             
                System.out.println("Admin Email id already exists");
                System.out.println("===========================================================");
            }
        } catch (Exception e) 
        {
            e.printStackTrace();
        }
    }

    public void reserveRoom(String roomNum, String emailid, int days, String address, String mobileNum, String cardNum) {
        try 
        {
            String availability = stubhotelbooking.checkRoomAvailability(roomNum, days, true);
            if(!availability.equals("Sorry this room is not available")) 
            {
               
            	stubhotelbooking.reserveRoom(roomNum, emailid, days, address, mobileNum, cardNum);
            }
            System.out.println("Rooms availability is:");
            System.out.println(availability);
            System.out.println("==========================================");
        } catch (Exception e) 
        {
            e.printStackTrace();
        }
    }

    public List<String> viewBookings(String role, String email) 
    {
        List<String> bookings = new ArrayList<>();
        try 
        { 
            bookings = stubhotelbooking.viewBookings(role, email);
        } catch (Exception e) 
        {
            e.printStackTrace();
        }
        return bookings;
    }

    public void modifyReservation(String roomNum, String newRoonNum, String emailid, int days) {
        try {
            
            String availability = stubhotelbooking.checkRoomAvailability(newRoonNum, days, false);
            if(!availability.equals("Sorry this room is not available")) 
            {               
            	stubhotelbooking.modifyReservation(roomNum, newRoonNum, emailid, days);
            }
            System.out.println("Rooms availability is:");
            System.out.println(availability);
            System.out.println("=========================================================");
        } catch (Exception e) 
        {
            e.printStackTrace();
        }
    }

    public void cancelReservation(String roomNum, String emailid) 
    {
        try 
        {
            String availability = stubhotelbooking.cancelReservation(roomNum, emailid);
            System.out.println(availability);
            System.out.println("==================================================================");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
