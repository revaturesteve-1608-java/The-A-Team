package quicktest;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wip.ims.dao.DaoIms;
import com.wip.ims.model.Product;

public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		doPost(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		DaoIms dao = new DaoIms();

		writeJSON(dao.retrieveAllItem(new Product()), resp);
	}

	private void writeJSON(List<Product> products, HttpServletResponse response) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		String rlistJSON = mapper.writeValueAsString(products);
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		out.write(rlistJSON);
	}

}
