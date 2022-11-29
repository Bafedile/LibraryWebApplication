package za.co.mecer.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import za.co.mecer.dao.ClosingDAO;
import za.co.mecer.dao.LoanDAO;
import za.co.mecer.dbconnection.DatabaseConnection;
import za.co.mecer.exceptions.LoanException;
import za.co.mecer.modelImpl.Loan;

/**
 *
 * @author Dimakatso Sebatane
 */
public class LoanDAOImpl implements LoanDAO, ClosingDAO {

    private Connection conn = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet result = null;
    List<Loan> loans = new ArrayList<>();

    /**
     *
     * @param conn
     */
    public LoanDAOImpl() {
        this.conn = DatabaseConnection.getInstance().getConnection();
    }

    /**
     *
     * @param clientIdentityNum
     * @param loan
     * @param bookISBN
     */
    @Override
    public void addLoan(String clientIdentityNum, Loan loan, String bookISBN) {
        /**
         * <<Loan Fields>> client_id, borroweddate, returndate, fine
         */
        try {
            if (conn != null) {
                preparedStatement = conn.prepareStatement("INSERT INTO loan (client_id,book_id,borroweddate, returndate,fine)"
                        + "VALUES ((SELECT client_id FROM client WHERE identityNum = ?),(SELECT book_id FROM book WHERE isbn=?),?,?,?)");

                preparedStatement.setString(1, clientIdentityNum);
                preparedStatement.setString(2, bookISBN);
                preparedStatement.setString(3, loan.getBorrowedDate().toString());
                preparedStatement.setString(4, loan.getReturnDate().toString());
                preparedStatement.setDouble(5, loan.getFine());
                preparedStatement.executeUpdate();
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
    public void removeLoan(int loanId) {
        try {
            if (conn != null) {
                preparedStatement = conn.prepareStatement("DELETE FROM loan WHERE loan_id = ? ");
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
     *
     * @param loanId
     * @param newReturnDate
     */
    @Override
    public void changeReturnDate(int loanId, LocalDate newReturnDate) {
        try {
            if (conn != null) {
                preparedStatement = conn.prepareStatement("UPDATE loan SET returndate = ? WHERE loan_id = ?");
                preparedStatement.setString(1, newReturnDate.toString());
                preparedStatement.setInt(2, loanId);
                preparedStatement.executeUpdate();
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
     * @param fine
     */
    @Override
    public void addFine(int loanId, double fine) {
        try {
            if (conn != null) {
                preparedStatement = conn.prepareStatement("UPDATE loan SET fine = ? WHERE loan_id = ?");
                preparedStatement.setDouble(1, fine);
                preparedStatement.setInt(2, loanId);
                preparedStatement.executeUpdate();
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
     * @return
     */
    @Override
    public Loan searchLoan(int loanId) {
        Loan loan = null;
        loans.clear();

        try {
            if (conn != null) {
                preparedStatement = conn.prepareStatement("SELECT * FROM loan WHERE loan_id =?");
                preparedStatement.setInt(1, loanId);
                result = preparedStatement.executeQuery();
                while (result.next()) {
                    loan = new Loan(result.getInt("loan_id"), result.getDate("borrowedDate").toLocalDate(),
                            result.getDate("returnDate").toLocalDate(), result.getDouble("fine"));
                    loans.add(loan);
                }
            }
        } catch (SQLException | LoanException se) {
        } finally {
            close(preparedStatement, result);
        }
        return loan;

    }

    /**
     * Gets all the loans in the database
     */
    @Override
    public void getAllLoans() {
        Loan loan = null;
        loans.clear();

        try {
            if (conn != null) {
                preparedStatement = conn.prepareStatement("SELECT * FROM loan");
                result = preparedStatement.executeQuery();
                while (result.next()) {
                    loan = new Loan(result.getInt("loan_id"), result.getDate("borrowedDate").toLocalDate(),
                            result.getDate("returnDate").toLocalDate(), result.getDouble("fine"));
                    loans.add(loan);
                }
            }
        } catch (SQLException | LoanException se) {
            System.err.println("Error " + se.getMessage());
        } finally {
            close(preparedStatement, result);
        }

    }

    /**
     * Displays all the loans
     */
    @Override
    public void displayLoans() {
        loans.forEach((loan) -> System.out.println(loan));
    }

    @Override
    public int getLoanId(String identityNum) {
        try {
            if (conn != null) {
                preparedStatement = conn.prepareStatement("SELECT loan_id FROM loan WHERE  client_id = (SELECT client_id FROM client WHERE identityNum = ?)");
                preparedStatement.setString(1, identityNum);
                result = preparedStatement.executeQuery();
                if (result.next()) {
                    return result.getInt("loan_id");
                }
            }
        } catch (SQLException se) {
            System.err.println(String.format("Error: %s%n", se.getMessage()));
        } finally {
            close(preparedStatement, result);
        }
        return 0;
    }

}
