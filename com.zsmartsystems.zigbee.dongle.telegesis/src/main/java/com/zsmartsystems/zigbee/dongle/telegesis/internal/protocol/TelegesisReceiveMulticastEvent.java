/**
 * Copyright (c) 2016-2017 by the respective copyright holders.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package com.zsmartsystems.zigbee.dongle.telegesis.internal.protocol;

import com.zsmartsystems.zigbee.IeeeAddress;

/**
 * Class to implement the Telegesis command <b>Receive Multicast</b>.
 * <p>
 * A Multicast with XX characters has been received
		
 * <p>
 * This class provides methods for processing Telegesis AT API commands.
 * <p>
 * Note that this code is autogenerated. Manual changes may be overwritten.
 *
 * @author Chris Jackson - Initial contribution of Java code generator
 */
public class TelegesisReceiveMulticastEvent extends TelegesisFrame implements TelegesisEvent {
    /**
     * MCAST response field
     */
    private IeeeAddress remoteAddress;

    /**
     * MCAST response field
     */
    private int[] messageData;

    /**
     * MCAST response field
     */
    private Integer rssi;

    /**
     * MCAST response field
     */
    private Integer lqi;

    /**
     *
     * @return the remoteAddress as {@link IeeeAddress}
     */
    public IeeeAddress getRemoteAddress() {
        return remoteAddress;
    }

    /**
     *
     * @return the messageData as {@link int[]}
     */
    public int[] getMessageData() {
        return messageData;
    }

    /**
     *
     * @return the rssi as {@link Integer}
     */
    public Integer getRssi() {
        return rssi;
    }

    /**
     *
     * @return the lqi as {@link Integer}
     */
    public Integer getLqi() {
        return lqi;
    }


    @Override
    public void deserialize(int[] data) {
        initialiseDeserializer(data);

        // Deserialize the fields for the "MCAST" response
        if (testPrompt(data, "MCAST:")) {
            setDeserializer(6);

            // Deserialize field "remote Address" [optional]
            pushDeserializer();
            remoteAddress = deserializeIeeeAddress();
            if (remoteAddress == null) {
                popDeserializer();
            } else {
                stepDeserializer();
            }

            // Deserialize field "message Data"
            messageData = deserializeData();
            stepDeserializer();

            // Deserialize field "rssi" [optional]
            pushDeserializer();
            rssi = deserializeSInt8();
            if (rssi == null) {
                popDeserializer();
            } else {
                stepDeserializer();
            }

            // Deserialize field "lqi" [optional]
            lqi = deserializeInt8();
        }
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder(480);
        builder.append("TelegesisReceiveMulticastEvent [remoteAddress=");
        builder.append(remoteAddress);
        builder.append(", messageData=");
        for (int c = 0; c < messageData.length; c++) {
            if (c > 0) {
                builder.append(' ');
            }
            builder.append(String.format("%02X", messageData[c]));
        }
        builder.append(", rssi=");
        builder.append(rssi);
        builder.append(", lqi=");
        builder.append(lqi);
        builder.append(']');
        return builder.toString();
    }
}
