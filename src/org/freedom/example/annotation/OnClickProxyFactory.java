package org.freedom.example.annotation;

import java.awt.event.ActionListener;
import java.lang.reflect.*;

/**
 * OnClick注解工厂
 *
 * Created by wangsheng on 16/5/31.
 */
public class OnClickProxyFactory {

    /**
     * 处理OnClick注解
     *
     * @param target 包含OnClick注解的目标对象
     */
    public static void handleOnClickAnnotation(Object target) {
        try {
            Class<?> clsTarget = target.getClass();
            // 检索目标对象的所有方法, 如果含有OnClick注解, 则为注解中声明的属性对象动态添加AddActionListener方法
            for (Method method : clsTarget.getDeclaredMethods()) {
                OnClick onClickAnnotation = method.getAnnotation(OnClick.class);
                if (onClickAnnotation != null) {
                    Field field = clsTarget.getDeclaredField(onClickAnnotation.value());
                    field.setAccessible(true);
                    autoAddActionlistener(field.get(target), getActionListenerProxy(target, method));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 为目标对象添加addActionListener方法, 该方法的参数ActionListener为ActionListener代理对象
     * @param target 被添加ActionListener方法的事件源对象
     * @param actionListenerProxy ActionListener代理对象
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    private static void autoAddActionlistener(Object target, Object actionListenerProxy) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        // 获取JButton的addActionListener方法对象
        Method methodAddActionListener = target.getClass().getMethod("addActionListener", ActionListener.class);
        // 为JButton对象添加addActionListener方法
        methodAddActionListener.invoke(target, actionListenerProxy);
    }

    /**
     * 获取ActionListener的代理对象
     * @param target 指定的代理对象
     * @param targetMethod 指定的代理对象的方法
     * @return
     */
    public static Object getActionListenerProxy(final Object target, final Method targetMethod) {
        InvocationHandler handler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                return targetMethod.invoke(target);
            }
        };
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), new Class[] {ActionListener.class}, handler);
    }
}
