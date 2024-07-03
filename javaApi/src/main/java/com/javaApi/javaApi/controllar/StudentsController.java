package com.javaApi.javaApi.controllar;
import com.javaApi.javaApi.entity.Students;
import com.javaApi.javaApi.services.StudentsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class StudentsController {
    @Autowired
    private StudentsServices studentsServices;

    @GetMapping("/students")
    public List<Students> getStudents() {
        return studentsServices.getAllStudent();
    }

    @GetMapping("/studentid")
    public Optional<Students> getByStudentId(int id) {
        return studentsServices.getStudentsById(id);


    }

    @PostMapping("/resigter")
    public Students registerStudent(@RequestBody Students students) {
        return studentsServices.savestudents(students);
    }

    @DeleteMapping("/delete")
    public void deleteStudent(@RequestParam int id) {

        studentsServices.deleteStudents(id);

    }

    @PutMapping("/updatestudentdetails")
    public Students updateStudent(@RequestParam int id, @RequestBody Students students) {
        students.setRollno(id);
        return studentsServices.updateStudent(students);
    }

}
