package com.tm.dao.impl;

import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import com.tm.dao.StudentDAO;
import com.tm.dto.Student;
import com.tm.mapper.StudentMapper;

public class StudentJDBCTemplate implements StudentDAO {

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	// private SimpleJdbcCall jdbcCall;

	/** 设置数据源 */
	@Override
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		// this.jdbcCall = new
		// SimpleJdbcCall(dataSource).withProcedureName("getRecord");
	}

	/** 新增 */
	@Override
	public void create(String name, Integer age) {
		String sql = "insert into student(name,age) VALUES(?,?)";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.update(sql, name, age);
		System.out.println("新增：name=" + name + " age=" + age);
		return;
	}

	/** 通过id查找 */
	@Override
	public Student getStudent(Integer id) {
		String sql = "select * from student where id=?";
		Student student = jdbcTemplate.queryForObject(sql, new Object[] { id }, new StudentMapper());
		return student;
//		SqlParameterSource in = new MapSqlParameterSource().addValue("in_id", id);
//		Map<String, Object> out = jdbcCall.execute(in);
//		Student student = new Student();
//		student.setId(id);
//		student.setName((String) out.get("out_name"));
//		student.setAge((Integer) out.get("out_age"));
//		return student;
	}

	/** 查询 */
	@Override
	public List<Student> listStudents() {
		String sql = "select * from student";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<Student> students = jdbcTemplate.query(sql, new StudentMapper());
		return students;
	}

	/** 修改 */
	@Override
	public void update(Integer id, Integer age) {
		String sql = "update student set age=? where id=?";
		jdbcTemplate.update(sql, age, id);
		System.out.println("修改的id=" + id);
		return;
	}

	/** 删除 */
	@Override
	public void delete(Integer id) {
		String sql = "delete from student where id = ?";
		jdbcTemplate.update(sql, id);
		System.out.println("删除的id=" + id);
		return;
	}

}
