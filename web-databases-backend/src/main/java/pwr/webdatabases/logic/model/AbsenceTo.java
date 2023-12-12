package pwr.webdatabases.logic.model;

import java.time.LocalDate;

public class AbsenceTo extends AbstractTo {

    private LocalDate date;

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
