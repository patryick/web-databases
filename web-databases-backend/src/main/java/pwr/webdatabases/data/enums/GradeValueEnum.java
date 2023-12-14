package pwr.webdatabases.data.enums;

public enum GradeValueEnum {
    ONE(1),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6);

    private final Integer value;

     GradeValueEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static GradeValueEnum of(int grade) {
        switch(grade) {
            case 1 -> {return ONE;}
            case 2 -> {return TWO;}
            case 3 -> {return THREE;}
            case 4 -> {return FOUR;}
            case 5 -> {return FIVE;}
            case 6 -> {return SIX;}
            default -> throw new IllegalArgumentException(grade + "value not allowed");
        }
    }
}
