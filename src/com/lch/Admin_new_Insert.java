package com.lch;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Admin_new_Insert {
    Connect connect = new Connect();

    public void save(String Sname, String Sno, String year, String month, String day, String Ssex,
                     String Collage, String Dept, String Sclass, String Address, String Number) throws Exception {
        String sql = "insert into stuinf(Sname,Sno,year,month,day,Ssex,Collage,Dept,Sclass,Address,Number) values(?,?,?,?,?,?,?,?,?,?,?)";
        Connection conn = connect.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, Sname);
        pstmt.setString(2, Sno);
        pstmt.setString(3, year);
        pstmt.setString(4, month);
        pstmt.setString(5, day);
        pstmt.setString(6, Ssex);
        pstmt.setString(7, Collage);
        pstmt.setString(8, Dept);
        pstmt.setString(9, Sclass);
        pstmt.setString(10, Address);
        pstmt.setString(11, Number);
        pstmt.executeUpdate();
        this.connect.close((ResultSet) null, pstmt, conn);
    }
}
