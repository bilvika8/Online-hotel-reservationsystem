package model;

import java.util.List;
import java.util.Scanner;

import controller.ClientController;
import view.CurrentSessionView;
import view.GuestMenuView;

public class CncrtGuest implements Guest 
{

    private ClientController clientController;

    public CncrtGuest() 
    {
        clientController = new ClientController();
    }

    @Override
    public int display(SessionRole session) 
    {
        int i = 0;
        CurrentSessionView.DisplayCurrentSessionView(session);
        GuestMenuView.DisplayGuestMenu();
        Scanner sc = new Scanner(System.in);
        try 
        {          
            i = Integer.parseInt(sc.nextLine());
        } 
        catch (Exception e) 
        {
            System.out.println(e);
        }
        return i;
    }

    @Override
    public void browseRooms() 
    {
        try 
        {         
            List<String> rooms = clientController.browseRooms();
            int count = 1;
            for (String room : rooms) 
            {
                System.out.println(count + ". " + room);
                count++;
            }
        } 
        catch (Exception e) 
        {
            e.getMessage();
        }
    }

    @Override
    public void reserveRoom(SessionRole session) 
    {
        try 
        {         
            System.out.println("List of Rooms");
            System.out.println("==============================================");
            List<String> rooms = clientController.browseRooms();
            int countroom = 1;
            for (String room : rooms) {
                System.out.println(countroom + ". " + room);
                countroom++;
            }

            DbEntry entry = new DbEntry();
            entry.getBookingDetails();
            String roomNo = entry.getRoomNo();
            int days = entry.getDays();
            String address = entry.getAddress();
            String mobileNum = entry.getMobileNo();
            String cardNum = entry.getCardNo();
            String emailid = session.getUser().getUserName();            
            clientController.reserveRoom(roomNo, emailid, days, address, mobileNum, cardNum);
        } 
        catch (Exception e) 
        {
            e.getMessage();
        }
    }

    @Override
    public void modifyReservation(SessionRole session) {
        try {
            String role = session.getUser().getRoleType();
            String emailid = session.getUser().getUserName();
            List<String> rooms = clientController.viewBookings(role, emailid);
            if (rooms.size() > 0) 
            {
                System.out.println("Bookings list");
                System.out.println("===========================================");
                int countroom = 1;
                for (String room : rooms) 
                {
                    System.out.println(countroom + ". " + room);
                    countroom++;
                }

                DbEntry entry = new DbEntry();
                entry.getModifyBookingDetails();
                String roomNo = entry.getRoomNo();
                int days = entry.getDays();
                String newRoomNo = entry.getAddress();
            
                clientController.modifyReservation(roomNo, newRoomNo, emailid, days);
            } 
            else 
            {
                System.out.println("No bookings at this time");
                System.out.println("======================================================");
            }
        } 
        catch (Exception e) 
        {
            e.getMessage();
        }
    }

    @Override
    public void cancelReservation(SessionRole session) 
    {
        try 
        {
            String role = session.getUser().getRoleType();
            String email = session.getUser().getUserName();
            List<String> rooms = clientController.viewBookings(role, email);
            if (rooms.size() > 0) 
            {
                System.out.println("Bookings List");
                System.out.println("===========================================");
                int count = 1;
                for (String room : rooms) 
                {
                    System.out.println(count + ". " + room);
                    count++;
                }
                DbEntry entry = new DbEntry();
                entry.getCancelookingDetails();
                String roomNo = entry.getRoomNo();       
                clientController.cancelReservation(roomNo, email);
            } 
            else
            {
                System.out.println("No bookings available at this hour");
                System.out.println("=======================================");
            }
        } 
        catch (Exception e) 
        {
            e.getMessage();
        }
    }
}
