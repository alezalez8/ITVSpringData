package itvdn.todolist.Sand.lambda;

public class Radio implements ElectricityConsumer {

    public void playMusic() {
        System.out.println("Radio is playing now");
    }

    @Override
    public void electricityOn(Object sender) {
        playMusic();
    }
}
