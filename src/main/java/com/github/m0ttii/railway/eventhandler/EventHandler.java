package com.github.m0ttii.railway.eventhandler;

import com.github.m0ttii.railway.interfaces.EventListener;
import com.github.m0ttii.railway.interfaces.IEvent;
import com.github.m0ttii.railway.interfaces.Railway;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class EventHandler implements Comparable<EventHandler> {
    private final EventListener listener;
    private final Method method;
    private final Railway annotation;

    public EventHandler(EventListener listener, Method method, Railway annotation) {
        this.listener = listener;
        this.method = method;
        this.annotation = annotation;
    }

    public Railway getAnnotation() {
        return annotation;
    }

    public Method getMethod() {
        return method;
    }
    public EventListener getListener() {
        return listener;
    }

    public void execute(IEvent event) {
        try {
            method.invoke(listener, event);
        } catch (IllegalAccessException e1) {
            //Logger.in.e("Exception when performing EventHandler " + this.listener + " for event " + event.toString(), e1);
        } catch (IllegalArgumentException e1) {
            //CustomFacade.getLog().e("Exception when performing EventHandler " + this.listener + " for event " + event.toString(), e1);
        } catch (InvocationTargetException e1) {
            //CustomFacade.getLog().e("Exception when performing EventHandler " + this.listener + " for event " + event.toString(), e1);
        }
    }
    @Override
    public String toString() {
        return "(EventHandler " + this.listener + ": " + method.getName() + ")";
    }

    /*public int getPriority() {
        return annotation.priority();
    }*/

    /*@Override
    public int compareTo(EventHandler other) {
        // Because we are using a TreeSet to store EventHandlers in, compareTo should never return "equal".
        int annotation = this.annotation.priority() - other.annotation.priority();
        if (annotation == 0)
            annotation = this.listener.hashCode() - other.listener.hashCode();
        return annotation == 0 ? this.hashCode() - other.hashCode() : annotation;
    }*/
}
