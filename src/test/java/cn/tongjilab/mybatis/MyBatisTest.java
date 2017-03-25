package cn.tongjilab.mybatis;

import static org.assertj.core.api.Assertions.*;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import cn.tongjilab.mybatis.entity.Article;
import cn.tongjilab.mybatis.entity.Author;
import cn.tongjilab.mybatis.entity.Comment;
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
	
	@Test
	public void testInsertAuthor(){
		Author author = new Author("james", "ja", LocalDate.of(1990, 1, 21), LocalDateTime.now());
		sqlSession.insert("insertAuthor", author);
		
		Author r = sqlSession.selectOne("selectAuthorByName", author.getUsername());
		assertThat(r).isNotNull();
		System.out.println(r);
		
		sqlSession.delete("deleteAuthor", r);
	}
	
	@Test
	public void testInsertArticle(){
		Author author = new Author("james", "ja", LocalDate.of(1990, 1, 21), LocalDateTime.now());
		sqlSession.insert("insertAuthor", author);
		
		Article article = new Article("hello", "Today is Saturday, sunshine good!", author, LocalDateTime.now(), LocalDateTime.now());
		sqlSession.insert("insertArticle", article);
		
//		Article r = sqlSession.selectOne("selectArticle", article.getId());  //关联的嵌套查询，N+1问题
		Article r = sqlSession.selectOne("selectArticle2", article.getId());  //关联的嵌套结果
		assertThat(r).isNotNull();
		System.out.println(r);
		
		sqlSession.delete("deleteArticle", r);
		sqlSession.delete("deleteAuthor", author);
	}
	
	@Test
	public void testInsertComment(){
		Author author = new Author("james", "ja", LocalDate.of(1990, 1, 21), LocalDateTime.now());
		sqlSession.insert("insertAuthor", author);
		
		Article article = new Article("hello", "Today is Saturday, sunshine good!", author, LocalDateTime.now(), LocalDateTime.now());
		sqlSession.insert("insertArticle", article);
		
		Author commentator = new Author("kobe", "ja", LocalDate.of(1991, 2, 15), LocalDateTime.now());
		sqlSession.insert("insertAuthor", commentator);
		Author commentator2 = new Author("wolf", "ja", LocalDate.of(1992, 3, 16), LocalDateTime.now());
		sqlSession.insert("insertAuthor", commentator2);
		
		Comment comment = new Comment("first comment", commentator, article, LocalDateTime.now());
		sqlSession.insert("insertComment", comment);
		Comment comment2 = new Comment("second comment", commentator2, article, LocalDateTime.now());
		sqlSession.insert("insertComment", comment2);
		
		List<Comment> comments = sqlSession.selectList("selectCommentsByArticle", article.getId());
		assertThat(comments).hasSize(2);
		System.out.println(comments);
		
//		Article r = sqlSession.selectOne("selectArticle", article.getId());  //关联的嵌套查询，N+1问题
		Article r = sqlSession.selectOne("selectArticle2", article.getId());  //关联的嵌套结果
		System.out.println(r);
		
		sqlSession.delete("deleteComment", comment);
		sqlSession.delete("deleteComment", comment2);
		sqlSession.delete("deleteArticle", article);
		sqlSession.delete("deleteAuthor", commentator);
		sqlSession.delete("deleteAuthor", commentator2);
		sqlSession.delete("deleteAuthor", author);
		
	}

}
