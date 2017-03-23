package cn.tongjilab.mybatis;

import static org.assertj.core.api.Assertions.*;

import java.io.IOException;
import java.time.LocalDate;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import cn.tongjilab.mybatis.entity.Person;
import cn.tongjilab.mybatis.mapper.PersonMapper;
import cn.tongjilab.mybatis.utils.MyBatisUtils;

public class MyBatisTest {

	private static SqlSessionFactory sqlSessionFactory;
	private SqlSession sqlSession;

	@BeforeClass
	public static void init() throws IOException {
		sqlSessionFactory = MyBatisUtils.getSqlSessionFactory();
	}

	@Before
	public void before() {
		sqlSession = sqlSessionFactory.openSession(true);// 自动提交
	}

	@After
	public void after() {
		sqlSession.close();
	}

	@Test
	public void testMyBatisUtils() {
		assertThat(sqlSessionFactory).isNotNull();
	}

	@Test
	public void testInsert() {
		Person p = new Person(0, "yitian", LocalDate.of(1993, 5, 6));
		sqlSession.insert("insertPerson", p);

		Person s = sqlSession.selectOne("selectPersonByName", p.getUsername());
		assertThat(s).isNotNull();
		System.out.println(s);

		sqlSession.delete("deletePerson", s);
	}

	@Test
	public void testUpdate() {
		Person p = new Person(1, "leo", LocalDate.of(1993, 5, 6));
		sqlSession.insert("insertPerson", p);

		p = sqlSession.selectOne("selectPersonByName", p.getUsername());
		LocalDate b = LocalDate.of(1987, 7, 8);
		p.setBirthday(b);
		sqlSession.update("updatePerson", p);
		Person s = sqlSession.selectOne("selectPersonByName", p.getUsername());
		assertThat(s.getBirthday()).isEqualTo(b);
		System.out.println(s);

		sqlSession.delete("deletePerson", s);
	}
	
	@Test
	public void testPersonMapper(){
		PersonMapper mapper = sqlSession.getMapper(PersonMapper.class);
		 
		Person p = new Person(0, "yitian", LocalDate.of(1993, 5, 6));
		mapper.insertPerson(p);
		 
		Person s = mapper.selectPersonByName(p.getUsername());
		assertThat(s).isNotNull();
		System.out.println(s);
		 
		mapper.deletePerson(s);
	}

}
