package itvdn.todolist.Sand.ObservMy;

public class PerseveranceTest {

    public static void main(String[] args) {
        // создадим экземпляр ровера
        Perseverance perseverance = new Perseverance();

        // и экземпляры классов-представлений
        TemperatureDisplay temperatureDisplay = new TemperatureDisplay(perseverance);
        PressureDisplay pressureDisplay = new PressureDisplay(perseverance);
        PhotoPublisher photoPublisher = new PhotoPublisher(perseverance);
        // отдельно регистрировать их в качестве Наблюдателей уже не нужно - они зарегистрировались в конструкторах

        // передадим роверу тестовые данные
        perseverance.onNewData(new PerseveranceData(-25, 0.6, "кратер Езеро"));
        System.out.println("--------------");
        // теперь уберём из списка подписчиков temperatureDisplay
        perseverance.unregisterObserver(temperatureDisplay);
        // и снова вызовем обновление данных
        perseverance.onNewData(new PerseveranceData(-35, 0.5, "море Дождей"));
    }
}
