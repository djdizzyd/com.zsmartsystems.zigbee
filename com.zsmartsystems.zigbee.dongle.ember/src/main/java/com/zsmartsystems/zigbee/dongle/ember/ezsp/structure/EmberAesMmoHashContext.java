/**
 * Copyright (c) 2016-2019 by the respective copyright holders.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package com.zsmartsystems.zigbee.dongle.ember.ezsp.structure;

import com.zsmartsystems.zigbee.dongle.ember.internal.serializer.EzspDeserializer;
import com.zsmartsystems.zigbee.dongle.ember.internal.serializer.EzspSerializer;

/**
 * Class to implement the Ember Structure <b>EmberAesMmoHashContext</b>.
 * <p>
 * The hash context for an ongoing hash operation.
 * <p>
 * Note that this code is autogenerated. Manual changes may be overwritten.
 *
 * @author Chris Jackson - Initial contribution of Java code generator
 */
public class EmberAesMmoHashContext {

    /**
     * The result of ongoing the hash operation.
     * <p>
     * EZSP type is <i>uint8_t[16]</i> - Java type is {@link int[]}
     */
    private int[] result;

    /**
     * The total length of the data that has been hashed so far.
     * <p>
     * EZSP type is <i>uint32_t</i> - Java type is {@link int}
     */
    private int length;

    /**
     * Default Constructor
     */
    public EmberAesMmoHashContext() {
    }

    public EmberAesMmoHashContext(EzspDeserializer deserializer) {
        deserialize(deserializer);
    }

    /**
     * The result of ongoing the hash operation.
     * <p>
     * EZSP type is <i>uint8_t[16]</i> - Java type is {@link int[]}
     *
     * @return the current result as {@link int[]}
     */
    public int[] getResult() {
        return result;
    }

    /**
     * The result of ongoing the hash operation.
     *
     * @param result the result to set as {@link int[]}
     */
    public void setResult(int[] result) {
        this.result = result;
    }

    /**
     * The total length of the data that has been hashed so far.
     * <p>
     * EZSP type is <i>uint32_t</i> - Java type is {@link int}
     *
     * @return the current length as {@link int}
     */
    public int getLength() {
        return length;
    }

    /**
     * The total length of the data that has been hashed so far.
     *
     * @param length the length to set as {@link int}
     */
    public void setLength(int length) {
        this.length = length;
    }

    /**
     * Serialise the contents of the EZSP structure.
     *
     * @param serializer the {@link EzspSerializer} used to serialize
     */
    public int[] serialize(EzspSerializer serializer) {
        // Serialize the fields
        serializer.serializeUInt8Array(result);
        serializer.serializeUInt32(length);
        return serializer.getPayload();
    }

    /**
     * Deserialise the contents of the EZSP structure.
     *
     * @param deserializer the {@link EzspDeserializer} used to deserialize
     */
    public void deserialize(EzspDeserializer deserializer) {
        // Deserialize the fields
        result = deserializer.deserializeUInt8Array(16);
        length = deserializer.deserializeUInt32();
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder(75);
        builder.append("EmberAesMmoHashContext [result=");
        builder.append('{');
        if (result == null) {
            builder.append("null");
        } else {
            for (int cnt = 0; cnt < result.length; cnt++) {
                if (cnt != 0) {
                    builder.append(' ');
                }
                builder.append(String.format("%02X", result[cnt]));
            }
        }
        builder.append('}');
        builder.append(", length=");
        builder.append(length);
        builder.append(']');
        return builder.toString();
    }
}
