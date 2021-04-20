package board_Proj.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board_Proj.dto.ActionForward;
import board_Proj.dto.BoardDto;
import board_Proj.dto.PageInfo;
import board_Proj.service.BoardListService;

public class BoardListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int page = 1;
		int limit = 10;

		BoardListService service = new BoardListService();

		if (request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}

		ArrayList<BoardDto> list = service.getArticleList(page, limit);
		list.stream().forEach(System.out::println);

		int listCount = service.getListCount();

		int maxPage = (int) Math.ceil((double) listCount / limit);

		int startPage = (int) Math.floor(page / 10) *10 + 1;
		int endPage = startPage + 9;
		
		if (endPage > maxPage) {endPage=maxPage;}
		
		System.out.println("listCount = " + listCount + " maxpage >> " + maxPage);
		System.out.println("startPage >> " + startPage);
		
		PageInfo pageInfo = new PageInfo(page, maxPage, startPage, endPage, listCount);
		request.setAttribute("pageInfo", pageInfo);
		request.setAttribute("articleList", list);
		
		ActionForward forward = new ActionForward();
		forward.setPath("/board/qna_board_list.jsp");
		return forward;
	}

}
