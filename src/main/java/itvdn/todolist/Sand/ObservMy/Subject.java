package itvdn.todolist.Sand.ObservMy;

public interface Subject {
    void registerObserver(Observer observer);

    void unregisterObserver(Observer observer);

    void notifyObservers();
}
