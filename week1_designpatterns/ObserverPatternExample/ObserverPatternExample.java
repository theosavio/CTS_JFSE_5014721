public class ObserverPatternExample {
    public static void main(String[] args) {
        StockMarket stockMarket = new StockMarket("XYZ");

        Observer mobileApp1 = new MobileApp("MobileApp1");
        Observer mobileApp2 = new MobileApp("MobileApp2");
        Observer webApp1 = new WebApp("WebApp1");

        stockMarket.registerObserver(mobileApp1);
        stockMarket.registerObserver(mobileApp2);
        stockMarket.registerObserver(webApp1);

        System.out.println("Setting stock price to $100.00");
        stockMarket.setStockPrice(100.00);

        System.out.println("\nSetting stock price to $105.50");
        stockMarket.setStockPrice(105.50);

        stockMarket.deregisterObserver(mobileApp2);

        System.out.println("\nSetting stock price to $110.00 after deregistering MobileApp2");
        stockMarket.setStockPrice(110.00);
    }
}
