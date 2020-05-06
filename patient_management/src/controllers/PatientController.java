package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import services.PatientService;



@WebServlet("/PatientController")
public class PatientController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final PatientService patientService = new PatientService();

   
    public PatientController() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("patient") == null) {
			response.sendRedirect("http://localhost:8080/patient-management-system/index.jsp");
		}else {
			Gson gson = new Gson();
			response.setContentType("application/json");
			response.getWriter().write(gson.toJson(patientService.getAllPatients()));
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		patientService.saveNewPatient(request);
	}

}
