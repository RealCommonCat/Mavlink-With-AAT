/* AUTO-GENERATED FILE.  DO NOT MODIFY.
 *
 * This class was automatically generated by the
 * java mavlink generator tool. It should not be modified by hand.
 */

// MESSAGE COMMAND_ACK PACKING
package com.MAVLink.common;
import com.MAVLink.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.MAVLinkPayload;
import com.MAVLink.Messages.Units;
import com.MAVLink.Messages.Description;

/**
 * Report status of a command. Includes feedback whether the command was executed. The command microservice is documented at https://mavlink.io/en/services/command.html
 */
public class msg_command_ack extends MAVLinkMessage {

    public static final int MAVLINK_MSG_ID_COMMAND_ACK = 77;
    public static final int MAVLINK_MSG_LENGTH = 3;
    private static final long serialVersionUID = MAVLINK_MSG_ID_COMMAND_ACK;

    
    /**
     * Command ID (of acknowledged command).
     */
    @Description("Command ID (of acknowledged command).")
    @Units("")
    public int command;
    
    /**
     * Result of command.
     */
    @Description("Result of command.")
    @Units("")
    public short result;
    

    /**
     * Generates the payload for a mavlink message for a message of this type
     * @return
     */
    @Override
    public MAVLinkPacket pack() {
        MAVLinkPacket packet = new MAVLinkPacket(MAVLINK_MSG_LENGTH,isMavlink2);
        packet.sysid = sysid;
        packet.compid = compid;
        packet.msgid = MAVLINK_MSG_ID_COMMAND_ACK;

        packet.payload.putUnsignedShort(command);
        packet.payload.putUnsignedByte(result);
        
        if (isMavlink2) {
            
        }
        return packet;
    }

    /**
     * Decode a command_ack message into this class fields
     *
     * @param payload The message to decode
     */
    @Override
    public void unpack(MAVLinkPayload payload) {
        payload.resetIndex();

        this.command = payload.getUnsignedShort();
        this.result = payload.getUnsignedByte();
        
        if (isMavlink2) {
            
        }
    }

    /**
     * Constructor for a new message, just initializes the msgid
     */
    public msg_command_ack() {
        this.msgid = MAVLINK_MSG_ID_COMMAND_ACK;
    }

    /**
     * Constructor for a new message, initializes msgid and all payload variables
     */
    public msg_command_ack( int command, short result) {
        this.msgid = MAVLINK_MSG_ID_COMMAND_ACK;

        this.command = command;
        this.result = result;
        
    }

    /**
     * Constructor for a new message, initializes everything
     */
    public msg_command_ack( int command, short result, int sysid, int compid, boolean isMavlink2) {
        this.msgid = MAVLINK_MSG_ID_COMMAND_ACK;
        this.sysid = sysid;
        this.compid = compid;
        this.isMavlink2 = isMavlink2;

        this.command = command;
        this.result = result;
        
    }

    /**
     * Constructor for a new message, initializes the message with the payload
     * from a mavlink packet
     *
     */
    public msg_command_ack(MAVLinkPacket mavLinkPacket) {
        this.msgid = MAVLINK_MSG_ID_COMMAND_ACK;

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
        return "MAVLINK_MSG_ID_COMMAND_ACK - sysid:"+sysid+" compid:"+compid+" command:"+command+" result:"+result+"";
    }

    /**
     * Returns a human-readable string of the name of the message
     */
    @Override
    public String name() {
        return "MAVLINK_MSG_ID_COMMAND_ACK";
    }
}
        