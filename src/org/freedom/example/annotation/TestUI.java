package org.freedom.example.annotation;

import javax.swing.*;
import java.awt.*;

/**
 * Created by wangsheng on 16/5/31.
 */
public class TestUI {
    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {

                UI frame = new UI();
                frame.setTitle("OnClick Annotation Test");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}
