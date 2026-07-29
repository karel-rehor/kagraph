package org.kagaka;

import java.util.Random;

/**
 * <p>GeneralKit class.</p>
 *
 * @author karl
 * @version $Id: $Id
 */
public final class GeneralKit {

    /** Constant <code>ID_LENGTH=16</code>. */
    public static final int ID_LENGTH = 16;

    private GeneralKit() {
    }

    /**
     * <p>genHexId.</p>
     *
     * @param length a int
     * @return a {@link java.lang.String} object
     */
    public static String genHexId(final int length) {
        Random r = new Random();
        StringBuffer sb = new StringBuffer();
        while (sb.length() < length) {
            sb.append(Integer.toHexString(r.nextInt()));
        }

        return sb.substring(0, length);
    }

}
