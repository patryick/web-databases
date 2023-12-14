package pwr.webdatabases.logic.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public class AbsenceDetailsTo extends AbstractTo {

    @JsonFormat(pattern = "mm/dd/yyyy")
    private LocalDate date;

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
