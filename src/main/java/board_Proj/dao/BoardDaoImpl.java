package board_Proj.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import board_Proj.dto.BoardDto;

public class BoardDaoImpl implements BoardDao {
	private static final BoardDaoImpl instance = new BoardDaoImpl();
	private Connection con;

	public BoardDaoImpl() {
	}

	public static BoardDaoImpl getInstance() {
		return instance;
	}

	public void setCon(Connection con) {
		this.con = con;
	}

	@Override
	public int selectListCount() {
		String sql = "select count(*) from board";
		try (PreparedStatement pstmt = con.prepareStatement(sql); ResultSet rs = pstmt.executeQuery()) {
			if (rs.next()) {
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public ArrayList<BoardDto> selectArticleList(int page, int limit) {
		String sql = "SELECT BOARD_NUM, BOARD_NAME, BOARD_PASS, BOARD_SUBJECT, BOARD_CONTENT, BOARD_FILE, BOARD_RE_REF, BOARD_RE_LEV, BOARD_RE_SEQ, BOARD_READCOUNT, BOARD_DATE"
				+ "  FROM board" + " order by BOARD_RE_REF desc, BOARD_RE_SEQ asc" + " limit ?, ?";
		int startRow = (page - 1) * limit;
		try (PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, limit);
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					ArrayList<BoardDto> list = new ArrayList<BoardDto>();
					do {
						list.add(getBoardDto(rs));
					} while (rs.next());
					return list;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	private BoardDto getBoardDto(ResultSet rs) throws SQLException {

		int board_num = rs.getInt("BOARD_NUM");
		String board_name = rs.getString("BOARD_NAME");
		String board_pass = rs.getString("BOARD_PASS");
		String board_subject = rs.getString("BOARD_SUBJECT");
		String board_content = rs.getString("BOARD_CONTENT");
		String board_file = rs.getString("BOARD_FILE");
		int board_re_ref = rs.getInt("BOARD_RE_REF");
		int board_re_lev = rs.getInt("BOARD_RE_LEV");
		int board_seq = rs.getInt("BOARD_RE_SEQ");
		int board_readcount = rs.getInt("BOARD_READCOUNT");
		Date board_date = rs.getDate("BOARD_DATE");

		return new BoardDto(board_num, board_name, board_pass, board_subject, board_content, board_file, board_re_ref,
				board_re_lev, board_seq, board_readcount, board_date);
	}

	@Override
	public BoardDto selectArticle(int board_num) {
		String sql = "select BOARD_NUM, BOARD_NAME, BOARD_PASS, BOARD_SUBJECT, BOARD_CONTENT, BOARD_FILE, BOARD_RE_REF, BOARD_RE_LEV, BOARD_RE_SEQ, BOARD_READCOUNT, BOARD_DATE"
				+ "  from board where BOARD_NUM = ?";
		try (PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setInt(1, board_num);
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					return getBoardDto(rs);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int insertArticle(BoardDto article) {
		String sql = ("INSERT INTO web_gradle_erp.board"
				+ " (BOARD_NUM, BOARD_NAME, BOARD_PASS, BOARD_SUBJECT, BOARD_CONTENT, BOARD_FILE, BOARD_RE_REF)"
				+ " VALUES(?, ?, ?, ?, ?, ?, ?)");
		try (PreparedStatement pstmt = con.prepareStatement(sql)) {
			int nextNum = nextBoardNum();
			pstmt.setInt(1, nextNum);
			pstmt.setNString(2, article.getBoard_name());
			pstmt.setNString(3, article.getBoard_pass());
			pstmt.setNString(4, article.getBoard_subject());
			pstmt.setNString(5, article.getBoard_content());
			pstmt.setNString(6, article.getBoard_file());
			pstmt.setInt(7, nextNum);
			System.out.println(pstmt);
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int insertReplyArticle(BoardDto article) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateArticle(BoardDto article) {
		String sql = "update board set board_subject = ?, board_content = ? where board_num = ?";
		try(PreparedStatement pstmt = con.prepareStatement(sql);){
			pstmt.setString(1, article.getBoard_subject());
			pstmt.setString(2, article.getBoard_content());
			pstmt.setInt(3, article.getBoard_num());
			System.out.println(pstmt);
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deleteArticle(int board_num) {
		String sql ="delete from board where board_num=?";
		try (PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setInt(1, board_num);
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return 0;
	}

	@Override
	public int updateReadCount(int board_num) {
		String sql = "update board set BOARD_READCOUNT = BOARD_READCOUNT+1 where BOARD_NUM = ?";
		try (PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setInt(1, board_num);
			System.out.println(pstmt);
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public boolean isArticleBoardWriter(int board_num, String pass) {
		String sql ="select 1 from board where board_num = ? and board_pass=?";
		try (PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setInt(1, board_num);
			pstmt.setString(2, pass);
			try(ResultSet rs = pstmt.executeQuery()){
				if(rs.next()) return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public int nextBoardNum() {
		String sql = "select max(BOARD_NUM) from board";
		try (PreparedStatement pstmt = con.prepareStatement(sql); ResultSet rs = pstmt.executeQuery()) {
			if (rs.next()) {
				return rs.getInt(1) + 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 1;
	}

}
