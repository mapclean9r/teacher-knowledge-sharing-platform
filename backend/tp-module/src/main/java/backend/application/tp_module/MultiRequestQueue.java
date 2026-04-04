package backend.application.tp_module;

import backend.application.tp_module.models.entities.User;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.function.Consumer;

public class MultiRequestQueue<T>{

    private final BlockingQueue<T> blockingQueue = new LinkedBlockingQueue<>();
    private final Consumer<T> consumer;

    public MultiRequestQueue(Consumer<T> consumer){
        this.consumer = consumer;
        startQueue();
    }

    private void startQueue(){
        Thread thread = new Thread(() -> {
            while (true) {
                try {
                    T t = blockingQueue.take();
                    consumer.accept(t);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        });

        thread.start();
    }


    public void accept(T t){
        blockingQueue.add(t);
    }

    public static void main(String[] args) {

        MultiRequestQueue<User> multiRequestQueue = new MultiRequestQueue<>(e->{
            System.out.println(e.getFullName());
        });

        User u1 = new User();
        u1.setFullName("hans");
        multiRequestQueue.accept(u1);

    }




}
