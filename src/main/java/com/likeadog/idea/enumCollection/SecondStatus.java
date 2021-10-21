package com.likeadog.idea.enumCollection;

public enum SecondStatus {
    basic("기초"), //기초
    additional("추가"), //추가
    extra("보강") ;// 보강

    final private String name;

    private SecondStatus(String name) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }

    public static SecondStatus nameOf(String name) {
        for (SecondStatus status : SecondStatus.values()) {
            if (status.getName().equals(name)) {
                return status;
            }
        }
        return null;
    }

}