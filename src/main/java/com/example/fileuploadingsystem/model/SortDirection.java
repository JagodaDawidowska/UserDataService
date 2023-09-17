package com.example.fileuploadingsystem.model;

public enum SortDirection {

    ASC("ASC"),
    DSC("DSC");

    private final String value;

    SortDirection (String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
