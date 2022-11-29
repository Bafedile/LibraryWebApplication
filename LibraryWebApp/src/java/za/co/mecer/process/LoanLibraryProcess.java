package za.co.mecer.process;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import za.co.mecer.exceptions.LoanException;
import za.co.mecer.modelImpl.Book;
import za.co.mecer.modelImpl.Loan;
import za.co.mecer.serviceimpl.BookServiceImpl;
import za.co.mecer.serviceimpl.LoanServiceImpl;
import za.co.mecer.services.BookService;
import za.co.mecer.services.LoanService;

/**
 *
 * @author Dimakatso Sebatane
 */
public class LoanLibraryProcess {

    Book book = null;

    public void processLoanRequest(HttpServletRequest request, HttpServletResponse response, String identity) throws ServletException, IOException, LoanException {
        LoanService loanService = new LoanServiceImpl();
        Loan loan = new Loan(LocalDate.now(), LocalDate.now().plusWeeks(2), 0.0);

        if (checkBookExists(request, response)) {
            loanService.addLoan(identity, loan, book.getISBN());
            response.sendRedirect("books");
        } else {
            response.sendRedirect("bookLoan");
        }
    }

    public boolean checkBookExists(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String author, bookISBN, bookTitle;
        bookISBN = request.getParameter("isbn");
        bookTitle = request.getParameter("bookTitle");

        try {
            BookService bookService = new BookServiceImpl();

            if ((bookISBN == null || bookISBN.isEmpty()) && (bookTitle == null || bookTitle.isEmpty())) {
                response.sendRedirect("bookLoan");
            } else {
                if (!(bookISBN == null || bookISBN.isEmpty()) && (bookTitle == null || bookTitle.isEmpty())) {
                    book = bookService.getBookByISBN(bookISBN);
                } else {
                    book = bookService.getBookByTitle(bookTitle);
                }
            }
        } catch (SQLException iox) {
        }

        return book != null;
    }
}
