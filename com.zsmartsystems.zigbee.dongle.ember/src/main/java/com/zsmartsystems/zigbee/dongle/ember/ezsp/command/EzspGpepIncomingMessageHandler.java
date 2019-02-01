/**
 * Copyright (c) 2016-2019 by the respective copyright holders.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package com.zsmartsystems.zigbee.dongle.ember.ezsp.command;

import com.zsmartsystems.zigbee.dongle.ember.ezsp.EzspFrameResponse;
import com.zsmartsystems.zigbee.dongle.ember.ezsp.structure.EmberGpAddress;
import com.zsmartsystems.zigbee.dongle.ember.ezsp.structure.EmberGpKeyType;
import com.zsmartsystems.zigbee.dongle.ember.ezsp.structure.EmberGpSecurityLevel;
import com.zsmartsystems.zigbee.dongle.ember.ezsp.structure.EmberStatus;

/**
 * Class to implement the Ember EZSP command <b>gpepIncomingMessageHandler</b>.
 * <p>
 * A callback invoked by the ZigBee GP stack when a GPDF is received.
 * <p>
 * This class provides methods for processing EZSP commands.
 * <p>
 * Note that this code is autogenerated. Manual changes may be overwritten.
 *
 * @author Chris Jackson - Initial contribution of Java code generator
 */
public class EzspGpepIncomingMessageHandler extends EzspFrameResponse {
    public static final int FRAME_ID = 0xC5;

    /**
     * An EmberStatus value indicating success or the reason for failure.
     * <p>
     * EZSP type is <i>EmberStatus</i> - Java type is {@link EmberStatus}
     */
    private EmberStatus status;

    /**
     * The gpdLink value of the received GPDF.
     * <p>
     * EZSP type is <i>uint8_t</i> - Java type is {@link int}
     */
    private int gpdLink;

    /**
     * The GPDF sequence number.
     * <p>
     * EZSP type is <i>uint8_t</i> - Java type is {@link int}
     */
    private int sequenceNumber;

    /**
     * The address of the source GPD.
     * <p>
     * EZSP type is <i>EmberGpAddress</i> - Java type is {@link EmberGpAddress}
     */
    private EmberGpAddress addr;

    /**
     * The security level of the received GPDF.
     * <p>
     * EZSP type is <i>EmberGpSecurityLevel</i> - Java type is {@link EmberGpSecurityLevel}
     */
    private EmberGpSecurityLevel gpdfSecurityLevel;

    /**
     * The securityKeyType used to decrypt/authenticate the incoming GPDF.
     * <p>
     * EZSP type is <i>EmberGpKeyType</i> - Java type is {@link EmberGpKeyType}
     */
    private EmberGpKeyType gpdfSecurityKeyType;

    /**
     * Whether the incoming GPDF had the auto-commissioning bit set.
     * <p>
     * EZSP type is <i>bool</i> - Java type is {@link boolean}
     */
    private boolean autoCommissioning;

    /**
     * Whether the incoming GPDF had the rxAfterTx bit set.
     * <p>
     * EZSP type is <i>bool</i> - Java type is {@link boolean}
     */
    private boolean rxAfterTx;

    /**
     * The security frame counter of the incoming GDPF.
     * <p>
     * EZSP type is <i>uint32_t</i> - Java type is {@link int}
     */
    private int gpdSecurityFrameCounterLength;

    /**
     * The gpdCommandId of the incoming GPDF.
     * <p>
     * EZSP type is <i>uint8_t</i> - Java type is {@link int}
     */
    private int gpdCommandId;

    /**
     * The received MIC of the GPDF.
     * <p>
     * EZSP type is <i>uint32_t</i> - Java type is {@link int}
     */
    private int mic;

    /**
     * The proxy table index of the corresponding proxy table entry to the incoming GPDF.
     * <p>
     * EZSP type is <i>uint8_t</i> - Java type is {@link int}
     */
    private int proxyTableIndex;

    /**
     * The GPD command payload.
     * <p>
     * EZSP type is <i>uint8_t[]</i> - Java type is {@link int[]}
     */
    private int[] gpdCommandPayload;

    /**
     * Response and Handler constructor
     */
    public EzspGpepIncomingMessageHandler(int[] inputBuffer) {
        // Super creates deserializer and reads header fields
        super(inputBuffer);

        // Deserialize the fields
        status = deserializer.deserializeEmberStatus();
        gpdLink = deserializer.deserializeUInt8();
        sequenceNumber = deserializer.deserializeUInt8();
        addr = deserializer.deserializeEmberGpAddress();
        gpdfSecurityLevel = deserializer.deserializeEmberGpSecurityLevel();
        gpdfSecurityKeyType = deserializer.deserializeEmberGpKeyType();
        autoCommissioning = deserializer.deserializeBool();
        rxAfterTx = deserializer.deserializeBool();
        gpdSecurityFrameCounterLength = deserializer.deserializeUInt32();
        gpdCommandId = deserializer.deserializeUInt8();
        mic = deserializer.deserializeUInt32();
        proxyTableIndex = deserializer.deserializeUInt8();
        int gpdCommandPayloadLength = deserializer.deserializeUInt8();
        gpdCommandPayload= deserializer.deserializeUInt8Array(gpdCommandPayloadLength);
    }

    /**
     * An EmberStatus value indicating success or the reason for failure.
     * <p>
     * EZSP type is <i>EmberStatus</i> - Java type is {@link EmberStatus}
     *
     * @return the current status as {@link EmberStatus}
     */
    public EmberStatus getStatus() {
        return status;
    }

    /**
     * An EmberStatus value indicating success or the reason for failure.
     *
     * @param status the status to set as {@link EmberStatus}
     */
    public void setStatus(EmberStatus status) {
        this.status = status;
    }

    /**
     * The gpdLink value of the received GPDF.
     * <p>
     * EZSP type is <i>uint8_t</i> - Java type is {@link int}
     *
     * @return the current gpdLink as {@link int}
     */
    public int getGpdLink() {
        return gpdLink;
    }

    /**
     * The gpdLink value of the received GPDF.
     *
     * @param gpdLink the gpdLink to set as {@link int}
     */
    public void setGpdLink(int gpdLink) {
        this.gpdLink = gpdLink;
    }

    /**
     * The GPDF sequence number.
     * <p>
     * EZSP type is <i>uint8_t</i> - Java type is {@link int}
     *
     * @return the current sequenceNumber as {@link int}
     */
    public int getSequenceNumber() {
        return sequenceNumber;
    }

    /**
     * The GPDF sequence number.
     *
     * @param sequenceNumber the sequenceNumber to set as {@link int}
     */
    public void setSequenceNumber(int sequenceNumber) {
        this.sequenceNumber = sequenceNumber;
    }

    /**
     * The address of the source GPD.
     * <p>
     * EZSP type is <i>EmberGpAddress</i> - Java type is {@link EmberGpAddress}
     *
     * @return the current addr as {@link EmberGpAddress}
     */
    public EmberGpAddress getAddr() {
        return addr;
    }

    /**
     * The address of the source GPD.
     *
     * @param addr the addr to set as {@link EmberGpAddress}
     */
    public void setAddr(EmberGpAddress addr) {
        this.addr = addr;
    }

    /**
     * The security level of the received GPDF.
     * <p>
     * EZSP type is <i>EmberGpSecurityLevel</i> - Java type is {@link EmberGpSecurityLevel}
     *
     * @return the current gpdfSecurityLevel as {@link EmberGpSecurityLevel}
     */
    public EmberGpSecurityLevel getGpdfSecurityLevel() {
        return gpdfSecurityLevel;
    }

    /**
     * The security level of the received GPDF.
     *
     * @param gpdfSecurityLevel the gpdfSecurityLevel to set as {@link EmberGpSecurityLevel}
     */
    public void setGpdfSecurityLevel(EmberGpSecurityLevel gpdfSecurityLevel) {
        this.gpdfSecurityLevel = gpdfSecurityLevel;
    }

    /**
     * The securityKeyType used to decrypt/authenticate the incoming GPDF.
     * <p>
     * EZSP type is <i>EmberGpKeyType</i> - Java type is {@link EmberGpKeyType}
     *
     * @return the current gpdfSecurityKeyType as {@link EmberGpKeyType}
     */
    public EmberGpKeyType getGpdfSecurityKeyType() {
        return gpdfSecurityKeyType;
    }

    /**
     * The securityKeyType used to decrypt/authenticate the incoming GPDF.
     *
     * @param gpdfSecurityKeyType the gpdfSecurityKeyType to set as {@link EmberGpKeyType}
     */
    public void setGpdfSecurityKeyType(EmberGpKeyType gpdfSecurityKeyType) {
        this.gpdfSecurityKeyType = gpdfSecurityKeyType;
    }

    /**
     * Whether the incoming GPDF had the auto-commissioning bit set.
     * <p>
     * EZSP type is <i>bool</i> - Java type is {@link boolean}
     *
     * @return the current autoCommissioning as {@link boolean}
     */
    public boolean getAutoCommissioning() {
        return autoCommissioning;
    }

    /**
     * Whether the incoming GPDF had the auto-commissioning bit set.
     *
     * @param autoCommissioning the autoCommissioning to set as {@link boolean}
     */
    public void setAutoCommissioning(boolean autoCommissioning) {
        this.autoCommissioning = autoCommissioning;
    }

    /**
     * Whether the incoming GPDF had the rxAfterTx bit set.
     * <p>
     * EZSP type is <i>bool</i> - Java type is {@link boolean}
     *
     * @return the current rxAfterTx as {@link boolean}
     */
    public boolean getRxAfterTx() {
        return rxAfterTx;
    }

    /**
     * Whether the incoming GPDF had the rxAfterTx bit set.
     *
     * @param rxAfterTx the rxAfterTx to set as {@link boolean}
     */
    public void setRxAfterTx(boolean rxAfterTx) {
        this.rxAfterTx = rxAfterTx;
    }

    /**
     * The security frame counter of the incoming GDPF.
     * <p>
     * EZSP type is <i>uint32_t</i> - Java type is {@link int}
     *
     * @return the current gpdSecurityFrameCounterLength as {@link int}
     */
    public int getGpdSecurityFrameCounterLength() {
        return gpdSecurityFrameCounterLength;
    }

    /**
     * The security frame counter of the incoming GDPF.
     *
     * @param gpdSecurityFrameCounterLength the gpdSecurityFrameCounterLength to set as {@link int}
     */
    public void setGpdSecurityFrameCounterLength(int gpdSecurityFrameCounterLength) {
        this.gpdSecurityFrameCounterLength = gpdSecurityFrameCounterLength;
    }

    /**
     * The gpdCommandId of the incoming GPDF.
     * <p>
     * EZSP type is <i>uint8_t</i> - Java type is {@link int}
     *
     * @return the current gpdCommandId as {@link int}
     */
    public int getGpdCommandId() {
        return gpdCommandId;
    }

    /**
     * The gpdCommandId of the incoming GPDF.
     *
     * @param gpdCommandId the gpdCommandId to set as {@link int}
     */
    public void setGpdCommandId(int gpdCommandId) {
        this.gpdCommandId = gpdCommandId;
    }

    /**
     * The received MIC of the GPDF.
     * <p>
     * EZSP type is <i>uint32_t</i> - Java type is {@link int}
     *
     * @return the current mic as {@link int}
     */
    public int getMic() {
        return mic;
    }

    /**
     * The received MIC of the GPDF.
     *
     * @param mic the mic to set as {@link int}
     */
    public void setMic(int mic) {
        this.mic = mic;
    }

    /**
     * The proxy table index of the corresponding proxy table entry to the incoming GPDF.
     * <p>
     * EZSP type is <i>uint8_t</i> - Java type is {@link int}
     *
     * @return the current proxyTableIndex as {@link int}
     */
    public int getProxyTableIndex() {
        return proxyTableIndex;
    }

    /**
     * The proxy table index of the corresponding proxy table entry to the incoming GPDF.
     *
     * @param proxyTableIndex the proxyTableIndex to set as {@link int}
     */
    public void setProxyTableIndex(int proxyTableIndex) {
        this.proxyTableIndex = proxyTableIndex;
    }

    /**
     * The GPD command payload.
     * <p>
     * EZSP type is <i>uint8_t[]</i> - Java type is {@link int[]}
     *
     * @return the current gpdCommandPayload as {@link int[]}
     */
    public int[] getGpdCommandPayload() {
        return gpdCommandPayload;
    }

    /**
     * The GPD command payload.
     *
     * @param gpdCommandPayload the gpdCommandPayload to set as {@link int[]}
     */
    public void setGpdCommandPayload(int[] gpdCommandPayload) {
        this.gpdCommandPayload = gpdCommandPayload;
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder(383);
        builder.append("EzspGpepIncomingMessageHandler [status=");
        builder.append(status);
        builder.append(", gpdLink=");
        builder.append(gpdLink);
        builder.append(", sequenceNumber=");
        builder.append(sequenceNumber);
        builder.append(", addr=");
        builder.append(addr);
        builder.append(", gpdfSecurityLevel=");
        builder.append(gpdfSecurityLevel);
        builder.append(", gpdfSecurityKeyType=");
        builder.append(gpdfSecurityKeyType);
        builder.append(", autoCommissioning=");
        builder.append(autoCommissioning);
        builder.append(", rxAfterTx=");
        builder.append(rxAfterTx);
        builder.append(", gpdSecurityFrameCounterLength=");
        builder.append(gpdSecurityFrameCounterLength);
        builder.append(", gpdCommandId=");
        builder.append(gpdCommandId);
        builder.append(", mic=");
        builder.append(mic);
        builder.append(", proxyTableIndex=");
        builder.append(proxyTableIndex);
        builder.append(", gpdCommandPayload=");
        for (int c = 0; c < gpdCommandPayload.length; c++) {
            if (c > 0) {
                builder.append(' ');
            }
            builder.append(String.format("%02X", gpdCommandPayload[c]));
        }
        builder.append(']');
        return builder.toString();
    }
}
