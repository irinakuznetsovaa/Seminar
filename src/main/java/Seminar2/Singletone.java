package Seminar2;


import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class Singletone {

    private static AtomicReference<Singletone> INSTANCE = new AtomicReference<>();
    final int id;
    private static final AtomicInteger count = new AtomicInteger(0);


    private Singletone(int id) {
        this.id = id;
    }

    public static Singletone getSingle(){

        INSTANCE.compareAndSet(null, new Singletone(count.getAndIncrement()));
        return INSTANCE.get();
    }

    public int getId() {
        return id;
    }
}