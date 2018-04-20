/**
 * Copyright (c) 2016-2018 by the respective copyright holders.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package com.zsmartsystems.zigbee.dongle.ember.internal.ezsp.command;

import com.zsmartsystems.zigbee.IeeeAddress;
import com.zsmartsystems.zigbee.dongle.ember.internal.ezsp.EzspFrameRequest;
import com.zsmartsystems.zigbee.dongle.ember.internal.ezsp.serializer.EzspSerializer;

/**
 * Class to implement the Ember EZSP command <b>getExtendedTimeout</b>.
 * <p>
 * Indicates whether or not the stack will extend the normal interval between retransmissions
 * of a retried unicast message by EMBER_INDIRECT_TRANSMISSION_TIMEOUT.
 * <p>
 * This class provides methods for processing EZSP commands.
 * <p>
 * Note that this code is autogenerated. Manual changes may be overwritten.
 *
 * @author Chris Jackson - Initial contribution of Java code generator
 */
public class EzspGetExtendedTimeoutRequest extends EzspFrameRequest {
    public static final int FRAME_ID = 0x7F;

    /**
     * The address of the node for which the timeout is to be returned.
     * <p>
     * EZSP type is <i>EmberEUI64</i> - Java type is {@link IeeeAddress}
     */
    private IeeeAddress remoteEui64;

    /**
     * Serialiser used to seialise to binary line data
     */
    private EzspSerializer serializer;

    /**
     * Request constructor
     */
    public EzspGetExtendedTimeoutRequest() {
        frameId = FRAME_ID;
        serializer = new EzspSerializer();
    }

    /**
     * The address of the node for which the timeout is to be returned.
     * <p>
     * EZSP type is <i>EmberEUI64</i> - Java type is {@link IeeeAddress}
     *
     * @return the current remoteEui64 as {@link IeeeAddress}
     */
    public IeeeAddress getRemoteEui64() {
        return remoteEui64;
    }

    /**
     * The address of the node for which the timeout is to be returned.
     *
     * @param remoteEui64 the remoteEui64 to set as {@link IeeeAddress}
     */
    public void setRemoteEui64(IeeeAddress remoteEui64) {
        this.remoteEui64 = remoteEui64;
    }

    @Override
    public int[] serialize() {
        // Serialize the header
        serializeHeader(serializer);

        // Serialize the fields
        serializer.serializeEmberEui64(remoteEui64);
        return serializer.getPayload();
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder(57);
        builder.append("EzspGetExtendedTimeoutRequest [remoteEui64=");
        builder.append(remoteEui64);
        builder.append(']');
        return builder.toString();
    }
}