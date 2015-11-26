package model;

/**
 * @author Administrator
 * @description
 *2015-5-9  下午3:34:39
 */
public class PersonForm {
    private String name;
    private int age;
    
    
    public PersonForm() {}

    public PersonForm(String name, int age) {
	this.name = name;
	this.age = age;
    }



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
	return "PersonForm [name=" + name + ", age=" + age + "]";
    }
    
}
