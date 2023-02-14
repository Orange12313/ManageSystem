package com.lch;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Admin_del extends JFrame implements ActionListener {
    private JLabel dellab;
    private JTextField delField;
    private JButton delbtn, canbtn;

    public Admin_del(String title) {
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

        dellab = new JLabel("请输入学号");
        delField = new JTextField(20);
        delbtn = new JButton("删除");
        canbtn = new JButton("取消");

        add(dellab);
        add(delField);
        add(delbtn);
        add(canbtn);

        dellab.setBounds(105, 0, 100, 50);
        delField.setBounds(90, 50, 100, 25);
        delbtn.setBounds(55, 95, 70, 25);
        canbtn.setBounds(150, 95, 70, 25);

        setLayout(null);

        delbtn.addActionListener(this);
        canbtn.addActionListener(this);

        setVisible(true);

    }

    public static void main(String[] args) {
        Admin_del admin_del = new Admin_del("删除");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String Sno = delField.getText();
        CheckSno check = new CheckSno();
        if (e.getSource() == this.delbtn) {
            int n = JOptionPane.showConfirmDialog(null, "确认删除吗?", "确认删除框", JOptionPane.YES_NO_OPTION);
            if (n == JOptionPane.YES_OPTION)
                if (n == JOptionPane.YES_OPTION) {
                    // 删除学生信息 否则报错
                    try {
                        //对比是否重复
                        boolean out = check.checkSno(Sno);
                        if (out == false) {//学号存在
                            Delete delete = new Delete(Sno);
                            this.dispose();
                        } else {
                            JOptionPane.showMessageDialog(null, "该学号不存在！");
                        }
                    } catch (Exception ec) {
                        JOptionPane.showMessageDialog(null, "删除时出现异常。异常原因为:" + ec.getMessage());
                    }
                } else if (n == JOptionPane.NO_OPTION) {
                    // 取消 关闭删除框
                    System.exit(0);
                }
        } else {
            //关闭当前界面
            this.dispose();
        }
    }
}
