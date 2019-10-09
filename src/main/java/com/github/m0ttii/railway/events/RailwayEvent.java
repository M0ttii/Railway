package com.github.m0ttii.railway.events;

import com.github.m0ttii.railway.interfaces.IEvent;
import lombok.Getter;
import netscape.javascript.JSObject;
import org.json.JSONObject;

public class RailwayEvent implements IEvent {
    @Getter
    private JSONObject jsonObject;
    public RailwayEvent(JSONObject jsonObject){
        this.jsonObject = jsonObject;
    }
}
