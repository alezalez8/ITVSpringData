package itvdn.todolist.Sand.lambda;

import java.util.LinkedList;
import java.util.List;

public class Switch {

    private List<ElectricityConsumer> listeners = new LinkedList<>();


    public void addElectricityListener(ElectricityConsumer listener) {
        listeners.add(listener);
    }

    public void removeElectricityListener(ElectricityConsumer listener) {
        if(listeners.contains(listener)) {
        listeners.remove(listener);}
        else {
            System.out.println("Error of deleting subscribing");
        }
    }

    public void switchOn() {
        System.out.println("Switch is on");

        if (listeners != null) {
            for (ElectricityConsumer item : listeners) {
                item.electricityOn(this);
            }
        }

    }
}


