/**
 * Copyright (c) 2016-2019 by the respective copyright holders.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package com.zsmartsystems.zigbee.dongle.ember.ezsp.command;

import com.zsmartsystems.zigbee.IeeeAddress;
import com.zsmartsystems.zigbee.dongle.ember.ezsp.EzspFrameResponse;
import com.zsmartsystems.zigbee.dongle.ember.ezsp.structure.EmberStatus;

/**
 * Class to implement the Ember EZSP command <b>lookupEui64ByNodeId</b>.
 * <p>
 * Returns the EUI64 that corresponds to the specified node ID. The EUI64 is found by searching
 * through all stack tables for the specified node ID.
 * <p>
 * This class provides methods for processing EZSP commands.
 * <p>
 * Note that this code is autogenerated. Manual changes may be overwritten.
 *
 * @author Chris Jackson - Initial contribution of Java code generator
 */
public class EzspLookupEui64ByNodeIdResponse extends EzspFrameResponse {
    public static final int FRAME_ID = 0x61;

    /**
     * EMBER_SUCCESS if the EUI64 was found, EMBER_ERR_FATAL if the EUI64 is not known.
     * <p>
     * EZSP type is <i>EmberStatus</i> - Java type is {@link EmberStatus}
     */
    private EmberStatus status;

    /**
     * The EUI64 of the node to look up.
     * <p>
     * EZSP type is <i>EmberEUI64</i> - Java type is {@link IeeeAddress}
     */
    private IeeeAddress eui64;

    /**
     * Response and Handler constructor
     */
    public EzspLookupEui64ByNodeIdResponse(int[] inputBuffer) {
        // Super creates deserializer and reads header fields
        super(inputBuffer);

        // Deserialize the fields
        status = deserializer.deserializeEmberStatus();
        eui64 = deserializer.deserializeEmberEui64();
    }

    /**
     * EMBER_SUCCESS if the EUI64 was found, EMBER_ERR_FATAL if the EUI64 is not known.
     * <p>
     * EZSP type is <i>EmberStatus</i> - Java type is {@link EmberStatus}
     *
     * @return the current status as {@link EmberStatus}
     */
    public EmberStatus getStatus() {
        return status;
    }

    /**
     * EMBER_SUCCESS if the EUI64 was found, EMBER_ERR_FATAL if the EUI64 is not known.
     *
     * @param status the status to set as {@link EmberStatus}
     */
    public void setStatus(EmberStatus status) {
        this.status = status;
    }

    /**
     * The EUI64 of the node to look up.
     * <p>
     * EZSP type is <i>EmberEUI64</i> - Java type is {@link IeeeAddress}
     *
     * @return the current eui64 as {@link IeeeAddress}
     */
    public IeeeAddress getEui64() {
        return eui64;
    }

    /**
     * The EUI64 of the node to look up.
     *
     * @param eui64 the eui64 to set as {@link IeeeAddress}
     */
    public void setEui64(IeeeAddress eui64) {
        this.eui64 = eui64;
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder(84);
        builder.append("EzspLookupEui64ByNodeIdResponse [status=");
        builder.append(status);
        builder.append(", eui64=");
        builder.append(eui64);
        builder.append(']');
        return builder.toString();
    }
}
