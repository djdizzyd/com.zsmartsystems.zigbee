/**
 * Copyright (c) 2016-2019 by the respective copyright holders.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package com.zsmartsystems.zigbee.dongle.ember.ezsp.command;

import com.zsmartsystems.zigbee.dongle.ember.ezsp.EzspFrameResponse;
import com.zsmartsystems.zigbee.dongle.ember.ezsp.structure.EmberLibraryStatus;

/**
 * Class to implement the Ember EZSP command <b>getLibraryStatus</b>.
 * <p>
 * This retrieves the status of the passed library ID to determine if it is compiled into the
 * stack.
 * <p>
 * This class provides methods for processing EZSP commands.
 * <p>
 * Note that this code is autogenerated. Manual changes may be overwritten.
 *
 * @author Chris Jackson - Initial contribution of Java code generator
 */
public class EzspGetLibraryStatusResponse extends EzspFrameResponse {
    public static final int FRAME_ID = 0x01;

    /**
     * The status of the library being queried.
     * <p>
     * EZSP type is <i>EmberLibraryStatus</i> - Java type is {@link EmberLibraryStatus}
     */
    private EmberLibraryStatus status;

    /**
     * Response and Handler constructor
     */
    public EzspGetLibraryStatusResponse(int[] inputBuffer) {
        // Super creates deserializer and reads header fields
        super(inputBuffer);

        // Deserialize the fields
        status = deserializer.deserializeEmberLibraryStatus();
    }

    /**
     * The status of the library being queried.
     * <p>
     * EZSP type is <i>EmberLibraryStatus</i> - Java type is {@link EmberLibraryStatus}
     *
     * @return the current status as {@link EmberLibraryStatus}
     */
    public EmberLibraryStatus getStatus() {
        return status;
    }

    /**
     * The status of the library being queried.
     *
     * @param status the status to set as {@link EmberLibraryStatus}
     */
    public void setStatus(EmberLibraryStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder(56);
        builder.append("EzspGetLibraryStatusResponse [status=");
        builder.append(status);
        builder.append(']');
        return builder.toString();
    }
}