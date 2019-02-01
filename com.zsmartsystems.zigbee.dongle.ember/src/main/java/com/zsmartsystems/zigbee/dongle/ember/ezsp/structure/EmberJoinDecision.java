/**
 * Copyright (c) 2016-2019 by the respective copyright holders.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package com.zsmartsystems.zigbee.dongle.ember.ezsp.structure;

import java.util.HashMap;
import java.util.Map;

/**
 * Class to implement the Ember Enumeration <b>EmberJoinDecision</b>.
 * <p>
 * Note that this code is autogenerated. Manual changes may be overwritten.
 *
 * @author Chris Jackson - Initial contribution of Java code generator
 */
public enum EmberJoinDecision {
    /**
     * Default unknown value
     */
    UNKNOWN(-1),

    /**
     * Allow the node to join. The joining node should have a pre-configured key. The security data
     * sent to it will be encrypted with that key.
     */
    EMBER_USE_PRECONFIGURED_KEY(0x0000),

    /**
     * Allow the node to join. Send the necessary key (the Network Key in Standard Security mode, the
     * Trust Center Master in High Security mode) in-the-clear to the joining device.
     */
    EMBER_SEND_KEY_IN_THE_CLEAR(0x0001),

    /**
     * Deny join.
     */
    EMBER_DENY_JOIN(0x0002),

    /**
     * Take no action.
     */
    EMBER_NO_ACTION(0x0003);

    /**
     * A mapping between the integer code and its corresponding type to
     * facilitate lookup by code.
     */
    private static Map<Integer, EmberJoinDecision> codeMapping;

    private int key;

    static {
        codeMapping = new HashMap<Integer, EmberJoinDecision>();
        for (EmberJoinDecision s : values()) {
            codeMapping.put(s.key, s);
        }
    }

    private EmberJoinDecision(int key) {
        this.key = key;
    }

    /**
     * Lookup function based on the EmberStatus type code. Returns null if the
     * code does not exist.
     *
     * @param code the code to lookup
     * @return enumeration value of the alarm type.
     */
    public static EmberJoinDecision getEmberJoinDecision(int code) {
        if (codeMapping.get(code) == null) {
            return UNKNOWN;
        }

        return codeMapping.get(code);
    }

    /**
     * Returns the EZSP protocol defined value for this enumeration.
     *
     * @return the EZSP protocol key
     */
    public int getKey() {
        return key;
    }
}
