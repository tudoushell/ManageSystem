package beanfactory;

import dao.DeptDao;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 对象工厂
 */
public class BeanFactory {
    static Map<String,Object> map = new HashMap<>();
    static {
        SAXReader reader = new SAXReader();
        try{
            Document doc = reader.read(BeanFactory.class.getClassLoader().getResourceAsStream("config.xml"));
            List<Element> list = doc.getRootElement().elements("bean");
            for (Element bean : list){
                String key = bean.attributeValue("key");
                String path = bean.attributeValue("value");
                Object o = Class.forName(path).newInstance();
                map.put(key.toLowerCase().trim(),o);
            }

        }catch (Exception e){
            e.getStackTrace();
        }
    }

    public static void setField(Element bean, Object o) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        //获取实体bean中所有要设置的字段信息
        List<Element> lsField = bean.elements("property");
        for(Element field : lsField){
            String name = field.attributeValue("name");
            String ref = field.attributeValue("ref");
            //获取已实例化的对象
            Object fieldObject = map.get(ref.toLowerCase().trim());
            //拼方法名
            String methodName = "set" + Character.toUpperCase(name.charAt(0)) + name.substring(1);
            //参数类型
            Class[] par = fieldObject.getClass().getInterfaces();
            //获得方法对象
            Method method = o.getClass().getDeclaredMethod(methodName,par);
            method.invoke(o,fieldObject);
        }
    }

    public static Object getObject(String name){
        name = name.toString().trim();
        return  map.get(name);
    }
    public static void main(String[] args){
        System.out.println(BeanFactory.getObject("permissionsservice"));
    }
}
