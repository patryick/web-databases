package pwr.webdatabases.logic.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import pwr.webdatabases.data.enums.GradeValueEnum;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class GradeDetailsTo extends AbstractTo {

    private int gradeValue;
    @JsonFormat(pattern = "MM/dd/yyyy")
    private LocalDate date;
    private String details;

    public GradeValueEnum getGradeValue() {
        return GradeValueEnum.of(gradeValue);
    }

    public void setGradeValue(GradeValueEnum gradeValue) {
        this.gradeValue = gradeValue.getValue();
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
