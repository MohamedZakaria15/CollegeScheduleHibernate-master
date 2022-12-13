package services;

import dataAccess.TimeDAO;
import entities.Time;

public class TimeServices {
    private TimeDAO timeDAO=new TimeDAO();

    public Time findTime(){
        return timeDAO.findTime();
    }
    public void updateTime(Time time){
        timeDAO.updateTime(time);
    }
}
