package com.kevin.mem.mng.log;

import java.lang.annotation.*;

/**
 * @Author 丁海峰
 * @DateTime 2018/11/11 20:46
 * @Description
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@Documented
public @interface OperatorLog {
    /**
     * 日志方法描述
     *
     * @return
     */
    String description() default "";

}

