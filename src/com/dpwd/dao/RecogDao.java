package com.dpwd.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.dpwd.entity.*;
import com.dpwd.utils.JdbcUtil;


public class RecogDao {
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public RContent findById(RContent rc0){
		String sql = "select * from content where id = ? and checkcode = ?";
		RContent rc = null;
		System.out.println("Ω¯»Î≤È—Ø£°");
		try {
			con = JdbcUtil.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, rc0.getId());
			pstmt.setString(2, rc0.getCheckCode());
			
			rs = pstmt.executeQuery();
			if (rs.next()) {
				rc = new RContent();
				rc.setId(rs.getInt("id"));
				rc.setName(rs.getString("name"));
				rc.setAudioPath(rs.getString("audiopath"));
				rc.setModelPath(rs.getString("modelpath"));
				rc.setPicPath(rs.getString("picpath"));
				rc.setText(rs.getString("text"));
				rc.setVideoPath(rs.getString("videopath"));
				rc.setCheckCode(rs.getString("checkcode"));
			}
			return rc;
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
		finally{
			JdbcUtil.close(con, pstmt);
		}

	}
	
	public void addItem(RContent rc){
		
	}
	
	
	
	
	
}
