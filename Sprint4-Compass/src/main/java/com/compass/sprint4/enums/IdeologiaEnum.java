package com.compass.sprint4.enums;

public enum IdeologiaEnum {
    DIREITA ("Direita"),
    CENTRO ("Centro"),
    ESQUERDA ("Esquerda");

    private String value;
    IdeologiaEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }
}
