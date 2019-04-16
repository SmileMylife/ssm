package com.store.utils;

import com.store.common.OutputObject;
import org.springframework.beans.BeanUtils;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ZhangPei on 2019/4/16.
 */
public class DeepCloneUtil {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Person person = new Person();
        person.setName("张佩");
        person.setAge("22");
        //测试序列化对象
        objSerializeable(person);

        Object o = objReSerializalbe("/Users/smile_mylife/Desktop/test.txt");

        if (o instanceof Person) {
            Person result = (Person) o;
            System.out.println(result.toString());
        }

        //测试深度克隆
        OutputObject outputObject = new OutputObject();
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("provCode", "00030016");
        map.put("tenantId", "100000");
        outputObject.setBean(map);

        Object out = deepClone(outputObject);

        OutputObject output = null;
        if (out instanceof OutputObject) {
            output = (OutputObject) out;
            System.out.println(output.toString());
        }

        output.getBean().put("provCode", "00030023");

        System.out.println(outputObject.getBean() == output.getBean());

        //测试浅克隆
        /*OutputObject outputObject = new OutputObject();
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("provCode", "00030016");
        map.put("tenantId", "100000");
        outputObject.setBean(map);

        OutputObject targetOutput = new OutputObject();

        BeanUtils.copyProperties(outputObject, targetOutput);

        targetOutput.getBean().put("provCode", "00030026");

        System.out.println(targetOutput.getBean() == outputObject.getBean());*/
    }


    /**
     * 深度克隆工具
     * @param sourceObj
     * @return
     */
    public static Object deepClone(Object sourceObj) throws IOException, ClassNotFoundException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();      //此处因为无需序列化到硬盘文件中，所以采用二进制数组进行存储
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);  //创建对象输出流，用于进行对象序列化操作
        objectOutputStream.writeObject(sourceObj);      //将对象序列化值二进制数组中

        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());  //将二进制数组中的对象详细读取至二进制数组流中
        ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);      //创建对象信息输入流，进行读取对象信息

        Object object = objectInputStream.readObject();     //读取对象信息
        return object;
    }

    /**
     * 对象的序列化
     * 如何将person对象序列化到硬盘
     */
    public static void objSerializeable(Object obj) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("/Users/smile_mylife/Desktop/test.txt"));
        objectOutputStream.writeObject(obj);
    }

    /**
     * 对象反序列化
     * 如何将对象从硬盘中读取到内存
     */
    public static Object objReSerializalbe(String filePath) throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filePath));
        Object object = objectInputStream.readObject();
        return object;

    }
}





class Person implements Serializable {
    private String name;
    private String age;
    private Map<String, Object> map;

    public Map<String, Object> getMap() {
        return map;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", map=" + map +
                '}';
    }
}
