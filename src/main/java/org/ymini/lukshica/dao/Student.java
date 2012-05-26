
package org.ymini.lukshica.dao;


import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Student implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    @Column(name = "AdmissionNo")
    private int admno;
    @Column(name = "FullName")
    private String name;
    @Column(name = "Address")
    private String address;
    @Column(name = "Grade")
    private int grade;
    @Column(name = "ParentName")
    private String parentName;

    public Student(String name, String address, int grade, String parentName) {
        this.name = name;
        this.address = address;
        this.grade = grade;
        this.parentName = parentName;
    }

    public Student() {
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public int getAdmno() {
        return admno;
    }

    public void setAdmno(int admno) {
        this.admno = admno;
    }
  
}
