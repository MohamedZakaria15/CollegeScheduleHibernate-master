package management;

import entities.*;
import management.DutiesObjects.AssistantDuty;
import management.DutiesObjects.LecturerDuty;
import services.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class DutyTime {
    public List<AssistantDuty> assistantTimeDuty() {
        List<AssistantDuty> assistantDuties = new ArrayList<>();
        for (CourseDepartmentLevel courseDepartmentLevel : new CourseDepartmentLevelServices().findAllCourseDepartmentLevel()) {
            float totalTime = 0;
            int numOfSections = 0;
            int totalSections = 0;
            CourseTypeDuration courseTypeDuration = courseDepartmentLevel.getCourse().getCourseTypeDurations().stream().filter(courseTypeDuration1 -> courseTypeDuration1.getPlaceType().getTypeID()!=1).findFirst().get();
            System.out.println(courseTypeDuration.getPlaceType().getTypeName());
            if (!courseTypeDuration.getPlaceType().getTypeName().equals("Hall") || courseTypeDuration.getPlaceType().getTypeID()!=1) {
                Assistant lastAssistant = null;
                if (courseDepartmentLevel.getCourse().getAssistants().size() == 1) {
                    Assistant assistant = courseDepartmentLevel.getCourse().getAssistants().stream().findFirst().get();
                    while (totalSections != courseDepartmentLevel.getNum_of_sections()) {
                        totalSections++;
                        totalTime += courseTypeDuration.getDuration();
                    }
                    AssistantDuty assistantDuty=new AssistantDuty(assistant.getAssistantID(), assistant.getAssistantFirstName() + assistant.getAssistantMiddleName() + assistant.getAssistantLastName(), courseDepartmentLevel.getLevel().getLevelID(), courseDepartmentLevel.getLevel().getLevelName(), courseDepartmentLevel.getDepartment().getDepartmentID(), courseDepartmentLevel.getDepartment().getDepartmentName(), courseDepartmentLevel.getCourse().getCourseID(), courseDepartmentLevel.getCourse().getCourseName(), courseTypeDuration.getPlaceType().getTypeID(), courseTypeDuration.getPlaceType().getTypeName(), courseTypeDuration.getDuration(), totalSections, totalTime);
                    assistantDuties.add(assistantDuty);
                    break;
                }
                for (Assistant assistant : courseDepartmentLevel.getCourse().getAssistants()) {
                    lastAssistant = assistant;
                }
                for (Assistant assistant : courseDepartmentLevel.getCourse().getAssistants()) {
                    float prevTotal = 0;
                    List<AssistantDuty> assistantDutyList = assistantDuties.stream().filter(assistantDuty -> assistantDuty.getAssistantId() == assistant.getAssistantID()).collect(Collectors.toList());
                    if (assistantDutyList.size() != 0) {
                        prevTotal = assistantDutyList.get(0).getTotalTime();
                    }
                    if (assistant.getAssistantID() == lastAssistant.getAssistantID()) {
                        while (totalSections != courseDepartmentLevel.getNum_of_sections()) {
                            totalTime += courseTypeDuration.getDuration();
                            numOfSections++;
                            totalSections++;
                            if ((totalTime + prevTotal) > assistant.getAssistantDegree().getDegreeMaximumHours() || (prevTotal == 0 && totalTime >= assistant.getAssistantDegree().getDegreeMinimumHours())) {
                                totalSections--;
                                numOfSections--;
                                totalTime -= courseTypeDuration.getDuration();
                                break;
                            }
                        }
                        if (totalSections < courseDepartmentLevel.getNum_of_sections()) {
                            int i = 0;
                            while (i < courseDepartmentLevel.getNum_of_sections() - totalSections) {
                                for (Assistant assistant1 : courseDepartmentLevel.getCourse().getAssistants()) {
                                    List<AssistantDuty> assistantDutyList1 = assistantDuties.stream().filter(assistantDuty -> assistantDuty.getAssistantId() == assistant1.getAssistantID()).collect(Collectors.toList());
                                    int counter = 0;
                                    if (assistantDutyList1.size() == 2) {
                                        if (assistantDutyList1.get(1).getTotalTime() + assistantDutyList1.get(0).getTotalTime() + courseTypeDuration.getDuration() < assistant1.getAssistantDegree().getDegreeMaximumHours()) {
                                            float Time = assistantDutyList1.get(1).getTotalTime() + courseTypeDuration.getDuration();
                                            int sections = assistantDutyList1.get(1).getNumOfSections() + 1;
                                            for (AssistantDuty assistantDuty : assistantDuties) {
                                                if (assistantDuty.getAssistantId() == assistantDutyList1.get(1).getAssistantId()) {
                                                    break;
                                                }
                                                counter++;
                                            }
                                            assistantDuties.remove(counter);
                                            AssistantDuty assistantDuty=new AssistantDuty(assistantDutyList1.get(1).getAssistantId(), assistantDutyList1.get(1).getAssistantName(), assistantDutyList1.get(1).getLevelId(), assistantDutyList1.get(1).getLevelName(), assistantDutyList1.get(1).getDepartmentId(), assistantDutyList1.get(1).getDepartmentName(), assistantDutyList1.get(1).getCourseId(), assistantDutyList1.get(1).getCourseName(), assistantDutyList1.get(1).getTypeId(), assistantDutyList1.get(1).getTypeName(), assistantDutyList1.get(1).getDuration(), sections, Time);
                                            assistantDuties.add(assistantDuty);
                                            i++;
                                            break;
                                        }
                                    } else {
                                        if (assistant1.getAssistantID() != lastAssistant.getAssistantID()) {
                                            if (assistantDutyList1.get(0).getTotalTime() + courseTypeDuration.getDuration() < assistant1.getAssistantDegree().getDegreeMinimumHours()) {
                                                float Time = assistantDutyList1.get(0).getTotalTime() + courseTypeDuration.getDuration();
                                                int sections = assistantDutyList1.get(0).getNumOfSections() + 1;
                                                for (AssistantDuty assistantDuty : assistantDuties) {
                                                    if (assistantDuty.getAssistantId() == assistantDutyList1.get(0).getAssistantId()) {
                                                        break;
                                                    }
                                                    counter++;
                                                }
                                                assistantDuties.remove(counter);
                                                AssistantDuty assistantDuty=new AssistantDuty(assistantDutyList1.get(0).getAssistantId(), assistantDutyList1.get(0).getAssistantName(), assistantDutyList1.get(0).getLevelId(), assistantDutyList1.get(0).getLevelName(), assistantDutyList1.get(0).getDepartmentId(), assistantDutyList1.get(0).getDepartmentName(), assistantDutyList1.get(0).getCourseId(), assistantDutyList1.get(0).getCourseName(), assistantDutyList1.get(0).getTypeId(), assistantDutyList1.get(0).getTypeName(), assistantDutyList1.get(0).getDuration(), sections, Time);
                                                assistantDuties.add(assistantDuty);
                                                i++;
                                                break;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    } else {
                        prevTotal = 0;
                        assistantDutyList = assistantDuties.stream().filter(assistantDuty -> assistantDuty.getAssistantId() == assistant.getAssistantID()).collect(Collectors.toList());
                        if (assistantDutyList.size() != 0) {
                            prevTotal = assistantDutyList.get(0).getTotalTime();
                        }
                        if (prevTotal != 0) {
                            while ((totalTime + prevTotal) < assistant.getAssistantDegree().getDegreeMaximumHours() && totalSections != courseDepartmentLevel.getNum_of_sections()) {
                                totalTime += courseTypeDuration.getDuration();
                                totalSections++;
                                numOfSections++;
                                if ((totalTime + prevTotal) > assistant.getAssistantDegree().getDegreeMaximumHours()) {
                                    totalSections--;
                                    numOfSections--;
                                    totalTime -= courseTypeDuration.getDuration();
                                    break;
                                }
                            }
                        } else {
                            while (totalTime < (int) (courseDepartmentLevel.getNum_of_sections() * courseTypeDuration.getDuration() / courseDepartmentLevel.getCourse().getAssistants().size()) && totalSections != courseDepartmentLevel.getNum_of_sections()) {
                                totalTime += courseTypeDuration.getDuration();
                                numOfSections++;
                                totalSections++;
                            }
                        }
                    }
                    AssistantDuty assistantDuty=new AssistantDuty(assistant.getAssistantID(), assistant.getAssistantFirstName() + assistant.getAssistantMiddleName() + assistant.getAssistantLastName(), courseDepartmentLevel.getLevel().getLevelID(), courseDepartmentLevel.getLevel().getLevelName(), courseDepartmentLevel.getDepartment().getDepartmentID(), courseDepartmentLevel.getDepartment().getDepartmentName(), courseDepartmentLevel.getCourse().getCourseID(), courseDepartmentLevel.getCourse().getCourseName(), courseTypeDuration.getPlaceType().getTypeID(), courseTypeDuration.getPlaceType().getTypeName(), courseTypeDuration.getDuration(), numOfSections, totalTime);
                    assistantDuties.add(assistantDuty);
                    numOfSections = 0;
                    totalTime = 0;
                }
            }
        }
                Comparator<AssistantDuty> compareByBothSectionAndLevel = Comparator
                .comparing(AssistantDuty::getCourseId);
        return assistantDuties.stream().sorted(compareByBothSectionAndLevel).collect(Collectors.toList());
    }

    public List<LecturerDuty> lecturerTimeDuty() {
        List<LecturerDuty> lecturerDuties = new ArrayList<>();
        float totalTime = 0;
        int numOfGroups = 0;
        for (CourseDepartmentLevel courseDepartmentLevel : new CourseDepartmentLevelServices().findAllCourseDepartmentLevel()) {
            numOfGroups = 0;
            List<CourseTypeDuration> courseTypeDurations = courseDepartmentLevel.getCourse().getCourseTypeDurations().stream().filter(courseTypeDuration1 -> courseTypeDuration1.getPlaceType().getTypeName().equals("Hall") || courseTypeDuration1.getPlaceType().getTypeID()==1).collect(Collectors.toList());
            if (courseTypeDurations.size() != 0) {
                CourseTypeDuration courseTypeDuration = courseTypeDurations.get(0);
                Lecturer lastLecturer = null;
                for (Lecturer temp : courseDepartmentLevel.getCourse().getLecturers()) {
                    lastLecturer = temp;
                }
                for (Lecturer lecturer : courseDepartmentLevel.getCourse().getLecturers()) {
                    float prev = 0;
                    int prevGroups = 0;
                    List<LecturerDuty> prevLecturerDuty = (lecturerDuties.stream().filter(lecturerDuty -> lecturerDuty.getLecturerId() == lecturer.getLecturerID()).collect(Collectors.toList()));
                    if (prevLecturerDuty.size() != 0) {
                        prev = prevLecturerDuty.get(0).getTotalTime();
                    }
                    List<LecturerDuty> lecturerDutyList = lecturerDuties.stream().filter(lecturerDuty -> lecturerDuty.getCourseId() == courseDepartmentLevel.getCourse().getCourseID()).collect(Collectors.toList());
                    for (LecturerDuty lecturerDuty : lecturerDutyList) {
                        prevGroups += lecturerDuty.getNumOfGroups();
                    }
                    if (prev != 0) {
                        while ((totalTime + prev) < lecturer.getLecturerDegree().getDegreeMaximumHours() && numOfGroups != courseDepartmentLevel.getNum_of_groups()) {
                            numOfGroups++;
                            totalTime += courseTypeDuration.getDuration();
                            if (totalTime + prev > lecturer.getLecturerDegree().getDegreeMaximumHours()) {
                                numOfGroups--;
                                totalTime -= courseTypeDuration.getDuration();
                                break;
                            }
                        }
                    } else {
                        if (lecturer.equals(lastLecturer)) {
                            while (numOfGroups != courseDepartmentLevel.getNum_of_groups()) {
                                numOfGroups++;
                                totalTime += courseTypeDuration.getDuration();
                                if (totalTime + prev > lecturer.getLecturerDegree().getDegreeMaximumHours()) {
                                    numOfGroups--;
                                    totalTime -= courseTypeDuration.getDuration();
                                    break;
                                }
                            }
                        } else {
                            while (totalTime < (courseDepartmentLevel.getNum_of_groups() * courseTypeDuration.getDuration()) / courseDepartmentLevel.getCourse().getLecturers().size()) {
                                numOfGroups++;
                                totalTime += courseTypeDuration.getDuration();
                            }
                        }
                    }
                    lecturerDuties.add(new LecturerDuty(lecturer.getLecturerID(), lecturer.getLecturerFirstName() + " " + lecturer.getLecturerMiddleName() + " " + lecturer.getLecturerLastName(), courseDepartmentLevel.getLevel().getLevelID(), courseDepartmentLevel.getLevel().getLevelName(), courseDepartmentLevel.getDepartment().getDepartmentID(), courseDepartmentLevel.getDepartment().getDepartmentName(), courseDepartmentLevel.getCourse().getCourseID(), courseDepartmentLevel.getCourse().getCourseName(), courseTypeDuration.getPlaceType().getTypeID(), courseTypeDuration.getPlaceType().getTypeName(), courseTypeDuration.getDuration(), numOfGroups - prevGroups, totalTime));
                    totalTime = 0;
                }
            }
        }
        Comparator<LecturerDuty> compareByBothSectionAndLevel = Comparator
                .comparing(LecturerDuty::getCourseId);
        return lecturerDuties.stream().sorted(compareByBothSectionAndLevel).collect(Collectors.toList());
    }

}
