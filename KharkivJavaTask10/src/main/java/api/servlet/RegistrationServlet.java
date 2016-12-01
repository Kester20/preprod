package api.servlet;

import formbean.RegistrationFormBean;
import shop.entity.Client;
import shop.service.ClientService;
import util.Validator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * @author Arsalan
 */
@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {

    private ClientService clientService;
    private Map<String, String> errors;
    private RegistrationFormBean formBean;

    @Override
    public void init() throws ServletException {
        clientService = new ClientService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(errors.size() > 0){
            request.setAttribute("formBean", formBean);
            request.setAttribute("errors", errors);
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("register.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        formBean = createFormBean(request);
        errors = validateBean(formBean);
        if(errors.size() == 0){
            if(clientService.checkExistClient(formBean.getEmail())){
                errors.put("email", "This email is already exist!");
            }else{
                Client client = transformBean(formBean);
                clientService.createClient(client);
            }
        }
        response.sendRedirect("RegistrationServlet");
    }

    private RegistrationFormBean createFormBean(HttpServletRequest request){
        if(request.getParameter("firstName") != null && request.getParameter("lastName") != null && request.getParameter("email") != null &&
                request.getParameter("pass") != null && request.getParameter("mobileNumber") != null){
            return new RegistrationFormBean(request.getParameter("firstName"), request.getParameter("lastName"),
                    request.getParameter("email"), request.getParameter("pass"),
                    request.getParameter("mobileNumber"));
        }
        return null;
    }

    private Map<String, String> validateBean(RegistrationFormBean formBean){
        return  new Validator(formBean).validate();
    }

    private Client transformBean(RegistrationFormBean formBean){
        return new Client(formBean.getFirstName(), formBean.getSecondName(), formBean.getEmail(),
                formBean.getPassword(), formBean.getMobileNumber());
    }
}
