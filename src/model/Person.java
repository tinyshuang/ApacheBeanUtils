package model;

/**
 * @author Administrator
 * @description
 *2015-5-9  下午3:34:39
 */
public class Person {
    private String name;
    private int age;
    private double money;
    
    
    
    public Person(String name, int age,double money) {
	this.name = name;
	this.age = age;
	this.money = money;
    }
    
    
    public Person() {}

    

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
    public double getMoney() {
        return money;
    }
    
    public void setMoney(double money) {
        this.money = money;
    }
    
    public Person getIndex(int index){
	System.out.println(index);
	return new Person("index", index, index*2);
    }
    
    @Override
    public String toString() {
	return "Person [name=" + name + ", age=" + age + ", money=" + money
		+ "]";
    }
    
}
