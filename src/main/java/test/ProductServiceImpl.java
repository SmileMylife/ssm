package test;

import org.springframework.stereotype.Component;

/**
 * Created by ZhangPei on 2018/5/11.
 */
@Component
public class ProductServiceImpl implements ProductService {
    @Override
    public String haha(String str) {
        System.out.println("跑步");
        return "跑步";
    }

    @Override
    public void hehe() {
        System.out.println("睡觉");
    }
}
