package com.bankapp.servlet;

import com.bankapp.dao.AccountDAO;
import com.bankapp.model.Account;
import com.bankapp.utils.SecurityUtils;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/AccountServlet")
public class AccountServlet extends HttpServlet {
    private AccountDAO accountDAO;

    @Override
    public void init() throws ServletException {
        accountDAO = new AccountDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        try {
            switch (action) {
                case "create":
                    createAccount(request, response);
                    break;
                // Implement other cases for deposit, withdraw, etc.
            }
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }

    private void createAccount(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        String accountNumber = SecurityUtils.generateAccountNumber(); 
        String accountType = request.getParameter("accountType");
        String customerName = request.getParameter("customerName");
        double balance = Double.parseDouble(request.getParameter("balance"));
        String safetyDepositBox = SecurityUtils.generateSafetyDepositBox();

        Account account = new Account(accountNumber, accountType, customerName, balance, safetyDepositBox);
        accountDAO.createAccount(account);

        response.getWriter().write("Account Created Successfully!");
    }
}
