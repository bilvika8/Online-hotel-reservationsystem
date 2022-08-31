package model;

import java.io.Serializable;

public class SessionRole implements Serializable
{

    private  Role role;
    
    public Role getUser() 
    {

        return role;
    }

    public SessionRole(String userRle, String userNme)
    {
        this.role = new Role(userRle, userNme);
    }

   

}