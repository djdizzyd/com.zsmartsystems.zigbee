/**
 * Copyright (c) 2016-2017 by the respective copyright holders.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package com.zsmartsystems.zigbee.dongle.ember.ezsp.command;

import com.zsmartsystems.zigbee.dongle.ember.ezsp.EzspFrameResponse;
import com.zsmartsystems.zigbee.dongle.ember.ezsp.structure.EzspStatus;

/**
 * Class to implement the Ember EZSP command <b>setConcentrator</b>.
 *
 */
public class EzspSetConcentratorResponse extends EzspFrameResponse {
    public static int FRAME_ID = 0x10;

    /**
     * EZSP_SUCCESS if the configuration value was changed, EZSP_ERROR_OUT_OF_MEMORY if the new
     * value exceeded the available memory, EZSP_ERROR_INVALID_VALUE if the new value was out of
     * bounds, EZSP_ERROR_INVALID_ID if the NCP does not recognize configId,
     * EZSP_ERROR_INVALID_CALL if configuration values can no longer be modified.
     * <p>
     * EZSP type is <i>EzspStatus</i> - Java type is {@link EzspStatus}
     */
    private EzspStatus status;

    /**
     * Response and Handler constructor
     */
    public EzspSetConcentratorResponse(int[] inputBuffer) {
        // Super creates deserializer and reads header fields
        super(inputBuffer);

        // Deserialize the fields
        status = deserializer.deserializeEzspStatus();
    }

    /**
     * EZSP_SUCCESS if the configuration value was changed, EZSP_ERROR_OUT_OF_MEMORY if the new
     * value exceeded the available memory, EZSP_ERROR_INVALID_VALUE if the new value was out of
     * bounds, EZSP_ERROR_INVALID_ID if the NCP does not recognize configId,
     * EZSP_ERROR_INVALID_CALL if configuration values can no longer be modified.
     * <p>
     * EZSP type is <i>EzspStatus</i> - Java type is {@link EzspStatus}
     *
     * @return the current status as {@link EzspStatus}
     */
    public EzspStatus getStatus() {
        return status;
    }

    /**
     * EZSP_SUCCESS if the configuration value was changed, EZSP_ERROR_OUT_OF_MEMORY if the new
     * value exceeded the available memory, EZSP_ERROR_INVALID_VALUE if the new value was out of
     * bounds, EZSP_ERROR_INVALID_ID if the NCP does not recognize configId,
     * EZSP_ERROR_INVALID_CALL if configuration values can no longer be modified.
     *
     * @param status the status to set as {@link EzspStatus}
     */
    public void setStatus(EzspStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder(51);
        builder.append("EzspSetConcentratorResponse [status=");
        builder.append(status);
        builder.append(']');
        return builder.toString();
    }
}
