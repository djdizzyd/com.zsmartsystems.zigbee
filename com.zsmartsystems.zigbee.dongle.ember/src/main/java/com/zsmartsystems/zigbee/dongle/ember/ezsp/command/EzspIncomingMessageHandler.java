/**
 * Copyright (c) 2016-2017 by the respective copyright holders.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package com.zsmartsystems.zigbee.dongle.ember.ezsp.command;

import com.zsmartsystems.zigbee.dongle.ember.ezsp.EzspFrameResponse;
import com.zsmartsystems.zigbee.dongle.ember.ezsp.structure.EmberApsFrame;
import com.zsmartsystems.zigbee.dongle.ember.ezsp.structure.EmberIncomingMessageType;

/**
 * Class to implement the Ember EZSP command <b>incomingMessageHandler</b>.
 * <p>
 * A callback indicating a message has been received.
 * <p>
 * This class provides methods for processing EZSP commands.
 * <p>
 * Note that this code is autogenerated. Manual changes may be overwritten.
 *
 * @author Chris Jackson - Initial contribution of Java code generator
 */
public class EzspIncomingMessageHandler extends EzspFrameResponse {
    public static int FRAME_ID = 0x45;

    /**
     * The type of the incoming message. One of the following: EMBER_INCOMING_UNICAST,
     * EMBER_INCOMING_UNICAST_REPLY, EMBER_INCOMING_MULTICAST,
     * EMBER_INCOMING_MULTICAST_LOOPBACK, EMBER_INCOMING_BROADCAST,
     * EMBER_INCOMING_BROADCAST_LOOPBACK
     * <p>
     * EZSP type is <i>EmberIncomingMessageType</i> - Java type is {@link EmberIncomingMessageType}
     */
    private EmberIncomingMessageType type;

    /**
     * The APS frame for the message.
     * <p>
     * EZSP type is <i>EmberApsFrame</i> - Java type is {@link EmberApsFrame}
     */
    private EmberApsFrame apsFrame;

    /**
     * The link quality from the node that last relayed the message.
     * <p>
     * EZSP type is <i>uint8_t</i> - Java type is {@link int}
     */
    private int lastHopLqi;

    /**
     * The energy level (in units of dBm) observed during the reception.
     * <p>
     * EZSP type is <i>int8s</i> - Java type is {@link int}
     */
    private int lastHopRssi;

    /**
     * The sender of the message.
     * <p>
     * EZSP type is <i>EmberNodeId</i> - Java type is {@link int}
     */
    private int sender;

    /**
     * The index of a binding that matches the message or 0xFF if there is no matching binding.
     * <p>
     * EZSP type is <i>uint8_t</i> - Java type is {@link int}
     */
    private int bindingIndex;

    /**
     * The index of the entry in the address table that matches the sender of the message or 0xFF if
     * there is no matching entry.
     * <p>
     * EZSP type is <i>uint8_t</i> - Java type is {@link int}
     */
    private int addressIndex;

    /**
     * The incoming message.
     * <p>
     * EZSP type is <i>uint8_t[]</i> - Java type is {@link int[]}
     */
    private int[] messageContents;

    /**
     * Response and Handler constructor
     */
    public EzspIncomingMessageHandler(int[] inputBuffer) {
        // Super creates deserializer and reads header fields
        super(inputBuffer);

        // Deserialize the fields
        type = deserializer.deserializeEmberIncomingMessageType();
        apsFrame = deserializer.deserializeEmberApsFrame();
        lastHopLqi = deserializer.deserializeUInt8();
        lastHopRssi = deserializer.deserializeInt8S();
        sender = deserializer.deserializeUInt16();
        bindingIndex = deserializer.deserializeUInt8();
        addressIndex = deserializer.deserializeUInt8();
        int messageLength = deserializer.deserializeUInt8();
        messageContents= deserializer.deserializeUInt8Array(messageLength);
    }

    /**
     * The type of the incoming message. One of the following: EMBER_INCOMING_UNICAST,
     * EMBER_INCOMING_UNICAST_REPLY, EMBER_INCOMING_MULTICAST,
     * EMBER_INCOMING_MULTICAST_LOOPBACK, EMBER_INCOMING_BROADCAST,
     * EMBER_INCOMING_BROADCAST_LOOPBACK
     * <p>
     * EZSP type is <i>EmberIncomingMessageType</i> - Java type is {@link EmberIncomingMessageType}
     *
     * @return the current type as {@link EmberIncomingMessageType}
     */
    public EmberIncomingMessageType getType() {
        return type;
    }

    /**
     * The type of the incoming message. One of the following: EMBER_INCOMING_UNICAST,
     * EMBER_INCOMING_UNICAST_REPLY, EMBER_INCOMING_MULTICAST,
     * EMBER_INCOMING_MULTICAST_LOOPBACK, EMBER_INCOMING_BROADCAST,
     * EMBER_INCOMING_BROADCAST_LOOPBACK
     *
     * @param type the type to set as {@link EmberIncomingMessageType}
     */
    public void setType(EmberIncomingMessageType type) {
        this.type = type;
    }

    /**
     * The APS frame for the message.
     * <p>
     * EZSP type is <i>EmberApsFrame</i> - Java type is {@link EmberApsFrame}
     *
     * @return the current apsFrame as {@link EmberApsFrame}
     */
    public EmberApsFrame getApsFrame() {
        return apsFrame;
    }

    /**
     * The APS frame for the message.
     *
     * @param apsFrame the apsFrame to set as {@link EmberApsFrame}
     */
    public void setApsFrame(EmberApsFrame apsFrame) {
        this.apsFrame = apsFrame;
    }

    /**
     * The link quality from the node that last relayed the message.
     * <p>
     * EZSP type is <i>uint8_t</i> - Java type is {@link int}
     *
     * @return the current lastHopLqi as {@link int}
     */
    public int getLastHopLqi() {
        return lastHopLqi;
    }

    /**
     * The link quality from the node that last relayed the message.
     *
     * @param lastHopLqi the lastHopLqi to set as {@link int}
     */
    public void setLastHopLqi(int lastHopLqi) {
        this.lastHopLqi = lastHopLqi;
    }

    /**
     * The energy level (in units of dBm) observed during the reception.
     * <p>
     * EZSP type is <i>int8s</i> - Java type is {@link int}
     *
     * @return the current lastHopRssi as {@link int}
     */
    public int getLastHopRssi() {
        return lastHopRssi;
    }

    /**
     * The energy level (in units of dBm) observed during the reception.
     *
     * @param lastHopRssi the lastHopRssi to set as {@link int}
     */
    public void setLastHopRssi(int lastHopRssi) {
        this.lastHopRssi = lastHopRssi;
    }

    /**
     * The sender of the message.
     * <p>
     * EZSP type is <i>EmberNodeId</i> - Java type is {@link int}
     *
     * @return the current sender as {@link int}
     */
    public int getSender() {
        return sender;
    }

    /**
     * The sender of the message.
     *
     * @param sender the sender to set as {@link int}
     */
    public void setSender(int sender) {
        this.sender = sender;
    }

    /**
     * The index of a binding that matches the message or 0xFF if there is no matching binding.
     * <p>
     * EZSP type is <i>uint8_t</i> - Java type is {@link int}
     *
     * @return the current bindingIndex as {@link int}
     */
    public int getBindingIndex() {
        return bindingIndex;
    }

    /**
     * The index of a binding that matches the message or 0xFF if there is no matching binding.
     *
     * @param bindingIndex the bindingIndex to set as {@link int}
     */
    public void setBindingIndex(int bindingIndex) {
        this.bindingIndex = bindingIndex;
    }

    /**
     * The index of the entry in the address table that matches the sender of the message or 0xFF if
     * there is no matching entry.
     * <p>
     * EZSP type is <i>uint8_t</i> - Java type is {@link int}
     *
     * @return the current addressIndex as {@link int}
     */
    public int getAddressIndex() {
        return addressIndex;
    }

    /**
     * The index of the entry in the address table that matches the sender of the message or 0xFF if
     * there is no matching entry.
     *
     * @param addressIndex the addressIndex to set as {@link int}
     */
    public void setAddressIndex(int addressIndex) {
        this.addressIndex = addressIndex;
    }

    /**
     * The incoming message.
     * <p>
     * EZSP type is <i>uint8_t[]</i> - Java type is {@link int[]}
     *
     * @return the current messageContents as {@link int[]}
     */
    public int[] getMessageContents() {
        return messageContents;
    }

    /**
     * The incoming message.
     *
     * @param messageContents the messageContents to set as {@link int[]}
     */
    public void setMessageContents(int[] messageContents) {
        this.messageContents = messageContents;
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("EzspIncomingMessageHandler [type=");
        builder.append(type);
        builder.append(", apsFrame=");
        builder.append(apsFrame);
        builder.append(", lastHopLqi=");
        builder.append(lastHopLqi);
        builder.append(", lastHopRssi=");
        builder.append(lastHopRssi);
        builder.append(", sender=");
        builder.append(sender);
        builder.append(", bindingIndex=");
        builder.append(bindingIndex);
        builder.append(", addressIndex=");
        builder.append(addressIndex);
        builder.append(", messageContents=");
        for (int c = 0; c < messageContents.length; c++) {
            if (c > 0) {
                builder.append(" ");
            }
            builder.append(String.format("%02X", messageContents[c]));
        }
        builder.append("]");
        return builder.toString();
    }
}
