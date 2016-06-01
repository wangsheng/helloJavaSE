package org.freedom.example.proxy;

/**
 * 创建服务生对象,实现 Receptor 接口
 *
 * Created by wangsheng on 16/5/31.
 */
public class Waiter implements Receptor{
    @Override
    public void welcome() {
        System.out.println("欢迎光临!");
    }

    @Override
    public void bye() {
        System.out.println("谢谢惠顾!");
    }
}
