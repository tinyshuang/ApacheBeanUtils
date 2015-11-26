package test;

import org.apache.commons.beanutils.ConvertUtils;

/**
 * @author Administrator
 * @description
 *2015-5-12  上午11:26:18
 */
public class ConvertUtil {
    public static void main(String[] args) {
	convert();
    }
    
    
    /**
     * @description 使用转换器来转换字符串	
     *2015-5-12  上午11:29:45
     *返回类型:void
     */
    public static void convert(){
	int value = (int) ConvertUtils.convert("12", int.class);
	System.out.println(value);
    }
}
