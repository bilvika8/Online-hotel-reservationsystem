package view;

import model.SessionRole;

public class CurrentSessionView 
{

    public static void DisplayCurrentSessionView(SessionRole session) 
    {
        System.out.println();
        
        System.out.println();
        
        
      
        System.out.println("Present SessionRole is  -  Role: " + session.getUser().getRoleType() + " | \n  emailid is: " + session.getUser().getUserName());
        
        System.out.println("====================================================================================");
        
        System.out.println("====================================================================================");
        
        System.out.println();
    }
    
}
