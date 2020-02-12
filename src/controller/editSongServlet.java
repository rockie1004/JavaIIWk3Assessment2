package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ListSong;

/**
 * Servlet implementation class editSongServlet
 */
@WebServlet("/editSongServlet")
public class editSongServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editSongServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		ListSongHelper dao = new ListSongHelper();
		String artist = request.getParameter("artist");  
		String title = request.getParameter("title"); 
		Integer tempId=Integer.parseInt(request.getParameter("id"));
		
		ListSong songToUpdate = dao.searchForSongById(tempId);
		songToUpdate.setTitle(title);
		songToUpdate.setArtist(artist);
		
		dao.updateSong(songToUpdate);
		
		
		getServletContext().getRequestDispatcher("/viewAllSongsServlet").forward(request, response);
		
	}

}
