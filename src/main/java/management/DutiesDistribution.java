package management;

import entities.AssistantsDistribution;
import entities.Day;
import entities.LecturersDistribution;
import entities.Room;
import entities.embedded.AssistantsDistributionKey;
import entities.embedded.LecturersDistributionKey;
import management.DutiesObjects.AssistantDuty;
import management.DutiesObjects.AssistantScheduleInstance;
import management.DutiesObjects.LecturerDuty;
import management.DutiesObjects.LecturerScheduleInstance;
import services.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class DutiesDistribution {
    private DutyTime dutyTime = new DutyTime();
    private AssistantsDistributionService assistantsDistributionService = new AssistantsDistributionService();

    public void assistantsDistribution() {
        AssistantsDistributionService assistantsDistributionService = new AssistantsDistributionService();
        assistantsDistributionService.deleteAllAssistantsDistribution();
        LevelDayDepartmentServices levelDayDepartmentServices = new LevelDayDepartmentServices();
        AssistantServices assistantServices = new AssistantServices();
        RoomServices roomServices = new RoomServices();
        TimeServices timeServices = new TimeServices();
        List<AssistantScheduleInstance> assistantScheduleInstances = new ArrayList<>();
        for (AssistantDuty assistantDuty : dutyTime.assistantTimeDuty()) {
            for (int i = 0; i < assistantDuty.getNumOfSections(); ) {
                for (Day day : assistantServices.findAssistantByID(assistantDuty.getAssistantId()).getDays()) {
                    if (levelDayDepartmentServices.findLevelDayDepartmentByAllThreeID(assistantDuty.getLevelId(), day.getDayID(), assistantDuty.getDepartmentId()) != null) {
                        List<Room> rooms = roomServices.findAllRooms().stream().filter(room -> room.getPlaceType().getTypeID() == assistantDuty.getTypeId()).collect(Collectors.toList());
                        for (Room room : rooms) {
                            List<AssistantScheduleInstance> assistantScheduleInstancesList1 = assistantScheduleInstances.stream().filter(assistantScheduleInstance -> assistantScheduleInstance.getDayId() == day.getDayID() && assistantScheduleInstance.getRoomNumber() == room.getRoomID()).collect(Collectors.toList());
                            List<AssistantScheduleInstance> assistantScheduleInstanceList2 = assistantScheduleInstances.stream().filter(assistantScheduleInstance -> assistantScheduleInstance.getLevelId() == assistantDuty.getLevelId() && assistantScheduleInstance.getDepartmentId() == assistantDuty.getDepartmentId() && assistantScheduleInstance.getCourseId() == assistantDuty.getCourseId()).collect(Collectors.toList());
                            if (assistantScheduleInstancesList1.size() == 0) {
                                List<AssistantScheduleInstance> assistantScheduleInstanceList = assistantScheduleInstances.stream().filter(assistantScheduleInstance -> assistantScheduleInstance.getDepartmentId() == assistantDuty.getDepartmentId() && assistantScheduleInstance.getLevelId() == assistantDuty.getLevelId() && assistantScheduleInstance.getDayId() == day.getDayID() && assistantScheduleInstance.getSectionNumber() == assistantScheduleInstanceList2.size() + 1 && assistantScheduleInstance.getStartTime() == timeServices.findTime().getStart_time()).collect(Collectors.toList());
                                if (assistantScheduleInstanceList.size() != 0) {
                                    assistantScheduleInstances.add(new AssistantScheduleInstance(assistantDuty.getDepartmentId(), assistantDuty.getDepartmentName(), assistantDuty.getLevelId(), assistantDuty.getLevelName(), assistantDuty.getAssistantId(), assistantDuty.getAssistantName(), assistantDuty.getCourseId(), assistantDuty.getCourseName(), day.getDayID(), day.getDayName(), assistantScheduleInstanceList2.size() + 1, room.getRoomID(), room.getRoomName(), 3, 5));
                                    assistantsDistributionService.insertAssistantDistribution(new AssistantsDistribution(new AssistantsDistributionKey(assistantDuty.getDepartmentId(), assistantDuty.getLevelId(), assistantDuty.getAssistantId(), assistantDuty.getCourseId(), (assistantScheduleInstanceList2.size() + 1)), assistantDuty.getDepartmentName(), assistantDuty.getLevelName(), assistantDuty.getAssistantName(), assistantDuty.getCourseName(), day.getDayID(), day.getDayName(), room.getRoomID(), room.getRoomName(), timeServices.findTime().getEnd_time() - assistantDuty.getDuration(), timeServices.findTime().getEnd_time()));
                                } else {
                                    assistantScheduleInstances.add(new AssistantScheduleInstance(assistantDuty.getDepartmentId(), assistantDuty.getDepartmentName(), assistantDuty.getLevelId(), assistantDuty.getLevelName(), assistantDuty.getAssistantId(), assistantDuty.getAssistantName(), assistantDuty.getCourseId(), assistantDuty.getCourseName(), day.getDayID(), day.getDayName(), assistantScheduleInstanceList2.size() + 1, room.getRoomID(), room.getRoomName(), timeServices.findTime().getStart_time(), timeServices.findTime().getStart_time() + assistantDuty.getDuration()));
                                    assistantsDistributionService.insertAssistantDistribution(new AssistantsDistribution(new AssistantsDistributionKey(assistantDuty.getDepartmentId(), assistantDuty.getLevelId(), assistantDuty.getAssistantId(), assistantDuty.getCourseId(), (assistantScheduleInstanceList2.size() + 1)), assistantDuty.getDepartmentName(), assistantDuty.getLevelName(), assistantDuty.getAssistantName(), assistantDuty.getCourseName(), day.getDayID(), day.getDayName(), room.getRoomID(), room.getRoomName(), timeServices.findTime().getStart_time(), (timeServices.findTime().getStart_time() + assistantDuty.getDuration())));
                                }
                                i++;
                                break;
                            } else {
                                float maxEndTime = assistantScheduleInstancesList1.stream().max(Comparator.comparing(AssistantScheduleInstance::getEndTime)).get().getEndTime();
                                if ((maxEndTime + assistantDuty.getDuration()) <= 12.0 + timeServices.findTime().getEnd_time()) {
                                    List<AssistantScheduleInstance> assistantScheduleInstanceList = assistantScheduleInstances.stream().filter(assistantScheduleInstance -> assistantScheduleInstance.getDepartmentId() == assistantDuty.getDepartmentId() && assistantScheduleInstance.getLevelId() == assistantDuty.getLevelId() && assistantScheduleInstance.getDayId() == day.getDayID() && assistantScheduleInstance.getSectionNumber() == assistantScheduleInstanceList2.size() + 1 && assistantScheduleInstance.getStartTime() == maxEndTime).collect(Collectors.toList());
                                    if (assistantScheduleInstanceList.size() != 0) {
                                        assistantScheduleInstances.add(new AssistantScheduleInstance(assistantDuty.getDepartmentId(), assistantDuty.getDepartmentName(), assistantDuty.getLevelId(), assistantDuty.getLevelName(), assistantDuty.getAssistantId(), assistantDuty.getAssistantName(), assistantDuty.getCourseId(), assistantDuty.getCourseName(), day.getDayID(), day.getDayName(), assistantScheduleInstanceList2.size() + 1, room.getRoomID(), room.getRoomName(), (timeServices.findTime().getEnd_time() - assistantDuty.getDuration()), timeServices.findTime().getEnd_time()));
                                        assistantsDistributionService.insertAssistantDistribution(new AssistantsDistribution(new AssistantsDistributionKey(assistantDuty.getDepartmentId(), assistantDuty.getLevelId(), assistantDuty.getAssistantId(), assistantDuty.getCourseId(), (assistantScheduleInstanceList2.size() + 1)), assistantDuty.getDepartmentName(), assistantDuty.getLevelName(), assistantDuty.getAssistantName(), assistantDuty.getCourseName(), day.getDayID(), day.getDayName(), room.getRoomID(), room.getRoomName(), timeServices.findTime().getEnd_time() - assistantDuty.getDuration(), timeServices.findTime().getEnd_time()));
                                    } else {
                                        assistantScheduleInstances.add(new AssistantScheduleInstance(assistantDuty.getDepartmentId(), assistantDuty.getDepartmentName(), assistantDuty.getLevelId(), assistantDuty.getLevelName(), assistantDuty.getAssistantId(), assistantDuty.getAssistantName(), assistantDuty.getCourseId(), assistantDuty.getCourseName(), day.getDayID(), day.getDayName(), assistantScheduleInstanceList2.size() + 1, room.getRoomID(), room.getRoomName(), maxEndTime, maxEndTime + assistantDuty.getDuration()));
                                        assistantsDistributionService.insertAssistantDistribution(new AssistantsDistribution(new AssistantsDistributionKey(assistantDuty.getDepartmentId(), assistantDuty.getLevelId(), assistantDuty.getAssistantId(), assistantDuty.getCourseId(), (assistantScheduleInstanceList2.size() + 1)), assistantDuty.getDepartmentName(), assistantDuty.getLevelName(), assistantDuty.getAssistantName(), assistantDuty.getCourseName(), day.getDayID(), day.getDayName(), room.getRoomID(), room.getRoomName(), maxEndTime, maxEndTime + assistantDuty.getDuration()));
                                    }
                                    i++;
                                    break;
                                } else {
                                    continue;
                                }
                            }
                        }
                        if (i == assistantDuty.getNumOfSections()) {
                            break;
                        }
                    }
                }
            }
        }
    }

    public void lecturersDistribution() {
        LecturersDistributionService lecturersDistributionService = new LecturersDistributionService();
        lecturersDistributionService.deleteAllLecturersDistribution();
        DayServices dayServices = new DayServices();
        LevelDayDepartmentServices levelDayDepartmentServices = new LevelDayDepartmentServices();
        LecturerServices lecturerServices = new LecturerServices();
        RoomServices roomServices = new RoomServices();
        TimeServices timeServices = new TimeServices();
        List<LecturerScheduleInstance> lecturerScheduleInstances = new ArrayList<>();
        for (LecturerDuty lecturerDuty : dutyTime.lecturerTimeDuty()) {
            for (int i = 0; i < lecturerDuty.getNumOfGroups(); ) {
                for (Day day : dayServices.findAllDays()) {
                    boolean flag = false;
                    for (Day day1 : lecturerServices.findLecturerByID(lecturerDuty.getLecturerId()).getDays()) {
                        if (day1.getDayID() == day.getDayID()) {
                            flag = true;
                        }
                    }
                    if (flag) {
                        continue;
                    }
                    if (levelDayDepartmentServices.findLevelDayDepartmentByAllThreeID(lecturerDuty.getLevelId(), day.getDayID(), lecturerDuty.getDepartmentId()) != null) {
                        List<LecturerScheduleInstance> lecturerScheduleInstanceList2 = lecturerScheduleInstances.stream().filter(lecturerScheduleInstance -> lecturerScheduleInstance.getLevelId() == lecturerDuty.getLevelId() && lecturerScheduleInstance.getDepartmentId() == lecturerDuty.getDepartmentId() && lecturerScheduleInstance.getCourseId() == lecturerDuty.getCourseId()).collect(Collectors.toList());
                        List<LecturerScheduleInstance> lecturerScheduleInstanceList3 = lecturerScheduleInstances.stream().filter(lecturerScheduleInstance -> lecturerScheduleInstance.getLevelId() == lecturerDuty.getLevelId() && lecturerScheduleInstance.getDepartmentId() == lecturerDuty.getDepartmentId() && lecturerScheduleInstance.getGroupNumber() == lecturerScheduleInstanceList2.size() + 1 && lecturerScheduleInstance.getDayId() == day.getDayID()).collect(Collectors.toList());
                        if (lecturerScheduleInstanceList3.size() == 2) {
                            continue;
                        }
                        List<Room> rooms = roomServices.findAllRooms().stream().filter(room -> room.getPlaceType().getTypeID() == lecturerDuty.getTypeId()).collect(Collectors.toList());
                        for (Room room : rooms) {
                            List<LecturerScheduleInstance> lecturerScheduleInstanceList1 = lecturerScheduleInstances.stream().filter(lecturerScheduleInstance -> lecturerScheduleInstance.getDayId() == day.getDayID() && lecturerScheduleInstance.getRoomNumber() == room.getRoomID()).collect(Collectors.toList());
                            List<LecturerScheduleInstance> instanceList = lecturerScheduleInstances.stream().filter(lecturerScheduleInstance -> lecturerScheduleInstance.getDayId() == day.getDayID() && lecturerScheduleInstance.getLevelId() == lecturerDuty.getLevelId() && lecturerScheduleInstance.getDepartmentId() == lecturerDuty.getDepartmentId() && lecturerScheduleInstance.getGroupNumber() == lecturerScheduleInstanceList2.size() + 1).collect(Collectors.toList());
                            if (lecturerScheduleInstanceList1.size() == 0 && instanceList.size() == 0) {
                                lecturerScheduleInstances.add(new LecturerScheduleInstance(lecturerDuty.getDepartmentId(), lecturerDuty.getDepartmentName(), lecturerDuty.getLevelId(), lecturerDuty.getLevelName(), lecturerDuty.getLecturerId(), lecturerDuty.getLecturerName(), lecturerDuty.getCourseId(), lecturerDuty.getCourseName(), day.getDayID(), day.getDayName(), lecturerScheduleInstanceList2.size() + 1, room.getRoomID(), room.getRoomName(), timeServices.findTime().getStart_time(), timeServices.findTime().getStart_time() + lecturerDuty.getDuration()));
                                lecturersDistributionService.insertLecturerDistribution(new LecturersDistribution(new LecturersDistributionKey(lecturerDuty.getDepartmentId(), lecturerDuty.getLevelId(), lecturerDuty.getLecturerId(), lecturerDuty.getCourseId(), (lecturerScheduleInstanceList2.size() + 1)), lecturerDuty.getDepartmentName(), lecturerDuty.getLevelName(), lecturerDuty.getLecturerName(), lecturerDuty.getCourseName(), day.getDayID(), day.getDayName(), room.getRoomID(), room.getRoomName(), timeServices.findTime().getStart_time(), timeServices.findTime().getStart_time() + lecturerDuty.getDuration()));
                                i++;
                                break;
                            } else {
                                float maxEndTime;
                                if (lecturerScheduleInstanceList1.size() != 0) {
                                    maxEndTime = lecturerScheduleInstanceList1.stream().max(Comparator.comparing(LecturerScheduleInstance::getEndTime)).get().getEndTime();
                                } else {
                                    maxEndTime = timeServices.findTime().getStart_time();
                                }
                                if (instanceList.size() != 0) {
                                    if (instanceList.stream().max(Comparator.comparing(LecturerScheduleInstance::getEndTime)).get().getEndTime() >= maxEndTime) {
                                        maxEndTime = instanceList.stream().max(Comparator.comparing(LecturerScheduleInstance::getEndTime)).get().getEndTime();
                                    }
                                }
                                if ((maxEndTime + lecturerDuty.getDuration()) <= 12.0 + timeServices.findTime().getEnd_time()) {
                                    float finalMaxEndTime = maxEndTime;
                                    lecturerScheduleInstances.add(new LecturerScheduleInstance(lecturerDuty.getDepartmentId(), lecturerDuty.getDepartmentName(), lecturerDuty.getLevelId(), lecturerDuty.getLevelName(), lecturerDuty.getLecturerId(), lecturerDuty.getLecturerName(), lecturerDuty.getCourseId(), lecturerDuty.getCourseName(), day.getDayID(), day.getDayName(), lecturerScheduleInstanceList2.size() + 1, room.getRoomID(), room.getRoomName(), maxEndTime, maxEndTime + lecturerDuty.getDuration()));
                                    lecturersDistributionService.insertLecturerDistribution(new LecturersDistribution(new LecturersDistributionKey(lecturerDuty.getDepartmentId(), lecturerDuty.getLevelId(), lecturerDuty.getLecturerId(), lecturerDuty.getCourseId(), (lecturerScheduleInstanceList2.size() + 1)), lecturerDuty.getDepartmentName(), lecturerDuty.getLevelName(), lecturerDuty.getLecturerName(), lecturerDuty.getCourseName(), day.getDayID(), day.getDayName(), room.getRoomID(), room.getRoomName(), maxEndTime, maxEndTime + lecturerDuty.getDuration()));
                                    i++;
                                    break;
                                } else {
                                    continue;
                                }
                            }
                        }
                        if (i == lecturerDuty.getNumOfGroups()) {
                            break;
                        }
                    }
                }
            }
        }
    }
}
