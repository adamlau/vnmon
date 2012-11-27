package com.smspl.mc4.monitoring.virtualnumber.ui;

import com.smspl.mc4.monitoring.virtualnumber.state.CheckStateStore;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * User: adamlau
 * Date: 15/10/12
 * Time: 2:41 PM
 */
@WebServlet("/dump/")
public class Dump extends HttpServlet {

    @Inject CheckStateStore checkStateStore;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("states", checkStateStore.getStates());
        req.setAttribute("removedStates", checkStateStore.getRemovedStates());
        getServletContext().getRequestDispatcher("/dump.jsp").forward(req,resp);
    }
}
