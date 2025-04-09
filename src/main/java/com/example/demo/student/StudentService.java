package com.example.demo.student;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * A service class to handle the business logic
 * It is annotated with @Service: to indicate that it is a service layer
 */
@Service
public class StudentService {

    //A dependency injection of the StudentRepository to access the database
    private final StudentRepository studentRepository;

    /**
     * A constructor to inject the StudentRepository
     * @param studentRepository the student repository
     */
    @Autowired
    public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents(){
        return studentRepository.findAll();
    }

    /**
     * A function to create a new student record
     * It first checks whether a record with the same email exists
     * If none, it saves to the database
     */
    public void addNewStudent(Student student) {
        Optional<Student> studentOptional = studentRepository.findStudentByEmail(student.getEmail());

        if(studentOptional.isPresent()){
            throw new IllegalStateException("email taken");
        }
        studentRepository.save(student);
    }

    /**
     * A function to delete a student from the system
     */
    public void deleteStudent(Long studentId){

      boolean exists =  studentRepository.existsById(studentId);
      if(!exists){
          throw new IllegalStateException("student with id " +studentId + "does not exist");
      }

      studentRepository.deleteById(studentId);

    }
    /**
     * update student data based on the id given on the path variable
     * It checks if the student exists
     * Then checks if the name and email are not null or empty
     * If they are not, it checks if the email is already taken
     * If not, it updates the student record
     */
    @Transactional
    public void updateStudent(Long studentId,String name,String email){

        Student student = studentRepository.findById(studentId).orElseThrow(() -> new IllegalStateException("Student with id" +studentId + "does not exist"));

        if (name!=null && !name.isEmpty() && !Objects.equals(student.getName(),name)){
            student.setName(name);
        }

        if(email!=null && !email.isEmpty() && !Objects.equals(student.getEmail(),email)){
            Optional<Student> studentOptional = studentRepository.findStudentByEmail(email);
            if(studentOptional.isPresent()){
                throw new IllegalStateException("email taken");
            }
            student.setEmail(email);
        }

    }
}
