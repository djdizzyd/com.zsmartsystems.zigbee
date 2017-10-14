/**
 * Copyright (c) 2016-2017 by the respective copyright holders.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package com.zsmartsystems.zigbee.dongle.ember.ash;

/**
 * ASH Error Frame
 *
 * @author Chris Jackson
 *
 */
public class AshFrameError extends AshFrame {
    private final int version;
    private final int errorCode;

    /**
     * Constructor to create an ASH frame from a byte buffer.
     *
     * @param frameBuffer
     */
    public AshFrameError(int[] frameBuffer) {
        this.frameType = FrameType.ERROR;
        processHeader(frameBuffer);

        this.version = frameBuffer[1];
        this.errorCode = frameBuffer[2];
    }

    public int getVersion() {
        return version;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public boolean isResetError() {
        return (errorCode == 0x00 || errorCode == 0x01 || errorCode == 0x02 || errorCode == 0x03 ||
                errorCode == 0x06 || errorCode == 0x09 || errorCode == 0x0B);
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("AshFrameError [version=");
        builder.append(version);
        builder.append(". errorCode=");
        builder.append(errorCode);
        AshErrorCode ashError = AshErrorCode.getAshErrorCode(errorCode);
        builder.append(ashError.getDescription());
        builder.append("]");
        return builder.toString();
    }

}
