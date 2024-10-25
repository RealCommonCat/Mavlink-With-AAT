package site.synocordial;

import com.MAVLink.MAVLinkPacket;
import com.MAVLink.MavlinkModule;
import com.MAVLink.Parser;
import com.fazecast.jSerialComm.SerialPort;

import java.util.Arrays;
import java.util.List;

public class MavlinkResolver {
   private Parser parser=new Parser();
   private String sendVCom,revVCom,flightCom;
   private int baudWidth;
   private boolean isRunning=false;
   private List<MavlinkModule> modules;
   private SerialPort sendPort,revPort,flightPort;
   private MavlinkThread mavlinkThread;
   private COMThread comThread;
   public MavlinkResolver(String sendVCom, String revVCom, String flightCom, int baudWidth, List<MavlinkModule> modules) {
      this.sendVCom = sendVCom;
      this.revVCom = revVCom;
      this.flightCom = flightCom;
      this.baudWidth = baudWidth;
      this.modules = modules;
      init();
   }
    public void init() {
        sendPort = SerialPort.getCommPort(sendVCom);
        revPort = SerialPort.getCommPort(revVCom);
        flightPort = SerialPort.getCommPort(flightCom);
        sendPort.setBaudRate(baudWidth);
        revPort.setBaudRate(baudWidth);
        flightPort.setBaudRate(baudWidth);
    }
    public void stop() {
        isRunning = false;
        sendPort.closePort();
        flightPort.closePort();
    }
    public void start() {
        for (MavlinkModule module : modules) {
            module.init();
        }
        sendPort.openPort();
        flightPort.openPort();
        isRunning = true;
        mavlinkThread = new MavlinkThread();
        mavlinkThread.start();
        comThread = new COMThread();
        comThread.start();
    }
    protected void processMavlinkPacket(MAVLinkPacket mavLinkPacket) {
       byte[] bytes = mavLinkPacket.encodePacket();
       System.out.println(Arrays.toString(bytes));
       sendPort.writeBytes(bytes, bytes.length);
        for (MavlinkModule module : modules) {
            module.processMavlinkPacket(mavLinkPacket);
        }
    }
    private class COMThread extends Thread {
        public void run() {
            while (isRunning) {
                byte[] buffer = new byte[1024];
                int numRead = sendPort.readBytes(buffer, buffer.length);
                if (numRead > 0) {
                    flightPort.writeBytes(buffer, numRead);
                }
            }
        }
    }
   private class MavlinkThread extends Thread {
      public void run() {
          while (isRunning){
              byte[] buffer = new byte[1024];
              int numRead = flightPort.readBytes(buffer, buffer.length);
              MAVLinkPacket packet;
                if (numRead > 0) {
                    for (int i = 0; i < numRead; i++) {
                        packet = parser.mavlink_parse_char(buffer[i] );
                        if (packet != null) {
                            processMavlinkPacket(packet);
                        }
                    }
                }
          }
      }
   }
}
