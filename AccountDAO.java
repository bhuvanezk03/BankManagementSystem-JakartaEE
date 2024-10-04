package com.bankapp.dao;

import com.bankapp.model.Account;
import com.bankapp.utils.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountDAO {

    public void createAccount(Account account) throws SQLException {
        String query = "INSERT INTO account (account_number, account_type, customer_name, balance, safety_deposit_box) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, account.getAccountNumber());
            stmt.setString(2, account.getAccountType());
            stmt.setString(3, account.getCustomerName());
            stmt.setDouble(4, account.getBalance());
            stmt.setString(5, account.getSafetyDepositBox());
            stmt.executeUpdate();
        }
    }

    public Account getAccountByNumber(String accountNumber) throws SQLException {
        String query = "SELECT * FROM account WHERE account_number = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, accountNumber);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Account(
                    rs.getString("account_number"),
                    rs.getString("account_type"),
                    rs.getString("customer_name"),
                    rs.getDouble("balance"),
                    rs.getString("safety_deposit_box")
                );
            }
        }
        return null;
    }
}
