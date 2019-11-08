package com.cmz.delegate.company;

import java.util.HashMap;
import java.util.Map;

public class Leader implements IEmployee {

    // 经理有一个登记表，记录对员工擅长东西的了解
    private Map<String, IEmployee> register = new HashMap<String, IEmployee>();

    // 经理被任命就开始构造登记表，后面要干活儿的时候就查登记表(这个表就是经理用来做管理用的)
    public Leader(){
        register.put("业务", new EmployeeA());
        register.put("架构", new EmployeeB());
    }

    // 项目经理自己不干活，自己根据对手下人员的了解，分配任务(代码实现就是查登记表)
    public void doing(String command) {
        register.get(command).doing(command);
    }
}
