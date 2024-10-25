/* AUTO-GENERATED FILE.  DO NOT MODIFY.
 *
 * This class was automatically generated by the
 * java mavlink generator tool. It should not be modified by hand.
 */

// MESSAGE MISSION_SET_CURRENT PACKING
package com.MAVLink.common;
import com.MAVLink.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPayload;
import com.MAVLink.Messages.Units;
import com.MAVLink.Messages.Description;

/**
 * 
        Set the mission item with sequence number seq as the current item and emit MISSION_CURRENT (whether or not the mission number changed).
        If a mission is currently being executed, the system will continue to this new mission item on the shortest path, skipping any intermediate mission items.
        Note that mission jump repeat counters are not reset (see MAV_CMD_DO_JUMP param2).

        This message may trigger a mission state-machine change on some systems: for example from MISSION_STATE_NOT_STARTED or MISSION_STATE_PAUSED to MISSION_STATE_ACTIVE.
        If the system is in mission mode, on those systems this command might therefore start, restart or resume the mission.
        If the system is not in mission mode this message must not trigger a switch to mission mode.
      
 */
public class msg_mission_set_current extends MAVLinkMessage {

    public static final int MAVLINK_MSG_ID_MISSION_SET_CURRENT = 41;
    public static final int MAVLINK_MSG_LENGTH = 4;
    private static final long serialVersionUID = MAVLINK_MSG_ID_MISSION_SET_CURRENT;

    
    /**
     * Sequence
     */
    @Description("Sequence")
    @Units("")
    public int seq;
    
    /**
     * System ID
     */
    @Description("System ID")
    @Units("")
    public short target_system;
    
    /**
     * Component ID
     */
    @Description("Component ID")
    @Units("")
    public short target_component;
    

    /**
     * Generates the payload for a mavlink message for a message of this type
     * @return
     */
    @Override
    public MAVLinkPacket pack() {
        MAVLinkPacket packet = new MAVLinkPacket(MAVLINK_MSG_LENGTH,isMavlink2);
        packet.sysid = sysid;
        packet.compid = compid;
        packet.msgid = MAVLINK_MSG_ID_MISSION_SET_CURRENT;

        packet.payload.putUnsignedShort(seq);
        packet.payload.putUnsignedByte(target_system);
        packet.payload.putUnsignedByte(target_component);
        
        if (isMavlink2) {
            
        }
        return packet;
    }

    /**
     * Decode a mission_set_current message into this class fields
     *
     * @param payload The message to decode
     */
    @Override
    public void unpack(MAVLinkPayload payload) {
        payload.resetIndex();

        this.seq = payload.getUnsignedShort();
        this.target_system = payload.getUnsignedByte();
        this.target_component = payload.getUnsignedByte();
        
        if (isMavlink2) {
            
        }
    }

    /**
     * Constructor for a new message, just initializes the msgid
     */
    public msg_mission_set_current() {
        this.msgid = MAVLINK_MSG_ID_MISSION_SET_CURRENT;
    }

    /**
     * Constructor for a new message, initializes msgid and all payload variables
     */
    public msg_mission_set_current( int seq, short target_system, short target_component) {
        this.msgid = MAVLINK_MSG_ID_MISSION_SET_CURRENT;

        this.seq = seq;
        this.target_system = target_system;
        this.target_component = target_component;
        
    }

    /**
     * Constructor for a new message, initializes everything
     */
    public msg_mission_set_current( int seq, short target_system, short target_component, int sysid, int compid, boolean isMavlink2) {
        this.msgid = MAVLINK_MSG_ID_MISSION_SET_CURRENT;
        this.sysid = sysid;
        this.compid = compid;
        this.isMavlink2 = isMavlink2;

        this.seq = seq;
        this.target_system = target_system;
        this.target_component = target_component;
        
    }

    /**
     * Constructor for a new message, initializes the message with the payload
     * from a mavlink packet
     *
     */
    public msg_mission_set_current(MAVLinkPacket mavLinkPacket) {
        this.msgid = MAVLINK_MSG_ID_MISSION_SET_CURRENT;

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
        return "MAVLINK_MSG_ID_MISSION_SET_CURRENT - sysid:"+sysid+" compid:"+compid+" seq:"+seq+" target_system:"+target_system+" target_component:"+target_component+"";
    }

    /**
     * Returns a human-readable string of the name of the message
     */
    @Override
    public String name() {
        return "MAVLINK_MSG_ID_MISSION_SET_CURRENT";
    }
}
        