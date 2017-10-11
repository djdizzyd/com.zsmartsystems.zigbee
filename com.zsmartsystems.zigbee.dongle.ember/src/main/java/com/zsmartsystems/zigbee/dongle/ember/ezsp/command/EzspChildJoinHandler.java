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
import com.zsmartsystems.zigbee.dongle.ember.ezsp.structure.EmberNodeType;

/**
 * Class to implement the Ember EZSP command <b>childJoinHandler</b>.
 * <p>
 * Indicates that a child has joined or left.
 * <p>
 * This class provides methods for processing EZSP commands.
 * <p>
 * Note that this code is autogenerated. Manual changes may be overwritten.
 *
 * @author Chris Jackson - Initial contribution of Java code generator
 */
public class EzspChildJoinHandler extends EzspFrameResponse {
    public static int FRAME_ID = 0x23;

    /**
     * The index of the child of interest.
     * <p>
     * EZSP type is <i>uint8_t</i> - Java type is {@link int}
     */
    private int index;

    /**
     * True if the child is joining. False the child is leaving.
     * <p>
     * EZSP type is <i>bool</i> - Java type is {@link boolean}
     */
    private boolean joining;

    /**
     * The node ID of the child.
     * <p>
     * EZSP type is <i>EmberNodeId</i> - Java type is {@link int}
     */
    private int childId;

    /**
     * The EUI64 of the child.
     * <p>
     * EZSP type is <i>EmberEUI64</i> - Java type is {@link IeeeAddress}
     */
    private IeeeAddress childEui64;

    /**
     * The node type of the child.
     * <p>
     * EZSP type is <i>EmberNodeType</i> - Java type is {@link EmberNodeType}
     */
    private EmberNodeType childType;

    /**
     * Response and Handler constructor
     */
    public EzspChildJoinHandler(int[] inputBuffer) {
        // Super creates deserializer and reads header fields
        super(inputBuffer);

        // Deserialize the fields
        index = deserializer.deserializeUInt8();
        joining = deserializer.deserializeBool();
        childId = deserializer.deserializeUInt16();
        childEui64 = deserializer.deserializeEmberEui64();
        childType = deserializer.deserializeEmberNodeType();
    }

    /**
     * The index of the child of interest.
     * <p>
     * EZSP type is <i>uint8_t</i> - Java type is {@link int}
     *
     * @return the current index as {@link int}
     */
    public int getIndex() {
        return index;
    }

    /**
     * The index of the child of interest.
     *
     * @param index the index to set as {@link int}
     */
    public void setIndex(int index) {
        this.index = index;
    }

    /**
     * True if the child is joining. False the child is leaving.
     * <p>
     * EZSP type is <i>bool</i> - Java type is {@link boolean}
     *
     * @return the current joining as {@link boolean}
     */
    public boolean getJoining() {
        return joining;
    }

    /**
     * True if the child is joining. False the child is leaving.
     *
     * @param joining the joining to set as {@link boolean}
     */
    public void setJoining(boolean joining) {
        this.joining = joining;
    }

    /**
     * The node ID of the child.
     * <p>
     * EZSP type is <i>EmberNodeId</i> - Java type is {@link int}
     *
     * @return the current childId as {@link int}
     */
    public int getChildId() {
        return childId;
    }

    /**
     * The node ID of the child.
     *
     * @param childId the childId to set as {@link int}
     */
    public void setChildId(int childId) {
        this.childId = childId;
    }

    /**
     * The EUI64 of the child.
     * <p>
     * EZSP type is <i>EmberEUI64</i> - Java type is {@link IeeeAddress}
     *
     * @return the current childEui64 as {@link IeeeAddress}
     */
    public IeeeAddress getChildEui64() {
        return childEui64;
    }

    /**
     * The EUI64 of the child.
     *
     * @param childEui64 the childEui64 to set as {@link IeeeAddress}
     */
    public void setChildEui64(IeeeAddress childEui64) {
        this.childEui64 = childEui64;
    }

    /**
     * The node type of the child.
     * <p>
     * EZSP type is <i>EmberNodeType</i> - Java type is {@link EmberNodeType}
     *
     * @return the current childType as {@link EmberNodeType}
     */
    public EmberNodeType getChildType() {
        return childType;
    }

    /**
     * The node type of the child.
     *
     * @param childType the childType to set as {@link EmberNodeType}
     */
    public void setChildType(EmberNodeType childType) {
        this.childType = childType;
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder(148);
        builder.append("EzspChildJoinHandler [index=");
        builder.append(index);
        builder.append(", joining=");
        builder.append(joining);
        builder.append(", childId=");
        builder.append(childId);
        builder.append(", childEui64=");
        builder.append(childEui64);
        builder.append(", childType=");
        builder.append(childType);
        builder.append(']');
        return builder.toString();
    }
}
