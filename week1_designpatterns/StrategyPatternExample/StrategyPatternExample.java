public class StrategyPatternExample {
    public static void main(String[] args) {
        PaymentContext context = new PaymentContext();

        // Paying with Credit Card
        PaymentStrategy creditCardPayment = new CreditCardPayment("9484838447474773", "theo savio", "123", "12/24");
        context.setPaymentStrategy(creditCardPayment);
        context.executePayment(150.00);

        // Paying with PayPal
        PaymentStrategy payPalPayment = new PayPalPayment("theo@example.com", "password123");
        context.setPaymentStrategy(payPalPayment);
        context.executePayment(75.50);
    }
}
