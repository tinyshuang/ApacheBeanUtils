package test;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.beanutils.DynaBean;
import org.apache.commons.beanutils.LazyDynaBean;
import org.apache.commons.beanutils.LazyDynaMap;

/**
 * @author Administrator
 * @description
 *2015-5-13  下午3:09:02
 */
public class LazyUtil {
    public static void main(String[] args) {
	map();
    }
    
    /**
     * @description 一个懒加载的键值对	
     *2015-5-13  下午3:04:01
     *返回类型:void
     */
    public static void bean(){
	DynaBean dynaBean = new LazyDynaBean();
	dynaBean.set("first", "1");			//simple
	dynaBean.set("num", "second", "2");		//map
	dynaBean.set("num", "third", "3");		//map
	dynaBean.set("name", 0, "one");			//indexed
	dynaBean.set("name", 1, "two");			//indexed
	System.out.println("正常的键值对  : " + dynaBean.get("first"));
	System.out.println("键值对中的键值对 : " + dynaBean.get("num", "second"));
	System.out.println("键值对中的有序数组 : " + dynaBean.get("name", 1));
    }
    
    
    /**
     * @description LazyDynaMap懒加载的Map..
     	使用getMap()可以将LazyDynaMap对象转换为键值对的Map
     	使用new LazyDynaMap(Map<String,Object>)普通Map转换为懒加载的Map
     *2015-5-13  下午3:50:20
     *返回类型:void
     */
    public static void map(){
	LazyDynaMap dynaBean = new LazyDynaMap();
	dynaBean.set("first", "1");			//simple
	dynaBean.set("num", "second", "2");		//map
	dynaBean.set("num", "third", "3");		//map
	dynaBean.set("name", 0, "one");			//indexed
	dynaBean.set("name", 1, "two");			//indexed
	System.out.println("----将懒加载的Map向上转换为Map----");
	Map<String, Object> map = dynaBean.getMap();
	for(Iterator<Entry<String, Object>> it = map.entrySet().iterator();it.hasNext();){
  	     System.out.println(it.next());       
  	}
	System.out.println("将普通的Map<String,Object>通过构造方法的方式转换为LazyDynaMap");
	DynaBean db = new LazyDynaMap(map);
	System.out.println(db.get("first"));
    }
}
;