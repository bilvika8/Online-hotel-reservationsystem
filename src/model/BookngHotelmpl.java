package model;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.rmi.server.UnicastRemoteObject;


public class BookngHotelmpl extends UnicastRemoteObject implements HotelBooking 
{

    public BookngHotelmpl() throws RemoteException 
    {
        super();
    }
  
    @Override
    public boolean adminRegister(String userName, String emailid, String passwrd) throws RemoteException 
    {
        try 
        {
            GetSetUser userExists = null;
            for (GetSetUser user : Db.users) 
            {
                if (user.getEmail().equals(emailid))
                {
                    userExists = user;
                }
            }

            if (userExists != null)
                return false;

            GetSetUser user = new GetSetUser();        
            user.setEmail(emailid);
            user.setName(userName);
            user.setPassword(passwrd);
            user.setRole("Admin");
            Db.users.add(user);
            return true;
        } 
        catch (Exception e) 
        {
        	System.out.println("Error in this method:");
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean guestRegister(String userName, String emailid, String passwrd) throws RemoteException 
    {
        try
        {
           
            GetSetUser userExists = null;
            for (GetSetUser user : Db.users) 
            {
                if (user.getEmail().equals(emailid)) 
                {
                    userExists = user;
                }
            }

            if (userExists != null)
                return false;

            GetSetUser user = new GetSetUser();
            user.setName(userName);  
            user.setPassword(passwrd);
            user.setEmail(emailid);
            user.setRole("Guest");
            Db.users.add(user);
            return true;
        } 
        catch (Exception e) 
        {
        	System.out.println("Error in this method:");
            e.printStackTrace();
        }
        return false;
    }
 
    @Override
    public boolean guestLogin(String userName, String passwrd) throws RemoteException 
    {
        try 
        {
            for (GetSetUser user : Db.users) 
            {
                if (user.getPassword().equals(passwrd) && user.getEmail().equals(userName) 
                        && user.getRole().equals("Guest")) 
                {
                    return true;
                }
            }
        } 
        catch (Exception e) 
        {
        	System.out.println("Error in this method:");
            e.printStackTrace();
        }
        return false;
    }
    @Override
    public boolean adminLogin(String userName, String passwrd) throws RemoteException 
    {
        try 
        {
            for (GetSetUser user : Db.users)
            {
                if (user.getPassword().equals(passwrd) && user.getEmail().equals(userName)
                        && user.getRole().equals("Admin")) 
                {
                    return true;
                }
            }
        } 
        catch (Exception e)
        {
        	System.out.println("Error in this method:");
            e.printStackTrace();
        }
        return false;
    }

  

   
    @Override
    public SessionRole processLogin(String userType, String userName) throws RemoteException
    {
        try 
        {          
            SessionRole session = new SessionRole(userType, userName);
            return session;
        } 
        catch (Exception e) 
        {
        	System.out.println("Error in this method:");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<String> browseRooms() throws RemoteException 
    {
        List<String> rooms = new ArrayList<>();
        try
        {
            for (Rooms room : Db.rooms) 
            {
                rooms.add("Rooms No for browse is: " + room.getRoomNo() + " ||| " + "Type of Room is: " + room.getType() + " ||| " + "Description: "
                        + room.getDescription() + " ||| " +
                        "Price per room: " + room.getPrice() + " ||| " + "Rating for this room is :" + room.getRating() + " ||| " + "No of beds available in room: "
                        + room.getNoOfBeds() + " ||| " +
                        "Type of bed for this room is \n: " + room.getTypeOfBed() + " ||| " + "Is Smoking allowed? " + room.isSmokingAllowed()
                        + " ||| " + "Room Availablilty is: " + room.isAvailable());
            }
        } catch (Exception e) 
        {
        	System.out.println("Error in this method:");
            e.printStackTrace();
        }
        return rooms;
    }

    @Override
    public boolean addRoom(String operation, String roomNo, String type, String description, String price,
            String rating, String noOfBeds,
            String typeOfBed, String isSmokingAllowed, String isAvailable) throws RemoteException 
    {
        try 
        {
            Rooms oldRoom = null;
            
            for (Rooms item : Db.rooms) 
            {
            	
                if (item.getRoomNo().equals(roomNo))
                	
                    oldRoom = item;
                
            }
            if (operation.equals("Add")) 
            {
                if (oldRoom != null)
                	
                    return false;
            }
            else 
            {
                if (oldRoom == null)
                	
                    return false;
                
                else 
                	
                {
                    Db.rooms.remove(oldRoom);
                    
                    if (isAvailable.equals("No"))
                    {
                    	
                        Booking existingBooking = null;
                        
                        for (Booking booking : Db.bookings)
                        	
                            if (roomNo.equals(booking.getRoomNo()))
                            	
                                existingBooking = booking;

                        if (existingBooking != null)
                        	
                            Db.bookings.remove(existingBooking);
                        
                    }
                }
            }

            Rooms room = new Rooms(roomNo, type, description, price, rating, noOfBeds, typeOfBed, isSmokingAllowed, isAvailable);
            Db.rooms.add(room);
            return true;
        } 
        catch (Exception e) 
        {
        	System.out.println("Error in this method:");
        	
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteRoom(String roomNo) throws RemoteException
    {
        try
        {
          
            Rooms room = null;
            
            for (Rooms item : Db.rooms)
            {
                if (item.getRoomNo().equals(roomNo))
                    room = item;
            }
            
          
            if (room != null) 
            {
                Db.rooms.remove(room);
                return true;
            }
            
        } 
        catch (Exception e) 
        {
        	System.out.println("Error in this method");
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<String> viewUsers(String type) throws RemoteException
    {
        List<String> users = new ArrayList<>();
        try 
        {
            for (GetSetUser user : Db.users) 
            {
                if (user.getRole().equals(type))
                    users.add("User Name which is set is: " + user.getName() + " | " + "Email: " + user.getEmail());
            }
        } 
        catch (Exception e) 
        {
        	System.out.println("Error in this method:");
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public boolean deleteUser(String type, String email) throws RemoteException 
    {
        try 
        {
            GetSetUser user = null;
            for (GetSetUser item : Db.users) 
            {
                if (item.getEmail().equals(email) && item.getRole().equals(type))
                    user = item;
            }

            if (user != null) 
            {
                Db.users.remove(user);
                return true;
            }
        } 
        catch (Exception e) 
        {
        	System.out.println("Error in this method:");
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public String checkRoomAvailability(String roomNum, int days, boolean isNew) throws RemoteException 
    {
        String result = "Rooms unavailable";
        try
        {
            int price = 0;
            
            boolean isAvailable = false;

            
            for (Rooms item : Db.rooms) 
            {
                if (item.getRoomNo().equals(roomNum) && item.isAvailable().equals("Yes")) 
                {
                    isAvailable = true;
                   
                    price = Integer.parseInt(item.getPrice()) * days;
                }
            }

            if (isAvailable) 
            {
                if (isNew)
                	
                    result = "Booking confirmation is done \n.with total price of: $" + price + ".\n Payment Successful";
                
                else
                	
                    result = "Booking updated with total price of \n: $" + price + ".with Payment Successful";
            }

        } 
        catch (Exception e) 
        {
        	System.out.println("Error in this method");
            e.printStackTrace();
        }
        
        return result;
    }

   
    @Override
    public boolean reserveRoom(String roomNo, String email, int days, String address, String mobileNo, String cardNo)
            throws RemoteException 
    {
        try 
        {
            int price = 0;
            
            Rooms oldRoom = null;
           
            for (Rooms item : Db.rooms) 
            {
                if (item.getRoomNo().equals(roomNo)) 
                {
                    oldRoom = item;
                    price = Integer.parseInt(item.getPrice()) * days;
                }
            }
         
            oldRoom.setAvailable("No");

            Booking booking = new Booking();
            
            booking.setDays(days);
            booking.setEmail(email);
            booking.setAddress(address);
            booking.setCardNo(cardNo);
            booking.setAmount(price);
            booking.setRoomNum(roomNo);
            booking.setMobileNo(mobileNo);        
            booking.setCancelled("No");

            Db.bookings.add(booking);

            return true;
        } 
        catch (Exception e) 
        {
        	System.out.println("Error in this method");
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<String> viewBookings(String role, String email) throws RemoteException 
    {
        List<String> bookings = new ArrayList<>();
        try
        {
            for (Booking booking : Db.bookings) 
            {
                if ((role.equals("Admin") || email.equals(booking.getEmail())) && booking.isCancelled().equals("No"))
                    bookings.add("Guest Email: " + booking.getEmail() + " | " + "Rooms No: " + booking.getRoomNo()
                    
                            + " | " + "Days: " + booking.getDays() + " | " +
                            
                            "Address: " + booking.getAddress() + " | " + "Mobile No:" + booking.getMobileNo() + " | "
                            
                            + "Credit Card No: "
                            
                            + booking.getCardNo() + " | " + " | " + "Price: " + booking.getAmount());
                
            }
        }
        catch (Exception e) 
        {
        	System.out.println("Error in this method");
            e.printStackTrace();
        }
        return bookings;
    }

    @Override
    public String modifyReservation(String roomNum, String newRoonNum, String emailid, int days) throws RemoteException 
    {
        String result = "Rooms unavailable";
        try
        {
            
            Booking existingBooking = null;
            
            for (Booking booking : Db.bookings)
                if (roomNum.equals(booking.getRoomNo()) && emailid.equals(booking.getEmail()) && booking.isCancelled().equals("No"))
                    existingBooking = booking;

            if (existingBooking != null) 
            {
                
                result = checkRoomAvailability(newRoonNum, days, false);
                if (!result.equals("Rooms unavailable")) 
                	
                {
                	
                    existingBooking.setRoomNum(newRoonNum);
                    
                    existingBooking.setDays(days);
                    Rooms oldRoom = null;
                    
                    for (Rooms item : Db.rooms) 
                    {
                        if (item.getRoomNo().equals(roomNum)) 
                        {
                            oldRoom = item;
                        }
                    }
                   
                    oldRoom.setAvailable("Yes");
                }
            } 
            else
                result = "Booking room is not found";

        } 
        catch (Exception ex) 
        {
        	System.out.println("Error in this method");
            ex.printStackTrace();
        }
        return result;
    }

    
    @Override
    public String cancelReservation(String roomNum, String emailid) throws RemoteException
    {
        String result = "Booking not found";
        try 
        {
         
            Booking existingBooking = null;
            
            for (Booking booking : Db.bookings)
                if (roomNum.equals(booking.getRoomNo()) && emailid.equals(booking.getEmail()) && booking.isCancelled().equals("No"))
                    existingBooking = booking;

            Rooms room = null;
            for (Rooms item : Db.rooms) 
            {
                if (item.getRoomNo().equals(roomNum))
                    room = item;
            }

            
            if (existingBooking != null) 
            {
                existingBooking.setCancelled("Yes");
                if (room != null)
                    room.setAvailable("Yes");

                int price = existingBooking.getAmount();
                price = (price * 20) / 100;
                result = "Booking cancelled successfully. Cancellation charges(20%) $" + price + ". Balance amount will be credit to your account";
            }

        } 
        catch (Exception ex) 
        {
        	System.out.println("Error in this method");
            ex.printStackTrace();
        }
        return result;
    }
}
