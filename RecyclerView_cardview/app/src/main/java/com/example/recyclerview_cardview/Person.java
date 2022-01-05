package com.example.recyclerview_cardview;

public class Person {
    //Person 클래스 정의하기
    //어댑터를 만들기 전에 어댑터 안에 들어갈 각 아이템의 데이터를 담아둘 클래스를 정의

    String name;
    String mobile;


    //생성자 함수를 통해 각 데이터를 입력받으며 각 멤버 변수에 대한 getter/setter 함수를 구현한 형태
    public Person(String name, String mobile) { //생성자
        this.name = name;
        this.mobile = mobile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
