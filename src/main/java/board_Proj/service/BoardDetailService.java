package board_Proj.service;

import java.sql.Connection;

import board_Proj.dao.BoardDaoImpl;
import board_Proj.ds.JndiDS;
import board_Proj.dto.BoardDto;

public class BoardDetailService {
	private BoardDaoImpl dao = BoardDaoImpl.getInstance();
	private Connection con = JndiDS.getConnection();

	public BoardDetailService() {
		dao.setCon(con);
	}

	public BoardDto getArticle(int board_num){
		
		dao.updateReadCount(board_num);
		return dao.selectArticle(board_num);
	}

}
