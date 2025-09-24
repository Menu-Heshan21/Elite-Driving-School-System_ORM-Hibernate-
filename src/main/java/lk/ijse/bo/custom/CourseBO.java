package lk.ijse.bo.custom;

import lk.ijse.bo.SuperBo;
import lk.ijse.bo.SuperBo;
import lk.ijse.dto.CourseDTO;

import java.util.List;

public interface CourseBO extends SuperBo {
    boolean saveCourse(CourseDTO dto) throws Exception;
    boolean updateCourse(CourseDTO dto) throws Exception;
    boolean deleteCourse(int id) throws Exception;
    List<CourseDTO> getAllCourses() throws Exception;
    CourseDTO getCourse(int id) throws Exception;
}