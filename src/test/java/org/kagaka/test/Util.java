package org.kagaka.test;

import java.util.regex.Pattern;

public final class Util {

    private Util() {

    }

    public static Pattern defaultIdPattern = Pattern.compile("^[0-9a-fA-f]{16}$");

}
