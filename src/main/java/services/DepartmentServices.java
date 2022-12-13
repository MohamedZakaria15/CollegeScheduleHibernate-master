package services;

import dataAccess.DepartmentDAO;
import entities.Department;

import java.util.List;

public class DepartmentServices {
    private DepartmentDAO departmentDAO=new DepartmentDAO();

    public List<Department> findAllDepartments(){
        return departmentDAO.findAllDepartments();
    }
    public Department findDepartmentByID(int id){
        return departmentDAO.findDepartmentByID(id);
    }
    public void deleteDepartmentByID(int id){
        departmentDAO.deleteDepartmentByID(id);
    }
    public void deleteAllDepartments(){
        departmentDAO.deleteAllDepartments();
    }
    public void insertDepartment(Department department){
        departmentDAO.insertDepartment(department);
    }
    public void updateDepartment(Department department){
        departmentDAO.updateDepartment(department);
    }
    public boolean constraintCheck(int id){
        return departmentDAO.constraintCheck(id);
    }
    public <Generic> List<Department> searchDepartments(Generic generic){
        return departmentDAO.searchDepartments(generic);
    }
}
