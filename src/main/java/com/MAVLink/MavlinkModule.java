package com.MAVLink;

public interface MavlinkModule {
    void init();
    void processMavlinkPacket(MAVLinkPacket mavLinkPacket);
    void stop();
}
