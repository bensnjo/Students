package ke.go.kra.students.Students;

import org.aspectj.apache.bcel.classfile.Module;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping( path = "/api/v1/student" )
public class StudentController {
    private final StudentService studentService;
        @Autowired
    public StudentController(StudentService studentService)
    {
        this.studentService = studentService;
    }

    @PostMapping
    public void addStudent(@RequestBody Student student) {

      studentService.SaveStudent(student);

    }

    @GetMapping
    public List<Student> getstudents(){

       return studentService.getStudents();
    }

    @DeleteMapping(path = "{studentId}")
    public void DeleteStudent(@PathVariable("studentId") Long studentId){
    studentService.deleteStudent(studentId);

    }
    @PutMapping(path="{studentId}")
    public void UpdateStudent(@PathVariable("studentId") Long studentId,
                              @RequestParam(required = false) String name,
                              @RequestParam(required = false) String email){

            studentService.updateStudent(studentId,name,email);
    }
}
