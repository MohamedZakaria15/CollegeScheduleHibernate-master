package services;

import dataAccess.LevelDAO;
import entities.Level;

import java.util.List;

public class LevelServices {
    private LevelDAO levelDAO=new LevelDAO();

    public List<Level> findAllLevels(){
        return levelDAO.findAllLevels();
    }
    public Level findLevelByID(int id){
        return levelDAO.findLevelByID(id);
    }
    public void deleteLevelByID(int id){
        levelDAO.deleteLevelByID(id);
    }
    public void deleteAllLevels(){
        levelDAO.deleteAllLevels();
    }
    public void insertLevel(Level level){
        levelDAO.insertLevel(level);
    }
    public void updateLevel(Level level){
        levelDAO.updateLevel(level);
    }
    public boolean constraintCheck(int id){
        return levelDAO.constraintCheck(id);
    }
    public <Generic> List<Level> searchLevels(Generic generic){
        return levelDAO.searchLevels(generic);
    }
}
