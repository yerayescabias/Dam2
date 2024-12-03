package fifthexercise;

import java.io.Serializable;

public class Student implements Serializable {
    private int id;
    private String name;
    private int age;
    private float distanceToCollege;

    public Student(String name, int age, float distanceToCollege) {
        this.name = name;
        this.age = age;
        this.distanceToCollege = distanceToCollege;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", distanceToCollege=" + distanceToCollege +
                '}';
    }
}
