package itvdn.todolist.Sand.lambda;

public class Program {
    public static void main(String[] args) {
        Switch aSwitch = new Switch();

        Lamp lamp = new Lamp();
        Lamp lamp1 = new Lamp();
        Lamp lamp2 = new Lamp();
        Lamp lamp3 = new Lamp();
        Radio radio = new Radio();

        aSwitch.addElectricityListener(lamp);
        aSwitch.addElectricityListener(lamp1);
        aSwitch.addElectricityListener(lamp2);
        aSwitch.addElectricityListener(lamp3);
        aSwitch.addElectricityListener(radio);

/*
        class Fire implements ElectricityConsumer{
            @Override
            public void electricityOn() {
                System.out.println("Fire!!!!!");
            }
        }
        aSwitch.addElectricityListener(new Fire());
*/

        aSwitch.addElectricityListener(s -> {
            System.out.print("lambda");
            System.out.println("===========================");
        });

        aSwitch.switchOn();
    }
}
/*

 * https://www.youtube.com/watch?v=DNC6Lknn2AE
 * time: 41:14
 * */
