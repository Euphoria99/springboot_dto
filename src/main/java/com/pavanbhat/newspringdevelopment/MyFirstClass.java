package com.pavanbhat.newspringdevelopment;


public class MyFirstClass {

    private String myVar;


    public MyFirstClass(String myVar) {
        this.myVar = myVar;
    }

    public String sayHello(){
        return "Hello there!, Heres my value ==> " + myVar ;
    }
}
