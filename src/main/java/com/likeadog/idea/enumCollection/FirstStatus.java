package com.likeadog.idea.enumCollection;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum FirstStatus {
    DHPPL("혼합예방주사"), //혼합예방주사
    Coronavirus("코로나바이러스성 장염"), //코로나바이러스성 장염
    Kennel_Cough("기관,기관지염"), //기관,기관지염
    Rabies("광견병"); //광견병

    final private String name;

    private FirstStatus(String name) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }

    public static FirstStatus nameOf(String name) {
        for (FirstStatus status : FirstStatus.values()) {
            if (status.getName().equals(name)) {
                return status;
            }
        }
        return null;
    }

}
