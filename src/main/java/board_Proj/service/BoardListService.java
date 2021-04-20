package board_Proj.service;

import java.sql.Connection;
import java.util.ArrayList;

import board_Proj.dao.BoardDaoImpl;
import board_Proj.ds.JndiDS;
import board_Proj.dto.BoardDto;

public class BoardListService {
	private BoardDaoImpl dao = BoardDaoImpl.getInstance();
	private Connection con = JndiDS.getConnection();

	public BoardListService() {
		dao.setCon(con);
	}

	public int getListCount() {
		return dao.selectListCount();
	}
	
	public ArrayList<BoardDto> getArticleList(int page, int limit){
		return dao.selectArticleList(page, limit);
	}

}
