package test;

import java.lang.reflect.InvocationTargetException;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.PropertyUtils;

import model.Father;
import model.Person;

/**
 * @author Administrator
 * @description
 *2015-5-9  下午3:38:21
 */
public class PropertyUtil {
    public static void main(String[] args)  {
	setNestProperty();
    }
    
    
    /**
     * @description 取得JavaBean的相关属性的值
     * 但是属性返回来的都是String	
     *2015-5-9  下午4:17:25
     *返回类型:void
     */
    public static void getProperty() {
	Person person = new Person("distinys",20,5.2);
	String name=null,age=null,money=null;
	try {
	    //获取各个属性的值,但是返回的都是String
	    name = BeanUtils.getProperty(person, "name");
	    age  = BeanUtils.getProperty(person, "age");
	    money = BeanUtils.getProperty(person, "money");
	    String sname =(String) PropertyUtils.getSimpleProperty(person, "name");
	    System.out.println("使用PropertyUtils的getSimpleProperty()取值 : " + sname);
	    System.out.println(name + "--" + age + "--" + money);
	} catch (IllegalAccessException e) {
	    e.printStackTrace();
	} catch (InvocationTargetException e) {
	    e.printStackTrace();
	} catch (NoSuchMethodException e) {
	    e.printStackTrace();
	}
    }
    
    
    /**
     * @description 给JavaBean设置值	
     *2015-5-9  下午4:17:04
     *返回类型:void
     */
    public static void setProperty(){
	Person person = new Person();
	try {
	    //设置bean的属性值
	    BeanUtils.setProperty(person, "name", "distinys");
	    BeanUtils.setProperty(person, "age", 12);
	    PropertyUtils.setSimpleProperty(person, "money", 10.5);
	} catch (IllegalAccessException e) {
	    e.printStackTrace();
	} catch (InvocationTargetException e) {
	    e.printStackTrace();
	} catch (NoSuchMethodException e) {
	    e.printStackTrace();
	}
	System.out.println(person.getName() + "--" + person.getAge() + "--" + person.getMoney());
    }
    
    
    /**
     * @description 使用PropertyUtils.getIndexedProperty(bean, name, index)的方法
     * 注意  : 
     	name方法必须是get开头的..
	index必须是int类型的
     * 	
     *2015-5-13  下午12:44:51
     *返回类型:void
     */
    public static void getIndexProperty(){
	Person person = new Person();
	try {
	    Person p = (Person) PropertyUtils.getIndexedProperty(person, "index", 10);
	    
	    System.out.println(p);
	} catch (IllegalAccessException e) {
	    e.printStackTrace();
	} catch (InvocationTargetException e) {
	    e.printStackTrace();
	} catch (NoSuchMethodException e) {
	    e.printStackTrace();
	}
    }
    
    
    /**
     * @description 使用PropertyUtils.getNestedProperty(bean, name)获取内嵌属性的值
      	 bean是整个的对象
         name是属性值..这里用"."号来区分嵌套  
     *2015-5-13  下午2:33:51
     *返回类型:void
     */
    public static void getNestProperty(){
	Father father = new Father();
	Person son = new Person("distinyss", 12, 20);
	father.setSon(son);
	try {
	    String name = (String) PropertyUtils.getNestedProperty(father, "son.name");
	    System.out.println(name);
	} catch (IllegalAccessException e) {
	    e.printStackTrace();
	} catch (InvocationTargetException e) {
	    e.printStackTrace();
	} catch (NoSuchMethodException e) {
	    e.printStackTrace();
	}
    }
    
    
    /**
     * @description PropertyUtils.setNestedProperty(bean, name, value)设置嵌套的属性
       name用"."号来区分嵌套类,比如:son.name表示son属性对象的name属性
     *2015-5-13  下午2:48:09
     *返回类型:void
     */
    public static void setNestProperty(){
	Father father = new Father();
	Person son = new Person("distinyss", 12, 20);
	father.setSon(son);
	try {
	    PropertyUtils.setNestedProperty(father, "son.name", "dis");
	} catch (IllegalAccessException e) {
	    e.printStackTrace();
	} catch (InvocationTargetException e) {
	    e.printStackTrace();
	} catch (NoSuchMethodException e) {
	    e.printStackTrace();
	}
	System.out.println(father.getSon().getName());
    }
    
    /**
     * @description 使用BeanUtils.getNestedProperty(bean,name)获取嵌套在JavaBean中的JavaBean的属性值	
     *2015-5-9  下午5:15:13
     *返回类型:void
     */
    public static void getBNestProperty(){
	Father father = new Father();
	father.setName("distinys");
	father.setAge(25);
	Person person = new Person();
	person.setName("distinyss");
	father.setSon(person);
	try {
	    //以下son的名字是其属性的名字
	    String name = BeanUtils.getNestedProperty(father, "son.name");
	    //其实内嵌的不一定需要使用getNestedProperty方法
	    String name2 = BeanUtils.getProperty(father, "son.name");
	    //可以使用序号的方式来操作list和Map等
	    System.out.println(BeanUtils.getProperty(father, "list[1]"));
	    System.out.println(name);
	    System.out.println(name2);
	} catch (IllegalAccessException e) {
	    e.printStackTrace();
	} catch (InvocationTargetException e) {
	    e.printStackTrace();
	} catch (NoSuchMethodException e) {
	    e.printStackTrace();
	}
    }
    
}
