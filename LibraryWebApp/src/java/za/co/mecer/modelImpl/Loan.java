package za.co.mecer.modelImpl;

import java.time.LocalDate;
import za.co.mecer.model.Loans;
import za.co.mecer.exceptions.LoanException;

/**
 *
 * @author Dimakatso Sebatane
 */
public class Loan implements Loans {

    private LocalDate borrowedDate, returnDate;
    private double fine;
    private int loanId;

    /**
     *
     * @param loanId
     * @param borrowedDate
     * @param returnDate
     * @param Fine
     * @throws LoanException
     */
    public Loan(int loanId, LocalDate borrowedDate, LocalDate returnDate, double Fine) throws LoanException {
        this.loanId = loanId;
        this.borrowedDate = borrowedDate;
        this.returnDate = returnDate;
        this.setFine(Fine);
    }

    /**
     *
     * @param borrowedDate
     * @param returnDate
     * @param Fine
     * @throws LoanException
     */
    public Loan(LocalDate borrowedDate, LocalDate returnDate, double Fine) throws LoanException {
        this.borrowedDate = borrowedDate;
        this.returnDate = returnDate;
        this.setFine(Fine);
    }

    /**
     *
     * @return
     */
    @Override
    public LocalDate getReturnDate() {
        return returnDate;
    }

    /**
     *
     * @param returnDate
     */
    @Override
    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    /**
     *
     * @return
     */
    @Override
    public LocalDate getBorrowedDate() {
        return borrowedDate;
    }

    /**
     *
     * @param borrowedDate
     */
    @Override
    public void setBorrowedDate(LocalDate borrowedDate) {
        this.borrowedDate = borrowedDate;
    }

    /**
     *
     * @param fine
     * @throws LoanException
     */
    @Override
    public void setFine(double fine) throws LoanException {
        if (fine < 0) {
            throw new LoanException(FINE_ERROR_MSG);
        }
        this.fine = fine;
    }

    /**
     *
     * @return
     */
    @Override
    public double getFine() {
        return fine;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return String.format("Book borrowed date: %s%n"
                + "Book return date: %s%n"
                + "Book fine:  %.2f%n", borrowedDate, returnDate, fine);
    }

    /**
     * @return the loanId
     */
    public int getLoanId() {
        return loanId;
    }

    /**
     * @param loanId the loanId to set
     */
    public void setLoanId(int loanId) throws LoanException {
        if (loanId <= 0) {
            throw new LoanException(LOAN_ID_ERROR_MSG);
        }
        this.loanId = loanId;
    }

}
