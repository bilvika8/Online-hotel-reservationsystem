package model;

import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;


public class Rooms extends UnicastRemoteObject 
{

    protected Rooms() throws RemoteException 
    {
        super();
    }  

    public Rooms(String roomNum, String type, String desc, String price, String rating, String noOfBeds,
            String typeOfBed, String isSmokingAllowed, String isAvailable) throws RemoteException 
    {
    	this.description = desc;
        this.roomNo = roomNum;
        this.type = type;
        this.rating = rating;
        this.noOfBeds = noOfBeds;
        this.typeOfBed = typeOfBed;
        this.isSmokingAllowed = isSmokingAllowed;
        this.price = price;
        this.isAvailable = isAvailable;
    }

    
    private String price;
    private String rating;
    private String roomNo;
    private String noOfBeds;
    private String typeOfBed;
    private String type;
    private String isSmokingAllowed;
    private String isAvailable;  

    private String description;
    
    
    

    public String getType() 
    {
        return type;
    }

    public void setType(String type) 
    {
        this.type = type;
    }

    public String getDescription() 
    {
        return description;
    }
    public void setDescription(String desc) 
    {
        this.description = desc;
    }
    public String getPrice() 
    {
        return price;
    }

    public void setPrice(String price) 
    {
        this.price = price;
    }
    public String getRoomNo() 
    {
        return roomNo;
    }

    public void setRoomNo(String roomNum)
    {
        this.roomNo = roomNum;
    }

    public String getTypeOfBed() 
    {
        return typeOfBed;
    }

    public void setTypeOfBed(String typeOfBed) 
    {
        this.typeOfBed = typeOfBed;
    }

    public String getRating() 
    {
        return rating;
    }

    public void setRating(String rating) 
    {
        this.rating = rating;
    }

    

    public String getNoOfBeds() 
    {
        return noOfBeds;
    }

    public void setNoOfBeds(String noOfBeds) 
    {
        this.noOfBeds = noOfBeds;
    }

    
    

    

    public void setSmokingAllowed(String isSmokingAllowed) 
    {
        this.isSmokingAllowed = isSmokingAllowed;
    }
    public String isSmokingAllowed() 
    {
        return isSmokingAllowed;
    }
    
    public void setAvailable(String isAvailable) 
    {
        this.isAvailable = isAvailable;
    }
    public String isAvailable() 
    {
        return isAvailable;
    }


}
