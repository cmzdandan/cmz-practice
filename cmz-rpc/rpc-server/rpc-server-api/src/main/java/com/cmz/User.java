package com.cmz;

/**
 * @author chen.mz
 * @email 1034667543@qq.com
 * @create 2019年6月9日 下午10:44:36
 * @description User实体类
 */
public class User {

	private String name;

	private int age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "User{" + "name='" + name + '\'' + ", age=" + age + '}';
	}

}
