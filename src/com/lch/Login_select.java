package com.lch;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Login_select {
    //数据库连类对象
    private Connect connect = new Connect();

    public boolean loginCheck(String account,String password,String role) throws Exception{
        String sql = "";
        if("管理员".equals(role))
            sql = "select * from login_admin where account=? and password=?";
        else if ("学生".equals(role))
            sql = "select * from stuinf where Sname=? and Sno=?";
        return query(sql,account,password);
    }

    public boolean query(String sql,String p1,String p2) throws Exception{
        boolean valid = false;

        //获得数据库连接对象
        Connection conn = connect.getConnection();
        //创建PreparedStatement对象
        PreparedStatement pstmt = conn.prepareStatement(sql);
        //给动态参数赋值
        pstmt.setString(1, p1);
        pstmt.setString(2, p2);
        //执行SQL查询
        ResultSet rs = pstmt.executeQuery();
        //查询结果返回1条或0条记录，如果查询结果不为空，则该用户存在
        if(rs.next()) valid = true;
        //关闭数据连接，释放资源
        connect.close(rs, pstmt, conn);

        return valid;
    }
}
