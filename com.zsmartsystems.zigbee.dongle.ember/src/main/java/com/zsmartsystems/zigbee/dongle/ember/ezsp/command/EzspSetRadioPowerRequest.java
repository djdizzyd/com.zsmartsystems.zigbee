/**
 * Copyright (c) 2016-2017 by the respective copyright holders.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package com.zsmartsystems.zigbee.dongle.ember.ezsp.command;

import com.zsmartsystems.zigbee.dongle.ember.ezsp.EzspFrameRequest;
import com.zsmartsystems.zigbee.dongle.ember.ezsp.serializer.EzspSerializer;

/**
 * Class to implement the Ember EZSP command <b>setRadioPower</b>.
 * <p>
 * Sets the radio output power at which a node is operating. Ember radios have discrete power settings. For a list of
 * available power settings, see the technical specification for the RF communication module in your Developer Kit.
 * <p>
 * <b>Note:</b> Care should
 * be taken when using this API on a running network, as it will directly impact the established link qualities
 * neighboring nodes have with the node on which it is called. This can lead to disruption of existing routes and
 * erratic network behavior.
 * <p>
 * This class provides methods for processing EZSP commands.
 * <p>
 *
 * @author Charles Schwer
 */
public class EzspSetRadioPowerRequest extends EzspFrameRequest {
    public static int FRAME_ID = 0x99;

    /**
     * Desired radio output power, in dBm
     * <p>
     * EZSP type is <i>int8s</i> - Java type is {@link int}
     */
    private int power;

    /**
     * Serialiser used to seialise to binary line data
     */
    private EzspSerializer serializer;

    /**
     * Request constructor
     */
    public EzspSetRadioPowerRequest() {
        frameId = FRAME_ID;
        serializer = new EzspSerializer();
    }

    /**
     * Desired radio output power.
     * <p>
     * EZSP type is <i>uint8_t</i> - Java type is {@link int}
     *
     * @return the current channel as {@link int}
     */
    public int getPower() {
        return power;
    }

    /**
     * Desired radio output power.
     *
     * @param power the power level to set as {@link int}
     */
    public void setPower(int power) {
        this.power = power;
    }

    @Override
    public int[] serialize() {
        // Serialize the header
        serializeHeader(serializer);

        // Serialize the fields
        serializer.serializeInt8S(power);
        return serializer.getPayload();
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder(54);
        builder.append("EzspSetRadioChannelRequest [power=");
        builder.append(power);
        builder.append(']');
        return builder.toString();
    }
}