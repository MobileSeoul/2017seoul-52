package com.example.jsbw2.homewoor;

/**
 * 한아이템에 필요한 데이터는 객체로 만들어둠
 *
 */

public class StudentItem {
    String name;
    String tel;
    String classNum;


    public StudentItem(String name, String tel, String classNum) {
        this.name = name;
        this.tel = tel;
        this.classNum = classNum;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getClassNum() {
        return classNum;
    }

    public void setClassNum(String classNum) {
        this.classNum = classNum;
    }


}
