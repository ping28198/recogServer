package com.dpwd.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dpwd.entity.RContent;
import com.dpwd.exception.ContentNotFoundException;
import com.dpwd.service.RecogService;

/**
 * Servlet implementation class RecogServlet
 */
@WebServlet("/Recog")
public class RecogServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private RecogService recogService = new RecogService();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RecogServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String method = request.getParameter("method");
		if("findcontent".equals(method))
		{
			findContent(request,response);
		}
	}

	private void findContent(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException{
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		String checkCode = request.getParameter("checkcode");
		
		RContent rContent = new RContent();
		rContent.setId(Integer.parseInt(id));
		rContent.setCheckCode(checkCode);
		System.out.println("--findContentMethod");
		try {
			RContent rc = recogService.getContentById(rContent);
			System.out.println(rc.getAudioPath());
			request.setAttribute("rcontent", rc);
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			
		} catch (ContentNotFoundException e) {
			// TODO: handle exception
			request.setAttribute("rcontent",null);
			request.getRequestDispatcher("/notFound.jsp").forward(request, response);
		} catch (Exception e){
			e.printStackTrace();  // 测试时候用
			// 其他错误, 跳转到错误页面
			response.sendRedirect(request.getContextPath() + "/error/error.jsp");
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
	}

}
