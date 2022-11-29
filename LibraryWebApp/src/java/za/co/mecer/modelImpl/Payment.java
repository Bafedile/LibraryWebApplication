package za.co.mecer.modelImpl;

import za.co.mecer.model.Payments;
import za.co.mecer.exceptions.PaymentException;

/**
 *
 * @author Dimakatso Sebatane
 */
public class Payment implements Payments {

    private double amount;
    private int paymentId;

    /**
     *
     * @param amount
     * @throws PaymentException
     */
    public Payment(double amount) throws PaymentException {
        setAmount(amount);
    }

    /**
     *
     * @param paymentId
     * @param amount
     * @throws PaymentException
     */
    public Payment(int paymentId, double amount) throws PaymentException {
        setAmount(amount);
        setPaymentId(paymentId);
    }

    /**
     *
     * @param amount
     * @throws PaymentException
     */
    @Override
    public void setAmount(double amount) throws PaymentException {
        if (amount < 0) {
            throw new PaymentException(AMOUNT_ERROR_MSG);
        }
        this.amount = amount;
    }

    /**
     * Returns an amount
     *
     * @return
     */
    @Override
    public double getAmount() {
        return amount;
    }

    /**
     * @return the paymentId
     */
    public int getPaymentId() {
        return paymentId;
    }

    /**
     * @param paymentId the paymentId to set
     */
    public void setPaymentId(int paymentId) throws PaymentException {
        if (paymentId <= 0) {
            throw new PaymentException(PAYMENT_ID_ERROR_MSG);
        }
        this.paymentId = paymentId;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return String.format("Payment Id: %d%n"
                + "Paid Amount:  %.2f%n%n", paymentId, amount);
    }

}
