package mvc;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用于解析mvc.xml
 */
public class ActionConfigUtil {
    static Map<String,ActionConfig> map = new HashMap<>();
    static {
        SAXReader reader = new SAXReader();
        try {
            Document document = reader.read(ActionConfigUtil.class.getClassLoader().getResourceAsStream("mvc.xml"));
            System.out.println(document);
            List<Element> list = document.getRootElement().elements("action");
            for(Element action : list){
                ActionConfig actionConfig = new ActionConfig();
                actionConfig.setName(action.attributeValue("name"));
                actionConfig.setClassName(action.attributeValue("class"));
                actionConfig.setMethod(action.attributeValue("method"));
                setField(action,actionConfig);
                map.put(actionConfig.getName(),actionConfig);
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
    public static void setField(Element action , ActionConfig actionConfig){
        List<Element> listField = action.elements("result");
        Map<String,ResultConfig> map = new HashMap<>();
        for(Element result : listField){
            ResultConfig resultConfig = new ResultConfig();
            resultConfig.setName(result.attributeValue("name"));
            resultConfig.setType(result.attributeValue("type"));
            resultConfig.setPath(result.getText());
            map.put(resultConfig.getName(),resultConfig);
        }
        actionConfig.setResultConfigMap(map);
    }

    public static ActionConfig getActionConfig(String name){
        return map.get(name);
    }

    public static void main(String[] args) {
       ActionConfig str = ActionConfigUtil.getActionConfig("list.do");
        System.out.println(str.getResultConfigMap().get("success"));
    }
}
