package model;

import java.util.List;
import java.util.ArrayList;


public class Invoker 
{

    private List<Cmnd> orderList = new ArrayList<Cmnd>();
    
    
    
    public void placeCommand() 
    {
        for (Cmnd command : orderList)
        {
            command.execute();
        }
        orderList.clear();
    }
    
    public void takeCommand(Cmnd command)
    {
        orderList.add(command);
    }
    
}
