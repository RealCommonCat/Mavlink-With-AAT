package site.synocordial.aat;
import com.MAVLink.MAVLinkPacket;
import com.MAVLink.MavlinkModule;
import com.fazecast.jSerialComm.SerialPort;

import java.io.UnsupportedEncodingException;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

import static com.MAVLink.common.msg_gps_raw_int.MAVLINK_MSG_ID_GPS_RAW_INT;

public class AAT implements MavlinkModule {
    // PWM range
    public static final int LOWER_RANGE=500,HIGHER_RANGE=2500;
    private double currentAlpha,currentBeta;
    private double deltaAlpha=0.1,deltaBeta=0.1;
    private SerialPort port;
    public static void printUnsignedByteArray(byte[] byteArray) {
        for (byte b : byteArray) {
            System.out.printf("%02X ", b);
        }
        System.out.println();
    }

    public AAT(double currentAlpha, double currentBeta) {
        this.currentAlpha = currentAlpha;
        this.currentBeta = currentBeta;

    }

    public static byte[] intToByteArray(int value) {
        return new byte[] {
                (byte) ((value >> 24) & 0xFF),
                (byte) ((value >> 16) & 0xFF),
                (byte) ((value >> 8) & 0xFF),
                (byte) (value & 0xFF)
        };
    }

    public void rotate(double alpha, double beta){
        currentAlpha=alpha%360;
        currentBeta=beta%360;
        int alphaInt=(int)((currentAlpha)/360*(HIGHER_RANGE-LOWER_RANGE)+LOWER_RANGE);
        int betaInt=(int)((currentBeta)/360*(HIGHER_RANGE-LOWER_RANGE)+LOWER_RANGE);
        byte[] a0=intToByteArray(alphaInt);
        byte[] b0=intToByteArray(betaInt);
        byte[]send={0,0,a0[2],a0[3],b0[2],b0[3],0,0,0,0};
        port.writeBytes(send,10);
    }

    public double getCurrentAlpha() {
        return currentAlpha;
    }

    public double getCurrentBeta() {
        return currentBeta;
    }

    public double getDeltaAlpha() {
        return deltaAlpha;
    }

    public double getDeltaBeta() {
        return deltaBeta;
    }

    public void connectToAAT(String comPort){
        if(comPort==null){
            System.out.println("未找到AAT");
            return;
        }
        SerialPort com=SerialPort.getCommPort(comPort);
        com.openPort();
        System.out.println("成功连接到AAT");
        this.port=com;
        this.port.setBaudRate(115200);
    }

    public String toString(){
        return "alpha:"+currentAlpha+" beta:"+currentBeta;
    }

    public String getPort() throws UnsupportedEncodingException {
        SerialPort[] serialPorts = SerialPort.getCommPorts();
        byte[] buffer = new byte[1024];
        for(SerialPort port:serialPorts){
            if(port.openPort()){
                int len=port.readBytes(buffer, buffer.length);
                String str=new String(buffer,0,len, StandardCharsets.UTF_8);
                port.closePort();
                if(str.contains("AAT")){
                    return port.getSystemPortName();
                }
            }
        }
        return null;
    }

    // get position
    public double[] getPosition(){
        return null;
    }

    public double[] getPosture(){
        return null;
    }

    @Override
    public void init() {
        try {
            connectToAAT(getPort());
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void processMavlinkPacket(MAVLinkPacket mavLinkPacket) {

        if(mavLinkPacket.unpack().msgid==MAVLINK_MSG_ID_GPS_RAW_INT){
            ByteBuffer buffer=mavLinkPacket.payload.getData();
            int rawTimeMil=buffer.getInt();
            int rawLat=buffer.getInt();
            int rawLon=buffer.getInt();
            int rawAlt=buffer.getInt();
            double time=rawTimeMil/1000.0;
            double lat=rawLat/10000000.0;
            double lon=rawLon/10000000.0;
            double alt=rawAlt/1000.0;
            double[] currentPos=getPosition();

        }
    }

    @Override
    public void stop() {
        port.closePort();
    }
}
