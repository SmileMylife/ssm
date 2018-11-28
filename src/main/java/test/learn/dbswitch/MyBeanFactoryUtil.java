package test.learn.dbswitch;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;

/**
 * Created by ZhangPei on 2018/8/9.
 */
public class MyBeanFactoryUtil implements BeanFactoryAware {
    private static BeanFactory beanFactory;

    //设置spring的bean工厂
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        //此处先猜测spring在初始化此类的时候会将beanFactory传入
        System.out.println("spring传入了beanFacroty，beanFactory内容为：" + beanFactory);
        this.beanFactory = beanFactory;
    }

    //获取bean实例
    public static Object getBean(String beanName) {
        return beanFactory.getBean(beanName);
    }

}
