package site.synocordial;

import com.MAVLink.MavlinkModule;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;
import java.util.ArrayList;

public class Main {
    public Main()  {
    }

    public static void main(String[] args) {
        MavlinkResolver mavlinkResolver = new MavlinkResolver("CNCA0", "CNCB0", "COM5", 115200, new ArrayList<MavlinkModule>());
        mavlinkResolver.start();
    }
}