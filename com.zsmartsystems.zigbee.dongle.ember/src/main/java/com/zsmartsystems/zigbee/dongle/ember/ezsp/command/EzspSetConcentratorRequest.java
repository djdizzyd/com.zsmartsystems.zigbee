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
 * Class to implement the Ember EZSP command <b>setConcentrator</b>.
 *
 */
public class EzspSetConcentratorRequest extends EzspFrameRequest {
    public static int FRAME_ID = 0x10;

    private boolean on;
    private int concentratorType;
    private int minTime;
    private int maxTime;
    private int routeErrorThreshold;
    private int deliveryFailureThreshold;
    private int maxHops;

    public boolean isOn() {
        return on;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

    public int getConcentratorType() {
        return concentratorType;
    }

    public void setConcentratorType(int concentratorType) {
        this.concentratorType = concentratorType;
    }

    public int getMinTime() {
        return minTime;
    }

    public void setMinTime(int minTime) {
        this.minTime = minTime;
    }

    public int getMaxTime() {
        return maxTime;
    }

    public void setMaxTime(int maxTime) {
        this.maxTime = maxTime;
    }

    public int getRouteErrorThreshold() {
        return routeErrorThreshold;
    }

    public void setRouteErrorThreshold(int routeErrorThreshold) {
        this.routeErrorThreshold = routeErrorThreshold;
    }

    public int getDeliveryFailureThreshold() {
        return deliveryFailureThreshold;
    }

    public void setDeliveryFailureThreshold(int deliveryFailureThreshold) {
        this.deliveryFailureThreshold = deliveryFailureThreshold;
    }

    public int getMaxHops() {
        return maxHops;
    }

    public void setMaxHops(int maxHops) {
        this.maxHops = maxHops;
    }

    public EzspSerializer getSerializer() {
        return serializer;
    }

    public void setSerializer(EzspSerializer serializer) {
        this.serializer = serializer;
    }


    /**
     * Serialiser used to seialise to binary line data
     */
    private EzspSerializer serializer;

    /**
     * Request constructor
     */
    public EzspSetConcentratorRequest() {
        frameId = FRAME_ID;
        serializer = new EzspSerializer();
    }



    @Override
    public int[] serialize() {
        // Serialize the header
        serializeHeader(serializer);

        // Serialize the fields
        serializer.serializeBool(on);
        serializer.serializeUInt16(concentratorType);
        serializer.serializeUInt16(minTime);
        serializer.serializeUInt16(maxTime);
        serializer.serializeUInt8(routeErrorThreshold);
        serializer.serializeUInt8(deliveryFailureThreshold);
        serializer.serializeUInt8(maxHops);
        return serializer.getPayload();
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder(225);
        builder.append("EzspSetConcentratorRequest [on=");
        builder.append(on);
        builder.append(", concentratorType=");
        builder.append(concentratorType);
        builder.append(", minTime=");
        builder.append(minTime);
        builder.append(", maxTime=");
        builder.append(maxTime);
        builder.append(", routeErrorThreshold=");
        builder.append(routeErrorThreshold);
        builder.append(", deliveryFailureThreshold=");
        builder.append(deliveryFailureThreshold);
        builder.append(", maxHops=");
        builder.append(maxHops);
        builder.append(']');
        return builder.toString();
    }
}
