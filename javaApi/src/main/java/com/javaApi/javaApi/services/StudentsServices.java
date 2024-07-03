package com.javaApi.javaApi.services;

import com.javaApi.javaApi.entity.Students;
import com.javaApi.javaApi.repository.StudentsRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Service
public class StudentsServices {
    @Autowired

    private StudentsRepository studentsRepository;

    public List<Students> getAllStudent() {
        return studentsRepository.findAll();
    }

    public Optional<Students> getStudentsById(int id) {
        return studentsRepository.findById(id);
    }

    public Students savestudents(Students students) {
        return studentsRepository.save(students);
    }


    public Optional<Students> deleteStudents(int id) {
        Optional<Students> studentList = studentsRepository.findById(id);
        if (studentList.isEmpty()) {
            throw new RuntimeException("No user found");
        } else {
            studentsRepository.delete(studentList.get());
            return studentList;
        }
    }

    public Students updateStudent(Students students) {
        Optional<Students> studentDetails = studentsRepository.findById(students.getRollno());
            Students existingUser = studentDetails.get();
            existingUser.setName(students.getName());
//        existingUser.setName(students.getName());
            return studentsRepository.save(existingUser);


    }

//    public Optional<Students> updateStudents(Students students) {
//        for (Students currentStudents : students) {
//            if (currentSutdents.getStudentname() == students.getStudentname()) {
//                currentSutdents.setStudentname(students.getStudentname());
//                currentSutdents.setStudentage(students.getStudentage());
//            }
//        }
//          return "students updated ";
//    }

}
