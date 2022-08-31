package model;

import java.io.BufferedReader;
import java.util.Scanner;
import java.io.InputStreamReader;
import java.io.IOException;
import view.MainView;

public class DbEntry 
{

    private int type;
    private String emailid;
    private String passwrd;
    private String roomType;
    private String roomNum;
    private String userName;
    private String price;
    private String desc;
    private String typeOfBed;
    private String rating;
    private int days;
    private String address;
    private String isSmokingAllowed;
    private String cardNo;
    private String isAvailable;
    private String noOfBeds;
    private String isCancelled;
    private String mobileNum;   
    private Scanner sc = new Scanner(System.in);

    public String login() 
    {
        MainView.DisplayHomeView();
        type = Integer.parseInt(sc.nextLine());

        if (type == 2)
            return "Guest";
        else if (type == 1)
            return "Admin";
        else if (type == 4)
            return "New Guest";
        else if (type == 3)
            return "New Admin";

        return "false";
    }

    public void guestLogin() 
    {      
        
        System.out.println("Enter email id for guest login: ");
        emailid = sc.nextLine();
        System.out.println("Enter password for guestLogin: ");
        passwrd = sc.nextLine();
    }

    public void adminLogin() 
    {
        
       
        System.out.println("Enter email id for admin login: ");
        emailid = sc.nextLine();
        System.out.println("Enter password for admin login: ");
        passwrd = sc.nextLine();
    }

    public void registration() 
    {
        
        System.out.println("Enter email id for registration: ");
        emailid = sc.nextLine();       
        System.out.println("Enter password  for mail id registartion: ");
        passwrd = sc.nextLine();
        System.out.println("Enter name for registration: ");
        userName = sc.nextLine();

    }
    
    public void getUserForDelete() 
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try
        {
            System.out.println("Enter email id : of  user to be deleted: ");
            emailid = reader.readLine();
            System.out.println();
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }
    }

    public void getRoomForDelete() 
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try 
        {
            System.out.println("Please Enter room number for deletion: ");
            emailid = reader.readLine();
            System.out.println();
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }
    }

    public void getRoomForAdd(String operation) 
    {
        try
        {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            try 
            {
                
            	if (operation == "Add")
                    System.out.println("Please Enter room number for new adding: ");
                else
                    System.out.println("Please Enter existing room number: ");

                roomNum = reader.readLine();
                System.out.println("Please enter following details for adding the new room: ");
                System.out.println("Please enter room type for: ");
                roomType = reader.readLine();
                System.out.println("Please Enter number of beds for room: ");
                noOfBeds = reader.readLine();
                System.out.println("Please Enter type of bed for room: ");
                typeOfBed = reader.readLine();
                System.out.println("Enter rating for room: ");
                rating = reader.readLine();
                System.out.println("Please Enter price for room: ");
                price = reader.readLine();
                System.out.println("Please Enter description for room: ");
                desc = reader.readLine();
                System.out.println("Rooms available for move in enter only Yes/No: ");
                isAvailable = reader.readLine();
                System.out.println("Is smoking allowed in the room enter only Yes/No: ");
                isSmokingAllowed = reader.readLine();
            
            } 
            catch (IOException e) 
            {
            	
            	System.out.println("error is:");
                e.printStackTrace();
                
            }
        } 
        catch (Exception e1) 
        {
        	
        	System.out.println("error is:");
            e1.printStackTrace();
            
        }
    }



    
    public void getBookingDetails()
    {
        try 
        {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            try 
            {
            	System.out.println("Please enter no of days: ");
                days = Integer.parseInt(reader.readLine());
                System.out.println("Please enter address: ");
                address = reader.readLine();
                System.out.println("Please enter mobile number: ");
                mobileNum = reader.readLine();
                System.out.println("Please enter room number for reservation: ");
                roomNum = reader.readLine();
                System.out.println("Please enter credit card number: ");
                cardNo = reader.readLine();
            } 
            catch (IOException e) 
            {
                e.printStackTrace();
            }
        } 
        catch (Exception e1)
        {
            e1.printStackTrace();
        }
    }

    public void getModifyBookingDetails() 
    {
        try 
        {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            try 
            {
                System.out.println("Please enter booked room number for modification: ");
                roomNum = reader.readLine();
                System.out.println("Please enter new room number: ");
                address = reader.readLine();
                System.out.println("Please enter no of days in the room: ");
                days = Integer.parseInt(reader.readLine());
            } 
            catch (IOException e) 
            {
            	System.out.println("Error in modifybookingdetails ");
                e.printStackTrace();
            }
        } 
        catch (Exception e1) 
        {
        	System.out.println("Error in modifybookingdetails ");
            e1.printStackTrace();
        }
    }


    public void getCancelookingDetails() 
    {
        try 
        {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            try 
            {
                System.out.println("Please enter alreday booked room number for  cancellation: ");
                roomNum = reader.readLine();
            } 
            catch (IOException e)
            {
            	System.out.println("Error in getCancelookingDetails method");
                e.printStackTrace();
            }
        } 
        catch (Exception e1) 
        {
        	System.out.println("Error in getCancelookingDetails method");
            e1.printStackTrace();
        }
    }

   

    public String getPassword() 
    {
        return passwrd;
    }
    public String getUserName() 
    {
        return userName;
    }
    public String getEmail() 
    {
        return emailid;
    }

    public void setRoomNo(String roomNum) 
    {
        this.roomNum = roomNum;
    }
    public String getRoomNo() 
    {
        return roomNum;
    }

    public void setRoomType(String roomtype) 
    {
        this.roomType = roomtype;
    }
    public String getRoomType() 
    {
        return roomType;
    }

    
    public void setDescription(String desc)
    {
        this.desc = desc;
    }
    public String getPrice() 
    {
        return price;
    }
    public String getDescription() 
    {
        return desc;
    }
    public String getRating()
    {
        return rating;
    }
    public void setRating(String roomRating) 
    {
        this.rating = roomRating;
    }

    public String getNoOfBeds() 
    {
        return noOfBeds;
    }

    public void setPrice(String roomPrice) 
    {
        this.price = roomPrice;
    }

    public String getTypeOfBed() 
    {
        return typeOfBed;
    }

    public void setTypeOfBed(String typeOfBed) 
    {
        this.typeOfBed = typeOfBed;
    }
    public String isSmokingAllowed() 
    {
        return isSmokingAllowed;
    }
    
    public void setNoOfBeds(String noOfBedsInRoom) 
    {
        this.noOfBeds = noOfBedsInRoom;
    }
    public String isAvailable() 
    {
        return isAvailable;
    }
   
    public void setAvailable(String isAvail) 
    {
        this.isAvailable = isAvail;
    }
    public String getIsCancelled() 
    {
        return isCancelled;
    }
    public void setIsCancelled(String isCanclled) 
    {
        this.isCancelled = isCanclled;
    }

    public void setSmokingAllowed(String isSmokingAllwed) 
    {
        this.isSmokingAllowed = isSmokingAllwed;
    }

    public void setCardNo(String cardNum) 
    {
        this.cardNo = cardNum;
    }

    public void setMobileNo(String mobileNum) 
    {
        this.mobileNum = mobileNum;
    }
    public String getMobileNo()
    {
        return mobileNum;
    }

    public String getAddress() 
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getCardNo() 
    {
        return cardNo;
    }

    public void setDays(int days) 
    {
        this.days = days;
    }

    public int getDays() 
    {
        return days;
    }
    
}
