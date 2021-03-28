package com.core.Constants;

public enum MonthEnum {
    JAN("january"),
    FEB("february"),
    MAR("march"),
    APR("april"),
    MAY("may"),
    JUN("june"),
    JUL("july"),
    AUG("august"),
    SEP("september"),
    OCT("october"),
    NOV("november"),
    DEC("december");


    private final String fullname;

    MonthEnum(String fullname) {
        this.fullname = fullname;
    }


    public String getFullname() {
        return fullname;
    }
}
