package com;

import org.apache.commons.codec.binary.Base64;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;;
import java.awt.image.BufferedImage;

import java.io.IOException;

public class MainServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.getRequestDispatcher("index.jsp").forward(req, resp);

        String name = req.getParameter("nameFile");

        if (name != null) {
            GetImage getImage = new GetImage();
            BufferedImage image = getImage.GetImage(req.getParameter("nameFile"));
            System.out.println(image);


            //if (image != null) {
              //  byte[] imageBytes = ((DataBufferByte) image.getData().getDataBuffer()).getData();
                //Base64 base = new Base64();
                //System.out.println(base.encode(imageBytes));
            //
            //    <img src="data:image/jpg;base64,iVBORw0KGgoAAAANS..." />
            //}
        }
    }
}