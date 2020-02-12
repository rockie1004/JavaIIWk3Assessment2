package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.ListSong;

/**
 * Servlet implementation class addSongServlet
 */
@WebServlet("/addSongServlet")
public class addSongServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public addSongServlet() {
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String artist = request.getParameter("artist");  
		String song = request.getParameter("song"); 
		
		ListSong li = new ListSong(artist, song);
		ListSongHelper dao = new ListSongHelper();
		dao.insertSong(li);
		
		getServletContext().getRequestDispatcher("/index.html").forward(request, response);
	
	}

}
