package itvdn.todolist.Sand.ObservMy;


   public class TemperatureDisplay implements Observer {

        public TemperatureDisplay(Subject subject) {
            subject.registerObserver(this);
        }

        @Override
        public void update(PerseveranceData data) {
            System.out.printf("Температура на Марсе - %2.0f градусов по Цельсию %n",data.getTemperature());
        }
    }

