package org.freedom.example.proxy;

/**
 * 创建一个接口对象,含有两个业务对象
 *
 * JDK动态代理只能代理接口类型的对象，并且返回接口类型
 *
 * Created by wangsheng on 16/5/31.
 */
public interface Receptor {
    /**
     * 光临
     */
    void welcome();

    /**
     * 离开
     */
    void bye();
}
