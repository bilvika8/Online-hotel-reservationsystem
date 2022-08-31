package model;

import java.lang.reflect.InvocationHandler;
import java.rmi.server.UnicastRemoteObject;
import java.lang.reflect.Method;
import java.rmi.RemoteException;

public class AuthorizationInvocationHandler extends UnicastRemoteObject implements InvocationHandler 
{
    private Object objectImpl;
   
    @Override
    public Object invoke(Object proxyserver, Method method, Object[] args) throws Throwable 
    {  
    	
        if (method.isAnnotationPresent(Roles.class)) 
        {
        	
            Roles test = method.getAnnotation(Roles.class);
            SessionRole session = (SessionRole) args[0];

            if (session.getUser().getRoleType().equals(test.value())) 
            { 
            	
                return method.invoke(objectImpl, args);
            }
            else 
            {
            	
                throw new AuthrizationException(method.getName());
            }
            
        } 
        
        else 
        {
            return method.invoke(objectImpl, args);
        }
        
    }
    public AuthorizationInvocationHandler(Object impl) throws RemoteException
    {
        this.objectImpl = impl;
    }
  
}
