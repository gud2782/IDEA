package com.likeadog.idea.enumCollection;

public enum ThirdStatus {
    Canine_Distemper("홍역"), //홍역
    Hepatitis("간염"), //간염
    Parvovirus("파보장염"), //파보장염
    Parainfluenza("파라인플루엔자"), //파라인플루엔자
    Leptospira("렙토스피라(혼합주사)"), //렙토스피라(혼합주사)
    none("해당없음");



    final private String name;

    private ThirdStatus(String name) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }

    public static ThirdStatus nameOf(String name) {
        for (ThirdStatus status : ThirdStatus.values()) {
            if (status.getName().equals(name)) {
                return status;
            }
        }
        return null;
    }

}