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
        switch (errorCode) {
            case 0x00:
                builder.append(", Reset: Unknown reason");
                break;
            case 0x01:
                builder.append(", Reset: External");
                break;
            case 0x02:
                builder.append(", Reset: Power-on");
                break;
            case 0x03:
                builder.append(", Reset: Watchdog");
                break;
            case 0x06:
                builder.append(", Reset: Assert");
                break;
            case 0x09:
                builder.append(", Reset: Boot loader");
                break;
            case 0x0B:
                builder.append(", Reset: Software");
                break;
            case 0x51:
                builder.append(", Error: Exceeded maximum ACK timeout count");
                break;
            default:
                break;
        }

        builder.append("]");
        return builder.toString();
    }

}
