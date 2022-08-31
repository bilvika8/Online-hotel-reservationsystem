package model;

import view.ErrorView;

public class Dispatch 
{  
    private AbstractFactory guestFactory;
    private AbstractFactory adminFactory;
    public Dispatch() 
    {       
        guestFactory = FactoryProducer.getFactory("Guest");
        adminFactory = FactoryProducer.getFactory("Admin");
    }
 
    public void dispatch(String view, SessionRole session) 
    {
        int optioncase = 0;
        if (view.equalsIgnoreCase("Admin")) 
        {          
            Admin admin = adminFactory.getAdmin("Admin");
            Invoker invoker = new Invoker();
            while (true) 
            {               
            	optioncase = admin.display(session);
                switch (optioncase) 
                {
	                
                	case 1: 
                	{
                		
                		Cmnd cmd = new CncrtAddingRoom(admin, "Add");
                		invoker.takeCommand(cmd);
                		invoker.placeCommand();
                		break;
                	}
                    case 2: 
                    {                    
                    	
                    	Cmnd cmd = new CncrteBrwseRooms(admin);
                        invoker.takeCommand(cmd);
                        invoker.placeCommand();
                        break;
                    }
                    case 3: 
                    {
                       
                    	Cmnd cmd = new ConcreteDelRoom(admin);
                        invoker.takeCommand(cmd);
                        invoker.placeCommand();
                        break;
                    }
                    case 4: 
                    {
                        
                    	 
                    	Cmnd cmd = new CncrtAddingRoom(admin, "Update");
                        invoker.takeCommand(cmd);
                        invoker.placeCommand();
                        break;
                    }
                    case 5:
                    {
                       
                        Cmnd cmd = new ConcreteViewUser(admin, "Admin");
                        invoker.takeCommand(cmd);
                        invoker.placeCommand();
                        break;
                    }
                    case 6: 
                    {
                        
                        Cmnd cmd = new ConcreteAddingUser(admin, "Admin");
                        invoker.takeCommand(cmd);
                        invoker.placeCommand();
                        break;
                    }
                    case 7: 
                    {
                        
                        Cmnd cmd = new ConcreteDelUser(admin, "Admin");
                        invoker.takeCommand(cmd);
                        invoker.placeCommand();
                        break;
                    }
                    
                    case 8: 
                    {
                       
                        Cmnd cmd = new ConcreteViewUser(admin, "Guest");
                        invoker.takeCommand(cmd);
                        invoker.placeCommand();
                        break;
                    }
                    case 9: 
                    {
                        
                        Cmnd cmd = new ConcreteAddingUser(admin, "Guest");
                        invoker.takeCommand(cmd);
                        invoker.placeCommand();
                        break;
                    }
                    case 10: 
                    {
                       
                        Cmnd cmd = new ConcreteDelUser(admin, "Guest");
                        invoker.takeCommand(cmd);
                        invoker.placeCommand();
                        break;
                    }
                    
                    case 11: 
                    {
                       
                         
                        System.out.flush(); 
                        System.out.println("Thank you for using the app");            
                       
                        System.exit(0);
                    }
                    default:
                        System.out.println("Invalid input, please select a valid option");
                        break;
                }
            }

           
        } 
        else if (view.equalsIgnoreCase("Guest")) 
        {

            Guest guest = guestFactory.getUser("Guest");

            Invoker invoker = new Invoker();

            while (true) 
            {
            	optioncase = guest.display(session);
                switch (optioncase) 
                {
                    case 1: 
                    {
                       
                        Cmnd cmd = new ConcrtGuestBrwseRooms(guest);
                        invoker.takeCommand(cmd);
                        invoker.placeCommand();
                        break;
                    }
                    case 2: 
                    {
                        
                        Cmnd cmd = new CncrtResrveRoom(guest, session);
                        invoker.takeCommand(cmd);
                        invoker.placeCommand();
                        break;
                    }
                    case 3: 
                    {
                        
                        Cmnd cmd = new CncrteModfyBookng(guest, session);
                        invoker.takeCommand(cmd);
                        invoker.placeCommand();
                        break;
                    }
                    case 4: 
                    {
                        
                        Cmnd cmd = new CncrtCanclBkng(guest, session);
                        invoker.takeCommand(cmd);
                        invoker.placeCommand();
                        break;
                    }
                    case 5: 
                    {
                       
                        System.out.print("Have a good day");  
                        System.out.flush(); 
                        System.out.println("Exiting online hotel reservation system");            
                        System.exit(0);
                    }
                    default:
                        System.out.println("Select valid option");
                        break;
                }
            }
        }
    }

    public void dispatchError(String view)
    {
        if (view.equalsIgnoreCase("ERROR")) 
        {
        	
            ErrorView obj = new ErrorView();
            System.out.println("Error is:");
            obj.print();

        }
    }

}
