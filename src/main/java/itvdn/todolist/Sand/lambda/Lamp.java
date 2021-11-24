package itvdn.todolist.Sand.lambda;

public class Lamp implements ElectricityConsumer{
    @Override
    public void electricityOn(Object sender) {
        lampOn();

    }

    private void lampOn() {
        System.out.println("Lamp switch on");
    }
}
