package com.likeadog.idea.enumCollection;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum BloodStatus {
    Blooding("헌혈완료"),
    complete("완료");



    final private String name;

    private BloodStatus(String name) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }

    public static BloodStatus nameOf(String name) {
        for (BloodStatus status : BloodStatus.values()) {
            if (status.getName().equals(name)) {
                return status;
            }
        }
        return null;
    }
}
