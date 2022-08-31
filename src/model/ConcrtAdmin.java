package model;

import java.util.List;
import java.util.Scanner;

import controller.ClientController;
import view.AdminMenuView;
import view.CurrentSessionView;

public class ConcrtAdmin implements Admin 
{
    private ClientController clientController;   
    @Override
    public int display(SessionRole session) 
    {
        int i = 0;
        CurrentSessionView.DisplayCurrentSessionView(session);
        AdminMenuView.DisplayAdminMenuView();
        Scanner sc = new Scanner(System.in);
        try 
        {           
            i = Integer.parseInt(sc.nextLine());
        } catch (Exception e) {
            System.out.println(e);
        }
        return i;
    }
    public ConcrtAdmin() 
    {
        clientController = new ClientController();
    }
    @Override
    public void browseRooms() 
    {
        try 
        {           
            System.out.println("Available List of rooms");
            System.out.println("===============================================");
            List<String> rooms = clientController.browseRooms();
            int countroom = 1;
            for (String room : rooms) 
            {
                System.out.println(countroom + ". " + room);
                countroom++;
            }
        } 
        catch (Exception e) 
        {
            e.getMessage();
        }
    }
    @Override
    public void viewUsers(String type) 
    {
        try {
            System.out.println("Users List" + type);
            System.out.println("======================================================");
            List<String> users = clientController.viewUsers(type);
            int countroom = 1;
            for (String user : users) 
            {
                System.out.println(countroom + ". " + user);
                countroom++;
            }
        } 
        catch (Exception e) 
        {
            e.getMessage();
        }
    }

    @Override
    public void deleteUser(String type) 
    {
        try 
        {
            DbEntry entry = new DbEntry();
            entry.getUserForDelete();
            String email = entry.getEmail();
            clientController.deleteUser(type, email);
        } 
        catch (Exception e) 
        {
            e.getMessage();
        }
    }

    @Override
    public void deleteRoom() 
    {
        try 
        {
            DbEntry entry = new DbEntry();
            entry.getRoomForDelete();
            String roomNo = entry.getEmail();
            clientController.deleteRoom(roomNo);
        } 
        catch (Exception e) 
        {
            e.getMessage();
        }
    }
    @Override
    public void addRoom(String operation) 
    {
        try 
        {
            DbEntry entry = new DbEntry();
            entry.getRoomForAdd(operation);
            String roomNum = entry.getRoomNo();
            String type = entry.getRoomType();
            String desc = entry.getDescription();
            String price = entry.getPrice();
            String rating = entry.getRating();
            String noOfBeds = entry.getNoOfBeds();
            String typeOfBed = entry.getTypeOfBed();
            String isSmokingAllowed = entry.isSmokingAllowed();
            String isAvailable = entry.isAvailable();
            clientController.addRoom(operation, roomNum, type, desc, price, rating, noOfBeds, typeOfBed, isSmokingAllowed, isAvailable);
        } 
        catch (Exception e)
        {
            e.getMessage();
        }
    }

    @Override
    public void addUser(String type) 
    {
        try 
        {
            DbEntry entry = new DbEntry();
            entry.registration();
            String email = entry.getEmail();
            String userName = entry.getUserName();
            String passwrd = entry.getPassword();
            if(type == "Admin")
                clientController.adminRegister(true, userName, email, passwrd);
            else    
                clientController.guestRegister(true, userName, email, passwrd);
        } 
        catch (Exception e) 
        {
            e.getMessage();
        }
    }
}
