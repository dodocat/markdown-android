package org.quanqi.markdroid;

import org.quanqi.markdroid.core.DataCharBuffer;
import org.quanqi.markdroid.core.IndexBuffer;

/**
 * Created by cindy on 8/15/14.
 */
public class Parser {
    private int position;
    private int elementIndex;
    private int stateIndex;
    private byte[] stateStack = new byte[256];

    public static final byte STATE_HEADER = 1;
    public static final byte STATE_TAB = 2;
    public static final byte STATE_NO_LIST = 3;

    public void parse(DataCharBuffer buffer, IndexBuffer indexBuffer) {


    }
}
