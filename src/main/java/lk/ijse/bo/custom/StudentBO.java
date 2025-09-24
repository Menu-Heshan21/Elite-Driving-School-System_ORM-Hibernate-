package lk.ijse.bo.custom;


import lk.ijse.dto.StudentDTO;

import java.util.List;
import java.util.Map;

public interface StudentBO extends lk.ijse.bo.SuperBo {
    boolean saveStudent(StudentDTO dto) throws Exception;
    boolean updateStudent(StudentDTO dto) throws Exception;
    boolean deleteStudent(int id) throws Exception;
    List<StudentDTO> getAllStudents() throws Exception;
    StudentDTO getStudent(int id) throws Exception;
    List<String> getAllStudentIds() throws Exception;
    List<StudentDTO> getStudentsRegisteredInAllCourses() throws Exception;
    Map<StudentDTO, List<String>> getStudentsWithCourses() throws Exception;
}