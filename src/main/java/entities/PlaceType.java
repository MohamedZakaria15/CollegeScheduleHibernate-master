package entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "places_types")
public class PlaceType {
    @Id
    @Column(name = "type_id")
    private int typeID;
    @Column(name = "type_name")
    private String typeName;


    @OneToMany(mappedBy = "placeType",cascade = CascadeType.ALL)
    private Set<CourseTypeDuration> courseTypeDurations=new HashSet<>();


    @OneToMany(mappedBy = "placeType",cascade = CascadeType.ALL)
    private Set<Room> rooms=new HashSet<>();

    public PlaceType(){};
    public PlaceType(int typeID, String typeName) {
        this.typeID = typeID;
        this.typeName = typeName;
    }

    public int getTypeID() {
        return typeID;
    }

    public void setTypeID(int typeID) {
        this.typeID = typeID;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Set<CourseTypeDuration> getCourseTypeDurations() {
        return courseTypeDurations;
    }

    public void setCourseTypeDurations(Set<CourseTypeDuration> courseTypeDurations) {
        this.courseTypeDurations = courseTypeDurations;
    }

    public Set<Room> getRooms() {
        return rooms;
    }

    public void setRooms(Set<Room> rooms) {
        this.rooms = rooms;
    }
}
