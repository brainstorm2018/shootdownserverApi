package org.zerhusen;

public class TypeOfServer {

    public static final int OTHER = 0;
    public static final int WINDOWS = 1;
    public static final int LINUX = 2;
    public static final int MAC = 3;

    private static int osType = OTHER;

    private static boolean isOther = false;
    private static boolean isWindows = false;
    private static boolean isLinux = false;
    private static boolean isMac = false;

    public static final String os = System.getProperty("os.name").toLowerCase();

    public static final void getOs() {
        if (os.startsWith("windows")) {
            osType = WINDOWS;
            isWindows = true;
        } else if (os.startsWith("nux")) {
            osType = LINUX;
            isLinux = true;
        } else if (os.startsWith("darwin")) {
            osType = MAC;
            isMac = true;
        } else {
            isOther = true;
        }
    }

    public static int osType() {
        return osType;
    }

    public static boolean isOther() {
        return isOther;
    }

    public static boolean isWindows() {
        return isWindows;
    }


    public static boolean isLinux() {
        return isLinux;
    }



    public static boolean isMac() {
        return isMac;
    }


}
