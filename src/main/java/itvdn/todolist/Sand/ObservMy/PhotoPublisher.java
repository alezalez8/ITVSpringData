package itvdn.todolist.Sand.ObservMy;

public class PhotoPublisher implements Observer{

    public PhotoPublisher(Subject subject)  {
        subject.registerObserver(this);
    }

    public void update(PerseveranceData data) {
        System.out.printf("Опубликовано новое фото Марса - %1$s %n", data.getPhoto());
    }
}
