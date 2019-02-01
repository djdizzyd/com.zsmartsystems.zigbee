/**
 * Copyright (c) 2016-2019 by the respective copyright holders.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package com.zsmartsystems.zigbee.dongle.ember.ezsp.command;

import com.zsmartsystems.zigbee.dongle.ember.ezsp.EzspFrameRequest;
import com.zsmartsystems.zigbee.dongle.ember.ezsp.structure.EmberApsFrame;
import com.zsmartsystems.zigbee.dongle.ember.internal.serializer.EzspSerializer;

/**
 * Class to implement the Ember EZSP command <b>sendBroadcast</b>.
 * <p>
 * Sends a broadcast message as per the ZigBee specification.
 * <p>
 * This class provides methods for processing EZSP commands.
 * <p>
 * Note that this code is autogenerated. Manual changes may be overwritten.
 *
 * @author Chris Jackson - Initial contribution of Java code generator
 */
public class EzspSendBroadcastRequest extends EzspFrameRequest {
    public static final int FRAME_ID = 0x36;

    /**
     * The destination to which to send the broadcast. This must be one of the three ZigBee broadcast
     * addresses.
     * <p>
     * EZSP type is <i>EmberNodeId</i> - Java type is {@link int}
     */
    private int destination;

    /**
     * The APS frame which is to be added to the message.
     * <p>
     * EZSP type is <i>EmberApsFrame</i> - Java type is {@link EmberApsFrame}
     */
    private EmberApsFrame apsFrame;

    /**
     * The message will be delivered to all nodes within radius hops of the sender. A radius of zero is
     * converted to EMBER_MAX_HOPS.
     * <p>
     * EZSP type is <i>uint8_t</i> - Java type is {@link int}
     */
    private int radius;

    /**
     * A value chosen by the Host. This value is used in the ezspMessageSentHandler response to
     * refer to this message.
     * <p>
     * EZSP type is <i>uint8_t</i> - Java type is {@link int}
     */
    private int messageTag;

    /**
     * Content of the message.
     * <p>
     * EZSP type is <i>uint8_t[]</i> - Java type is {@link int[]}
     */
    private int[] messageContents;

    /**
     * Serialiser used to serialise to binary line data
     */
    private EzspSerializer serializer;

    /**
     * Request constructor
     */
    public EzspSendBroadcastRequest() {
        frameId = FRAME_ID;
        serializer = new EzspSerializer();
    }

    /**
     * The destination to which to send the broadcast. This must be one of the three ZigBee broadcast
     * addresses.
     * <p>
     * EZSP type is <i>EmberNodeId</i> - Java type is {@link int}
     *
     * @return the current destination as {@link int}
     */
    public int getDestination() {
        return destination;
    }

    /**
     * The destination to which to send the broadcast. This must be one of the three ZigBee broadcast
     * addresses.
     *
     * @param destination the destination to set as {@link int}
     */
    public void setDestination(int destination) {
        this.destination = destination;
    }

    /**
     * The APS frame which is to be added to the message.
     * <p>
     * EZSP type is <i>EmberApsFrame</i> - Java type is {@link EmberApsFrame}
     *
     * @return the current apsFrame as {@link EmberApsFrame}
     */
    public EmberApsFrame getApsFrame() {
        return apsFrame;
    }

    /**
     * The APS frame which is to be added to the message.
     *
     * @param apsFrame the apsFrame to set as {@link EmberApsFrame}
     */
    public void setApsFrame(EmberApsFrame apsFrame) {
        this.apsFrame = apsFrame;
    }

    /**
     * The message will be delivered to all nodes within radius hops of the sender. A radius of zero is
     * converted to EMBER_MAX_HOPS.
     * <p>
     * EZSP type is <i>uint8_t</i> - Java type is {@link int}
     *
     * @return the current radius as {@link int}
     */
    public int getRadius() {
        return radius;
    }

    /**
     * The message will be delivered to all nodes within radius hops of the sender. A radius of zero is
     * converted to EMBER_MAX_HOPS.
     *
     * @param radius the radius to set as {@link int}
     */
    public void setRadius(int radius) {
        this.radius = radius;
    }

    /**
     * A value chosen by the Host. This value is used in the ezspMessageSentHandler response to
     * refer to this message.
     * <p>
     * EZSP type is <i>uint8_t</i> - Java type is {@link int}
     *
     * @return the current messageTag as {@link int}
     */
    public int getMessageTag() {
        return messageTag;
    }

    /**
     * A value chosen by the Host. This value is used in the ezspMessageSentHandler response to
     * refer to this message.
     *
     * @param messageTag the messageTag to set as {@link int}
     */
    public void setMessageTag(int messageTag) {
        this.messageTag = messageTag;
    }

    /**
     * Content of the message.
     * <p>
     * EZSP type is <i>uint8_t[]</i> - Java type is {@link int[]}
     *
     * @return the current messageContents as {@link int[]}
     */
    public int[] getMessageContents() {
        return messageContents;
    }

    /**
     * Content of the message.
     *
     * @param messageContents the messageContents to set as {@link int[]}
     */
    public void setMessageContents(int[] messageContents) {
        this.messageContents = messageContents;
    }

    @Override
    public int[] serialize() {
        // Serialize the header
        serializeHeader(serializer);

        // Serialize the fields
        serializer.serializeUInt16(destination);
        serializer.serializeEmberApsFrame(apsFrame);
        serializer.serializeUInt8(radius);
        serializer.serializeUInt8(messageTag);
        serializer.serializeUInt8(messageContents.length);
        serializer.serializeUInt8Array(messageContents);
        return serializer.getPayload();
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder(177);
        builder.append("EzspSendBroadcastRequest [destination=");
        builder.append(destination);
        builder.append(", apsFrame=");
        builder.append(apsFrame);
        builder.append(", radius=");
        builder.append(radius);
        builder.append(", messageTag=");
        builder.append(String.format("%02X", messageTag));
        builder.append(", messageContents=");
        for (int c = 0; c < messageContents.length; c++) {
            if (c > 0) {
                builder.append(' ');
            }
            builder.append(String.format("%02X", messageContents[c]));
        }
        builder.append(']');
        return builder.toString();
    }
}
