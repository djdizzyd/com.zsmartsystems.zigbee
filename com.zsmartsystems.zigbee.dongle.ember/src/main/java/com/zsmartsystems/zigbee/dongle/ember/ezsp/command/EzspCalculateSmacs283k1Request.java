/**
 * Copyright (c) 2016-2019 by the respective copyright holders.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package com.zsmartsystems.zigbee.dongle.ember.ezsp.command;

import com.zsmartsystems.zigbee.dongle.ember.ezsp.EzspFrameRequest;
import com.zsmartsystems.zigbee.dongle.ember.ezsp.structure.EmberCertificate283k1Data;
import com.zsmartsystems.zigbee.dongle.ember.ezsp.structure.EmberPublicKey283k1Data;
import com.zsmartsystems.zigbee.dongle.ember.internal.serializer.EzspSerializer;

/**
 * Class to implement the Ember EZSP command <b>calculateSmacs283k1</b>.
 * <p>
 * Calculates the SMAC verification keys for both the initiator and responder roles of CBKE for
 * the 283k1 ECC curve using the passed parameters and the stored public/private key pair
 * previously generated with ezspGenerateKeysRetrieveCert283k1(). It also stores the
 * unverified link key data in temporary storage on the NCP until the key establishment is
 * complete.
 * <p>
 * This class provides methods for processing EZSP commands.
 * <p>
 * Note that this code is autogenerated. Manual changes may be overwritten.
 *
 * @author Chris Jackson - Initial contribution of Java code generator
 */
public class EzspCalculateSmacs283k1Request extends EzspFrameRequest {
    public static final int FRAME_ID = 0xEA;

    /**
     * The role of this device in the Key Establishment protocol.
     * <p>
     * EZSP type is <i>bool</i> - Java type is {@link boolean}
     */
    private boolean amInitiator;

    /**
     * The key establishment partner's implicit certificate.
     * <p>
     * EZSP type is <i>EmberCertificate283k1Data</i> - Java type is {@link EmberCertificate283k1Data}
     */
    private EmberCertificate283k1Data partnerCertificate;

    /**
     * The key establishment partner's ephemeral public key
     * <p>
     * EZSP type is <i>EmberPublicKey283k1Data</i> - Java type is {@link EmberPublicKey283k1Data}
     */
    private EmberPublicKey283k1Data partnerEphemeralPublicKey;

    /**
     * Serialiser used to serialise to binary line data
     */
    private EzspSerializer serializer;

    /**
     * Request constructor
     */
    public EzspCalculateSmacs283k1Request() {
        frameId = FRAME_ID;
        serializer = new EzspSerializer();
    }

    /**
     * The role of this device in the Key Establishment protocol.
     * <p>
     * EZSP type is <i>bool</i> - Java type is {@link boolean}
     *
     * @return the current amInitiator as {@link boolean}
     */
    public boolean getAmInitiator() {
        return amInitiator;
    }

    /**
     * The role of this device in the Key Establishment protocol.
     *
     * @param amInitiator the amInitiator to set as {@link boolean}
     */
    public void setAmInitiator(boolean amInitiator) {
        this.amInitiator = amInitiator;
    }

    /**
     * The key establishment partner's implicit certificate.
     * <p>
     * EZSP type is <i>EmberCertificate283k1Data</i> - Java type is {@link EmberCertificate283k1Data}
     *
     * @return the current partnerCertificate as {@link EmberCertificate283k1Data}
     */
    public EmberCertificate283k1Data getPartnerCertificate() {
        return partnerCertificate;
    }

    /**
     * The key establishment partner's implicit certificate.
     *
     * @param partnerCertificate the partnerCertificate to set as {@link EmberCertificate283k1Data}
     */
    public void setPartnerCertificate(EmberCertificate283k1Data partnerCertificate) {
        this.partnerCertificate = partnerCertificate;
    }

    /**
     * The key establishment partner's ephemeral public key
     * <p>
     * EZSP type is <i>EmberPublicKey283k1Data</i> - Java type is {@link EmberPublicKey283k1Data}
     *
     * @return the current partnerEphemeralPublicKey as {@link EmberPublicKey283k1Data}
     */
    public EmberPublicKey283k1Data getPartnerEphemeralPublicKey() {
        return partnerEphemeralPublicKey;
    }

    /**
     * The key establishment partner's ephemeral public key
     *
     * @param partnerEphemeralPublicKey the partnerEphemeralPublicKey to set as {@link EmberPublicKey283k1Data}
     */
    public void setPartnerEphemeralPublicKey(EmberPublicKey283k1Data partnerEphemeralPublicKey) {
        this.partnerEphemeralPublicKey = partnerEphemeralPublicKey;
    }

    @Override
    public int[] serialize() {
        // Serialize the header
        serializeHeader(serializer);

        // Serialize the fields
        serializer.serializeBool(amInitiator);
        serializer.serializeEmberCertificate283k1Data(partnerCertificate);
        serializer.serializeEmberPublicKey283k1Data(partnerEphemeralPublicKey);
        return serializer.getPayload();
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder(108);
        builder.append("EzspCalculateSmacs283k1Request [amInitiator=");
        builder.append(amInitiator);
        builder.append(", partnerCertificate=");
        builder.append(partnerCertificate);
        builder.append(", partnerEphemeralPublicKey=");
        builder.append(partnerEphemeralPublicKey);
        builder.append(']');
        return builder.toString();
    }
}