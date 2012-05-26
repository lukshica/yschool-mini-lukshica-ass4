package org.ymini.lukshica.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;


public class StudentDAO {
    
    EntityManagerFactory emf;
    EntityManager em;
    
    public StudentDAO() {
        this.emf = Persistence.createEntityManagerFactory("jpatestPU");
        this.em = emf.createEntityManager();
    }

    public List<Student> getStudentList() {
        Query query = em.createQuery("select s from Student s");
        return query.getResultList();
    }

    
    public boolean insertStudent(Student student) {
        if (student == null) {
            return false;
        }
        em.getTransaction().begin();
        em.persist(student);
        em.getTransaction().commit();
        return true;
    }
    
/*
    public List<Student> findStudent(int grade){
            List<Student> s;       
            Query query = em.createQuery("select s from Student s where Grade='"+grade+"'");
            s=query.getResultList();      
            return s;
      }
*/
    
    public boolean updateStudent(final Student student) {
        if (student == null) {
            return false;
        }
        em.getTransaction().begin();
        Student persistStudent = em.find(Student.class, student.getAdmno());
        if (persistStudent == null) {
            return false;
        } else {
            persistStudent.setName(student.getName());
            persistStudent.setAddress(student.getAddress());
            persistStudent.setGrade(student.getGrade());
            persistStudent.setParentName(student.getParentName());
            em.getTransaction().commit();
        }
        return true;
    }
  
    public boolean deleteStudent(Student student) {
         if (student == null) {
            return false;
        }
        em.getTransaction().begin();
        Student persistStudent = em.find(Student.class, student.getAdmno());
        if (persistStudent == null) {
            return false;
        } else {
            em.remove(persistStudent);
            em.getTransaction().commit();
        }
        return true;
    }

}
