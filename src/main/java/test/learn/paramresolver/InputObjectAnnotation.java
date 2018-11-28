package test.learn.paramresolver;

import java.lang.annotation.*;

/**
 * Created by ZhangPei on 2018/9/27.
 */
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface InputObjectAnnotation {

}
