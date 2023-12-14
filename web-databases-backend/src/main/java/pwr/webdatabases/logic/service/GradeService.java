package pwr.webdatabases.logic.service;

import pwr.webdatabases.logic.model.GradeDetailsTo;
import pwr.webdatabases.logic.model.GradeTo;
import pwr.webdatabases.logic.model.StudentGradeTo;

import java.util.List;

public interface GradeService {

    List<StudentGradeTo> findAllGradesByStudentId(Long studentId);
    GradeDetailsTo saveGrade(GradeTo grade);
    GradeDetailsTo updateGrade(GradeTo grade, Long gradeId);
    void deleteGrade(Long id);
}
