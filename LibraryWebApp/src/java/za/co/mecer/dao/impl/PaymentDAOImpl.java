package za.co.mecer.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import za.co.mecer.dao.ClosingDAO;
import za.co.mecer.dao.PaymentDAO;
import za.co.mecer.dbconnection.DatabaseConnection;
import za.co.mecer.exceptions.PaymentException;
import za.co.mecer.modelImpl.Payment;

/**
 *
 * @author Dimakatso Sebatane
 */
public class PaymentDAOImpl implements PaymentDAO, ClosingDAO {

    private Connection conn = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet result = null;
    private List<Payment> payments = new ArrayList<>();

    /**
     *
     * @param conn
     */
    public PaymentDAOImpl() {
        this.conn = DatabaseConnection.getInstance().getConnection();
    }

    /**
     *
     * @param loanId
     * @param payment
     */
    @Override
    public void addPayment(int loanId, Payment payment) {
        double amountOwed;
        try {
            if (conn != null) {
                conn.setAutoCommit(false);

                preparedStatement = conn.prepareStatement("SELECT fine FROM loan WHERE loan_id = ?");
                preparedStatement.setInt(1, loanId);
                result = preparedStatement.executeQuery();

                if (result.next()) {
                    amountOwed = result.getDouble("fine");
                    if (amountOwed > 0.0) {
                        if ((payment.getAmount() - amountOwed) > 0.0) {
                            new LoanDAOImpl().addFine(loanId, 0.0);
                        } else {
                            new LoanDAOImpl().addFine(loanId, (-1) * (payment.getAmount() - amountOwed));
                        }
                        preparedStatement = conn.prepareStatement("INSERT INTO payment (loan_id,amount) VALUES(?,?)");
                        preparedStatement.setInt(1, loanId);
                        preparedStatement.setDouble(2, payment.getAmount());
                        preparedStatement.executeUpdate();
                    } else {
                        System.out.println(String.format("You Owe %.2f%n%n ", amountOwed));
                    }
                }
                conn.setAutoCommit(true);
            }
        } catch (SQLException se) {
            System.err.println("Error " + se.getMessage());
        } finally {
            close(preparedStatement, result);
        }
    }

    /**
     *
     * @param loanId
     */
    @Override
    public void removePayment(int loanId) {
        try {
            if (conn != null) {
                preparedStatement = conn.prepareStatement("DELETE FROM payment WHERE loan_id = ?");
                preparedStatement.setInt(1, loanId);
                preparedStatement.executeUpdate();

            }
        } catch (SQLException se) {
            System.err.println("Error " + se.getMessage());
        } finally {
            close(preparedStatement, result);
        }
    }

    /**
     * Gets all the payments from the database
     */
    @Override
    public void getAllPayments() {
        Payment payment = null;
        try {
            if (conn != null) {
                preparedStatement = conn.prepareStatement("SELECT * FROM payment");
                result = preparedStatement.executeQuery();
                while (result.next()) {
                    payment = new Payment(result.getInt("payment_id"), result.getDouble("amount"));
                    payments.add(payment);
                }
            }
        } catch (SQLException | PaymentException se) {
            System.err.println("Error " + se.getMessage());
        } finally {
            close(preparedStatement, result);
        }
    }

    /**
     *
     * @param loanId
     * @return
     */
    @Override
    public Payment getPayment(int loanId) {
        Payment payment = null;
        try {
            if (conn != null) {
                preparedStatement = conn.prepareStatement("SELECT * FROM payment WHERE loan_id = ?");
                preparedStatement.setInt(1, loanId);
                result = preparedStatement.executeQuery();
                while (result.next()) {
                    payment = new Payment(result.getInt("payment_id"), result.getDouble("amount"));
                    payments.add(payment);
                }
            }
        } catch (SQLException | PaymentException se) {
            System.err.println("Error " + se.getMessage());
        } finally {
            close(preparedStatement, result);
        }
        return payment;
    }

    /**
     * Displays all the
     *
     */
    @Override
    public void displayPayments() {
        payments.forEach((payment) -> System.out.println(payment));
    }

}
