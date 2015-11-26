package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.beanutils.BeanComparator;

import model.Person;

/**
 * @author Administrator
 * @description
 *2015-5-13  下午4:29:55
 */
public class BeanComparatorUtil {
    public static void main(String[] args) {
	sort();
    }
    
    public static void sort(){
	Person person1 = new Person("distinys1", 26,10);
	Person person2 = new Person("distinys2", 25,11);
	Person person3 = new Person("distinys3", 27,12);
	List<Person> list = new ArrayList<Person>();
	list.add(person1);
	list.add(person2);
	list.add(person3);
	Collections.sort(list, new BeanComparator<Person>("age"));
	System.out.println(list);
    }
}
