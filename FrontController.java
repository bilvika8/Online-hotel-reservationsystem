package controller;

import model.Dispatch;
import model.SessionRole;
import model.DbEntry;


public class FrontController 
{

    private Dispatch dispatcher;
    private SessionRole session = null;
    private ClientController clientController = new ClientController();
    private DbEntry entry = new DbEntry();

    public FrontController() 
    {
        dispatcher = new Dispatch();
    }

    private boolean isAuthenticUser(String view) 
    {
       
        if (view.equalsIgnoreCase("Guest")) 
        {         
        	  entry.guestLogin();
              String email = entry.getEmail();
              String pass = entry.getPassword();
              if (clientController.guestLogin(email, pass)) 
              {
                  session = clientController.processLogin("Guest", email);
                  return true;
              }

        } 
        else if (view.equalsIgnoreCase("Admin")) 
        {         
            entry.adminLogin();
            String email = entry.getEmail();
            String pass = entry.getPassword();          
            if (clientController.adminLogin(email, pass)) 
            {
                session = clientController.processLogin("Admin", email);
                return true;
            }
        } else if (view.equalsIgnoreCase("New Guest")) 
        {
            entry.registration();
            String emailid, userName, passwrd;
            emailid = entry.getEmail();
            userName = entry.getUserName();
            passwrd = entry.getPassword();
            clientController.guestRegister(false, userName, emailid, passwrd);
            return true;        
        } else if (view.equalsIgnoreCase("New Admin")) 
        {
            entry.registration();
            String emailid, userName, passwrd;
            emailid = entry.getEmail();
            userName = entry.getUserName();
            passwrd = entry.getPassword();
            clientController.adminRegister(false, userName, emailid, passwrd);
            return true;
        }

        return false;
    }

    public void dispatchRequest(String view)
    {
        if (isAuthenticUser(view))
            dispatcher.dispatch(view, session);
        else
            dispatcher.dispatchError("ERROR");
    }
}
