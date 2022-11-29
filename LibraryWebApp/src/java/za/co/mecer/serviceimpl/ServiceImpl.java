//package za.co.mecer.serviceimpl;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.sql.Connection;
//import java.sql.SQLException;
//import java.util.InputMismatchException;
//import java.util.Scanner;
//import za.co.mecer.dbconnection.DatabaseConnection;
//import za.co.mecer.exceptions.AuthorException;
//import za.co.mecer.exceptions.ClientException;
//import za.co.mecer.exceptions.LoanException;
//import za.co.mecer.exceptions.PaymentException;
//import za.co.mecer.services.Services;
//import za.co.mecer.exceptions.BookException;
//
///**
// *
// * @author Dimakatso Sebatane
// */
//public class ServiceImpl implements Services {
//
//    Scanner input = new Scanner(System.in);
//    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//    DatabaseConnection dbConn = DatabaseConnection.getInstance();
//    BookServiceImpl bookService;
//    LoanServiceImpl loanService;
//    ClientServiceImpl clientService;
//    PaymentServiceImpl paymentService;
//    AuthorServiceImpl authorService;
//
//    /**
//     *
//     * @param conn
//     * @throws SQLException
//     */
//    public ServiceImpl(Connection conn) throws SQLException {
//        this.bookService = new BookServiceImpl(conn);
//        this.loanService = new LoanServiceImpl(conn);
//        this.clientService = new ClientServiceImpl(conn);
//        this.paymentService = new PaymentServiceImpl(conn);
//        this.authorService = new AuthorServiceImpl(conn);
//    }
//
//    /**
//     *
//     * @return
//     */
//    @Override
//    public int getMenuChoice() {
//        boolean isValid;
//        int choice = 0;
//        do {
//
//            try {
//                System.out.println("Please choose from the below\n"
//                        + "1 Display Book Menu\n"
//                        + "2 Display Client Menu\n"
//                        + "3 Display Loan Menu\n"
//                        + "4 Display Payment Menu\n"
//                        + "5 Display Author Menu\n"
//                        + "6 Exit\n"
//                        + "Your choice: \n");
//                choice = input.nextInt();
//                isValid = !(choice < 1 && choice > 6);
//
//            } catch (NumberFormatException | InputMismatchException ex) {
//                System.out.println(String.format("Error: %s%n", ex.getMessage()));
//                isValid = false;
//            }
//        } while (!isValid);
//        return choice;
//    }
//
//    /**
//     *
//     * @param choice
//     * @throws SQLException
//     * @throws ClientException
//     * @throws LoanException
//     * @throws IOException
//     * @throws AuthorException
//     * @throws PaymentException
//     * @throws BookException
//     */
//    @Override
//    public void setOptionChoice(int choice) throws SQLException, ClientException, LoanException, IOException,
//            AuthorException, PaymentException, BookException {
//        switch (choice) {
//            case 1:
//
//                bookService.processBookMenu(getBookMenuChoice());
//                break;
//            case 2:
//                clientService.processClientMenu(getClientMenuChoice());
//                break;
//            case 3:
//                loanService.processLoanMenu(getLoanMenuChoice());
//                break;
//            case 4:
//                paymentService.processPaymentMenu(getPaymentMenuChoice());
//                break;
//            case 5:
//                authorService.processAuthorMenu(getAuthorMenuChoice());
//            default:
//                System.out.println(String.format("%n------------------------------------------------%n"
//                        + "\tTHANK YOU FOR USING OUR SERVICES%n"
//                        + "------------------------------------------------%n%n"));
//        }
//    }
//
//    /**
//     *
//     * @return
//     */
//    @Override
//    public int getBookMenuChoice() {
//        boolean isValid;
//        int choice = 0;
//        do {
//            try {
//                System.out.print("Choose from the below Book Menu\n"
//                        + "1 Add A Book\n"
//                        + "2 Get A Book\n"
//                        + "3 Get Available Books\n"
//                        + "4 Get Accessible Books\n"
//                        + "5 Update Book Availability\n"
//                        + "6 Update Book Accessibility\n"
//                        + "7 Get ALL Books\n"
//                        + "8 Exit Book Menu\n"
//                        + "Your choice:");
//                choice = input.nextInt();
//                isValid = !(choice < 1 && choice > 8);
//            } catch (NumberFormatException ex) {
//                System.out.println(String.format("Error: %s%n", ex.getMessage()));
//                isValid = false;
//            }
//
//        } while (!isValid);
//
//        return choice;
//
//    }
//
//    /**
//     *
//     * @return
//     */
//    @Override
//    public int getAuthorMenuChoice() {
//        boolean isValid;
//        int choice = 0;
//        do {
//            try {
//                System.out.println(String.format("Choose from the below Author Menu\n"
//                        + "1 Add An Author\n"
//                        + "2 Get An Author\n"
//                        + "3 Remove An Author\n"
//                        + "4 Get ALL Authors\n"
//                        + "5 Display An Author and Book\n"
//                        + "6 Exit Author Menu\n"
//                        + "Your Choice:"));
//                choice = input.nextInt();
//                isValid = !(choice < 1 && choice > 5);
//            } catch (NumberFormatException ex) {
//                System.out.println(String.format("Error: %s%n", ex.getMessage()));
//                isValid = false;
//            }
//        } while (!isValid);
//
//        return choice;
//    }
//
//    /**
//     *
//     * @return
//     */
//    @Override
//    public int getClientMenuChoice() {
//        boolean isValid;
//        int choice = 0;
//        do {
//            try {
//                System.out.println(String.format("Choose from the below Client Menu\n"
//                        + "1 Add A Client\n"
//                        + "2 Get A Client\n"
//                        + "3 Remove A Client\n"
//                        + "4 Update Client Address\n"
//                        + "5 Update Client Home Telephone Number\n"
//                        + "6 Update Client Mobile Telephone Number\n"
//                        + "7 Update Client Work Telephone Number\n"
//                        + "8 Get ALL Clients\n"
//                        + "9 Exit Client Menu\n"
//                        + "Your Choice:"));
//                choice = input.nextInt();
//                isValid = !(choice < 1 && choice > 9);
//            } catch (NumberFormatException ex) {
//                System.out.println(String.format("Error: %s%n", ex.getMessage()));
//                isValid = false;
//            }
//        } while (!isValid);
//
//        return choice;
//    }
//
//    /**
//     *
//     * @return
//     */
//    @Override
//    public int getLoanMenuChoice() {
//        boolean isValid;
//        int choice = 0;
//        do {
//            try {
//                System.out.println(String.format("Choose from the below Loan Menu\n"
//                        + "1 Add A Loan\n"
//                        + "2 Get A Loan\n"
//                        + "3 Remove A Loan\n"
//                        + "4 Update Return Date\n"
//                        + "5 Get All Loans\n"
//                        + "6 Update Loan Fine\n"
//                        + "7 Exit Loan Menu\n"
//                        + "Your Choice:"));
//                choice = input.nextInt();
//                isValid = !(choice < 1 && choice > 7);
//            } catch (NumberFormatException ex) {
//                System.out.println(String.format("Error: %s%n", ex.getMessage()));
//                isValid = false;
//            }
//        } while (!isValid);
//
//        return choice;
//
//    }
//
//    /**
//     *
//     * @return
//     */
//    @Override
//    public int getPaymentMenuChoice() {
//        boolean isValid;
//        int choice = 0;
//        do {
//            try {
//                System.out.println(String.format("Choose from the below Payment Menu\n"
//                        + "1 Add Payment\n"
//                        + "2 Get Payment\n"
//                        + "3 Remove Payment\n"
//                        + "4 Get All Payments\n"
//                        + "5 Exit Payment Menu\n"
//                        + "Your Choice: "));
//                choice = input.nextInt();
//                isValid = !(choice < 1 && choice > 5);
//            } catch (NumberFormatException ex) {
//                System.out.println(String.format("Error: %s%n", ex.getMessage()));
//                isValid = false;
//            }
//        } while (!isValid);
//
//        return choice;
//    }
//
//}
