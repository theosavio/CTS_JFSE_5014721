public class AdapterPatternExample {
    public static void main(String[] args) {
        PaymentProcessor paypalProcessor = new PayPalAdapter(new PayPalGateway());
        paypalProcessor.processPayment(100.0);

        PaymentProcessor stripeProcessor = new StripeAdapter(new StripeGateway());
        stripeProcessor.processPayment(200.0);

        PaymentProcessor squareProcessor = new SquareAdapter(new SquareGateway());
        squareProcessor.processPayment(300.0);
    }
}
