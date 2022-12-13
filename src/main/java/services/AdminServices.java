package services;

import dataAccess.AdminDAO;
import entities.Admin;
import java.util.List;


public class AdminServices {
    private AdminDAO adminDAO=new AdminDAO();

    public List<Admin> findAllAdmins(){
        return adminDAO.findAllAdmins();
    }
    public Admin findAdminByID(int id){
        return adminDAO.findAdminByID(id);
    }
    public void insertAdmin(Admin admin){
        adminDAO.insertAdmin(admin);
    }
    public void updateAdmin(Admin admin){adminDAO.updateAdmin(admin);}
    public void deleteAdminByID(int id){
        adminDAO.deleteAdminByID(id);
    }
    public void deleteAllAdmins(){adminDAO.deleteAllAdmins();}
    public Admin loginCheck(String email,String password){
        return adminDAO.loginCheck(email,password);
    }
    public Admin emailCheck(String email){return adminDAO.emailCheck(email);}
    public <Generic> List<Admin> searchAdmins(Generic generic){
        return adminDAO.searchAdmins(generic);
    }
}
