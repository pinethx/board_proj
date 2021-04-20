package board_Proj.action;

import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import board_Proj.dto.ActionForward;
import board_Proj.dto.BoardDto;
import board_Proj.service.BoardWriteService;

public class BoardWriteProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String realFolder ="";
		String saveFolder = "/boardUpload";
		int fileSize = 5*1024*1024;
		
		ServletContext context = request.getServletContext();
		realFolder = context.getRealPath(saveFolder);
		
		MultipartRequest multi = new MultipartRequest(request, realFolder, fileSize, "UTF-8", new DefaultFileRenamePolicy());
		
		BoardDto boardDto = new BoardDto();
		boardDto.setBoard_name(multi.getParameter("BOARD_NAME"));
		boardDto.setBoard_pass(multi.getParameter("BOARD_PASS"));
		boardDto.setBoard_subject(multi.getParameter("BOARD_SUBJECT"));
		boardDto.setBoard_content(multi.getParameter("BOARD_CONTENT"));
		boardDto.setBoard_file(multi.getOriginalFileName((String)multi.getFileNames().nextElement()));

		System.out.println("realFolder >> " + realFolder);
		System.out.println("boardDto >> " + boardDto);
				
		BoardWriteService service = new BoardWriteService();
		boolean result = service.registerArticle(boardDto);
		
		ActionForward forward = null;
		
		if (result) {
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("boardList.do");
		} else {
			PrintWriter out = response.getWriter();
			out.println("<script> alert('등록실패') history.back(); </script>");
		}
		
		return forward;
	}

}
