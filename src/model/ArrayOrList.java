package model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 * @description
 *2015-5-9  下午4:43:58
 */
public class ArrayOrList {
    private List<String> list = new ArrayList<String>();
    private final String[]  array = {"one","two","three"};
    
    
    
    public boolean add(String value){
	return list.add(value);
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public  String[] getArray() {
        return array;
    }
    
}
