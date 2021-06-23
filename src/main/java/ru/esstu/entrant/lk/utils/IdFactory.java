package ru.esstu.entrant.lk.utils;

import java.net.InetAddress;
import java.security.SecureRandom;
public class IdFactory {
    // Cached per JVM server ip
    private static String hexServerIP = null;

    // initialise the secure random instance
    private static final SecureRandom seeder = new SecureRandom();

    public static final String getGUID(Object o) {
        StringBuffer tmpBuffer = new StringBuffer(16);
        if (hexServerIP == null) {
            InetAddress localInetAddress = null;
            try {
                // get the inet address
                localInetAddress = InetAddress.getLocalHost();
            } catch (java.net.UnknownHostException uhe) {
                System.err.println(
                        "GUID: Could not get the local IP address using InetAddress.getLocalHost()!");
                // todo: find better way to get around this...
                uhe.printStackTrace();
                return null;
            }
            byte serverIP[] = localInetAddress.getAddress();
            hexServerIP = hexFormat(getInt(serverIP), 8);
        }
        String hashcode = hexFormat(System.identityHashCode(o), 8);
        tmpBuffer.append(hexServerIP);
        tmpBuffer.append(hashcode);

        long timeNow = System.currentTimeMillis();
        int timeLow = (int) timeNow & 0xFFFFFFFF;
        int node = seeder.nextInt();

        StringBuffer guid = new StringBuffer(32);
        guid.append(hexFormat(timeLow, 8));
        guid.append(tmpBuffer.toString());
        guid.append(hexFormat(node, 8));
        return guid.toString();
    }

    private static int getInt(byte bytes[]) {
        int i = 0;
        int j = 24;
        for (int k = 0; j >= 0; k++) {
            int l = bytes[k] & 0xff;
            i += l << j;
            j -= 8;
        }
        return i;
    }

    private static String hexFormat(int i, int j) {
        String s = Integer.toHexString(i);
        return padHex(s, j) + s;
    }

    private static String padHex(String s, int i) {
        StringBuffer tmpBuffer = new StringBuffer();
        if (s.length() < i) {
            for (int j = 0; j < i - s.length(); j++) {
                tmpBuffer.append('0');
            }
        }
        return tmpBuffer.toString();
    }
}
