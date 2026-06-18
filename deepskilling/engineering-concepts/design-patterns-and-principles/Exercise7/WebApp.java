public class WebApp implements Observer {
    private String dashboardName;

    public WebApp(String dashboardName) {
        this.dashboardName = dashboardName;
    }

    @Override
    public void update(String stockName, double price) {
        System.out.println("[" + dashboardName + " Web Dashboard] Updated ticker for " + stockName + " to $" + price);
    }
}
