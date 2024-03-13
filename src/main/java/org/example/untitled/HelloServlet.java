package org.example.untitled;

import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;
import org.example.untitled.entity.edata;
import org.example.untitled.model.usermodel;
import org.apache.commons.text.StringEscapeUtils;

import java.io.PrintWriter;
import java.util.logging.Logger;
import java.util.List;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    static final String Error = "Error";


    @Override
    public void init() {
        //part of life-cycle
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {

        response.setContentType("text/html");
        final Logger logger = Logger.getLogger(getClass().getName());
        String action = request.getParameter("action");
        if (action != null && !action.isEmpty()) {
            switch (action) {
                case "listuser":
                    listuser(request, response);
                    break;
                default:
                    PrintWriter out = null;
                    try {
                        out = response.getWriter();
                        out.println("<script>alert('unknown action')</script>");
                    } catch (Exception e) {
                        logger.info(Error+e);
                    }

                    break;
            }
        } else {
            // Handle the case when no action is specified
            PrintWriter out = null;
            try {
                out = response.getWriter();
                out.println("<script>alert('unknown action')</script>");
            } catch (Exception e) {
                logger.info(Error+e);
            }

        }

    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response){
        response.setContentType("text/html");
        final Logger logger = Logger.getLogger(getClass().getName());
        String action = request.getParameter("action");
        if (action != null && !action.isEmpty()) {
            switch (action) {
                case "signup":
                    signup(request,response);
                    break;
                default:
                    PrintWriter out = null;
                    try {
                        out = response.getWriter();
                        out.println("<script>alert('unknown action')</script>");
                    } catch (Exception e) {
                        logger.info(Error+e);
                    }

                    break;
            }
        } else {
            // Handle the case when no action is specified
            PrintWriter out = null;
            try {
                out = response.getWriter();
                out.println("<script>alert('unknown action')</script>");
            } catch (Exception e) {
                logger.info(Error+e);
            }

        }
    }

    @Override
    public void destroy() {

        //part of life-cycle
    }

    public void listuser(HttpServletRequest request, HttpServletResponse response){
        final Logger logger = Logger.getLogger(getClass().getName());
        List<edata> edata;
        edata = usermodel.listusers();
        request.setAttribute("udata",edata);
        try {
            request.getRequestDispatcher("listuser.jsp").forward(request,response);
        } catch (Exception e) {
            logger.info(Error+e);
        }
    }

    public void signup(HttpServletRequest request, HttpServletResponse response){
        final Logger logger = Logger.getLogger(getClass().getName());
        try {
            String username = StringEscapeUtils.escapeHtml4(request.getParameter("signupName"));
            String useremail = StringEscapeUtils.escapeHtml4(request.getParameter("signupEmail"));
            String userpass = StringEscapeUtils.escapeHtml4(request.getParameter("signupPassword"));
            String usercnpass = StringEscapeUtils.escapeHtml4(request.getParameter("confirmPassword"));

            if(usercnpass.equals(userpass)) {
                edata edat = new edata(username, useremail, userpass);
                int res = usermodel.adduser(edat);
                if (res == 0) {
                    PrintWriter out = response.getWriter();
                    out.println("<script>alert('Registration done!');</script>");
                    out.println("<script>setTimeout(function(){ window.location.href = '" + request.getContextPath() + "/index.jsp'; }, 1000);</script>");
                } else {
                    request.setAttribute("udata", "user already exists!");
                    request.getRequestDispatcher("signup.jsp").forward(request, response);
                }
            }
            else{
                logger.warning("password doesn't match!");
                request.setAttribute("udata","password doesn't match");
                request.getRequestDispatcher("signup.jsp").forward(request,response);
            }

        } catch (Exception e) {
            logger.info(Error+e);
        }
    }
}