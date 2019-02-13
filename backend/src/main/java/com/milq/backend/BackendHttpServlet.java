package com.milq.backend;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class BackendHttpServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        ObjectMapper objectMapper = new ObjectMapper();
        int request_id = Integer.parseInt(req.getParameter("id"));
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setId(request_id);
        responseDTO.setValue("Backed Value");
        PrintWriter out = resp.getWriter();
        objectMapper.writerWithDefaultPrettyPrinter().writeValue(out,responseDTO);
    }
}
