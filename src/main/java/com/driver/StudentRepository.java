package com.driver;

import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
@Repository
public class StudentRepository {

   private HashMap<String,Student> studentMap;
    private HashMap<String,Teacher>teacherMap;
    private HashMap<String,List<String>>studentTeacherMap;

    public StudentRepository(HashMap<String, Student> studentMap, HashMap<String, Teacher> teacherMap, HashMap<String, List<String>> studentTeacherMap) {
        this.studentMap = new HashMap<>();
        this.teacherMap = new HashMap<>();
        this.studentTeacherMap = new HashMap<>();
    }

    public HashMap<String, Student> getStudentMap() {
        return studentMap;
    }

    public void setStudentMap(HashMap<String, Student> studentMap) {
        this.studentMap = studentMap;
    }

    public HashMap<String, Teacher> getTeacherMap() {
        return teacherMap;
    }

    public void setTeacherMap(HashMap<String, Teacher> teacherMap) {
        this.teacherMap = teacherMap;
    }

    public HashMap<String, List<String>> getStudentTeacherMap() {
        return studentTeacherMap;
    }

    public void setStudentTeacherMap(HashMap<String, List<String>> studentTeacherMap) {
        this.studentTeacherMap = studentTeacherMap;
    }
    public void saveStudent(Student student){
        studentMap.put(student.getName(),student);
    }
    public void saveTeacher(Teacher teacher){
        teacherMap.put(teacher.getName(), teacher);
    }
    public void saveTeacherStudent(String StudentName,String TeacherName){
              if(studentMap.containsKey(StudentName)&&teacherMap.containsKey(TeacherName)){
                  studentMap.put(StudentName,studentMap.get(StudentName));
                  teacherMap.put(TeacherName,teacherMap.get(TeacherName));
                  List<String>students=new ArrayList<>();
                  if(studentTeacherMap.containsKey(TeacherName)){
                      students=studentTeacherMap.get(TeacherName);
                  }
                  students.add(StudentName);
                  studentTeacherMap.put(TeacherName,students);
              }
    }
    public Student getStudent(String name){
        return studentMap.get(name);
    }
    public Teacher getTeacher(String name){
        return teacherMap.get(name);
    }
    public List<String> getStudentTeacher(String name){
        List<String>studentList=new ArrayList<>();
        if(studentTeacherMap.containsKey(name)){
            studentList=studentTeacherMap.get(name);
        }
        return studentList;
    }
    public List<String> getAllStudent(){
        return new ArrayList<>(studentMap.keySet());
    }
    public void deleteTeacherStudent(String teacher){
       List<String>students=new ArrayList<>();
       if(studentTeacherMap.containsKey(teacher)){
           students=studentTeacherMap.get(teacher);
           for(String student:students){
               if(studentMap.containsKey(student)){
                   studentMap.remove(student);
               }
           }
           studentTeacherMap.remove(teacher);
       }
       if(teacherMap.containsKey(teacher)){
           teacherMap.remove(teacher);
       }
    }
    public void deleteAll(){
     for(String Key:studentMap.keySet()){
         studentMap.remove(Key,studentMap.get(Key));
     }
     for(String Key:teacherMap.keySet()){
         teacherMap.remove(Key,teacherMap.get(Key));
     }
    }
}
