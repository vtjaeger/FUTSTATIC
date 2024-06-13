package com.br.futstatic.models;

public enum Stadium {
    MARACANA("Maracanã"),
    ALLIANZ_ARENA("Allianz Arena"),
    WEMBLEY("Wembley Stadium"),
    CAMP_NOU("Camp Nou");
    private final String displayName;

    Stadium(String displayName) {
        this.displayName = displayName;
    }

}