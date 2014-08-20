package org.quanqi.markdroid.core;

/**
 * Created by cindy on 8/15/14.
 */
public class DataCharBuffer {

    public char[] data = null;
    public int length = 0;

    public DataCharBuffer() {
    }

    public DataCharBuffer(char[] data) {
        this.data = data;
    }

    public DataCharBuffer(int capacity) {
        this.data = new char[capacity];
    }

}
