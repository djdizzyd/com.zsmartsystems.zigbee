/**
 * Copyright (c) 2016-2017 by the respective copyright holders.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package com.zsmartsystems.zigbee.dongle.ember.ezsp.command;

import com.zsmartsystems.zigbee.dongle.ember.ezsp.EzspFrameResponse;
import com.zsmartsystems.zigbee.dongle.ember.ezsp.structure.EmberStatus;

/**
 * Class to implement the Ember EZSP command <b>sendReply</b>.
 * <p>
 * Sends a reply to a received unicast message. The incomingMessageHandler callback for the
 * unicast being replied to supplies the values for all the parameters except the reply itself.
 * <p>
 * This class provides methods for processing EZSP commands.
 * <p>
 * Note that this code is autogenerated. Manual changes may be overwritten.
 *
 * @author Chris Jackson - Initial contribution of Java code generator
 */
public class EzspSendReplyResponse extends EzspFrameResponse {
    public static int FRAME_ID = 0x39;

    /**
     * An EmberStatus value. EMBER_INVALID_CALL - The EZSP_UNICAST_REPLIES_POLICY is set to
     * EZSP_HOST_WILL_NOT_SUPPLY_REPLY. This means the NCP will automatically send an empty
     * reply. The Host must change the policy to EZSP_HOST_WILL_SUPPLY_REPLY before it can supply
     * the reply. There is one exception to this rule: In the case of responses to message fragments,
     * the host must call sendReply when a message fragment is received. In this case, the policy set
     * on the NCP does not matter. The NCP expects a sendReply call from the Host for message
     * fragments regardless of the current policy settings. EMBER_NO_BUFFERS - Not enough memory
     * was available to send the reply. EMBER_NETWORK_BUSY - Either no route or insufficient
     * resources available. EMBER_SUCCESS - The reply was successfully queued for transmission.
     * <p>
     * EZSP type is <i>EmberStatus</i> - Java type is {@link EmberStatus}
     */
    private EmberStatus policyDecision;

    /**
     * Response and Handler constructor
     */
    public EzspSendReplyResponse(int[] inputBuffer) {
        // Super creates deserializer and reads header fields
        super(inputBuffer);

        // Deserialize the fields
        policyDecision = deserializer.deserializeEmberStatus();
    }

    /**
     * An EmberStatus value. EMBER_INVALID_CALL - The EZSP_UNICAST_REPLIES_POLICY is set to
     * EZSP_HOST_WILL_NOT_SUPPLY_REPLY. This means the NCP will automatically send an empty
     * reply. The Host must change the policy to EZSP_HOST_WILL_SUPPLY_REPLY before it can supply
     * the reply. There is one exception to this rule: In the case of responses to message fragments,
     * the host must call sendReply when a message fragment is received. In this case, the policy set
     * on the NCP does not matter. The NCP expects a sendReply call from the Host for message
     * fragments regardless of the current policy settings. EMBER_NO_BUFFERS - Not enough memory
     * was available to send the reply. EMBER_NETWORK_BUSY - Either no route or insufficient
     * resources available. EMBER_SUCCESS - The reply was successfully queued for transmission.
     * <p>
     * EZSP type is <i>EmberStatus</i> - Java type is {@link EmberStatus}
     *
     * @return the current policyDecision as {@link EmberStatus}
     */
    public EmberStatus getPolicyDecision() {
        return policyDecision;
    }

    /**
     * An EmberStatus value. EMBER_INVALID_CALL - The EZSP_UNICAST_REPLIES_POLICY is set to
     * EZSP_HOST_WILL_NOT_SUPPLY_REPLY. This means the NCP will automatically send an empty
     * reply. The Host must change the policy to EZSP_HOST_WILL_SUPPLY_REPLY before it can supply
     * the reply. There is one exception to this rule: In the case of responses to message fragments,
     * the host must call sendReply when a message fragment is received. In this case, the policy set
     * on the NCP does not matter. The NCP expects a sendReply call from the Host for message
     * fragments regardless of the current policy settings. EMBER_NO_BUFFERS - Not enough memory
     * was available to send the reply. EMBER_NETWORK_BUSY - Either no route or insufficient
     * resources available. EMBER_SUCCESS - The reply was successfully queued for transmission.
     *
     * @param policyDecision the policyDecision to set as {@link EmberStatus}
     */
    public void setPolicyDecision(EmberStatus policyDecision) {
        this.policyDecision = policyDecision;
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("EzspSendReplyResponse [policyDecision=");
        builder.append(policyDecision);
        builder.append("]");
        return builder.toString();
    }
}
