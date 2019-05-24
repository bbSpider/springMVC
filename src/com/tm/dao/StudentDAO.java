package com.tm.dao;

import java.util.List;

import javax.sql.DataSource;

import com.tm.dto.Student;

public interface StudentDAO {
	/** 设置数据源 */
	public void setDataSource(DataSource ds);

	/** 新增 */
	public void create(String name, Integer age);

	/** 通过id查找 */
	public Student getStudent(Integer id);

	/** 查询 */
	public List<Student> listStudents();

	/** 修改 */
	public void update(Integer id, Integer age);

	/** 删除 */
	public void delete(Integer id);
}
