package board_Proj.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board_Proj.action.Action;
import board_Proj.action.BoardDeleteProAction;
import board_Proj.action.BoardDetailAction;
import board_Proj.action.BoardFileDownAction;
import board_Proj.action.BoardListAction;
import board_Proj.action.BoardModifyAction;
import board_Proj.action.BoardModifyFormAction;
import board_Proj.action.BoardReplyFormAction;
import board_Proj.action.BoardWriteProAction;
import board_Proj.dto.ActionForward;

@WebServlet("*.do")
public class BoardFrontControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doprocess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doprocess(request, response);
	}

	private void doprocess(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
//		String requestURI = request.getRequestURI();
//		String contextPath = request.getContextPath();
		String command = request.getServletPath();

//		String command = requestURI.substring(contextPath.length());
//		System.out.println(requestURI + " >> " + contextPath + ">>" + command);
		System.out.println(command);

		ActionForward forward = null;
		Action action = null;

		if (command.equals("/boardWriteForm.do")) {
			forward = new ActionForward();
			forward.setPath("/board/qna_board_write.jsp");
		} else if (command.equals("/boardWritePro.do")) {
			action = new BoardWriteProAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/boardList.do")) {
			action = new BoardListAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/boardDetail.do")) {
			action = new BoardDetailAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/boardReplyForm.do")) {
			action = new BoardReplyFormAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/boardDeleteForm.do")) {
			// board_num=26&page=1
			String nowPage = request.getParameter("page");
			request.setAttribute("page", nowPage);

			int board_num = Integer.parseInt(request.getParameter("board_num"));
			request.setAttribute("board_num", board_num);

			forward = new ActionForward();
			forward.setPath("/board/qna_board_delete.jsp");
		} else if (command.equals("/boardDelete.do")) {
			action = new BoardDeleteProAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/file_down.do")) {
			action = new BoardFileDownAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/boardModifyForm.do")) {
			action = new BoardModifyFormAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/boardModify.do")) {
			action = new BoardModifyAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			if (forward != null) {
				if (forward.isRedirect()) {
					response.sendRedirect(forward.getPath());
				} else {
					request.getRequestDispatcher(forward.getPath()).forward(request, response);
				}
			}

		}
	}
}