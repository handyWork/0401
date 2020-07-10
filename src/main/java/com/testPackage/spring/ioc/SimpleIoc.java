package com.testPackage.spring.ioc;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.FileInputStream;
import java.lang.reflect.Field;
import java.util.HashMap;

/**
 * 先从简单的 IOC 容器实现开始，最简单的 IOC 容器只需4步即可实现，如下：
 * <p>
 * 加载 xml 配置文件，遍历其中的标签
 * 获取标签中的 id 和 class 属性，加载 class 属性对应的类，并创建 bean
 * 遍历标签中的标签，获取属性值，并将属性值填充到 bean 中
 * 将 bean 注册到 bean 容器中
 */
public class SimpleIoc {

    private HashMap<String, Object> beanMap = new HashMap<>();


    public SimpleIoc(String location) throws Exception {
        loadBean(location);
    }

    public Object getBean(String beanName) {
        Object bean = beanMap.get(beanName);
        if (bean == null) {
            throw new IllegalArgumentException("there is no bean with name " + beanName);
        }
        return bean;
    }


    private void loadBean(String location) throws Exception {

        // 加载xml配置文件

        FileInputStream fileInputStream = new FileInputStream(location);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = factory.newDocumentBuilder();
        Document doc = docBuilder.parse(fileInputStream);
        Element root = doc.getDocumentElement();
        NodeList nodes = root.getChildNodes();

        // 遍历bean标签
        for (int i = 0; i < nodes.getLength(); i++) {
            Node node = nodes.item(i);
            if (node instanceof Element) {
                Element ele = (Element) node;
                String id = ele.getAttribute("id");
                String className = ele.getAttribute("class");
                // 加载bean Class
                Class beanClass = null;
                try {
                    beanClass = Class.forName(className);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                    return;
                }
                // 创建bean
                Object bean = beanClass.newInstance();

                // 遍历 <property> 标签
                NodeList propertyNodes = ele.getElementsByTagName("property");
                for (int j = 0; j < propertyNodes.getLength(); j++) {
                    Node propertyNode = propertyNodes.item(j);
                    if (propertyNode instanceof Element) {
                        Element propertyElement = (Element) propertyNode;
                        String name = propertyElement.getAttribute("name");
                        String value = propertyElement.getAttribute("value");

                        // 利用反射将 bean 相关字段访问权限设为可访问
                        Field declaredField = bean.getClass().getDeclaredField(name);
                        declaredField.setAccessible(true);

                        if (value != null && value.length() > 0) {
                            declaredField.set(bean, value);
                        } else {
                            String ref = propertyElement.getAttribute("ref");
                            if (ref == null || ref.length() == 0) {
                                throw new IllegalArgumentException("ref config error");
                            }
                            // 将引用填充到相关字段中
                            declaredField.set(bean, getBean(ref));
                        }
                        // 将 bean 注册到 bean 容器中
                        registerBean(id, bean);
                    }
                }

            }

        }


    }

    /**
     * 注册bean
     *
     * @param id
     * @param bean
     */
    private void registerBean(String id, Object bean) {
        beanMap.put(id, bean);
    }


}
