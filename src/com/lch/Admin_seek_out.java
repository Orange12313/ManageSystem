package com.lch;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Admin_seek_out extends JFrame implements ActionListener {
    Connect connect = new Connect();
    private JLabel snamelab, snamelabout, snolab, snolabout, birthlab, birthlabout, sexlab, sexlabout, colllab, colllabout,
            deptlab, deptlabout, classlab, classlabout, addlab, addlabout, numberlab, numberlabout;
    private JButton clobtn;

    public Admin_seek_out(String title,String Sno) {
        setTitle(title);

        //居中显示
        setSize(600, 500);
        double width = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
        double height = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
        int x = (int) (width - this.getWidth()) / 2;
        int y = (int) (height - this.getHeight()) / 2;
        setLocation(x, y);
        //关闭窗体
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //设置窗体大小不可改变
        setResizable(false);

        try {
            seek se = new seek(Sno);
            snamelab = new JLabel("姓名");
            snolab = new JLabel("学号");
            birthlab = new JLabel("生日");
            sexlab = new JLabel("性别");
            colllab = new JLabel("学院");
            deptlab = new JLabel("专业");
            classlab = new JLabel("班级");
            addlab = new JLabel("地址");
            numberlab = new JLabel("电话");
            snamelabout = new JLabel(se.getsname);
            snolabout = new JLabel(se.getsno);
            birthlabout = new JLabel(se.getyear+"."+se.getmonth+"."+se.getday);
            sexlabout = new JLabel(se.getsex);
            colllabout = new JLabel(se.getcoll);
            deptlabout = new JLabel(se.getdept);
            classlabout = new JLabel(se.getclass);
            addlabout = new JLabel(se.getadd);
            numberlabout = new JLabel(se.getnum);
        } catch (Exception e) {
            e.printStackTrace();
        }

        clobtn = new JButton("关闭");
        add(snamelab);
        add(snamelabout);
        snamelab.setBounds(50, 25, 50, 25);
        snamelabout.setBounds(100, 25, 150, 25);
        add(snolab);
        add(snolabout);
        snolab.setBounds(300, 25, 50, 25);
        snolabout.setBounds(350, 25, 150, 25);
        add(birthlab);
        add(birthlabout);
        birthlab.setBounds(170, 75, 40, 25);
        birthlabout.setBounds(350, 75, 50, 25);
        add(sexlab);
        add(sexlabout);
        sexlab.setBounds(100, 125, 50, 25);
        sexlabout.setBounds(150, 125, 50, 25);
        add(colllab);
        add(colllabout);
        colllab.setBounds(300, 125, 50, 25);
        colllabout.setBounds(350, 125, 150, 25);
        add(deptlab);
        add(deptlabout);
        deptlab.setBounds(50, 175, 50, 25);
        deptlabout.setBounds(100, 175, 150, 25);
        add(classlab);
        add(classlabout);
        classlab.setBounds(300, 175, 50, 25);
        classlabout.setBounds(350, 175, 150, 25);
        add(addlab);
        add(addlabout);
        addlab.setBounds(150, 225, 50, 25);
        addlabout.setBounds(200, 225, 200, 25);
        add(numberlab);
        add(numberlabout);
        numberlab.setBounds(150, 275, 50, 25);
        numberlabout.setBounds(200, 275, 150, 25);
        add(clobtn);
        clobtn.setBounds(250, 325, 100, 50);

        //设置布局方式为空布局
        setLayout(null);
        //----------------(3)事件处理-----------------
        clobtn.addActionListener(this);

        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == clobtn) {
            //关闭当前界面
            this.dispose();
        }
    }
}
