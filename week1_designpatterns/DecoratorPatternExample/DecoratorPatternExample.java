public class DecoratorPatternExample {
    public static void main(String[] args) {
        Notifier emailNotifier = new EmailNotifier();
        Notifier smsNotifier = new SMSNotifierDecorator(emailNotifier);
        Notifier slackNotifier = new SlackNotifierDecorator(smsNotifier);

        System.out.println("Sending email notification:");
        emailNotifier.send("This is an email notification.");

        System.out.println("\nSending email and SMS notifications:");
        smsNotifier.send("This is an email and SMS notification.");

        System.out.println("\nSending email, SMS, and Slack notifications:");
        slackNotifier.send("This is an email, SMS, and Slack notification.");
    }
}
