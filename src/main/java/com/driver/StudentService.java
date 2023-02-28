package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
@Autowired
    StudentRepository studentRepository;
public void addStudent(Student student){
   studentRepository.saveStudent(student);
}
public void addTeacher(Teacher teacher){
    studentRepository.saveTeacher(teacher);
}
public void addStudentTeacher(String student,String teacher){
    studentRepository.saveTeacherStudent(student,teacher);
}
public Student findStudent(String name){
     return studentRepository.getStudent(name);
}
public Teacher findTeacher(String name){
    return studentRepository.getTeacher(name);
}
public List<String> getStudentTeachers(String name){
    return studentRepository.getStudentTeacher(name);
}
public List<String> getAllStudents(){
    return studentRepository.getAllStudent();
}
public void deleteStudentTeacher(String name){
    studentRepository.deleteTeacherStudent(name);
}
public void deleteAllName(){
    studentRepository.deleteAll();
}
}
