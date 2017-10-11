/**
 * Copyright (c) 2016-2017 by the respective copyright holders.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package com.zsmartsystems.zigbee.dongle.ember.ezsp.structure;

import com.zsmartsystems.zigbee.dongle.ember.ezsp.serializer.EzspDeserializer;
import com.zsmartsystems.zigbee.dongle.ember.ezsp.serializer.EzspSerializer;

/**
 * Class to implement the Ember Structure <b>EmberZigbeeNetwork</b>.
 * <p>
 * The parameters of a ZigBee network.
 * <p>
 * Note that this code is autogenerated. Manual changes may be overwritten.
 *
 * @author Chris Jackson - Initial contribution of Java code generator
 */
public class EmberZigbeeNetwork {

    /**
     * The 802.15.4 channel associated with the network.
     * <p>
     * EZSP type is <i>uint8_t</i> - Java type is {@link int}
     */
    private int channel;

    /**
     * The network's PAN identifier
     * <p>
     * EZSP type is <i>uint16_t</i> - Java type is {@link int}
     */
    private int panId;

    /**
     * The network's extended PAN identifier.
     * <p>
     * EZSP type is <i>uint8_t[8]</i> - Java type is {@link int[]}
     */
    private int[] extendedPanId;

    /**
     * Whether the network is allowing MAC associations.
     * <p>
     * EZSP type is <i>bool</i> - Java type is {@link boolean}
     */
    private boolean allowingJoin;

    /**
     * The Stack Profile associated with the network.
     * <p>
     * EZSP type is <i>uint8_t</i> - Java type is {@link int}
     */
    private int stackProfile;

    /**
     * The instance of the Network.
     * <p>
     * EZSP type is <i>uint8_t</i> - Java type is {@link int}
     */
    private int nwkUpdateId;

    /**
     * Default Constructor
     */
    public EmberZigbeeNetwork() {
    }

    public EmberZigbeeNetwork(EzspDeserializer deserializer) {
        deserialize(deserializer);
    }

    /**
     * The 802.15.4 channel associated with the network.
     * <p>
     * EZSP type is <i>uint8_t</i> - Java type is {@link int}
     *
     * @return the current channel as {@link int}
     */
    public int getChannel() {
        return channel;
    }

    /**
     * The 802.15.4 channel associated with the network.
     *
     * @param channel the channel to set as {@link int}
     */
    public void setChannel(int channel) {
        this.channel = channel;
    }

    /**
     * The network's PAN identifier
     * <p>
     * EZSP type is <i>uint16_t</i> - Java type is {@link int}
     *
     * @return the current panId as {@link int}
     */
    public int getPanId() {
        return panId;
    }

    /**
     * The network's PAN identifier
     *
     * @param panId the panId to set as {@link int}
     */
    public void setPanId(int panId) {
        this.panId = panId;
    }

    /**
     * The network's extended PAN identifier.
     * <p>
     * EZSP type is <i>uint8_t[8]</i> - Java type is {@link int[]}
     *
     * @return the current extendedPanId as {@link int[]}
     */
    public int[] getExtendedPanId() {
        return extendedPanId;
    }

    /**
     * The network's extended PAN identifier.
     *
     * @param extendedPanId the extendedPanId to set as {@link int[]}
     */
    public void setExtendedPanId(int[] extendedPanId) {
        this.extendedPanId = extendedPanId;
    }

    /**
     * Whether the network is allowing MAC associations.
     * <p>
     * EZSP type is <i>bool</i> - Java type is {@link boolean}
     *
     * @return the current allowingJoin as {@link boolean}
     */
    public boolean getAllowingJoin() {
        return allowingJoin;
    }

    /**
     * Whether the network is allowing MAC associations.
     *
     * @param allowingJoin the allowingJoin to set as {@link boolean}
     */
    public void setAllowingJoin(boolean allowingJoin) {
        this.allowingJoin = allowingJoin;
    }

    /**
     * The Stack Profile associated with the network.
     * <p>
     * EZSP type is <i>uint8_t</i> - Java type is {@link int}
     *
     * @return the current stackProfile as {@link int}
     */
    public int getStackProfile() {
        return stackProfile;
    }

    /**
     * The Stack Profile associated with the network.
     *
     * @param stackProfile the stackProfile to set as {@link int}
     */
    public void setStackProfile(int stackProfile) {
        this.stackProfile = stackProfile;
    }

    /**
     * The instance of the Network.
     * <p>
     * EZSP type is <i>uint8_t</i> - Java type is {@link int}
     *
     * @return the current nwkUpdateId as {@link int}
     */
    public int getNwkUpdateId() {
        return nwkUpdateId;
    }

    /**
     * The instance of the Network.
     *
     * @param nwkUpdateId the nwkUpdateId to set as {@link int}
     */
    public void setNwkUpdateId(int nwkUpdateId) {
        this.nwkUpdateId = nwkUpdateId;
    }

    /**
     * Serialise the contents of the EZSP structure.
     *
     * @param serializer the {@link EzspSerializer} used to serialize
     */
    public int[] serialize(EzspSerializer serializer) {
        // Serialize the fields
        serializer.serializeUInt8(channel);
        serializer.serializeUInt16(panId);
        serializer.serializeUInt8Array(extendedPanId);
        serializer.serializeBool(allowingJoin);
        serializer.serializeUInt8(stackProfile);
        serializer.serializeUInt8(nwkUpdateId);
        return serializer.getPayload();
    }

    /**
     * Deserialise the contents of the EZSP structure.
     *
     * @param deserializer the {@link EzspDeserializer} used to deserialize
     */
    public void deserialize(EzspDeserializer deserializer) {
        // Deserialize the fields
        channel = deserializer.deserializeUInt8();
        panId = deserializer.deserializeUInt16();
        extendedPanId = deserializer.deserializeUInt8Array(8);
        allowingJoin = deserializer.deserializeBool();
        stackProfile = deserializer.deserializeUInt8();
        nwkUpdateId = deserializer.deserializeUInt8();
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder(171);
        builder.append("EmberZigbeeNetwork [channel=");
        builder.append(channel);
        builder.append(", panId=");
        builder.append(panId);
        builder.append(", extendedPanId=");
        builder.append("{");
        if (extendedPanId == null) {
            builder.append("null");
        } else {
            for (int cnt = 0; cnt < extendedPanId.length; cnt++) {
                if (cnt != 0) {
                    builder.append(" ");
                }
                builder.append(String.format("%02X", extendedPanId[cnt]));
            }
        }
        builder.append("}");
        builder.append(", allowingJoin=");
        builder.append(allowingJoin);
        builder.append(", stackProfile=");
        builder.append(stackProfile);
        builder.append(", nwkUpdateId=");
        builder.append(nwkUpdateId);
        builder.append(']');
        return builder.toString();
    }
}
