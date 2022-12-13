package services;

import dataAccess.DayDAO;
import entities.Day;

import java.util.List;

public class DayServices {
    private DayDAO dayDAO=new DayDAO();

    public List<Day> findAllDays(){
        return dayDAO.findAllDays();
    }
    public Day findDayByID(int id){
        return dayDAO.findDayByID(id);
    }
}
