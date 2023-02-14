package com.lch;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class Delete {
    Connect connect = new Connect();

    public Delete(String Sno) throws Exception {
        String sql = "Delete From stuinf Where Sno = ?";
        Connection conn = connect.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);

        pstmt.setString(1, Sno);
        pstmt.executeUpdate();
        JOptionPane.showMessageDialog(null, "删除成功!");
//        connect.close(rs, pstmt, conn);
    }
}
