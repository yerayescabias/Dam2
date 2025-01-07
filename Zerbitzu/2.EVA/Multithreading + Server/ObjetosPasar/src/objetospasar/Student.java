/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package objetospasar;

import java.io.Serializable;

/**
 *
 * @author Administrador
 */
public class Student implements Serializable{


    
    public int id;
    public String name;
    public String surname;
    public int edad;
    public float distance;

    public Student(int id, String name, String surname, int edad, float distance) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.edad = edad;
        this.distance = distance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getDistance() {
        return distance;
    }

    public void setDistance(float distance) {
        this.distance = distance;
    }
   
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

   
       @Override
    public String toString() {
        return "Student{" + "id=" + id + ", name=" + name + ", surname=" + surname + ", edad=" + edad + ", distance=" + distance + '}';
    }
   
}
