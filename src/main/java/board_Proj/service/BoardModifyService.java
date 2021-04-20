package board_Proj.service;

import java.sql.Connection;

import board_Proj.dao.BoardDaoImpl;
import board_Proj.ds.JndiDS;
import board_Proj.dto.BoardDto;

public class BoardModifyService {
	private BoardDaoImpl dao = BoardDaoImpl.getInstance();
	private Connection con = JndiDS.getConnection();

	public BoardModifyService() {
		dao.setCon(con);
	}

	public BoardDto getArticle(int board_num){
		
		return dao.selectArticle(board_num);
	}

	public boolean isArticleWriter(int board_num, String pass) {
		// TODO Auto-generated method stub
		return false;
	}

}
