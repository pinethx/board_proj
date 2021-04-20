package board_Proj.service;

import java.sql.Connection;

import board_Proj.dao.BoardDaoImpl;
import board_Proj.ds.JndiDS;
import board_Proj.dto.BoardDto;

public class BoardWriteService {
	private BoardDaoImpl dao = BoardDaoImpl.getInstance();
	private Connection con = JndiDS.getConnection();

	public BoardWriteService() {
		dao.setCon(con);
	}

	public boolean registerArticle(BoardDto boardDto) {
		return dao.insertArticle(boardDto) == 1 ? true : false;
	}
	
	public int getListCount() {
		return dao.selectListCount();
	}
}
