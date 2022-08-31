package model;


import java.io.Serializable;

public class Role implements Serializable
{

    private String userRle, userNme, firstNme;
  
    public String getFirstName() 
    {
        return firstNme;
    }
    public Role(String userRole, String userName)
    {
        
        this.userNme = userName;
        this.userRle=userRole;
    }

    public String getRoleType()
    {

        return userRle;
    }
    public String getUserName() 
    {
        return userNme;
    }

    
    
}