/* AUTO-GENERATED FILE.  DO NOT MODIFY.
 *
 * This class was automatically generated by the
 * java mavlink generator tool. It should not be modified by hand.
 */

// MESSAGE RC_CHANNELS PACKING
package com.MAVLink.common;
import com.MAVLink.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPayload;
import com.MAVLink.Messages.Units;
import com.MAVLink.Messages.Description;

/**
 * The PPM values of the RC channels received. The standard PPM modulation is as follows: 1000 microseconds: 0%, 2000 microseconds: 100%.  A value of UINT16_MAX implies the channel is unused. Individual receivers/transmitters might violate this specification.
 */
public class msg_rc_channels extends MAVLinkMessage {

    public static final int MAVLINK_MSG_ID_RC_CHANNELS = 65;
    public static final int MAVLINK_MSG_LENGTH = 42;
    private static final long serialVersionUID = MAVLINK_MSG_ID_RC_CHANNELS;

    
    /**
     * Timestamp (time since system boot).
     */
    @Description("Timestamp (time since system boot).")
    @Units("ms")
    public long time_boot_ms;
    
    /**
     * RC channel 1 value.
     */
    @Description("RC channel 1 value.")
    @Units("us")
    public int chan1_raw;
    
    /**
     * RC channel 2 value.
     */
    @Description("RC channel 2 value.")
    @Units("us")
    public int chan2_raw;
    
    /**
     * RC channel 3 value.
     */
    @Description("RC channel 3 value.")
    @Units("us")
    public int chan3_raw;
    
    /**
     * RC channel 4 value.
     */
    @Description("RC channel 4 value.")
    @Units("us")
    public int chan4_raw;
    
    /**
     * RC channel 5 value.
     */
    @Description("RC channel 5 value.")
    @Units("us")
    public int chan5_raw;
    
    /**
     * RC channel 6 value.
     */
    @Description("RC channel 6 value.")
    @Units("us")
    public int chan6_raw;
    
    /**
     * RC channel 7 value.
     */
    @Description("RC channel 7 value.")
    @Units("us")
    public int chan7_raw;
    
    /**
     * RC channel 8 value.
     */
    @Description("RC channel 8 value.")
    @Units("us")
    public int chan8_raw;
    
    /**
     * RC channel 9 value.
     */
    @Description("RC channel 9 value.")
    @Units("us")
    public int chan9_raw;
    
    /**
     * RC channel 10 value.
     */
    @Description("RC channel 10 value.")
    @Units("us")
    public int chan10_raw;
    
    /**
     * RC channel 11 value.
     */
    @Description("RC channel 11 value.")
    @Units("us")
    public int chan11_raw;
    
    /**
     * RC channel 12 value.
     */
    @Description("RC channel 12 value.")
    @Units("us")
    public int chan12_raw;
    
    /**
     * RC channel 13 value.
     */
    @Description("RC channel 13 value.")
    @Units("us")
    public int chan13_raw;
    
    /**
     * RC channel 14 value.
     */
    @Description("RC channel 14 value.")
    @Units("us")
    public int chan14_raw;
    
    /**
     * RC channel 15 value.
     */
    @Description("RC channel 15 value.")
    @Units("us")
    public int chan15_raw;
    
    /**
     * RC channel 16 value.
     */
    @Description("RC channel 16 value.")
    @Units("us")
    public int chan16_raw;
    
    /**
     * RC channel 17 value.
     */
    @Description("RC channel 17 value.")
    @Units("us")
    public int chan17_raw;
    
    /**
     * RC channel 18 value.
     */
    @Description("RC channel 18 value.")
    @Units("us")
    public int chan18_raw;
    
    /**
     * Total number of RC channels being received. This can be larger than 18, indicating that more channels are available but not given in this message. This value should be 0 when no RC channels are available.
     */
    @Description("Total number of RC channels being received. This can be larger than 18, indicating that more channels are available but not given in this message. This value should be 0 when no RC channels are available.")
    @Units("")
    public short chancount;
    
    /**
     * Receive signal strength indicator in device-dependent units/scale. Values: [0-254], UINT8_MAX: invalid/unknown.
     */
    @Description("Receive signal strength indicator in device-dependent units/scale. Values: [0-254], UINT8_MAX: invalid/unknown.")
    @Units("")
    public short rssi;
    

    /**
     * Generates the payload for a mavlink message for a message of this type
     * @return
     */
    @Override
    public MAVLinkPacket pack() {
        MAVLinkPacket packet = new MAVLinkPacket(MAVLINK_MSG_LENGTH,isMavlink2);
        packet.sysid = sysid;
        packet.compid = compid;
        packet.msgid = MAVLINK_MSG_ID_RC_CHANNELS;

        packet.payload.putUnsignedInt(time_boot_ms);
        packet.payload.putUnsignedShort(chan1_raw);
        packet.payload.putUnsignedShort(chan2_raw);
        packet.payload.putUnsignedShort(chan3_raw);
        packet.payload.putUnsignedShort(chan4_raw);
        packet.payload.putUnsignedShort(chan5_raw);
        packet.payload.putUnsignedShort(chan6_raw);
        packet.payload.putUnsignedShort(chan7_raw);
        packet.payload.putUnsignedShort(chan8_raw);
        packet.payload.putUnsignedShort(chan9_raw);
        packet.payload.putUnsignedShort(chan10_raw);
        packet.payload.putUnsignedShort(chan11_raw);
        packet.payload.putUnsignedShort(chan12_raw);
        packet.payload.putUnsignedShort(chan13_raw);
        packet.payload.putUnsignedShort(chan14_raw);
        packet.payload.putUnsignedShort(chan15_raw);
        packet.payload.putUnsignedShort(chan16_raw);
        packet.payload.putUnsignedShort(chan17_raw);
        packet.payload.putUnsignedShort(chan18_raw);
        packet.payload.putUnsignedByte(chancount);
        packet.payload.putUnsignedByte(rssi);
        
        if (isMavlink2) {
            
        }
        return packet;
    }

    /**
     * Decode a rc_channels message into this class fields
     *
     * @param payload The message to decode
     */
    @Override
    public void unpack(MAVLinkPayload payload) {
        payload.resetIndex();

        this.time_boot_ms = payload.getUnsignedInt();
        this.chan1_raw = payload.getUnsignedShort();
        this.chan2_raw = payload.getUnsignedShort();
        this.chan3_raw = payload.getUnsignedShort();
        this.chan4_raw = payload.getUnsignedShort();
        this.chan5_raw = payload.getUnsignedShort();
        this.chan6_raw = payload.getUnsignedShort();
        this.chan7_raw = payload.getUnsignedShort();
        this.chan8_raw = payload.getUnsignedShort();
        this.chan9_raw = payload.getUnsignedShort();
        this.chan10_raw = payload.getUnsignedShort();
        this.chan11_raw = payload.getUnsignedShort();
        this.chan12_raw = payload.getUnsignedShort();
        this.chan13_raw = payload.getUnsignedShort();
        this.chan14_raw = payload.getUnsignedShort();
        this.chan15_raw = payload.getUnsignedShort();
        this.chan16_raw = payload.getUnsignedShort();
        this.chan17_raw = payload.getUnsignedShort();
        this.chan18_raw = payload.getUnsignedShort();
        this.chancount = payload.getUnsignedByte();
        this.rssi = payload.getUnsignedByte();
        
        if (isMavlink2) {
            
        }
    }

    /**
     * Constructor for a new message, just initializes the msgid
     */
    public msg_rc_channels() {
        this.msgid = MAVLINK_MSG_ID_RC_CHANNELS;
    }

    /**
     * Constructor for a new message, initializes msgid and all payload variables
     */
    public msg_rc_channels( long time_boot_ms, int chan1_raw, int chan2_raw, int chan3_raw, int chan4_raw, int chan5_raw, int chan6_raw, int chan7_raw, int chan8_raw, int chan9_raw, int chan10_raw, int chan11_raw, int chan12_raw, int chan13_raw, int chan14_raw, int chan15_raw, int chan16_raw, int chan17_raw, int chan18_raw, short chancount, short rssi) {
        this.msgid = MAVLINK_MSG_ID_RC_CHANNELS;

        this.time_boot_ms = time_boot_ms;
        this.chan1_raw = chan1_raw;
        this.chan2_raw = chan2_raw;
        this.chan3_raw = chan3_raw;
        this.chan4_raw = chan4_raw;
        this.chan5_raw = chan5_raw;
        this.chan6_raw = chan6_raw;
        this.chan7_raw = chan7_raw;
        this.chan8_raw = chan8_raw;
        this.chan9_raw = chan9_raw;
        this.chan10_raw = chan10_raw;
        this.chan11_raw = chan11_raw;
        this.chan12_raw = chan12_raw;
        this.chan13_raw = chan13_raw;
        this.chan14_raw = chan14_raw;
        this.chan15_raw = chan15_raw;
        this.chan16_raw = chan16_raw;
        this.chan17_raw = chan17_raw;
        this.chan18_raw = chan18_raw;
        this.chancount = chancount;
        this.rssi = rssi;
        
    }

    /**
     * Constructor for a new message, initializes everything
     */
    public msg_rc_channels( long time_boot_ms, int chan1_raw, int chan2_raw, int chan3_raw, int chan4_raw, int chan5_raw, int chan6_raw, int chan7_raw, int chan8_raw, int chan9_raw, int chan10_raw, int chan11_raw, int chan12_raw, int chan13_raw, int chan14_raw, int chan15_raw, int chan16_raw, int chan17_raw, int chan18_raw, short chancount, short rssi, int sysid, int compid, boolean isMavlink2) {
        this.msgid = MAVLINK_MSG_ID_RC_CHANNELS;
        this.sysid = sysid;
        this.compid = compid;
        this.isMavlink2 = isMavlink2;

        this.time_boot_ms = time_boot_ms;
        this.chan1_raw = chan1_raw;
        this.chan2_raw = chan2_raw;
        this.chan3_raw = chan3_raw;
        this.chan4_raw = chan4_raw;
        this.chan5_raw = chan5_raw;
        this.chan6_raw = chan6_raw;
        this.chan7_raw = chan7_raw;
        this.chan8_raw = chan8_raw;
        this.chan9_raw = chan9_raw;
        this.chan10_raw = chan10_raw;
        this.chan11_raw = chan11_raw;
        this.chan12_raw = chan12_raw;
        this.chan13_raw = chan13_raw;
        this.chan14_raw = chan14_raw;
        this.chan15_raw = chan15_raw;
        this.chan16_raw = chan16_raw;
        this.chan17_raw = chan17_raw;
        this.chan18_raw = chan18_raw;
        this.chancount = chancount;
        this.rssi = rssi;
        
    }

    /**
     * Constructor for a new message, initializes the message with the payload
     * from a mavlink packet
     *
     */
    public msg_rc_channels(MAVLinkPacket mavLinkPacket) {
        this.msgid = MAVLINK_MSG_ID_RC_CHANNELS;

        this.sysid = mavLinkPacket.sysid;
        this.compid = mavLinkPacket.compid;
        this.isMavlink2 = mavLinkPacket.isMavlink2;
        unpack(mavLinkPacket.payload);
    }

                                              
    /**
     * Returns a string with the MSG name and data
     */
    @Override
    public String toString() {
        return "MAVLINK_MSG_ID_RC_CHANNELS - sysid:"+sysid+" compid:"+compid+" time_boot_ms:"+time_boot_ms+" chan1_raw:"+chan1_raw+" chan2_raw:"+chan2_raw+" chan3_raw:"+chan3_raw+" chan4_raw:"+chan4_raw+" chan5_raw:"+chan5_raw+" chan6_raw:"+chan6_raw+" chan7_raw:"+chan7_raw+" chan8_raw:"+chan8_raw+" chan9_raw:"+chan9_raw+" chan10_raw:"+chan10_raw+" chan11_raw:"+chan11_raw+" chan12_raw:"+chan12_raw+" chan13_raw:"+chan13_raw+" chan14_raw:"+chan14_raw+" chan15_raw:"+chan15_raw+" chan16_raw:"+chan16_raw+" chan17_raw:"+chan17_raw+" chan18_raw:"+chan18_raw+" chancount:"+chancount+" rssi:"+rssi+"";
    }

    /**
     * Returns a human-readable string of the name of the message
     */
    @Override
    public String name() {
        return "MAVLINK_MSG_ID_RC_CHANNELS";
    }
}
        