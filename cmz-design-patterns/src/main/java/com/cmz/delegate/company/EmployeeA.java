package com.cmz.delegate.company;

public class EmployeeA implements IEmployee {
    public void doing(String command) {
        System.out.printf("我员工A，我开始做：" + command);
    }
}
