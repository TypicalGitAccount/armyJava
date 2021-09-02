package com.jdxarmy.back.interfaces;

import com.jdxarmy.back.classes.units.Unit;
import java.util.HashSet;

public class Observable {
    private HashSet<Observer> subscribers = new HashSet<>(1, 0.75f);

    public void subscribe(Observer subscriber, Unit observable) {
        subscribers.add(subscriber);
        observable.getState().setIsObserved(true);
        observable.getState().setObserver((Unit)subscriber);
    }

    protected void notifyObservers(Unit observable) {
        for ( Observer subscriber : subscribers ) {
            subscriber.update(observable);
        }
    }
}
