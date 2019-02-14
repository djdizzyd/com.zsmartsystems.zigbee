/**
 * Copyright (c) 2016-2019 by the respective copyright holders.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package com.zsmartsystems.zigbee.dongle.xbee.internal.protocol;


/**
 * Class to implement the XBee command <b>Set Scan Channels</b>.
 * <p>
 * AT Command <b>SC</b></p>Set or read the list of channels to scan. Coordinator - Bit field
 * list of channels to choose from prior to starting network. Router/End Device - Bit field list
 * of channels scanned to find a Coordinator/Router to join. Write changes to SC using the WR
 * command to preserve the SC setting if a power cycle occurs.
 * <p>
 * This class provides methods for processing XBee API commands.
 * <p>
 * Note that this code is autogenerated. Manual changes may be overwritten.
 *
 * @author Chris Jackson - Initial contribution of Java code generator
 */
public class XBeeSetScanChannelsCommand extends XBeeFrame implements XBeeCommand {
    /**
     */
    private Integer frameId;

    /**
     */
    private Integer channels;

    /**
     *
     * @param frameId the frameId to set as {@link Integer}
     */
    public void setFrameId(Integer frameId) {
        this.frameId = frameId;
    }

    /**
     *
     * @param channels the channels to set as {@link Integer}
     */
    public void setChannels(Integer channels) {
        this.channels = channels;
    }

    @Override
    public int[] serialize() {
        // Serialize the command fields
        serializeCommand(0x08);
        serializeInt8(frameId);
        serializeAtCommand("SC");
        serializeInt16(channels);

        return getPayload();
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder(386);
        // First present the command parameters...
        // Then the responses later if they are available
        builder.append("XBeeSetScanChannelsCommand [frameId=");
        builder.append(frameId);
        builder.append(", channels=");
        builder.append(channels);
        builder.append(']');
        return builder.toString();
    }
}