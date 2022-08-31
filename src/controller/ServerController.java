package controller;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import model.Db;
import model.HotelBooking;
import model.BookngHotelmpl;

public class ServerController extends UnicastRemoteObject 
{ 
    protected ServerController() throws RemoteException 
    {
        super();
    }

    public static void main(String[] args) throws RemoteException, MalformedURLException 
    {
        try 
        {
            Db.createData();
            HotelBooking stubx = new BookngHotelmpl();
            Naming.rebind("//in-csci-rrpc04.cs.iupui.edu:4002/HotelBooking", stubx);
            System.out.println("Online Hotel Server Started");
        }
        catch(Exception ex) 
        {
            System.out.println("Server error is : " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}
