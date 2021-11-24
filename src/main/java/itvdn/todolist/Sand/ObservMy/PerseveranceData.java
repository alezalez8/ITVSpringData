package itvdn.todolist.Sand.ObservMy;

public class PerseveranceData {
    private final double temperature; // температура
    private final double pressure; // давление
    private final String photo; // фотография (для простоты пусть это будет строка)

    public PerseveranceData(double temperature, double pressure, String photo) {
        this.temperature = temperature;
        this.pressure = pressure;
        this.photo = photo;
    }

    public double getTemperature() {
        return temperature;
    }

    public double getPressure() {
        return pressure;
    }

    public String getPhoto() {
        return photo;
    }
}
