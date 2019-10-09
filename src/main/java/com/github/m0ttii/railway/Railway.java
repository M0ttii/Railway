package com.github.m0ttii.railway;

import com.github.m0ttii.railway.events.RailwayEvent;
import com.github.m0ttii.railway.processor.WebProcessor;
import lombok.Getter;

public class Railway {
    @Getter
    public static WebProcessor webProcessor;

    public Railway(){
        webProcessor = new WebProcessor();
    }

    public static void main(String[] args){

    }

    @com.github.m0ttii.railway.interfaces.Railway("ban")
    public void banEvent(RailwayEvent event){
        event.getJsonObject().


    }
}
