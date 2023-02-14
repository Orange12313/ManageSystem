package com.lch;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Admin_seek extends JFrame implements ActionListener {
    private JLabel seeklab;
    private JTextField seekField;
    private JButton seekbtn, canbtn;

    public Admin_seek(String title) {
        setTitle(title);

        //居中显示
        setSize(300, 200);
        double width = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
        double height = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
        int x = (int) (width - this.getWidth()) / 2;
        int y = (int) (height - this.getHeight()) / 2;
        setLocation(x, y);
        //关闭窗体
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //设置窗体大小不可改变
        setResizable(false);

        seeklab = new JLabel("请输入学号");
        seekField = new JTextField(20);
        seekbtn = new JButton("查询");
        canbtn = new JButton("取消");

        add(seeklab);
        add(seekField);
        add(seekbtn);
        add(canbtn);

        seeklab.setBounds(105, 0, 100, 50);
        seekField.setBounds(90, 50, 100, 25);
        seekbtn.setBounds(55, 95, 70, 25);
        canbtn.setBounds(150, 95, 70, 25);

        setLayout(null);

        seekbtn.addActionListener(this);
        canbtn.addActionListener(this);

        setVisible(true);
    }

    public static void main(String[] args) {
        Admin_seek admin_seek = new Admin_seek("查询");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String Sno = seekField.getText();
        CheckSno check = new CheckSno();
        if (e.getSource() == seekbtn) {
            try {
                //对比是否重复
                boolean out = check.checkSno(Sno);
                if (out == false) {
                    Admin_seek_out seek = new Admin_seek_out("查询",Sno);
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "该学号不存在！");
                }
            } catch (Exception ec) {
                JOptionPane.showMessageDialog(null, "查询时出现异常。异常原因为:" + ec.getMessage());
            }
        } else {
            //关闭当前界面
            this.dispose();
        }
    }
}
