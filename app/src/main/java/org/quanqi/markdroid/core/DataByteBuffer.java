package org.quanqi.markdroid.core;

/**
 * Created by cindy on 8/15/14.
 */
public class DataByteBuffer {

    byte[] data = null;
    int length = 0;


    public DataByteBuffer() {
    }

    public DataByteBuffer(byte[] data) {
        this.data = data;
    }

    public DataByteBuffer(int capacity) {
        this.data = new byte[capacity];
    }

}
