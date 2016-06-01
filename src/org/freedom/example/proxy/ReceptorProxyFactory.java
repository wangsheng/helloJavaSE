package org.freedom.example.proxy;

import java.lang.reflect.Proxy;

/**
 * 创建一个可以获取增强了功能之后对象的代理工厂，工厂的作用就是返回增强后的代理--proxy,他的类型应该和目标对象的接口类型相同。
 *
 * Created by wangsheng on 16/5/31.
 */
public class ReceptorProxyFactory {

    public static Object getProxy(Object target) {
        ReceptorHandler handler = new ReceptorHandler();
        handler.setTarget(target);

        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), handler);
    }
}
