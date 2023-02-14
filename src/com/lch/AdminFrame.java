package com.lch;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminFrame extends JFrame implements ActionListener {
    private JButton newbtn, rebtn, seekbtn, exitbtn,delbtn;
    private JLabel welcoLab1, welcoLab2;


    public AdminFrame(String title) {
        //----------------(1)创建窗体-----------------
        //设置窗体标题
        setTitle(title);
        //居中显示
        setSize(500, 400);
        double width = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
        double height = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
        int x = (int) (width - this.getWidth()) / 2;
        int y = (int) (height - this.getHeight()) / 2;
        setLocation(x, y);
        //关闭窗体
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //设置窗体大小不可改变
        setResizable(false);
        //---------(2)创建界面元素-----------
        setLayout(null);
        welcoLab1 = new JLabel("管理员，欢迎你！");
        welcoLab2 = new JLabel("请选择功能");
        welcoLab1.setFont(new Font(null, 1, 25));
        welcoLab2.setFont(new Font(null, 1, 25));
        welcoLab1.setBounds(150, 10, 600, 30);
        welcoLab2.setBounds(175, 40, 500, 30);
        add(welcoLab1);
        add(welcoLab2);
//        newbtn = new JButton("新增");
//        seekbtn = new JButton("查询");
//        rebtn = new JButton("修改");
//        delbtn = new JButton("删除");
//        exitbtn = new JButton("退出");
//        newbtn.setBounds(130, 100, 100, 40);
//        seekbtn.setBounds(270, 100, 100, 40);
//        rebtn.setBounds(130, 160, 100, 40);
//        delbtn.setBounds(270,160,100,40);
//        exitbtn.setBounds(200, 220, 100, 40);
        newbtn = new JButton("新增");
        seekbtn = new JButton("查询");
        delbtn = new JButton("删除");
        exitbtn = new JButton("退出");
        newbtn.setBounds(60, 120, 100, 40);
        seekbtn.setBounds(200, 120, 100, 40);
        delbtn.setBounds(340,120,100,40);
        exitbtn.setBounds(200, 190, 100, 40);
        add(newbtn);
        add(seekbtn);
        add(delbtn);
        add(exitbtn);
        //-------------------(3)事件处理----------------
        //注册事件监听
        newbtn.addActionListener(this);
        seekbtn.addActionListener(this);
        delbtn.addActionListener(this);
        exitbtn.addActionListener(this);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == newbtn) {
            //关闭当前窗体进入相应的主界面
            new Admin_new("新增");
        } else if (e.getSource() == seekbtn) {
            new Admin_seek("查询");
        } else if (e.getSource() == delbtn) {
            new Admin_del("删除");
        } else {
            System.exit(0);//退出,注意该方法将退出应用程序，从JVM里退出来
        }
    }

    public static void main(String[] args) {
        AdminFrame adminFrame = new AdminFrame("管理员界面");
    }
}
