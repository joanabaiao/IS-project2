package web;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ejb.MoviesEJBRemote;
import jpa.MovieJPA;

@WebServlet("/WebFrontend")
public class WebFrontend extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@EJB
	private MoviesEJBRemote ejb;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException {

		List<MovieJPA> movies = ejb.getMovies();
		movies.sort(Comparator.comparing(MovieJPA::getTop250Rank));
				
		request.setAttribute("movies", movies);
		request.getRequestDispatcher("/display.jsp").forward(request, response);
	}
}
