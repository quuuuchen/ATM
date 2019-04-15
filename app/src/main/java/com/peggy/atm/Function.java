package com.peggy.atm;
//儲存單筆資料的類別

public class Function {
    String name; //功能名稱

    public Function() {
    }

    public Function(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
