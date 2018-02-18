/**
 * Copyright (c) 2016-2017 by the respective copyright holders.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package com.zsmartsystems.zigbee.dongle.ember.ezsp.structure;

import java.util.HashMap;
import java.util.Map;

/**
 * Class to implement the Ember Enumeration <b>EzspConfigId</b>.
 * <p>
 * Identifies which configuration value to read or change with getConfigurationValue and
 * setConfigurationValue.
 * <p>
 * Note that this code is autogenerated. Manual changes may be overwritten.
 *
 * @author Chris Jackson - Initial contribution of Java code generator
 */
public enum EzspConfigId {
    /**
     * Default unknown value
     */
    UNKNOWN(-1),

    /**
     * The number of packet buffers available to the stack. When set to the special value 0xFF, the
     * NCP will allocate all remaining configuration RAM towards packet buffers, such that the
     * resulting count will be the largest whole number of packet buffers that can fit into the
     * available memory.
     */
    EZSP_CONFIG_PACKET_BUFFER_COUNT(0x0001),

    /**
     * The maximum number of non-volatile bindings supported by the stack.
     */
    EZSP_CONFIG_BINDING_TABLE_SIZE(0x0004),

    /**
     * The maximum number of EUI64 to network address associations that the stack can maintain for
     * the application. (Note, the total number of such address associations maintained by the NCP
     * is the sum of the value of this setting and the value of
     * ::EZSP_CONFIG_TRUST_CENTER_ADDRESS_CACHE_SIZE.).
     */
    EZSP_CONFIG_ADDRESS_TABLE_SIZE(0x0005),

    /**
     * Specifies the stack profile.
     */
    EZSP_CONFIG_STACK_PROFILE(0x000C),

    /**
     * The security level used for security at the MAC and network layers. The supported values are 0
     * (no security) and 5 (payload is encrypted and a four-byte MIC is used for authentication).
     */
    EZSP_CONFIG_SECURITY_LEVEL(0x000D),

    /**
     * The maximum number of hops for a message.
     */
    EZSP_CONFIG_MAX_HOPS(0x0010),

    /**
     * The maximum number of end device children that a router will support.
     */
    EZSP_CONFIG_MAX_END_DEVICE_CHILDREN(0x0011),

    /**
     * The maximum amount of time that the MAC will hold a message for indirect transmission to a
     * child.
     */
    EZSP_CONFIG_INDIRECT_TRANSMISSION_TIMEOUT(0x0012),

    /**
     * The maximum amount of time that an end device child can wait between polls. If no poll is heard
     * within this timeout, then the parent removes the end device from its tables.
     */
    EZSP_CONFIG_END_DEVICE_POLL_TIMEOUT(0x0013),

    /**
     * Enables boost power mode and/or the alternate transmitter output.
     */
    EZSP_CONFIG_TX_POWER_MODE(0x0017),

    /**
     * The maximum number of EUI64 to network address associations that the Trust Center can
     * maintain. These address cache entries are reserved for and reused by the Trust Center when
     * processing device join/rejoin authentications. This cache size limits the number of
     * overlapping joins the Trust Center can process within a narrow time window (e.g. two
     * seconds), and thus should be set to the maximum number of near simultaneous joins the Trust
     * Center is expected to accommodate. (Note, the total number of such address associations
     * maintained by the NCP is the sum of the value of this setting and the value of
     * ::EZSP_CONFIG_ADDRESS_TABLE_SIZE.)
     */
    EZSP_CONFIG_TRUST_CENTER_ADDRESS_CACHE_SIZE(0x0019),

    /**
     * The size of the source route table.
     */
    EZSP_CONFIG_SOURCE_ROUTE_TABLE_SIZE(0x001A),

    /**
     * The size of the Key Table used for storing individual link keys (if the device is a Trust
     * Center) or Application Link Keys (if the device is a normal node).
     */
    EZSP_CONFIG_KEY_TABLE_SIZE(0x001E),

    /**
     * This is a bitmask that controls which incoming ZDO request messages are passed to the
     * application. The bits are defined in the EmberZdoConfigurationFlags enumeration. To see
     * if the application is required to send a ZDO response in reply to an incoming message, the
     * application must check the APS options bitfield within the incomingMessageHandler
     * callback to see if the EMBER_APS_OPTION_ZDO_RESPONSE_REQUIRED flag is set.
     */
    EZSP_CONFIG_APPLICATION_ZDO_FLAGS(0x002A),

    /**
     * The number of supported networks.
     */
    EZSP_CONFIG_SUPPORTED_NETWORKS(0x002D),

    /**
     * The number of passive acknowledgements to record from neighbors before we stop
     * re-transmitting broadcasts.
     */
    EZSP_CONFIG_BROADCAST_MIN_ACKS_NEEDED(0x0037),

    /**
     * The length of time, in seconds, that a trust center will allow a Trust Center (insecure)
     * rejoin for a device that is using the well-known link key. This timeout takes effect once
     * rejoins using the well-known key has been allowed. This command updates the
     * emAllowTcRejoinsUsingWellKnownKeyTimeoutSec value.
     */
    EZSP_CONFIG_TC_REJOINS_USING_WELL_KNOWN_KEY_TIMEOUT_S(0x0038);

    /**
     * A mapping between the integer code and its corresponding type to
     * facilitate lookup by code.
     */
    private static Map<Integer, EzspConfigId> codeMapping;

    private int key;

    private EzspConfigId(int key) {
        this.key = key;
    }

    private static void initMapping() {
        codeMapping = new HashMap<Integer, EzspConfigId>();
        for (EzspConfigId s : values()) {
            codeMapping.put(s.key, s);
        }
    }

    /**
     * Lookup function based on the EmberStatus type code. Returns null if the
     * code does not exist.
     *
     * @param code
     *            the code to lookup
     * @return enumeration value of the alarm type.
     */
    public static EzspConfigId getEzspConfigId(int code) {
        if (codeMapping == null) {
            initMapping();
        }

        if (codeMapping.get(code) == null) {
            return UNKNOWN;
        }

        return codeMapping.get(code);
    }

    /**
     * Returns the EZSP protocol defined value for this enum
     *
     * @return the EZSP protocol key
     */
    public int getKey() {
        return key;
    }
}
