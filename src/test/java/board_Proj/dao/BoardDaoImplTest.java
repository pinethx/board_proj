package board_Proj.dao;

import static org.junit.Assert.fail;

import java.sql.Connection;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import board_Proj.dto.BoardDto;
import board_Proj.util.JdbcUtil;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BoardDaoImplTest {
	private static Connection con = JdbcUtil.getConnection();
	private static BoardDaoImpl dao = BoardDaoImpl.getInstance();
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		dao.setCon(con);
	}

	@After
	public void tearDown() throws Exception {
		System.out.println();
	}

	@Test
	public void testBoardDaoImpl() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetInstance() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetCon() {
		fail("Not yet implemented");
	}

	@Test
	public void testNextBoardNum() {
		System.out.println("testNextBoardNum");
		int res = dao.nextBoardNum();
		Assert.assertNotEquals(0, res);
		System.out.println("next Number >> " + res);
	}
	
	@Test
	public void testSelectListCount() {
		System.out.println("testSelectListCount");
		int res = dao.selectListCount();
		
		Assert.assertNotEquals(-1, res);
		System.out.println("ListCount >> " + res);
	}

	@Test
	public void testSelectArticleList() {
		System.out.println("testSelectArticleList");
		int page = 1;
		int limit = 10;
		ArrayList<BoardDto> list = dao.selectArticleList(page, limit);
		Assert.assertNotNull(list);
		
		list.stream().forEach(System.out::println);
		System.out.println("==========================");
		dao.selectArticleList(2, 10).stream().forEach(System.out::println);
	}

	@Test
	public void testSelectArticle() {
		fail("Not yet implemented");
	}

	@Test
	public void testInsertArticle() {
		System.out.println("testInsertArticle");
		BoardDto newBoard = new BoardDto(
				"ksk",
				"1234",
				"5시퇴근가능?",
				"no....",
				"test.txt");
		int res = dao.insertArticle(newBoard);
		Assert.assertEquals(1, res);
	}

	@Test
	public void testInsertReplyArticle() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateArticle() {
		System.out.println("testUpdateArticle");
		int board_num = 4;
		BoardDto article = dao.selectArticle(board_num);
		int res = dao.updateArticle(article);
		Assert.assertEquals(1, res);
		
		System.out.println("res >> "+res);
	}

	@Test
	public void test08DeleteArticle() {
		System.out.println("testDeleteArticle");
		int board_num = dao.nextBoardNum()-1;
		int res = dao.deleteArticle(board_num);
		Assert.assertEquals(1, res);
		System.out.println("res >> " + res);
	}

	@Test
	public void test07IsArticleBoardWriter() {
		System.out.println("test07IsArticleBoardWriter()");
		int board_num = 22;
		boolean res = dao.isArticleBoardWriter(board_num, "1234");
		Assert.assertEquals(true, res);
		System.out.println("res >> "+res);
	}
	
	@Test
	public void testUpdateReadCount() {
		fail("Not yet implemented");
	}

}
