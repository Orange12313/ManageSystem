package com.lch;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CheckSno {
    //数据库连类对象
    private Connect connect = new Connect();

    public boolean checkSno(String sno) throws Exception {
        boolean out = true;

        //获得数据库连接对象
        Connection conn = connect.getConnection();
        //创建PreparedStatement对象
        PreparedStatement pstmt = conn.prepareStatement("Select * From stuinf Where Sno=?");

        //给动态参数赋值
        pstmt.setString(1, sno);

        ResultSet rs = pstmt.executeQuery();
        //查询结果返回1条或0条记录，如果查询结果不为空，则该用户存在
        if (rs.next())
            out = false;
        return out;
    }
}
