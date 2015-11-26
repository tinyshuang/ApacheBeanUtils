package test;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

import model.Person;
import model.PersonForm;

/**
 * @author Administrator
 * @description
 *2015-5-9  下午4:29:03
 */
public class BeanUtil {
    private static Person person = new Person("distinys", 25, 60.5);
    
    public static void main(String[] args) {
	cloneBean();
    }
    
    /**
     * @description 克隆实体类	
     *2015-5-9  下午4:34:59
     *返回类型:void
     */
    public static void cloneBean(){
	Person clone = null;
	try {
	    clone = (Person) BeanUtils.cloneBean(person);
	} catch (IllegalAccessException e) {
	    e.printStackTrace();
	} catch (InstantiationException e) {
	    e.printStackTrace();
	} catch (InvocationTargetException e) {
	    e.printStackTrace();
	} catch (NoSuchMethodException e) {
	    e.printStackTrace();
	}
	System.out.println(clone.getName());
    }
    
    /**
     * @description BeanUtils.describe(Object)将实体类转换为map
     * 不过格式是Map<String, String>这种的Map	 
     *2015-5-9  下午4:35:12
     *返回类型:void
     */
    public static void toMap(){
	try {
	    Map<String, String> map = BeanUtils.describe(person);
	    System.out.println(map.get("name"));
	    System.out.println(map.get("age"));
	} catch (IllegalAccessException e) {
	    e.printStackTrace();
	} catch (InvocationTargetException e) {
	    e.printStackTrace();
	} catch (NoSuchMethodException e) {
	    e.printStackTrace();
	}
    }
    
    
    /**
     * @description BeanUtils.populate(object, map)将属性封装到Map<String, Object> map再转换到JavaBean去	 
     *2015-5-9  下午4:39:57
     *返回类型:void
     */
    public static void mapToBean(){
	Person p = new Person();
	Map<String, Object> map = new HashMap<String, Object>();
	map.put("name", "dsitinys");
	map.put("money", 5.6);
	try {
	    BeanUtils.populate(p, map);
	} catch (IllegalAccessException e) {
	    e.printStackTrace();
	} catch (InvocationTargetException e) {
	    e.printStackTrace();
	}
	System.out.println(p.getName() + "--" + p.getAge() +"--"+ p.getMoney());
    }
    
    /**
     * @description 将一个对象的属性值copy到另外一个对象上	
     	copyProperties(dest, orig)
      	dest和orig可以不是同一个类的对象,但orig必须是dest的子集
     *2015-5-12  上午10:53:54
     *返回类型:void
     */
    public static void copyProperty(){
	Person p = new Person();
	PersonForm pf = new PersonForm("distinyss",36);
	try {
	    BeanUtils.copyProperties(p, person);
	    System.out.println(p);
	    BeanUtils.copyProperties(person, pf);
	    System.out.println(person);
	} catch (IllegalAccessException e) {
	    e.printStackTrace();
	} catch (InvocationTargetException e) {
	    e.printStackTrace();
	}
    }
    
}
