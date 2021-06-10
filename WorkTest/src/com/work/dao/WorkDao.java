package com.work.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.work.model.Admin;
import com.work.model.Clazz;
import com.work.model.Page;
import com.work.model.Work;
import com.work.util.StringUtil;

public class WorkDao extends BaseDao {
	public boolean addWork(Work work){
		String sql = "insert into s_work values(null,'"+work.getSn()+"','"+work.getName()+"'";
		sql += ",'" + work.getPassword() + "'," + work.getClazzId();
		sql += ",'" + work.getSex() + "','" + work.getuid() + "'";
		sql += ",'" + work.getmoney() + "',null)";
		return update(sql);
	}
	public boolean editWork(Work work) {
		// TODO Auto-generated method stub
		String sql = "update s_work set name = '"+work.getName()+"'";
		sql += ",sex = '" + work.getSex() + "'";
		sql += ",uid = '" + work.getuid() + "'";
		sql += ",money = '" + work.getmoney() + "'";
		sql += ",clazz_id = " + work.getClazzId();
		sql += " where id = " + work.getId();
		return update(sql);
	}
	public boolean setWorkPhoto(Work work) {
		// TODO Auto-generated method stub
		String sql = "update s_work set photo = ? where id = ?";
		Connection connection = getConnection();
		try {
			PreparedStatement prepareStatement = connection.prepareStatement(sql);
			prepareStatement.setBinaryStream(1, work.getPhoto());
			prepareStatement.setInt(2, work.getId());
			return prepareStatement.executeUpdate() > 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return update(sql);
	}
	public boolean deleteWork(String ids) {
		// TODO Auto-generated method stub
		String sql = "delete from s_work where id in("+ids+")";
		return update(sql);
	}
	public Work getWork(int id){
		String sql = "select * from s_work where id = " + id;
		Work work = null;
		ResultSet resultSet = query(sql);
		try {
			if(resultSet.next()){
				work = new Work();
				work.setId(resultSet.getInt("id"));
				work.setClazzId(resultSet.getInt("clazz_id"));
				work.setuid(resultSet.getString("uid"));
				work.setName(resultSet.getString("name"));
				work.setPassword(resultSet.getString("password"));
				work.setPhoto(resultSet.getBinaryStream("photo"));
				work.setmoney(resultSet.getString("money"));
				work.setSex(resultSet.getString("sex"));
				work.setSn(resultSet.getString("sn"));
				return work;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return work;
	}
	public List<Work> getWorkList(Work work,Page page){
		List<Work> ret = new ArrayList<Work>();
		String sql = "select * from s_work ";
		if(!StringUtil.isEmpty(work.getName())){
			sql += "and name like '%" + work.getName() + "%'";
		}
		if(work.getClazzId() != 0){
			sql += " and clazz_id = " + work.getClazzId();
		}
		if(work.getId() != 0){
			sql += " and id = " + work.getId();
		}
		sql += " limit " + page.getStart() + "," + page.getPageSize();
		ResultSet resultSet = query(sql.replaceFirst("and", "where"));
		try {
			while(resultSet.next()){
				Work s = new Work();
				s.setId(resultSet.getInt("id"));
				s.setClazzId(resultSet.getInt("clazz_id"));
				s.setuid(resultSet.getString("uid"));
				s.setName(resultSet.getString("name"));
				s.setPassword(resultSet.getString("password"));
				s.setPhoto(resultSet.getBinaryStream("photo"));
				s.setmoney(resultSet.getString("money"));
				s.setSex(resultSet.getString("sex"));
				s.setSn(resultSet.getString("sn"));
				ret.add(s);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ret;
	}
	public int getWorkListTotal(Work work){
		int total = 0;
		String sql = "select count(*)as total from s_work ";
		if(!StringUtil.isEmpty(work.getName())){
			sql += "and name like '%" + work.getName() + "%'";
		}
		if(work.getClazzId() != 0){
			sql += " and clazz_id = " + work.getClazzId();
		}
		if(work.getId() != 0){
			sql += " and id = " + work.getId();
		}
		ResultSet resultSet = query(sql.replaceFirst("and", "where"));
		try {
			while(resultSet.next()){
				total = resultSet.getInt("total");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return total;
	}
	
	public Work login(String name ,String password){
		String sql = "select * from s_work where name = '" + name + "' and password = '" + password + "'";
		ResultSet resultSet = query(sql);
		try {
			if(resultSet.next()){
				Work work = new Work();
				work.setId(resultSet.getInt("id"));
				work.setName(resultSet.getString("name"));
				work.setPassword(resultSet.getString("password"));
				work.setClazzId(resultSet.getInt("clazz_id"));
				work.setuid(resultSet.getString("uid"));
				work.setPhoto(resultSet.getBinaryStream("photo"));
				work.setmoney(resultSet.getString("money"));
				work.setSex(resultSet.getString("sex"));
				work.setSn(resultSet.getString("sn"));
				return work;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public boolean editPassword(Work work,String newPassword) {
		// TODO Auto-generated method stub
		String sql = "update s_work set password = '"+newPassword+"' where id = " + work.getId();
		return update(sql);
	}
}
