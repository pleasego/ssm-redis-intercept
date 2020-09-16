package com.xtkj.utilsTool;

public enum LoadEnum {

    USER("com.xtkj.pojo.User"),
    ROLE("com.xtkj.pojo.Role"),
    POWER("com.xtkj.pojo.Power");

    private String clazz;

    public String getClazz(){
        return clazz;
    }

     LoadEnum(String clazz){
        this.clazz = clazz;
    }



}
