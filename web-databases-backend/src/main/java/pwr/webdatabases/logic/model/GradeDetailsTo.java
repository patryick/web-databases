package pwr.webdatabases.logic.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import pwr.webdatabases.data.enums.GradeValueEnum;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class GradeDetailsTo extends AbstractTo {

    private Integer gradeValue;
    @JsonFormat(pattern = "MM/dd/yyyy")
    private LocalDate date;
    private String details;

    public Integer getGradeValue() {
        return gradeValue;
    }

    public void setGradeValue(Integer gradeValue) {
        this.gradeValue = gradeValue;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
