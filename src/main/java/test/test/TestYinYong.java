package test.test;

/**
 * Created by ZhangPei on 2018/8/21.
 */
public class TestYinYong {
    public static void main(String[] args) {
        Person person = new Person();
        test(person);
        System.out.println(person.getUsername());       //测试结果为zhangpei
    }

    public static void test(Person person) {
        person.setUsername("zhangpei");
        person = new Person();
        person.setUsername("zhangxu");
    }

}

class Person {
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
