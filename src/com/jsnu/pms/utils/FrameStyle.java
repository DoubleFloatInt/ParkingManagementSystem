
package com.jsnu.pms.utils;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.plaf.FontUIResource;
import java.awt.*;
import java.io.IOException;
import java.util.Enumeration;

/*
 * @Author 周星晨
 * @Date 2020/4/21 17:42
 */

public class FrameStyle {
    public static void InitGlobalFont(Font font) {
        FontUIResource fontRes = new FontUIResource(font);
        for (Enumeration<Object> keys = UIManager.getDefaults().keys(); keys.hasMoreElements(); ) {
            Object key = keys.nextElement();
            Object value = UIManager.get(key);
            if (value instanceof FontUIResource) {
                UIManager.put(key, fontRes);
            }
        }
    }
    public static void Regular(JLabel jl){
        jl.setFont(new Font("宋体", Font.BOLD, 10));
        jl.setForeground(Color.LIGHT_GRAY);
    }

    public static void ErrorRegular(JLabel jl){
        jl.setFont(new Font("宋体", Font.BOLD, 10));
        jl.setForeground(Color.red);
    }




}