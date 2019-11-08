package com.cmz.delegate.company;

public class EmployeeB implements IEmployee {
    public void doing(String command) {

        System.out.printf("我是员工B，我开始做：" + command);
    }
}
