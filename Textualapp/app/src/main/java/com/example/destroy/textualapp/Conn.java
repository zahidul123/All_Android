package com.example.destroy.textualapp;

/**
 * Created by Destroy on 22-Jan-18.
 */

public class Conn {
    public boolean seen;
    public long timestamp;

    public Conn(){

    }

    public Conn(boolean seen, long timestamp) {
        this.seen = seen;
        this.timestamp = timestamp;
    }

    public boolean isSeen() {
        return seen;
    }

    public void setSeen(boolean seen) {
        this.seen = seen;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}
