
package org.ymini.lukshica.managedBean;

import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.apache.log4j.Logger;
import org.ymini.lukshica.dao.Student;
import org.ymini.lukshica.dao.StudentDAO;


@ManagedBean(name = "studentManagedBean")
@SessionScoped
public class studentManagedBean implements Serializable {
   
    
    private static final Logger log = Logger.getLogger(studentManagedBean.class);
    
    private Student createStudent;
    private Student selectedStudent;
    StudentDAO studentDAO;
    private String message;
   

    public studentManagedBean() {
        this.createStudent = new Student();
        this.selectedStudent = new Student();               
        this.studentDAO = new StudentDAO();
        
        log.info("Initiated studentManagedBean");
    

    }
    
    public List<Student> getStudentList() {
        return this.studentDAO.getStudentList();
    }
    
    public void prepareCreate() {
            this.studentDAO.insertStudent(createStudent);
            setSelectedStudent(createStudent);

            log.info("New Student Inserted :" + createStudent.getName());

            createStudent = new Student();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, " Student added successfully ", null));

        }
    
    public void updateStudent() {
        this.studentDAO.updateStudent(this.selectedStudent);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, " Student updated successfully ", null)); 
          
        log.info("Student");
    }

     public void deleteStudent() {
        this.studentDAO.deleteStudent(this.selectedStudent);
        this.selectedStudent = new Student();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, " Student deleted successfully ", null));  
          log.info("Student Deleted ");
    }

     
    public Student getSelectedStudent() {
        return selectedStudent;
    }

    public void setSelectedStudent(Student selectedStudent) {
        this.selectedStudent = selectedStudent;
    }

    public Student getCreateStudent() {
        return createStudent;
    }

    public void setCreateStudent(Student createStudent) {
        this.createStudent = createStudent;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}