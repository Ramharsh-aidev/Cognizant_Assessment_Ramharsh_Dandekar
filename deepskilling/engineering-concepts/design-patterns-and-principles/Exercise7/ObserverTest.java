public class ObserverTest {
    public static void main(String[] args) {
        System.out.println("Testing Observer Pattern");

        StockMarket aapl = new StockMarket("AAPL", 150.00);

        Observer mobileApp = new MobileApp("Robinhood");
        Observer webApp = new WebApp("Yahoo Finance");

        aapl.registerObserver(mobileApp);
        aapl.registerObserver(webApp);

        System.out.println("Updating price to 155.00...");
        aapl.setPrice(155.00);

        System.out.println("\nDeregistering the Mobile App...");
        aapl.deregisterObserver(mobileApp);

        System.out.println("\nUpdating price to 160.00...");
        aapl.setPrice(160.00);
    }
}
