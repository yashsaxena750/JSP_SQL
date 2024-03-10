package org.example.untitled;

import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;
import org.example.untitled.entity.edata;
import org.example.untitled.model.usermodel;
import java.util.logging.Logger;
import org.apache.commons.text.StringEscapeUtils;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {


    @Override
    public void init() {
        //part of life-cycle
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {

        response.setContentType("text/html");
        final Logger logger = Logger.getLogger(getClass().getName());
        List<edata> edata;
        edata = usermodel.listusers();


        try (PrintWriter out = response.getWriter()) {

            for (edata data : edata) {
                out.println("UserID: " + data.getUserid());
                out.println("<br>");
                out.println("Username: " + StringEscapeUtils.escapeHtml4(data.getUname()));
                out.println("<br>");
                out.println("UserEmail: " + StringEscapeUtils.escapeHtml4(data.getUemail()));
                out.println("<br>");
                out.println("UserPassword: " + StringEscapeUtils.escapeHtml4(data.getUpassword()));
                out.println("<br>");
                out.println("-------------------------");
                out.println("<br>");
            }
        }catch (Exception e)
        {
            logger.info("Error"+e);
        }

    }

    @Override
    public void destroy() {

        //part of life-cycle
    }
}