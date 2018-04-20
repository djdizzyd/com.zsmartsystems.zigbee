/**
 * Copyright (c) 2016-2018 by the respective copyright holders.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package com.zsmartsystems.zigbee.dongle.ember.internal.ezsp.command;

import com.zsmartsystems.zigbee.dongle.ember.internal.ezsp.EzspFrameResponse;
import com.zsmartsystems.zigbee.dongle.ember.internal.ezsp.structure.EzspStatus;

/**
 * Class to implement the Ember EZSP command <b>invalidCommand</b>.
 * <p>
 * Indicates that the NCP received an invalid command.
 * <p>
 * This class provides methods for processing EZSP commands.
 * <p>
 * Note that this code is autogenerated. Manual changes may be overwritten.
 *
 * @author Chris Jackson - Initial contribution of Java code generator
 */
public class EzspInvalidCommandResponse extends EzspFrameResponse {
    public static final int FRAME_ID = 0x58;

    /**
     * The reason why the command was invalid.
     * <p>
     * EZSP type is <i>EzspStatus</i> - Java type is {@link EzspStatus}
     */
    private EzspStatus reason;

    /**
     * Response and Handler constructor
     */
    public EzspInvalidCommandResponse(int[] inputBuffer) {
        // Super creates deserializer and reads header fields
        super(inputBuffer);

        // Deserialize the fields
        reason = deserializer.deserializeEzspStatus();
    }

    /**
     * The reason why the command was invalid.
     * <p>
     * EZSP type is <i>EzspStatus</i> - Java type is {@link EzspStatus}
     *
     * @return the current reason as {@link EzspStatus}
     */
    public EzspStatus getReason() {
        return reason;
    }

    /**
     * The reason why the command was invalid.
     *
     * @param reason the reason to set as {@link EzspStatus}
     */
    public void setReason(EzspStatus reason) {
        this.reason = reason;
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder(54);
        builder.append("EzspInvalidCommandResponse [reason=");
        builder.append(reason);
        builder.append(']');
        return builder.toString();
    }
}