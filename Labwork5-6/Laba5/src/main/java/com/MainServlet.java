package com;

import org.apache.commons.io.FileUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;;
import java.io.IOException;
import java.util.Base64;

public class MainServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        ServletContext selvletContext = getServletContext();

        String name = req.getParameter("nameFile");

        if (name != null) {
            GetImage getImage = new GetImage();
            byte[]fileContent = FileUtils.readFileToByteArray(getImage.GetImage(name));
            String encodedString = Base64.getEncoder().encodeToString(fileContent);  // convert to BASE64

            if (encodedString != null) {
                selvletContext.setAttribute("encodedString", encodedString);
                getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
            }
        }
    }
}