package org.freedom.example.proxy;

/**
 * 测试代理
 *
 * Created by wangsheng on 16/5/31.
 */
public class TestProxy {

    public static void main(String[] args) {
        Waiter target = new Waiter();
        Receptor receptor = (Receptor) ReceptorProxyFactory.getProxy(target);
        receptor.welcome();
        receptor.bye();
    }
}
