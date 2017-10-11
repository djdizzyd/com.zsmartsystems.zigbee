/**
 * Copyright (c) 2016-2017 by the respective copyright holders.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package com.zsmartsystems.zigbee.dongle.ember.ezsp.command;

import com.zsmartsystems.zigbee.IeeeAddress;
import com.zsmartsystems.zigbee.dongle.ember.ezsp.EzspFrameResponse;
import com.zsmartsystems.zigbee.dongle.ember.ezsp.structure.EmberDeviceUpdate;
import com.zsmartsystems.zigbee.dongle.ember.ezsp.structure.EmberJoinDecision;

/**
 * Class to implement the Ember EZSP command <b>trustCenterJoinHandler</b>.
 * <p>
 * The NCP used the trust center behavior policy to decide whether to allow a new node to join the
 * network. The Host cannot change the current decision, but it can change the policy for future
 * decisions using the setPolicy command.
 * <p>
 * This class provides methods for processing EZSP commands.
 * <p>
 * Note that this code is autogenerated. Manual changes may be overwritten.
 *
 * @author Chris Jackson - Initial contribution of Java code generator
 */
public class EzspTrustCenterJoinHandler extends EzspFrameResponse {
    public static int FRAME_ID = 0x24;

    /**
     * The Node Id of the node whose status changed.
     * <p>
     * EZSP type is <i>EmberNodeId</i> - Java type is {@link int}
     */
    private int newNodeId;

    /**
     * The EUI64 of the node whose status changed.
     * <p>
     * EZSP type is <i>EmberEUI64</i> - Java type is {@link IeeeAddress}
     */
    private IeeeAddress newNodeEui64;

    /**
     * The status of the node: Secure Join/Rejoin, Unsecure Join/Rejoin, Device left.
     * <p>
     * EZSP type is <i>EmberDeviceUpdate</i> - Java type is {@link EmberDeviceUpdate}
     */
    private EmberDeviceUpdate status;

    /**
     * An EmberJoinDecision reflecting the decision made.
     * <p>
     * EZSP type is <i>EmberJoinDecision</i> - Java type is {@link EmberJoinDecision}
     */
    private EmberJoinDecision policyDecision;

    /**
     * The parent of the node whose status has changed.
     * <p>
     * EZSP type is <i>EmberNodeId</i> - Java type is {@link int}
     */
    private int parentOfNewNodeId;

    /**
     * Response and Handler constructor
     */
    public EzspTrustCenterJoinHandler(int[] inputBuffer) {
        // Super creates deserializer and reads header fields
        super(inputBuffer);

        // Deserialize the fields
        newNodeId = deserializer.deserializeUInt16();
        newNodeEui64 = deserializer.deserializeEmberEui64();
        status = deserializer.deserializeEmberDeviceUpdate();
        policyDecision = deserializer.deserializeEmberJoinDecision();
        parentOfNewNodeId = deserializer.deserializeUInt16();
    }

    /**
     * The Node Id of the node whose status changed.
     * <p>
     * EZSP type is <i>EmberNodeId</i> - Java type is {@link int}
     *
     * @return the current newNodeId as {@link int}
     */
    public int getNewNodeId() {
        return newNodeId;
    }

    /**
     * The Node Id of the node whose status changed.
     *
     * @param newNodeId the newNodeId to set as {@link int}
     */
    public void setNewNodeId(int newNodeId) {
        this.newNodeId = newNodeId;
    }

    /**
     * The EUI64 of the node whose status changed.
     * <p>
     * EZSP type is <i>EmberEUI64</i> - Java type is {@link IeeeAddress}
     *
     * @return the current newNodeEui64 as {@link IeeeAddress}
     */
    public IeeeAddress getNewNodeEui64() {
        return newNodeEui64;
    }

    /**
     * The EUI64 of the node whose status changed.
     *
     * @param newNodeEui64 the newNodeEui64 to set as {@link IeeeAddress}
     */
    public void setNewNodeEui64(IeeeAddress newNodeEui64) {
        this.newNodeEui64 = newNodeEui64;
    }

    /**
     * The status of the node: Secure Join/Rejoin, Unsecure Join/Rejoin, Device left.
     * <p>
     * EZSP type is <i>EmberDeviceUpdate</i> - Java type is {@link EmberDeviceUpdate}
     *
     * @return the current status as {@link EmberDeviceUpdate}
     */
    public EmberDeviceUpdate getStatus() {
        return status;
    }

    /**
     * The status of the node: Secure Join/Rejoin, Unsecure Join/Rejoin, Device left.
     *
     * @param status the status to set as {@link EmberDeviceUpdate}
     */
    public void setStatus(EmberDeviceUpdate status) {
        this.status = status;
    }

    /**
     * An EmberJoinDecision reflecting the decision made.
     * <p>
     * EZSP type is <i>EmberJoinDecision</i> - Java type is {@link EmberJoinDecision}
     *
     * @return the current policyDecision as {@link EmberJoinDecision}
     */
    public EmberJoinDecision getPolicyDecision() {
        return policyDecision;
    }

    /**
     * An EmberJoinDecision reflecting the decision made.
     *
     * @param policyDecision the policyDecision to set as {@link EmberJoinDecision}
     */
    public void setPolicyDecision(EmberJoinDecision policyDecision) {
        this.policyDecision = policyDecision;
    }

    /**
     * The parent of the node whose status has changed.
     * <p>
     * EZSP type is <i>EmberNodeId</i> - Java type is {@link int}
     *
     * @return the current parentOfNewNodeId as {@link int}
     */
    public int getParentOfNewNodeId() {
        return parentOfNewNodeId;
    }

    /**
     * The parent of the node whose status has changed.
     *
     * @param parentOfNewNodeId the parentOfNewNodeId to set as {@link int}
     */
    public void setParentOfNewNodeId(int parentOfNewNodeId) {
        this.parentOfNewNodeId = parentOfNewNodeId;
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder(154);
        builder.append("EzspTrustCenterJoinHandler [newNodeId=");
        builder.append(newNodeId);
        builder.append(", newNodeEui64=");
        builder.append(newNodeEui64);
        builder.append(", status=");
        builder.append(status);
        builder.append(", policyDecision=");
        builder.append(policyDecision);
        builder.append(", parentOfNewNodeId=");
        builder.append(parentOfNewNodeId);
        builder.append(']');
        return builder.toString();
    }
}
