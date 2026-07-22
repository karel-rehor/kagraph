package org.kagaka;

import java.util.Random;

public final class GeneralKit {

    public static final int ID_LENGTH = 16;

    private GeneralKit() {
    }

    public static String genHexId(final int length) {
        Random r = new Random();
        StringBuffer sb = new StringBuffer();
        while (sb.length() < length) {
            sb.append(Integer.toHexString(r.nextInt()));
        }

        return sb.substring(0, length);
    }

}
