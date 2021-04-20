package board_Proj.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board_Proj.dto.ActionForward;
import board_Proj.dto.BoardDto;
import board_Proj.service.BoardModifyService;

public class BoardModifyAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		ActionForward forward = new ActionForward();
		
		boolean isModifySuccess = false;
		
		int board_num=Integer.parseInt(request.getParameter("baord_num"));
		String pass = request.getParameter("board_pass");
		BoardDto article = new BoardDto();
		
		BoardModifyService service = new BoardModifyService();
		
		boolean isArticleWriter = service.isArticleWriter(board_num, pass);
//		isModifySuccess = service.modifyArticle(article);
		
		if(!isArticleWriter) {
			SendMessage(response, "수정 권한 없음");
			return forward;
		}

		if(!isModifySuccess) {
			SendMessage(response, "수정 실패");
			return forward;
		}
		
		forward.setRedirect(true);
		forward.setPath("boardList.do?board_num=" + article.getBoard_num());
		return forward;
	}

	private void SendMessage(HttpServletResponse response, String msg) throws IOException {
		PrintWriter out = response.getWriter();
		out.println("<script>");
		out.println("alert('" + msg + "');");
		out.println("history.back()");
		out.println("</script>");		
	}

}
