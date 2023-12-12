package pwr.webdatabases.logic.model;

import pwr.webdatabases.data.enums.GradeValueEnum;

import java.time.LocalDateTime;

public class GradeTo extends AbstractTo {

    private GradeValueEnum gradeValue;
    private LocalDateTime date;
    private String details;

    public GradeValueEnum getGradeValue() {
        return gradeValue;
    }

    public void setGradeValue(GradeValueEnum gradeValue) {
        this.gradeValue = gradeValue;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
