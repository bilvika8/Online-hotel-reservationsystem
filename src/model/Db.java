package model;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import java.util.ArrayList;


public class Db extends UnicastRemoteObject 
{
	public static List<Rooms> rooms = new ArrayList<Rooms>();
    public static List<GetSetUser> users = new ArrayList<GetSetUser>();  
    public static List<Booking> bookings = new ArrayList<Booking>();

    public Db() throws RemoteException 
    {
        super();
    }

   
    public static void createData() throws RemoteException 
    {
        try 
        {
            
        	GetSetUser admin = new GetSetUser();
            admin.setName("Admin");        
            admin.setRole("Admin");
            admin.setEmail("admin@onlinehotel.com");
            admin.setPassword("Admin@123");
            users.add(admin);
            
            GetSetUser admin2 = new GetSetUser();
            admin2.setName("Bilvika");        
            admin2.setRole("Admin");
            admin2.setEmail("bilvika@onlinehotel.com");
            admin2.setPassword("bilvika@123");
            users.add(admin2);
            
            
            GetSetUser guest1 = new GetSetUser();
            guest1.setName("Guest2");     
            guest1.setRole("Guest");
            guest1.setEmail("guest2@gmail.com");
            guest1.setPassword("guest2@123");
            users.add(guest1);
                     
            GetSetUser guest2 = new GetSetUser();
            guest2.setName("Guest1");       
            guest2.setRole("Guest");
            guest2.setEmail("guest1@gmail.com");
            guest2.setPassword("guest1@123");
            users.add(guest2);
            
            

            
            Rooms room1 = new Rooms();
            room1.setRoomNo("101");
            room1.setType("Single Rooms");
            room1.setTypeOfBed("Single Bed");
            room1.setDescription("Single room, smoking is not allowed");
            room1.setPrice("250");
            room1.setRating("2");
            room1.setNoOfBeds("1");
            room1.setSmokingAllowed("No");
            room1.setAvailable("Yes");
            rooms.add(room1);
            
            Rooms room2 = new Rooms();
            room2.setRoomNo("102");
            room2.setType("Single Rooms");      
            room2.setSmokingAllowed("Yes");
            room2.setDescription("Single room, smoking is allowed");
            room2.setPrice("300");
            room2.setRating("4");
            room2.setNoOfBeds("2");
            room2.setTypeOfBed("Doble Bed");
            room2.setAvailable("Yes");
            rooms.add(room2);
            
            Rooms room3 = new Rooms();
            room3.setRoomNo("103");
            room3.setType("Double");
            room3.setTypeOfBed("Single Bed");
            room3.setDescription("Double room, smoking is not allowed");
            room3.setPrice("350");
            room3.setRating("3");
            room3.setNoOfBeds("1");
            room3.setSmokingAllowed("No");
            room3.setAvailable("Yes");
            rooms.add(room3);


            
            Rooms room4 = new Rooms();
            room4.setRoomNo("104");
            room4.setType("Double");
            room4.setTypeOfBed("Double Bed");
            room4.setDescription("Double room, smoking is allowed");
            room4.setPrice("400");
            room4.setRating("3");
            room4.setNoOfBeds("2");
            room4.setSmokingAllowed("Yes");
            room4.setAvailable("No");
            rooms.add(room4);
            
            

            Rooms room5 = new Rooms();
            room5.setRoomNo("105");
            room5.setType("Pent House"); 
            room5.setNoOfBeds("1");
            room5.setDescription("Pent house, without view, smoking is not allowed");
            room5.setPrice("450");
            room5.setRating("3");
            room5.setTypeOfBed("King Bed");
            room5.setSmokingAllowed("No");
            room5.setAvailable("Yes");
            rooms.add(room5);


            Rooms room6 = new Rooms();
            room6.setRoomNo("106");
            room6.setType("Pent House");
            room6.setTypeOfBed("Queen Bed");
            room6.setDescription("Pent house, with amazing view, smoking is allowed");
            room6.setPrice("500");
            room6.setRating("4");
            room6.setNoOfBeds("1");
            room6.setSmokingAllowed("Yes");
            room6.setAvailable("No");
            rooms.add(room6);
            
            Rooms room7 = new Rooms();
            room7.setRoomNo("107");
            room7.setNoOfBeds("3");
            room7.setType("Triple room");
            room7.setDescription("Triple room, with amazing view, smoking is allowed");
            room7.setPrice("5000");
            room7.setRating("5");
            room7.setTypeOfBed("King Bed");
            room7.setSmokingAllowed("Yes");
            room7.setAvailable("No");
            rooms.add(room6);

            Booking booking1 = new Booking();
            booking1.setEmail("b@gmail.com");
            booking1.setRoomNum("101");
            booking1.setCancelled("No");
            booking1.setDays(2);
            booking1.setAddress("Indianapolis");
            booking1.setMobileNo("22222222");
            booking1.setCardNo("123456789");
            booking1.setAmount(800);
            bookings.add(booking1);
            

            Booking booking2 = new Booking();
            booking2.setEmail("a@gmail.com");
            booking2.setRoomNum("102");
            booking2.setDays(4);
            booking2.setAddress("Chicago");
            booking2.setMobileNo("1111111111");
            booking2.setCardNo("6543568876");
            booking2.setCancelled("No");
            booking2.setAmount(2000);
            bookings.add(booking2);
            
            
            
        } 
        catch (Exception e) 
        {
        	System.out.println("Error is:");
            e.printStackTrace();
        }

    }

}
