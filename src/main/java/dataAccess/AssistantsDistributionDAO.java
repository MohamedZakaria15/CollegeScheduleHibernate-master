package dataAccess;

import dataAccess.hibernateSession.HibernateUtil;
import entities.AssistantsDistribution;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class AssistantsDistributionDAO {
    public List<AssistantsDistribution> findAllAssistantsDistribution(){
        List<AssistantsDistribution> assistantsDistributions=null;
        Transaction transaction=null;
        try (Session session= HibernateUtil.getSessionFactory().openSession()){
            transaction=session.beginTransaction();
            assistantsDistributions=session.createQuery("from AssistantsDistribution order by assistantsDistributionKey.level_id,assistantsDistributionKey.section_number,day_id").getResultList();
            transaction.commit();
        }catch (Exception exception){
            transaction.rollback();
            exception.printStackTrace();
        }
        return assistantsDistributions;
    }
    public void insertAssistantDistribution(AssistantsDistribution assistantsDistribution){
        Transaction transaction=null;
        try (Session session=HibernateUtil.getSessionFactory().openSession()){
            transaction=session.beginTransaction();
            session.save(assistantsDistribution);
            transaction.commit();
        }catch (Exception exception){
            transaction.rollback();
            exception.printStackTrace();
        }
    }
    public void deleteAllAssistantsDistribution(){
        Transaction transaction=null;
        try (Session session=HibernateUtil.getSessionFactory().openSession()){
            transaction= session.beginTransaction();
            session.createQuery("delete from AssistantsDistribution ").executeUpdate();
            transaction.commit();
        }catch (Exception exception){
            transaction.rollback();
            exception.printStackTrace();
        }
    }
    public List<AssistantsDistribution> searchAssistantsDistribution(int departmentId,int levelId,int assistantId,int sectionNumber){
        boolean flag=false;
        String sql="";
        if(departmentId!=-1){
            sql+="where department_id="+departmentId;
            flag=true;
        }
        if(levelId!=-1){
            if(flag){
                sql+=" and level_id="+levelId;
            }else{
                sql+="where level_id="+levelId;
                flag=true;
            }
        }
        if(assistantId!=-1){
            if(flag){
                sql+=" and assistant_id="+assistantId;
            }else{
                sql+="where assistant_id="+assistantId;
                flag=true;
            }
        }
        if(sectionNumber!=0){
            if(flag){
                sql+=" and section_number="+sectionNumber;
            }else{
                sql+="where section_number="+sectionNumber;
            }
        }
        List<AssistantsDistribution> assistantsDistributions=null;
        Transaction transaction=null;
        try (Session session= HibernateUtil.getSessionFactory().openSession()){
            transaction=session.beginTransaction();
            assistantsDistributions=session.createQuery("from AssistantsDistribution "+sql+" order by assistantsDistributionKey.level_id,assistantsDistributionKey.section_number,day_id").getResultList();
            transaction.commit();
        }catch (Exception exception){
            transaction.rollback();
            exception.printStackTrace();
        }
        return assistantsDistributions;
    }
    private List<AssistantsDistribution> reverseSections(List<AssistantsDistribution> assistantsDistributions){
        int last=assistantsDistributions.size()-1,first=0,temp;
        while (first < last){
                temp = assistantsDistributions.get(first).getAssistantsDistributionKey().getSection_number();
                assistantsDistributions.get(first).getAssistantsDistributionKey().setSection_number(assistantsDistributions.get(last).getAssistantsDistributionKey().getSection_number());
                assistantsDistributions.get(last).getAssistantsDistributionKey().setSection_number(temp);
                last--;
                first++;
            }
        Collections.reverse(assistantsDistributions);
//        for(int i=0;i<assistantsDistributions.size()-1;i++) {
//            if (assistantsDistributions.get(i).getAssistantsDistributionKey().getSection_number() == assistantsDistributions.get(i + 1).getAssistantsDistributionKey().getSection_number() && assistantsDistributions.get(i).getDay_id() == assistantsDistributions.get(i + 1).getDay_id() && (assistantsDistributions.get(i).getStart_time() == assistantsDistributions.get(i + 1).getStart_time() || (assistantsDistributions.get(i).getStart_time() < assistantsDistributions.get(i + 1).getEnd_time() && assistantsDistributions.get(i).getStart_time() > assistantsDistributions.get(i + 1).getStart_time()) || (assistantsDistributions.get(i).getEnd_time() > assistantsDistributions.get(i + 1).getStart_time() && assistantsDistributions.get(i).getEnd_time() < assistantsDistributions.get(i + 1).getEnd_time()))) {
//                int levelId = assistantsDistributions.get(i).getAssistantsDistributionKey().getLevel_id();
//                int departmentId = assistantsDistributions.get(i).getAssistantsDistributionKey().getDepartment_id();
//                int secNum = assistantsDistributions.get(i).getAssistantsDistributionKey().getSection_number();
//                int courseId = assistantsDistributions.get(i).getAssistantsDistributionKey().getCourse_id();
//                int finalSecNum1 = secNum;
//                if(finalSecNum1>assistantsDistributions.get(assistantsDistributions.size()-1).getAssistantsDistributionKey().getSection_number()){
//                    break;
//                }
//                List<AssistantsDistribution> assistantsDistributionList = assistantsDistributions.stream().filter(assistantsDistribution1 -> assistantsDistribution1.getAssistantsDistributionKey().getDepartment_id() == departmentId && assistantsDistribution1.getAssistantsDistributionKey().getLevel_id() == levelId && assistantsDistribution1.getAssistantsDistributionKey().getCourse_id() == courseId && assistantsDistribution1.getAssistantsDistributionKey().getSection_number() == finalSecNum1 + 1).collect(Collectors.toList());
//                AssistantsDistribution assistantsDistribution=null;
//                if(assistantsDistributionList.size()==0){
//                    continue;
//                }else{
//                    assistantsDistribution=assistantsDistributionList.get(0);
//                }
//                while (assistantsDistribution.getStart_time() != assistantsDistributions.get(i + 1).getEnd_time() || assistantsDistribution.getEnd_time() == assistantsDistributions.get(i + 1).getStart_time()) {
//                    secNum++;
//                    int finalSecNum = secNum;
//                    if(finalSecNum>assistantsDistributions.get(assistantsDistributions.size()-1).getAssistantsDistributionKey().getSection_number()){
//                        break;
//                    }
//                    List<AssistantsDistribution> assistantsDistribution2 = assistantsDistributions.stream().filter(assistantsDistribution1 -> assistantsDistribution1.getAssistantsDistributionKey().getDepartment_id() == departmentId && assistantsDistribution1.getAssistantsDistributionKey().getLevel_id() == levelId && assistantsDistribution1.getAssistantsDistributionKey().getCourse_id() == courseId && assistantsDistribution1.getAssistantsDistributionKey().getSection_number() == finalSecNum + 1).collect(Collectors.toList());
//                    if(assistantsDistribution2.size()==0){
//                        continue;
//                    }else{
//                        assistantsDistribution=assistantsDistribution2.get(0);
//                    }
//                }
//                temp = assistantsDistributions.get(i).getAssistantsDistributionKey().getSection_number();
//                assistantsDistributions.get(i).getAssistantsDistributionKey().setSection_number(assistantsDistribution.getAssistantsDistributionKey().getSection_number());
//                assistantsDistribution.getAssistantsDistributionKey().setSection_number(temp);
//            }
//        }
        return assistantsDistributions;
    }
    public List<AssistantsDistribution> orderSections(List<AssistantsDistribution> assistantsDistributions){
       List<AssistantsDistribution> result=new ArrayList<>();
        int last=0;
       for(int first=last;first<assistantsDistributions.size();){
           while (assistantsDistributions.get(first).getAssistantsDistributionKey().getLevel_id()==assistantsDistributions.get(last).getAssistantsDistributionKey().getLevel_id()){
               last++;
               if(last==assistantsDistributions.size()){
                   break;
               }
           }
           if(last==assistantsDistributions.size()){
               result.addAll(this.reverseSections(assistantsDistributions.subList(first,last)));
               break;
           }else{
               result.addAll(this.reverseSections(assistantsDistributions.subList(first,last)));
               first=last;
           }
       }
        return result;
    }

}
