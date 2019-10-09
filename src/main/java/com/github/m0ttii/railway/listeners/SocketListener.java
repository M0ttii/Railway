package com.github.m0ttii.railway.listeners;

import com.github.m0ttii.railway.Railway;
import com.github.m0ttii.railway.events.RailwayEvent;
import io.socket.client.IO;
import io.socket.client.Socket;
import io.socket.emitter.Emitter;
import org.json.JSONObject;

public class SocketListener {
    private Socket socket;

    public SocketListener(String uri){
        socket = IO.socket(uri);
        socket.on("foo", new Emitter.Listener() {
            @Override
            public void call(Object... args) {
                JSONObject obj = (JSONObject)args[0];
                Railway.getWebProcessor().executeEvent(new RailwayEvent(obj));
            }
        });
    }

}
