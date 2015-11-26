package test;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

import org.apache.commons.beanutils.BeanUtils;

import model.ArrayOrList;

/**
 * @author Administrator
 * @description
 *2015-5-9  下午4:46:20
 */
public class ArrayOrListUtil {
    public static void main(String[] args) {
	getArray();
    }
    
    
    /**
     * @description 从一个JavaBean中获取一个数组的	
     *2015-5-9  下午4:52:02
     *返回类型:void
     */
    public static void getArray(){
	ArrayOrList al = new ArrayOrList();
	try {
	    //以下跟直接getArray貌似没啥区别
	    String[] array = BeanUtils.getArrayProperty(al, "array");
	    System.out.println(Arrays.toString(array));
	    //可以提前到List的具体的某个的值
	    System.out.println(BeanUtils.getProperty(al, "array[1]"));
	    System.out.println(BeanUtils.getIndexedProperty(al, "array", 2));
	} catch (IllegalAccessException e) {
	    e.printStackTrace();
	} catch (InvocationTargetException e) {
	    e.printStackTrace();
	} catch (NoSuchMethodException e) {
	    e.printStackTrace();
	}
	
    }
    
    
    /**
     * @description 从一个JavaBean中获取一个List	
     *2015-5-9  下午4:52:02
     *返回类型:void
     */
    public static void getList(){
	ArrayOrList al = new ArrayOrList();
	al.add("1");
	al.add("2");
	al.add("3");
	try {
	    //以下跟直接getArray貌似没啥区别
	    String[] list = BeanUtils.getArrayProperty(al, "list");
	    System.out.println(Arrays.toString(list));
	    //可以提前到List的具体的第几个的值
	    System.out.println(BeanUtils.getProperty(al, "list[1]"));
	    System.out.println(BeanUtils.getIndexedProperty(al, "list", 2));
	} catch (IllegalAccessException e) {
	    e.printStackTrace();
	} catch (InvocationTargetException e) {
	    e.printStackTrace();
	} catch (NoSuchMethodException e) {
	    e.printStackTrace();
	}
	
    }
    
}
