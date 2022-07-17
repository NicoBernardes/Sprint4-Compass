package com.compass.sprint4.enums;

public enum CargoPoliticoEnum {
    VEREADOR ("Vereador"),
    PREFEITO ("Prefeito"),
    DEPUTADO_ESTADUAL ("Deputado Estadual"),
    DEPUTADO_FEDERAL ("Deputado Federal"),
    SENADOR ("Senador"),
    GOVERNADOR ("Governador"),
    PRESIDENTE ("Presidente"),
    NENHUM ("Nenhum");

    private String value;
    CargoPoliticoEnum(String value) {
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
