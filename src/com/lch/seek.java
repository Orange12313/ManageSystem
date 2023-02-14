package com.lch;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class seek {
    public String getsname,getsno,getyear,getmonth,getday,getsex,getcoll,getdept,getclass,getadd,getnum;
    Connect connect = new Connect();

    public seek(String Sno) throws Exception{
        String sql = "Select * From stuinf Where Sno=?";
        Connection conn = connect.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);

        pstmt.setString(1, Sno);
        //执行SQL查询
        ResultSet rs = pstmt.executeQuery();
        //查询结果返回1条或0条记录，如果查询结果不为空，则该用户存在
        if(rs.next()){
            getsname = rs.getString("Sname");
            getsno = rs.getString("Sno");
            getyear = rs.getString("year");
            getmonth = rs.getString("month");
            getday = rs.getString("day");
            getsex = rs.getString("Ssex");
            getcoll = rs.getString("Collage");
            getdept = rs.getString("Dept");
            getclass = rs.getString("Sclass");
            getadd = rs.getString("Address");
            getnum = rs.getString("Number");
        }
        //关闭数据连接，释放资源
        connect.close(rs, pstmt, conn);

    }
}
