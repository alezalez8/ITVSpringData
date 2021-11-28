package itvdn.todolist.Sand.lambda;

public class Program {

    public  void fire(Object sender) {
        System.out.println("fire!!!");

    }


    public static void main(String[] args) {
        Switch aSwitch = new Switch();
        String message = "Пожар";


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
        aSwitch.addElectricityListener(r -> System.out.println("Helloy"));
        aSwitch.addElectricityListener(r -> System.out.println(message));

        aSwitch.addElectricityListener(s -> {
            System.out.println("lambda");
            System.out.println(message);
            System.out.println("===========================");
        });
       // aSwitch.addElectricityListener(s -> (new Program.fire(s));
        aSwitch.addElectricityListener(new Program()::fire);


        aSwitch.switchOn();
    }
}
/*

 * https://www.youtube.com/watch?v=DNC6Lknn2AE
 * time: 41:14
 * */
