package com.lch;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Stu_save {
    Connect connect = new Connect();

    public void save(String Sname, String Sno,String Collage, String Dept, String Sclass, String Address, String Number) throws Exception {
        String sql = "Update stuinf Set Sname=?,Collage=?,Dept=?,Sclass=?,Address=?,Number=? Where Sno = ?";
        Connection conn = connect.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, Sname);
        pstmt.setString(2, Collage);
        pstmt.setString(3, Dept);
        pstmt.setString(4, Sclass);
        pstmt.setString(5, Address);
        pstmt.setString(6, Number);
        pstmt.setString(7, Sno);
        pstmt.executeUpdate();
        this.connect.close((ResultSet) null, pstmt, conn);
    }
}
