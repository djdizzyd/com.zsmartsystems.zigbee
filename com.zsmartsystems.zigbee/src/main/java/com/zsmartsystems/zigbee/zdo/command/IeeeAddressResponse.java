/**
 * Copyright (c) 2016-2017 by the respective copyright holders.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package com.zsmartsystems.zigbee.zdo.command;

import com.zsmartsystems.zigbee.zcl.ZclFieldSerializer;
import com.zsmartsystems.zigbee.zcl.ZclFieldDeserializer;
import com.zsmartsystems.zigbee.zcl.protocol.ZclDataType;
import com.zsmartsystems.zigbee.zdo.ZdoResponse;

import java.util.List;
import java.util.ArrayList;
import com.zsmartsystems.zigbee.zdo.ZdoStatus;
import com.zsmartsystems.zigbee.IeeeAddress;

/**
 * IEEE Address Response value object class.
 * <p>
 * The IEEE_addr_rsp is generated by a Remote Device in response to an
 * IEEE_addr_req command inquiring as to the 64-bit IEEE address of the Remote
 * Device or the 64-bit IEEE address of an address held in a local discovery cache.
 * The destination addressing on this command shall be unicast.
 * <p>
 * Code is auto-generated. Modifications may be overwritten!
 */
public class IeeeAddressResponse extends ZdoResponse {
    /**
     * IEEEAddrRemoteDev command message field.
     */
    private IeeeAddress ieeeAddrRemoteDev;

    /**
     * NWKAddrRemoteDev command message field.
     */
    private Integer nwkAddrRemoteDev;

    /**
     * NumAssocDev command message field.
     */
    private Integer numAssocDev;

    /**
     * StartIndex command message field.
     */
    private Integer startIndex;

    /**
     * NWKAddrAssocDevList command message field.
     */
    private List<Integer> nwkAddrAssocDevList;

    /**
     * Default constructor.
     */
    public IeeeAddressResponse() {
        clusterId = 0x8001;
    }

    /**
     * Gets IEEEAddrRemoteDev.
     *
     * @return the IEEEAddrRemoteDev
     */
    public IeeeAddress getIeeeAddrRemoteDev() {
        return ieeeAddrRemoteDev;
    }

    /**
     * Sets IEEEAddrRemoteDev.
     *
     * @param ieeeAddrRemoteDev the IEEEAddrRemoteDev
     */
    public void setIeeeAddrRemoteDev(final IeeeAddress ieeeAddrRemoteDev) {
        this.ieeeAddrRemoteDev = ieeeAddrRemoteDev;
    }

    /**
     * Gets NWKAddrRemoteDev.
     *
     * @return the NWKAddrRemoteDev
     */
    public Integer getNwkAddrRemoteDev() {
        return nwkAddrRemoteDev;
    }

    /**
     * Sets NWKAddrRemoteDev.
     *
     * @param nwkAddrRemoteDev the NWKAddrRemoteDev
     */
    public void setNwkAddrRemoteDev(final Integer nwkAddrRemoteDev) {
        this.nwkAddrRemoteDev = nwkAddrRemoteDev;
    }

    /**
     * Gets NumAssocDev.
     *
     * @return the NumAssocDev
     */
    public Integer getNumAssocDev() {
        return numAssocDev;
    }

    /**
     * Sets NumAssocDev.
     *
     * @param numAssocDev the NumAssocDev
     */
    public void setNumAssocDev(final Integer numAssocDev) {
        this.numAssocDev = numAssocDev;
    }

    /**
     * Gets StartIndex.
     *
     * @return the StartIndex
     */
    public Integer getStartIndex() {
        return startIndex;
    }

    /**
     * Sets StartIndex.
     *
     * @param startIndex the StartIndex
     */
    public void setStartIndex(final Integer startIndex) {
        this.startIndex = startIndex;
    }

    /**
     * Gets NWKAddrAssocDevList.
     *
     * @return the NWKAddrAssocDevList
     */
    public List<Integer> getNwkAddrAssocDevList() {
        return nwkAddrAssocDevList;
    }

    /**
     * Sets NWKAddrAssocDevList.
     *
     * @param nwkAddrAssocDevList the NWKAddrAssocDevList
     */
    public void setNwkAddrAssocDevList(final List<Integer> nwkAddrAssocDevList) {
        this.nwkAddrAssocDevList = nwkAddrAssocDevList;
    }

    @Override
    public void serialize(final ZclFieldSerializer serializer) {
        super.serialize(serializer);

        serializer.serialize(status, ZclDataType.ZDO_STATUS);
        serializer.serialize(ieeeAddrRemoteDev, ZclDataType.IEEE_ADDRESS);
        serializer.serialize(nwkAddrRemoteDev, ZclDataType.NWK_ADDRESS);
        serializer.serialize(numAssocDev, ZclDataType.UNSIGNED_8_BIT_INTEGER);
        serializer.serialize(startIndex, ZclDataType.UNSIGNED_8_BIT_INTEGER);
        for (int cnt = 0; cnt < nwkAddrAssocDevList.size(); cnt++) {
            serializer.serialize(nwkAddrAssocDevList.get(cnt), ZclDataType.NWK_ADDRESS);
        }
    }

    @Override
    public void deserialize(final ZclFieldDeserializer deserializer) {
        super.deserialize(deserializer);

        // Create lists
        nwkAddrAssocDevList = new ArrayList<Integer>();

        status = (ZdoStatus) deserializer.deserialize(ZclDataType.ZDO_STATUS);
        if (status != ZdoStatus.SUCCESS) {
            // Don't read the full response if we have an error
            return;
        }
        ieeeAddrRemoteDev = (IeeeAddress) deserializer.deserialize(ZclDataType.IEEE_ADDRESS);
        nwkAddrRemoteDev = (Integer) deserializer.deserialize(ZclDataType.NWK_ADDRESS);
        if (deserializer.isEndOfStream()) {
            return;
        }
        numAssocDev = (Integer) deserializer.deserialize(ZclDataType.UNSIGNED_8_BIT_INTEGER);
        if (numAssocDev == 0) {
            return;
        }
        startIndex = (Integer) deserializer.deserialize(ZclDataType.UNSIGNED_8_BIT_INTEGER);
        for (int cnt = 0; cnt < numAssocDev; cnt++) {
            nwkAddrAssocDevList.add((Integer) deserializer.deserialize(ZclDataType.NWK_ADDRESS));
        }
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder(221);
        builder.append("IeeeAddressResponse [");
        builder.append(super.toString());
        builder.append(", status=");
        builder.append(status);
        builder.append(", ieeeAddrRemoteDev=");
        builder.append(ieeeAddrRemoteDev);
        builder.append(", nwkAddrRemoteDev=");
        builder.append(nwkAddrRemoteDev);
        builder.append(", numAssocDev=");
        builder.append(numAssocDev);
        builder.append(", startIndex=");
        builder.append(startIndex);
        builder.append(", nwkAddrAssocDevList=");
        builder.append(nwkAddrAssocDevList);
        builder.append(']');
        return builder.toString();
    }

}
