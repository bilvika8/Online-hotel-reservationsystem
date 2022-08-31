package model;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Booking extends UnicastRemoteObject 
{
    public Booking() throws RemoteException 
    {
        super();
    }
    public Booking(String roomNo, String email, int days, String address, String mobileNum, String cardNum, String isCancelled, int amount) throws RemoteException
    {
        this.roomNo = roomNo;
        this.email = email;
        this.days = days;
        this.setAddress(address);
        this.setMobileNo(mobileNum);
        this.setCardNo(cardNum);
        this.isCancelled = isCancelled;
        this.setAmount(amount);
    }

    private String roomNo;
    private String email;
    private int days;
    private String address;
    private String mobileNo;
    private String cardNo;
    private String isCancelled;
    private int amount;

    
    public void setRoomNum(String roomNum) 
    {
        this.roomNo = roomNum;
    }
    public String getRoomNo()
    {
        return roomNo;
    }
    public void setEmail(String emailid) 
    {
        this.email = emailid;
    }
    public String getEmail() 
    {
        return email;
    }
    public int getDays() {
        return days;
    }
    public String isCancelled() 
    {
        return isCancelled;
    }
    public void setDays(int days) 
    {
        this.days = days;
    }
    public void setCancelled(String isCancelled) 
    {
        this.isCancelled = isCancelled;
    }

    public String getCardNo() 
    {
        return cardNo;
    }

    public void setCardNo(String cardNo) 
    {
        this.cardNo = cardNo;
    }
    
    public String getMobileNo() 
    {
        return mobileNo;
    }
    
    public void setMobileNo(String mobileNo) 
    {
        this.mobileNo = mobileNo;
    }
    
    public int getAmount() 
    {
        return amount;
    }
    public String getAddress() 
    {
        return address;
    }
    public void setAddress(String address)
    {
        this.address = address;
    }
    public void setAmount(int amount) 
    {
        this.amount = amount;
    }
    
}
