package ke.go.kra.students.Students;

import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public  void SaveStudent(Student student) {

        Optional<Student> StudentByEmail= studentRepository.findStudentbyEmail(student.getEmail());

        if(StudentByEmail.isPresent()){

            throw new IllegalStateException("Email is taken");
        }
          studentRepository.save(student);
    }


    public List<Student> getStudents() {
        /* return List.of(
                new Student(
                        1L,
                        "jamal",
                        LocalDate.of(2000,04,22),
                      "ben@ss.com"
                )
        );*/

       return studentRepository.findAll();
    }


    public void deleteStudent(Long studentId) {
        boolean exists=studentRepository.existsById(studentId);
        if(exists){
            studentRepository.deleteById(studentId);
        }
        else {
            throw new IllegalStateException("The student does not exist");
        }



    }
    @Transactional
    public void updateStudent(Long studentId, String name, String email) {
       Student student=studentRepository.findById(studentId)
               .orElseThrow(()->new IllegalStateException("Student does not exist"));

           if(name !=null && name.length()>0 && !Objects.equals(student.getName(),name) ){
               student.setName(name);
    }
           if(email !=null && email.length()>0 && !Objects.equals(student.getEmail(),email) ){
              Optional<Student> studentOptional=studentRepository.findStudentbyEmail(email);
               if(studentOptional.isPresent()){
                   throw new IllegalStateException("Email is taken");
               }
               student.setEmail(email);
           }
}
}