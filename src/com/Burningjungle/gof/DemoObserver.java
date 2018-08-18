package gof;

import java.util.ArrayList;
import java.util.List;

interface IPublishier {
    void register(ISubscriber obj);

    void unregister(ISubscriber obj);

    void nitifyObservers();

    Object getUpdate();
}

interface ISubscriber {
    void update();

    void setPublisher(IPublishier publisher);

//    Object getUpdate();
}


class MyPublisher implements IPublishier {
    private List<ISubscriber> subscriberList;
    private String message;
    private boolean changed;
    private final Object MUTEX = new Object();

    public MyPublisher() {
        this.subscriberList = new ArrayList<>();
    }

    @Override
    public void register(ISubscriber obj) {
        if (obj == null) {
            throw new NullPointerException("Null Suber");
        }
        synchronized (MUTEX) {
            if (!subscriberList.contains(obj)) {
                subscriberList.add(obj);
            }
            obj.setPublisher(this);
        }
    }


    @Override
    public void unregister(ISubscriber obj) {
        synchronized (MUTEX) {
            subscriberList.remove(obj);
        }
    }

    @Override
    public void nitifyObservers() {
        List<ISubscriber> subscriberLocal;

        synchronized (MUTEX) {
            if (!changed) {
                return;
            }
            subscriberLocal = new ArrayList<>(this.subscriberList);
            this.changed = false;
        }
        for (ISubscriber obj : subscriberLocal) {
            obj.update();
        }
    }




    @Override
    public Object getUpdate() {
        return this.message;
    }

    public void postMessage(String mg) {
        System.out.println("Massage Posted to Topic  ," + mg);
        this.message = mg;
        this.changed = true;
        nitifyObservers();
    }

}


class TopicSubscriber implements ISubscriber {
    private String name;
    private IPublishier topic;

    public TopicSubscriber(String name) {
        this.name = name;
    }

    @Override
    public void update() {
        String message = (String) topic.getUpdate();
        if (message == null) {
            System.out.println(name + "::No new msg");
        } else {
            System.out.println(name + ":: comsuming msg ::" + message);
        }
    }

    @Override
    public void setPublisher(IPublishier publisher) {
        this.topic = publisher;

    }



}


public class DemoObserver {
    public static void main(String[] args) {
        MyPublisher publisher = new MyPublisher();

        ISubscriber hanhan1 = new TopicSubscriber("jhw");
        ISubscriber hanhan2 = new TopicSubscriber("jk");
        ISubscriber hanhan3 = new TopicSubscriber("nyq");

        publisher.register(hanhan1);
        publisher.register(hanhan2);
        publisher.register(hanhan3);

        hanhan1.update();

        publisher.postMessage("Damo java 2018");

    }

}
