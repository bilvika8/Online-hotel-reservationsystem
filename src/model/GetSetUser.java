

package model;

import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;


    public class GetSetUser extends UnicastRemoteObject 
    {
    	private String role;      
        private String password;
        private String name;
        private String email;
        

    public GetSetUser() throws RemoteException 
    {
        super();
    }

    public GetSetUser(String name, String email, String password, String role) throws RemoteException 
    {
        
        this.password = password;
        this.name = name;
        this.email = email;
        this.role = role;
    }

    public String getPassword() 
    {
        return password;
    }

    public void setPassword(String passwrd) 
    {
        this.password = passwrd;
    }

    public String getEmail() 
    {
        return email;
    }

    public void setEmail(String emailid)
    {
        this.email = emailid;
    }
    
    public String getRole() 
    {
        return role;
    }

    public void setRole(String rle)
    {
        this.role = rle;
    }

    public String getName() 
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }
   
    @Override
    public String toString() 
    {
        return this.email +" "+this.password;
    }

}