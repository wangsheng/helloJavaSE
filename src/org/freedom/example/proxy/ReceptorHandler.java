package org.freedom.example.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 创建一个可以使用公用代码对象的对象，这个对象可以对要被处理的目标对象实施方法拦截，执行公用代码对象中的方法
 *
 * Created by wangsheng on 16/5/31.
 */
public class ReceptorHandler implements InvocationHandler {

    private Object target; //哪个对象要被增强

    private PoliteWords interceptor = new PoliteWords(); //增强目标对象所用的对象

    public void setTarget(Object target) {
        this.target = target;
    }

    /**
     * 重写invoke方法,从而达到增强目标对象的目的
     *
     * @param proxy 增强后的对象
     * @param method 目标对象上正在被调用的方法
     * @param args 目标对象上正在被调用的方法所传递的参数
     * @return 目标对象正在被调用的方法执行的结果
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result;
        if (method.getName().equals("welcome")) {// welcome之前sayHello
            interceptor.sayHello();
            result = method.invoke(target, args);
        } else if (method.getName().equals("bye")) {// bye之后sayHappy
            result = method.invoke(target, args);
            interceptor.sayHappy();
        } else {
            result = method.invoke(target, args);
        }
        return result;
    }
}
