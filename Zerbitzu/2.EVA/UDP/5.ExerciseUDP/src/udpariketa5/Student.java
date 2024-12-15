
package udpariketa5;

import java.io.Serializable;

public class Student implements Serializable {
    private int id;
    private String name;
    private int age;
    private float distanceToCollege;

    // Constructor to initialize the student details (without id)
    public Student(String name, int age, float distanceToCollege) {
        this.name = name;
        this.age = age;
        this.distanceToCollege = distanceToCollege;
    }

    // Getter and Setter for id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Getters and Setters for other fields
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public float getDistanceToCollege() {
        return distanceToCollege;
    }

    public void setDistanceToCollege(float distanceToCollege) {
        this.distanceToCollege = distanceToCollege;
    }

    @Override
    public String toString() {
        return "Student{id=" + id + ", name='" + name + "', age=" + age + ", distanceToCollege=" + distanceToCollege + "}";
    }
}
