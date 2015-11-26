package model;

import java.util.Arrays;
import java.util.List;

/**
 * @author Administrator
 * @description
 *2015-5-9  下午5:07:05
 */
public class Father {
    private String name;
    private int age;
    private Person son;
    private String[] values = {"1","2","3"};
    private List<String> list = Arrays.asList(values);
    
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
    public Person getSon() {
        return son;
    }
    public void setSon(Person son) {
        this.son = son;
    }
    public List<String> getList() {
        return list;
    }
    public void setList(List<String> list) {
        this.list = list;
    }
    @Override
    public String toString() {
	return "Father [name=" + name + ", age=" + age + ", son=" + son
		+ ", values=" + Arrays.toString(values) + ", list=" + list
		+ "]";
    }
    
    
}
