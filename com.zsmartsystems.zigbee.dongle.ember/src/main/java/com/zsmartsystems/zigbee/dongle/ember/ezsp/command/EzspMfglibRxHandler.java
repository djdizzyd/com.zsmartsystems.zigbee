/**
 * Copyright (c) 2016-2019 by the respective copyright holders.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package com.zsmartsystems.zigbee.dongle.ember.ezsp.command;

import com.zsmartsystems.zigbee.dongle.ember.ezsp.EzspFrameResponse;

/**
 * Class to implement the Ember EZSP command <b>mfglibRxHandler</b>.
 * <p>
 * A callback indicating a packet with a valid CRC has been received.
 * <p>
 * This class provides methods for processing EZSP commands.
 * <p>
 * Note that this code is autogenerated. Manual changes may be overwritten.
 *
 * @author Chris Jackson - Initial contribution of Java code generator
 */
public class EzspMfglibRxHandler extends EzspFrameResponse {
    public static final int FRAME_ID = 0x8E;

    /**
     * The link quality observed during the reception.
     * <p>
     * EZSP type is <i>uint8_t</i> - Java type is {@link int}
     */
    private int linkQuality;

    /**
     * The energy level (in units of dBm) observed during the reception.
     * <p>
     * EZSP type is <i>int8s</i> - Java type is {@link int}
     */
    private int rssi;

    /**
     * The received packet. The last two bytes are the 16-bit CRC.
     * <p>
     * EZSP type is <i>uint8_t[]</i> - Java type is {@link int[]}
     */
    private int[] packetContents;

    /**
     * Response and Handler constructor
     */
    public EzspMfglibRxHandler(int[] inputBuffer) {
        // Super creates deserializer and reads header fields
        super(inputBuffer);

        // Deserialize the fields
        linkQuality = deserializer.deserializeUInt8();
        rssi = deserializer.deserializeInt8S();
        int packetLength = deserializer.deserializeUInt8();
        packetContents= deserializer.deserializeUInt8Array(packetLength);
    }

    /**
     * The link quality observed during the reception.
     * <p>
     * EZSP type is <i>uint8_t</i> - Java type is {@link int}
     *
     * @return the current linkQuality as {@link int}
     */
    public int getLinkQuality() {
        return linkQuality;
    }

    /**
     * The link quality observed during the reception.
     *
     * @param linkQuality the linkQuality to set as {@link int}
     */
    public void setLinkQuality(int linkQuality) {
        this.linkQuality = linkQuality;
    }

    /**
     * The energy level (in units of dBm) observed during the reception.
     * <p>
     * EZSP type is <i>int8s</i> - Java type is {@link int}
     *
     * @return the current rssi as {@link int}
     */
    public int getRssi() {
        return rssi;
    }

    /**
     * The energy level (in units of dBm) observed during the reception.
     *
     * @param rssi the rssi to set as {@link int}
     */
    public void setRssi(int rssi) {
        this.rssi = rssi;
    }

    /**
     * The received packet. The last two bytes are the 16-bit CRC.
     * <p>
     * EZSP type is <i>uint8_t[]</i> - Java type is {@link int[]}
     *
     * @return the current packetContents as {@link int[]}
     */
    public int[] getPacketContents() {
        return packetContents;
    }

    /**
     * The received packet. The last two bytes are the 16-bit CRC.
     *
     * @param packetContents the packetContents to set as {@link int[]}
     */
    public void setPacketContents(int[] packetContents) {
        this.packetContents = packetContents;
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder(122);
        builder.append("EzspMfglibRxHandler [linkQuality=");
        builder.append(linkQuality);
        builder.append(", rssi=");
        builder.append(rssi);
        builder.append(", packetContents=");
        for (int c = 0; c < packetContents.length; c++) {
            if (c > 0) {
                builder.append(' ');
            }
            builder.append(String.format("%02X", packetContents[c]));
        }
        builder.append(']');
        return builder.toString();
    }
}