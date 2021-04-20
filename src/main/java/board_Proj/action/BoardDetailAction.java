package board_Proj.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board_Proj.dto.ActionForward;
import board_Proj.dto.BoardDto;
import board_Proj.service.BoardDetailService;

public class BoardDetailAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int board_num = Integer.parseInt(request.getParameter("board_num"));
		int page = Integer.parseInt(request.getParameter("page"));
		
		BoardDetailService service = new BoardDetailService();
		BoardDto article = service.getArticle(board_num);
		
		request.setAttribute("page", page);
		request.setAttribute("article", article);
		
		ActionForward forward = new ActionForward();
		forward.setPath("/board/qna_board_view.jsp");
		return forward;
	}

}
