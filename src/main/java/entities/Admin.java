package entities;

import dataAccess.AssistantsDistributionDAO;
import entities.embedded.AssistantsDistributionKey;
import entities.embedded.LecturersDistributionKey;
import management.DutiesDistribution;
import management.DutiesObjects.AssistantDuty;
import management.DutiesObjects.AssistantScheduleInstance;
import management.DutiesObjects.LecturerDuty;
import management.DutiesObjects.LecturerScheduleInstance;
import management.DutyTime;
import services.AssistantsDistributionService;
import services.LecturersDistributionService;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "admins")
public class Admin {
    @Id
    @Column(name = "admin_id")
    private int adminID;
    @Column(name = "first_name")
    private String adminFirstName;
    @Column(name = "middle_name")
    private String adminMiddleName;
    @Column(name = "last_name")
    private String adminLastName;
    @Column(name = "admin_email")
    private String adminEmail;
    @Column(name = "admin_password")
    private String adminPassword;

    public Admin() {
    }

    public Admin(int adminID, String adminFirstName, String adminMiddleName, String adminLastName, String adminEmail, String adminPassword) {
        this.adminID = adminID;
        this.adminFirstName = adminFirstName;
        this.adminMiddleName = adminMiddleName;
        this.adminLastName = adminLastName;
        this.adminEmail = adminEmail;
        this.adminPassword = adminPassword;
    }


    public int getAdminID() {
        return adminID;
    }

    public void setAdminID(int adminID) {
        this.adminID = adminID;
    }

    public String getAdminFirstName() {
        return adminFirstName;
    }

    public void setAdminFirstName(String adminFirstName) {
        this.adminFirstName = adminFirstName;
    }

    public String getAdminMiddleName() {
        return adminMiddleName;
    }

    public void setAdminMiddleName(String adminMiddleName) {
        this.adminMiddleName = adminMiddleName;
    }

    public String getAdminLastName() {
        return adminLastName;
    }

    public void setAdminLastName(String adminLastName) {
        this.adminLastName = adminLastName;
    }

    public String getAdminEmail() {
        return adminEmail;
    }

    public void setAdminEmail(String adminEmail) {
        this.adminEmail = adminEmail;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "adminID=" + adminID +
                ", adminFirstName='" + adminFirstName + '\'' +
                ", adminMiddleName='" + adminMiddleName + '\'' +
                ", adminLastName='" + adminLastName + '\'' +
                ", adminEmail='" + adminEmail + '\'' +
                ", adminPassword='" + adminPassword + '\'' +
                '}';
    }

    public static void main(String[] args) {
        AssistantsDistributionDAO assistantsDistributionDAO=new AssistantsDistributionDAO();
        AssistantsDistribution assistantsDistribution=new AssistantsDistribution(new AssistantsDistributionKey(1,1,1,1,1),"General","First","Ahmed","Database",1,"Satruday",1,"room 1",9,11);
//        System.out.println(assistantsDistribution);
//        assistantsDistribution.getAssistantsDistributionKey().setSection_number(5);
//        System.out.println(assistantsDistribution);
        for(AssistantsDistribution assistantsDistribution1 :assistantsDistributionDAO.orderSections(assistantsDistributionDAO.findAllAssistantsDistribution())){
            System.out.println(assistantsDistribution1);
        }
//            for(AssistantsDistribution assistantsDistribution1: assistantsDistributionDAO.searchAssistantsDistribution(-1,-1,-1,0)){
//                System.out.println(assistantsDistribution1);
//            }

    }
}
