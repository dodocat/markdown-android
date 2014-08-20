package org.quanqi.markdroid.core;

/**
 * Created by cindy on 8/15/14.
 */
public class IndexBuffer {

    public int[] positions = null;
    public int[] lengths = null;
    public byte[] types = null;
    public int count;

    public IndexBuffer() {
        this.count = 0;
    }

    public IndexBuffer(int capacity) {
        this();
        this.positions = new int[capacity];
        this.lengths = new int[capacity];
    }
    public IndexBuffer(int capacity, boolean useTypeArray) {
        this(capacity);
        this.types = new byte[capacity];
    }
}
