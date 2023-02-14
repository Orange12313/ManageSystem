package com.lch;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StuFrame extends JFrame implements ActionListener {
    private JLabel snamelab, snolab, birthlab, sexlab, colllab, deptlab, classlab, addlab, numberlab,getsexlab,getyearlab,getmonthlab,getdaylab;
    private JTextField snameField, snoField, collField, deptField, classField, addField, numberField;
    private JComboBox sexcbox,yearcbox,monthcbox,daycbox;
    private JButton updbtn, canbtn;

    public StuFrame(String title, String account,String Sno) {
        setTitle(title+":"+account);
        //----------------(1)创建窗体-----------------
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
        //----------------(2)创建界面元素--------------
        try {
            seek se = new seek(Sno);
            snamelab = new JLabel("姓名：");
            snolab = new JLabel("学号：");
            birthlab = new JLabel("生日：");
            sexlab = new JLabel("性别：");
            colllab = new JLabel("学院：");
            deptlab = new JLabel("专业：");
            classlab = new JLabel("班级：");
            addlab = new JLabel("地址：");
            numberlab = new JLabel("电话：");
            snameField = new JTextField(20);
            snoField = new JTextField(20);
            collField = new JTextField(20);
            deptField = new JTextField(20);
            classField = new JTextField(20);
            addField = new JTextField(20);
            numberField = new JTextField(20);
            snameField.setText(se.getsname);
            snoField.setText(se.getsno);
            getsexlab = new JLabel(se.getsex);
            getyearlab = new JLabel(se.getyear+"年");
            getmonthlab = new JLabel(se.getmonth+"月");
            getdaylab = new JLabel(se.getday+"日");
            collField.setText(se.getcoll);
            deptField.setText(se.getdept);
            classField.setText(se.getclass);
            addField.setText(se.getadd);
            numberField.setText(se.getnum);
//            sexcbox = new JComboBox(new String[]{"男", "女"});
//            if("男".equals(se.getsex)){
//                int n = 1;
//                sexcbox.getSelectedItem();
//            }
//            yearcbox = new JComboBox(new String[]{"1995", "1996", "1997", "1998", "1999",
//                    "2000", "2001", "2002", "2003", "2004", "2005",
//                    "2006", "2007", "2008", "2009", "2010"});
//            monthcbox = new JComboBox(new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"});
//            daycbox = new JComboBox(new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
//                    "11", "12", "13", "14", "15", "16", "17", "18", "19", "20",
//                    "21", "22", "23", "24", "25", "26", "27", "28", "29", "30"
//            });
        } catch (Exception e) {
            e.printStackTrace();
        }

        updbtn = new JButton("更新");
        canbtn = new JButton("退出");
        add(snamelab);
        add(snameField);
        snamelab.setBounds(50, 25, 50, 25);
        snameField.setBounds(100, 25, 150, 25);
        add(snolab);
        add(snoField);
        snolab.setBounds(300, 25, 50, 25);
        snoField.setBounds(350, 25, 150, 25);
        add(birthlab);
        add(getyearlab);
        add(getmonthlab);
        add(getdaylab);
//        add(yearcbox);
//        add(monthcbox);
//        add(daycbox);
        birthlab.setBounds(170, 75, 40, 25);
//        yearcbox.setBounds(220, 75, 60, 25);
//        monthcbox.setBounds(290, 75, 50, 25);
//        daycbox.setBounds(350, 75, 50, 25);
        getyearlab.setBounds(220, 75, 60, 25);
        getmonthlab.setBounds(290, 75, 50, 25);
        getdaylab.setBounds(350, 75, 50, 25);
        add(sexlab);
        add(getsexlab);
//        add(sexcbox);
        sexlab.setBounds(100, 125, 50, 25);
//        sexcbox.setBounds(150, 125, 50, 25);
        getsexlab.setBounds(150, 125, 50, 25);
        add(colllab);
        add(collField);
        colllab.setBounds(300, 125, 50, 25);
        collField.setBounds(350, 125, 150, 25);
        add(deptlab);
        add(deptField);
        deptlab.setBounds(50, 175, 50, 25);
        deptField.setBounds(100, 175, 150, 25);
        add(classlab);
        add(classField);
        classlab.setBounds(300, 175, 50, 25);
        classField.setBounds(350, 175, 150, 25);
        add(addlab);
        add(addField);
        addlab.setBounds(150, 225, 50, 25);
        addField.setBounds(200, 225, 200, 25);
        add(numberlab);
        add(numberField);
        numberlab.setBounds(150, 275, 50, 25);
        numberField.setBounds(200, 275, 150, 25);
        add(updbtn);
        updbtn.setBounds(100, 325, 100, 50);
        add(canbtn);
        canbtn.setBounds(400, 325, 100, 50);

        //设置布局方式为空布局
        setLayout(null);
//        setLayout(new FlowLayout(FlowLayout.LEFT));
        //----------------(3)事件处理-----------------
        updbtn.addActionListener(this);
        canbtn.addActionListener(this);

        setVisible(true);
    }

    public static void main(String[] args) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == updbtn) {
            //更新数据 否则报错
            String Sname = snameField.getText();
            String Sno = snoField.getText();
//            String year = (String) yearcbox.getSelectedItem();
//            String month = (String) monthcbox.getSelectedItem();
//            String day = (String) daycbox.getSelectedItem();
//            String Ssex = (String) sexcbox.getSelectedItem();
            String Collage = collField.getText();
            String Dept = deptField.getText();
            String Sclass = classField.getText();
            String Address = addField.getText();
            String Number = numberField.getText();

            CheckSno check = new CheckSno();
            try {
                //对比是否重复
                boolean out = check.checkSno(Sno);
                if (out == false) {
                    Stu_save stu_save = new Stu_save();
                    stu_save.save(Sname,Sno,Collage,Dept,Sclass,Address,Number);

                    JOptionPane.showMessageDialog(null, "更新成功！");
                    //关闭新增界面
//                    this.dispose();

                } else {
                    JOptionPane.showMessageDialog(null, "更新失败！");
                }
            } catch (Exception ec) {
                JOptionPane.showMessageDialog(null, "更新时出现异常。异常原因为:" + ec.getMessage());
            }
        } else {
            //关闭当前界面
            this.dispose();
        }
    }
}

