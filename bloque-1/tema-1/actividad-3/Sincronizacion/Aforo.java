package Sincronizacion;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Aforo {
    private int valor = 0;
    private final Lock lock = new ReentrantLock();

    public void incrementar() {
        lock.lock();
        try {
            int actual = valor;
            valor = actual + 1;
        } finally {
            lock.unlock();
        }
    }

    public int getValor() {
        return valor;
    }
}
