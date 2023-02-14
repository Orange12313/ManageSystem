package com.lch;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame implements ActionListener {
    private JLabel accountLbl, passwordLbl,roleLbl;
    private JTextField accountField;
    private JPasswordField passwordField;
    private JButton enterBtn, exitBtn;
    private JComboBox roleCombox;

    public Login(String title) {
        //----------------(1)创建窗体-----------------
        //设置窗体标题
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
        //---------(2)创建界面元素-----------
        accountLbl = new JLabel("用户账号:");
        passwordLbl = new JLabel("用户密码:");
        roleLbl = new JLabel("用户身份:");
        accountField = new JTextField(20);
        passwordField = new JPasswordField(20);
        enterBtn = new JButton("登录");
        exitBtn = new JButton("退出");
        roleCombox = new JComboBox(new String[]{"管理员", "学生"});
        //设置布局方式为空布局
        setLayout(null);
        accountLbl.setBounds(30, 10, 60, 20);
        accountField.setBounds(90, 10, 150, 20);//90=30+60
        passwordLbl.setBounds(30, 40, 60, 20);  //40=10+20+10
        passwordField.setBounds(90, 40, 150, 20);
        roleLbl.setBounds(30, 70, 60, 20);
        roleCombox.setBounds(90, 70, 150, 20);
        enterBtn.setBounds(30, 100, 100, 20);
        exitBtn.setBounds(140, 100, 100, 20);
        add(accountLbl);
        add(accountField);
        add(passwordLbl);
        add(passwordField);
        add(roleLbl);
        add(roleCombox);
        add(enterBtn);
        add(exitBtn);
        //-------------------(3)事件处理----------------
        //注册事件监听
        enterBtn.addActionListener(this);
        exitBtn.addActionListener(this);
        //显示窗体
        setVisible(true);
    }

    public static void main(String[] args) {
        Login login = new Login("登陆");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == enterBtn) {
            String account = accountField.getText();
            String password = new String(passwordField.getPassword());
            String role = (String) roleCombox.getSelectedItem();
            if (account == null || "".equals(account.trim()) || password == null || "".equals(password.trim())) {
                JOptionPane.showMessageDialog(null, "用户账号或密码不能为空");
                return;
            }
            Login_select select = new Login_select();
            try {
                boolean valid = select.loginCheck(account, password,role);
                if (valid == true) {
                    JOptionPane.showMessageDialog(null, "登录成功，欢迎您使用本系统");
                    //关闭当前窗体进入相应的主界面
                    this.dispose();
                    if("管理员".equals(role))
                        //管理员登录成功进入管理员主界面
                        new AdminFrame("管理员界面");
                    else if ("学生".equals(role))
                         new StuFrame("学生界面",account,password);
                } else {
                    JOptionPane.showMessageDialog(null, "登录失败，请检查用户名或密码是否正确");
                }
            } catch (Exception ec) {
                JOptionPane.showMessageDialog(null, "登录时出现异常。异常原因为:" + ec.getMessage());
            }
        } else {
            System.exit(0);//退出,注意该方法将退出应用程序，从JVM里退出来
        }
    }
}

