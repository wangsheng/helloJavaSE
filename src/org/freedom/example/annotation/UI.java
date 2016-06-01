package org.freedom.example.annotation;

import javax.swing.*;
import java.awt.*;

/**
 * 界面中包含三个按钮:btnBlue, btnRed, btnSayHello
 *
 * 三个按钮对象并没有通过传统的 link{@javax.swing.JButton#addActionListener(ActionListener)}方法添加事件处理类,
 * 而是通过 link{@org.freedom.example.annotation.OnClick} 注解自动绑定了含有注解的方法作为按钮点击的处理方法。
 * 从而分别实现:
 * <ul>
 *     <li>点点击btnBlue改变背景为蓝色</li>
 *     <li>点击btnRed改变背景为红色</li>
 *     <li>点击btnSayHello弹出Hello World的对话框</li>
 * </ul>
 *
 * Created by wangsheng on 16/5/31.
 */
public class UI extends JFrame{
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 200;

    private JPanel panel;
    private JButton btnBlue;
    private JButton btnRed;
    private JButton btnSayHello;

    public UI() {
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

        panel = new JPanel();
        add(panel);

        btnBlue = new JButton("Blue");
        btnRed = new JButton("Red");
        btnSayHello = new JButton("Say Hello");

        panel.add(btnBlue);
        panel.add(btnRed);
        panel.add(btnSayHello);

        // 通过OnClickProxyFactory工厂来处理OnClick注解
        OnClickProxyFactory.handleOnClickAnnotation(this);
    }

    @OnClick("btnBlue")
    public void setBlueBackground() {
        panel.setBackground(Color.BLUE);
    }

    @OnClick("btnRed")
    public void setRedBackground() {
        panel.setBackground(Color.RED);
    }

    @OnClick("btnSayHello")
    public void sayHello() {
        JOptionPane.showConfirmDialog(null, "Hello World!", "Tips", JOptionPane.YES_OPTION);
    }
}
