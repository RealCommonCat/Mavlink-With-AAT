/* AUTO-GENERATED FILE.  DO NOT MODIFY.
 *
 * This class was automatically generated by the
 * java mavlink generator tool. It should not be modified by hand.
 */

// MESSAGE ATTITUDE_QUATERNION PACKING
package com.MAVLink.common;
import com.MAVLink.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPayload;
import com.MAVLink.Messages.Units;
import com.MAVLink.Messages.Description;

/**
 * The attitude in the aeronautical frame (right-handed, Z-down, X-front, Y-right), expressed as quaternion. Quaternion order is w, x, y, z and a zero rotation would be expressed as (1 0 0 0).
 */
public class msg_attitude_quaternion extends MAVLinkMessage {

    public static final int MAVLINK_MSG_ID_ATTITUDE_QUATERNION = 31;
    public static final int MAVLINK_MSG_LENGTH = 32;
    private static final long serialVersionUID = MAVLINK_MSG_ID_ATTITUDE_QUATERNION;

    
    /**
     * Timestamp (time since system boot).
     */
    @Description("Timestamp (time since system boot).")
    @Units("ms")
    public long time_boot_ms;
    
    /**
     * Quaternion component 1, w (1 in null-rotation)
     */
    @Description("Quaternion component 1, w (1 in null-rotation)")
    @Units("")
    public float q1;
    
    /**
     * Quaternion component 2, x (0 in null-rotation)
     */
    @Description("Quaternion component 2, x (0 in null-rotation)")
    @Units("")
    public float q2;
    
    /**
     * Quaternion component 3, y (0 in null-rotation)
     */
    @Description("Quaternion component 3, y (0 in null-rotation)")
    @Units("")
    public float q3;
    
    /**
     * Quaternion component 4, z (0 in null-rotation)
     */
    @Description("Quaternion component 4, z (0 in null-rotation)")
    @Units("")
    public float q4;
    
    /**
     * Roll angular speed
     */
    @Description("Roll angular speed")
    @Units("rad/s")
    public float rollspeed;
    
    /**
     * Pitch angular speed
     */
    @Description("Pitch angular speed")
    @Units("rad/s")
    public float pitchspeed;
    
    /**
     * Yaw angular speed
     */
    @Description("Yaw angular speed")
    @Units("rad/s")
    public float yawspeed;
    

    /**
     * Generates the payload for a mavlink message for a message of this type
     * @return
     */
    @Override
    public MAVLinkPacket pack() {
        MAVLinkPacket packet = new MAVLinkPacket(MAVLINK_MSG_LENGTH,isMavlink2);
        packet.sysid = sysid;
        packet.compid = compid;
        packet.msgid = MAVLINK_MSG_ID_ATTITUDE_QUATERNION;

        packet.payload.putUnsignedInt(time_boot_ms);
        packet.payload.putFloat(q1);
        packet.payload.putFloat(q2);
        packet.payload.putFloat(q3);
        packet.payload.putFloat(q4);
        packet.payload.putFloat(rollspeed);
        packet.payload.putFloat(pitchspeed);
        packet.payload.putFloat(yawspeed);
        
        if (isMavlink2) {
            
        }
        return packet;
    }

    /**
     * Decode a attitude_quaternion message into this class fields
     *
     * @param payload The message to decode
     */
    @Override
    public void unpack(MAVLinkPayload payload) {
        payload.resetIndex();

        this.time_boot_ms = payload.getUnsignedInt();
        this.q1 = payload.getFloat();
        this.q2 = payload.getFloat();
        this.q3 = payload.getFloat();
        this.q4 = payload.getFloat();
        this.rollspeed = payload.getFloat();
        this.pitchspeed = payload.getFloat();
        this.yawspeed = payload.getFloat();
        
        if (isMavlink2) {
            
        }
    }

    /**
     * Constructor for a new message, just initializes the msgid
     */
    public msg_attitude_quaternion() {
        this.msgid = MAVLINK_MSG_ID_ATTITUDE_QUATERNION;
    }

    /**
     * Constructor for a new message, initializes msgid and all payload variables
     */
    public msg_attitude_quaternion( long time_boot_ms, float q1, float q2, float q3, float q4, float rollspeed, float pitchspeed, float yawspeed) {
        this.msgid = MAVLINK_MSG_ID_ATTITUDE_QUATERNION;

        this.time_boot_ms = time_boot_ms;
        this.q1 = q1;
        this.q2 = q2;
        this.q3 = q3;
        this.q4 = q4;
        this.rollspeed = rollspeed;
        this.pitchspeed = pitchspeed;
        this.yawspeed = yawspeed;
        
    }

    /**
     * Constructor for a new message, initializes everything
     */
    public msg_attitude_quaternion( long time_boot_ms, float q1, float q2, float q3, float q4, float rollspeed, float pitchspeed, float yawspeed, int sysid, int compid, boolean isMavlink2) {
        this.msgid = MAVLINK_MSG_ID_ATTITUDE_QUATERNION;
        this.sysid = sysid;
        this.compid = compid;
        this.isMavlink2 = isMavlink2;

        this.time_boot_ms = time_boot_ms;
        this.q1 = q1;
        this.q2 = q2;
        this.q3 = q3;
        this.q4 = q4;
        this.rollspeed = rollspeed;
        this.pitchspeed = pitchspeed;
        this.yawspeed = yawspeed;
        
    }

    /**
     * Constructor for a new message, initializes the message with the payload
     * from a mavlink packet
     *
     */
    public msg_attitude_quaternion(MAVLinkPacket mavLinkPacket) {
        this.msgid = MAVLINK_MSG_ID_ATTITUDE_QUATERNION;

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
        return "MAVLINK_MSG_ID_ATTITUDE_QUATERNION - sysid:"+sysid+" compid:"+compid+" time_boot_ms:"+time_boot_ms+" q1:"+q1+" q2:"+q2+" q3:"+q3+" q4:"+q4+" rollspeed:"+rollspeed+" pitchspeed:"+pitchspeed+" yawspeed:"+yawspeed+"";
    }

    /**
     * Returns a human-readable string of the name of the message
     */
    @Override
    public String name() {
        return "MAVLINK_MSG_ID_ATTITUDE_QUATERNION";
    }
}
        