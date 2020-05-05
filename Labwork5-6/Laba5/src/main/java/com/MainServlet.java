package com;

import org.apache.commons.io.FileUtils;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;;
import java.io.File;
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
            File image  = getImage.GetImage(name);

            if (image != null) {
                byte[]fileContent = FileUtils.readFileToByteArray(image);
                String encodedString = Base64.getEncoder().encodeToString(fileContent);  // convert to BASE64
                selvletContext.setAttribute("encodedString", encodedString);
                selvletContext.setAttribute("errorMessage", "");
            }
            else {
                selvletContext.setAttribute("encodedString", null);
                selvletContext.setAttribute("errorMessage", "Image not found !!! Enter another name");
            }

            getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
        }
    }
}