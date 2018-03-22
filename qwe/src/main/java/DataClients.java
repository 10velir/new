/*
    Класс, хранящий информацию о клиенте и его ставки
*/
public class DataClients {
    Clients client;

    private double rateOfClient;

    public double getRateOfClient() {
        return rateOfClient;
    }

    public void setRateOfClient(double rateOfClient) {
        this.rateOfClient = rateOfClient;
    }

    public String getClintName() {
        return client.getFirstname();
    }

    public DataClients(Clients client, double rateOfClient) {
        this.client = client;
        this.rateOfClient = rateOfClient;
    }
}
