/**
 * Copyright (c) 2016-2017 by the respective copyright holders.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package com.zsmartsystems.zigbee.zcl.clusters;

import com.zsmartsystems.zigbee.CommandResult;
import com.zsmartsystems.zigbee.IeeeAddress;
import com.zsmartsystems.zigbee.ZigBeeEndpoint;
import com.zsmartsystems.zigbee.ZigBeeNetworkManager;
import com.zsmartsystems.zigbee.zcl.ZclAttribute;
import com.zsmartsystems.zigbee.zcl.ZclCluster;
import com.zsmartsystems.zigbee.zcl.ZclCommand;
import com.zsmartsystems.zigbee.zcl.clusters.iaszone.ZoneEnrollRequestCommand;
import com.zsmartsystems.zigbee.zcl.clusters.iaszone.ZoneEnrollResponse;
import com.zsmartsystems.zigbee.zcl.clusters.iaszone.ZoneStatusChangeNotificationCommand;
import com.zsmartsystems.zigbee.zcl.protocol.ZclClusterType;
import com.zsmartsystems.zigbee.zcl.protocol.ZclDataType;
import java.util.Calendar;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Future;

/**
 * <b>IAS Zone</b> cluster implementation (<i>Cluster ID 0x0500</i>).
 * <p>
 * The IAS Zone cluster defines an interface to the functionality of an IAS security
 * zone device. IAS Zone supports up to two alarm types per zone, low battery
 * reports and supervision of the IAS network.
 * <p>
 * Code is auto-generated. Modifications may be overwritten!
 */
public class ZclIasZoneCluster extends ZclCluster {
    // Cluster ID
    public static final int CLUSTER_ID = 0x0500;

    // Cluster Name
    public static final String CLUSTER_NAME = "IAS Zone";

    // Attribute constants
    public static final int ATTR_ZONESTATE = 0x0000;
    public static final int ATTR_ZONETYPE = 0x0001;
    public static final int ATTR_ZONESTATUS = 0x0002;
    public static final int ATTR_IASCIEADDRESS = 0x0010;
    public static final int ATTR_ZONEID = 0x0011;
    public static final int ATTR_NUMBEROFZONESENSITIVITYLEVELSSUPPORTED = 0x0012;
    public static final int ATTR_CURRENTZONESENSITIVITYLEVEL = 0x0013;

    // Attribute initialisation
    protected Map<Integer, ZclAttribute> initializeAttributes() {
        Map<Integer, ZclAttribute> attributeMap = new ConcurrentHashMap<Integer, ZclAttribute>(7);

        attributeMap.put(ATTR_ZONESTATE, new ZclAttribute(ZclClusterType.IAS_ZONE, ATTR_ZONESTATE, "ZoneState", ZclDataType.ENUMERATION_8_BIT, true, true, false, false));
        attributeMap.put(ATTR_ZONETYPE, new ZclAttribute(ZclClusterType.IAS_ZONE, ATTR_ZONETYPE, "ZoneType", ZclDataType.ENUMERATION_16_BIT, true, true, false, false));
        attributeMap.put(ATTR_ZONESTATUS, new ZclAttribute(ZclClusterType.IAS_ZONE, ATTR_ZONESTATUS, "ZoneStatus", ZclDataType.BITMAP_16_BIT, true, true, false, false));
        attributeMap.put(ATTR_IASCIEADDRESS, new ZclAttribute(ZclClusterType.IAS_ZONE, ATTR_IASCIEADDRESS, "IASCIEAddress", ZclDataType.IEEE_ADDRESS, true, true, true, false));
        attributeMap.put(ATTR_ZONEID, new ZclAttribute(ZclClusterType.IAS_ZONE, ATTR_ZONEID, "ZoneID", ZclDataType.UNSIGNED_8_BIT_INTEGER, true, true, false, false));
        attributeMap.put(ATTR_NUMBEROFZONESENSITIVITYLEVELSSUPPORTED, new ZclAttribute(ZclClusterType.IAS_ZONE, ATTR_NUMBEROFZONESENSITIVITYLEVELSSUPPORTED, "NumberOfZoneSensitivityLevelsSupported", ZclDataType.UNSIGNED_8_BIT_INTEGER, false, true, false, false));
        attributeMap.put(ATTR_CURRENTZONESENSITIVITYLEVEL, new ZclAttribute(ZclClusterType.IAS_ZONE, ATTR_CURRENTZONESENSITIVITYLEVEL, "CurrentZoneSensitivityLevel", ZclDataType.UNSIGNED_8_BIT_INTEGER, false, true, true, false));

        return attributeMap;
    }

    /**
     * Default constructor to create a IAS Zone cluster.
     *
     * @param zigbeeManager {@link ZigBeeNetworkManager}
     * @param zigbeeEndpoint the {@link ZigBeeEndpoint}
     */
    public ZclIasZoneCluster(final ZigBeeNetworkManager zigbeeManager, final ZigBeeEndpoint zigbeeEndpoint) {
        super(zigbeeManager, zigbeeEndpoint, CLUSTER_ID, CLUSTER_NAME);
    }


    /**
     * Get the <i>ZoneState</i> attribute [attribute ID <b>0</b>].
     * <p>
     * The attribute is of type {@link Integer}.
     * <p>
     * The implementation of this attribute by a device is MANDATORY
     *
     * @return the {@link Future<CommandResult>} command result future
     */
    public Future<CommandResult> getZoneStateAsync() {
        return read(attributes.get(ATTR_ZONESTATE));
    }


    /**
     * Synchronously get the <i>ZoneState</i> attribute [attribute ID <b>0</b>].
     * <p>
     * This method can return cached data if the attribute has already been received.
     * The parameter <i>refreshPeriod</i> is used to control this. If the attribute has been received
     * within <i>refreshPeriod</i> milliseconds, then the method will immediately return the last value
     * received. If <i>refreshPeriod</i> is set to 0, then the attribute will always be updated.
     * <p>
     * This method will block until the response is received or a timeout occurs unless the current value is returned.
     * <p>
     * The attribute is of type {@link Integer}.
     * <p>
     * The implementation of this attribute by a device is MANDATORY
     *
     * @param refreshPeriod the maximum age of the data (in milliseconds) before an update is needed
     * @return the {@link Integer} attribute value, or null on error
     */
    public Integer getZoneState(final long refreshPeriod) {
        if(refreshPeriod > 0 && attributes.get(ATTR_ZONESTATE).getLastReportTime() != null) {
            long refreshTime = Calendar.getInstance().getTimeInMillis() - refreshPeriod;
            if(attributes.get(ATTR_ZONESTATE).getLastReportTime().getTimeInMillis() < refreshTime) {
                return (Integer) attributes.get(ATTR_ZONESTATE).getLastValue();
            }
        }

        return (Integer) readSync(attributes.get(ATTR_ZONESTATE));
    }

    /**
     * Get the <i>ZoneType</i> attribute [attribute ID <b>1</b>].
     * <p>
     * The Zone Type dictates the meaning of Alarm1 and Alarm2 bits of the ZoneStatus attribute
     * <p>
     * The attribute is of type {@link Integer}.
     * <p>
     * The implementation of this attribute by a device is MANDATORY
     *
     * @return the {@link Future<CommandResult>} command result future
     */
    public Future<CommandResult> getZoneTypeAsync() {
        return read(attributes.get(ATTR_ZONETYPE));
    }


    /**
     * Synchronously get the <i>ZoneType</i> attribute [attribute ID <b>1</b>].
     * <p>
     * The Zone Type dictates the meaning of Alarm1 and Alarm2 bits of the ZoneStatus attribute
     * <p>
     * This method can return cached data if the attribute has already been received.
     * The parameter <i>refreshPeriod</i> is used to control this. If the attribute has been received
     * within <i>refreshPeriod</i> milliseconds, then the method will immediately return the last value
     * received. If <i>refreshPeriod</i> is set to 0, then the attribute will always be updated.
     * <p>
     * This method will block until the response is received or a timeout occurs unless the current value is returned.
     * <p>
     * The attribute is of type {@link Integer}.
     * <p>
     * The implementation of this attribute by a device is MANDATORY
     *
     * @param refreshPeriod the maximum age of the data (in milliseconds) before an update is needed
     * @return the {@link Integer} attribute value, or null on error
     */
    public Integer getZoneType(final long refreshPeriod) {
        if(refreshPeriod > 0 && attributes.get(ATTR_ZONETYPE).getLastReportTime() != null) {
            long refreshTime = Calendar.getInstance().getTimeInMillis() - refreshPeriod;
            if(attributes.get(ATTR_ZONETYPE).getLastReportTime().getTimeInMillis() < refreshTime) {
                return (Integer) attributes.get(ATTR_ZONETYPE).getLastValue();
            }
        }

        return (Integer) readSync(attributes.get(ATTR_ZONETYPE));
    }

    /**
     * Get the <i>ZoneStatus</i> attribute [attribute ID <b>2</b>].
     * <p>
     * The ZoneStatus attribute is a bit map.
     * <p>
     * The attribute is of type {@link Integer}.
     * <p>
     * The implementation of this attribute by a device is MANDATORY
     *
     * @return the {@link Future<CommandResult>} command result future
     */
    public Future<CommandResult> getZoneStatusAsync() {
        return read(attributes.get(ATTR_ZONESTATUS));
    }


    /**
     * Synchronously get the <i>ZoneStatus</i> attribute [attribute ID <b>2</b>].
     * <p>
     * The ZoneStatus attribute is a bit map.
     * <p>
     * This method can return cached data if the attribute has already been received.
     * The parameter <i>refreshPeriod</i> is used to control this. If the attribute has been received
     * within <i>refreshPeriod</i> milliseconds, then the method will immediately return the last value
     * received. If <i>refreshPeriod</i> is set to 0, then the attribute will always be updated.
     * <p>
     * This method will block until the response is received or a timeout occurs unless the current value is returned.
     * <p>
     * The attribute is of type {@link Integer}.
     * <p>
     * The implementation of this attribute by a device is MANDATORY
     *
     * @param refreshPeriod the maximum age of the data (in milliseconds) before an update is needed
     * @return the {@link Integer} attribute value, or null on error
     */
    public Integer getZoneStatus(final long refreshPeriod) {
        if(refreshPeriod > 0 && attributes.get(ATTR_ZONESTATUS).getLastReportTime() != null) {
            long refreshTime = Calendar.getInstance().getTimeInMillis() - refreshPeriod;
            if(attributes.get(ATTR_ZONESTATUS).getLastReportTime().getTimeInMillis() < refreshTime) {
                return (Integer) attributes.get(ATTR_ZONESTATUS).getLastValue();
            }
        }

        return (Integer) readSync(attributes.get(ATTR_ZONESTATUS));
    }


    /**
     * Set the <i>IASCIEAddress</i> attribute [attribute ID <b>16</b>].
     * <p>
     * The IAS_CIE_Address attribute specifies the address that commands generated by
     * the server shall be sent to. All commands received by the server must also come
     * from this address.
     * <p>
     * It is up to the zone's specific implementation to permit or deny change (write) of
     * this attribute at specific times. Also, it is up to the zone's specific implementation
     * to implement some auto-detect for the CIE (example: by requesting the ZigBee
     * cluster discovery service to locate a Zone Server cluster.) or require the
     * intervention of a CT in order to configure this attribute during installation.
     * <p>
     * The attribute is of type {@link IeeeAddress}.
     * <p>
     * The implementation of this attribute by a device is MANDATORY
     *
     * @param iascieAddress the {@link IeeeAddress} attribute value to be set
     * @return the {@link Future<CommandResult>} command result future
     */
    public Future<CommandResult> setIascieAddress(final Object value) {
        return write(attributes.get(ATTR_IASCIEADDRESS), value);
    }

    /**
     * Get the <i>IASCIEAddress</i> attribute [attribute ID <b>16</b>].
     * <p>
     * The IAS_CIE_Address attribute specifies the address that commands generated by
     * the server shall be sent to. All commands received by the server must also come
     * from this address.
     * <p>
     * It is up to the zone's specific implementation to permit or deny change (write) of
     * this attribute at specific times. Also, it is up to the zone's specific implementation
     * to implement some auto-detect for the CIE (example: by requesting the ZigBee
     * cluster discovery service to locate a Zone Server cluster.) or require the
     * intervention of a CT in order to configure this attribute during installation.
     * <p>
     * The attribute is of type {@link IeeeAddress}.
     * <p>
     * The implementation of this attribute by a device is MANDATORY
     *
     * @return the {@link Future<CommandResult>} command result future
     */
    public Future<CommandResult> getIascieAddressAsync() {
        return read(attributes.get(ATTR_IASCIEADDRESS));
    }


    /**
     * Synchronously get the <i>IASCIEAddress</i> attribute [attribute ID <b>16</b>].
     * <p>
     * The IAS_CIE_Address attribute specifies the address that commands generated by
     * the server shall be sent to. All commands received by the server must also come
     * from this address.
     * <p>
     * It is up to the zone's specific implementation to permit or deny change (write) of
     * this attribute at specific times. Also, it is up to the zone's specific implementation
     * to implement some auto-detect for the CIE (example: by requesting the ZigBee
     * cluster discovery service to locate a Zone Server cluster.) or require the
     * intervention of a CT in order to configure this attribute during installation.
     * <p>
     * This method can return cached data if the attribute has already been received.
     * The parameter <i>refreshPeriod</i> is used to control this. If the attribute has been received
     * within <i>refreshPeriod</i> milliseconds, then the method will immediately return the last value
     * received. If <i>refreshPeriod</i> is set to 0, then the attribute will always be updated.
     * <p>
     * This method will block until the response is received or a timeout occurs unless the current value is returned.
     * <p>
     * The attribute is of type {@link IeeeAddress}.
     * <p>
     * The implementation of this attribute by a device is MANDATORY
     *
     * @param refreshPeriod the maximum age of the data (in milliseconds) before an update is needed
     * @return the {@link IeeeAddress} attribute value, or null on error
     */
    public IeeeAddress getIascieAddress(final long refreshPeriod) {
        if(refreshPeriod > 0 && attributes.get(ATTR_IASCIEADDRESS).getLastReportTime() != null) {
            long refreshTime = Calendar.getInstance().getTimeInMillis() - refreshPeriod;
            if(attributes.get(ATTR_IASCIEADDRESS).getLastReportTime().getTimeInMillis() < refreshTime) {
                return (IeeeAddress) attributes.get(ATTR_IASCIEADDRESS).getLastValue();
            }
        }

        return (IeeeAddress) readSync(attributes.get(ATTR_IASCIEADDRESS));
    }

    /**
     * Get the <i>ZoneID</i> attribute [attribute ID <b>17</b>].
     * <p>
     * The attribute is of type {@link Integer}.
     * <p>
     * The implementation of this attribute by a device is MANDATORY
     *
     * @return the {@link Future<CommandResult>} command result future
     */
    public Future<CommandResult> getZoneIdAsync() {
        return read(attributes.get(ATTR_ZONEID));
    }


    /**
     * Synchronously get the <i>ZoneID</i> attribute [attribute ID <b>17</b>].
     * <p>
     * This method can return cached data if the attribute has already been received.
     * The parameter <i>refreshPeriod</i> is used to control this. If the attribute has been received
     * within <i>refreshPeriod</i> milliseconds, then the method will immediately return the last value
     * received. If <i>refreshPeriod</i> is set to 0, then the attribute will always be updated.
     * <p>
     * This method will block until the response is received or a timeout occurs unless the current value is returned.
     * <p>
     * The attribute is of type {@link Integer}.
     * <p>
     * The implementation of this attribute by a device is MANDATORY
     *
     * @param refreshPeriod the maximum age of the data (in milliseconds) before an update is needed
     * @return the {@link Integer} attribute value, or null on error
     */
    public Integer getZoneId(final long refreshPeriod) {
        if(refreshPeriod > 0 && attributes.get(ATTR_ZONEID).getLastReportTime() != null) {
            long refreshTime = Calendar.getInstance().getTimeInMillis() - refreshPeriod;
            if(attributes.get(ATTR_ZONEID).getLastReportTime().getTimeInMillis() < refreshTime) {
                return (Integer) attributes.get(ATTR_ZONEID).getLastValue();
            }
        }

        return (Integer) readSync(attributes.get(ATTR_ZONEID));
    }

    /**
     * Get the <i>NumberOfZoneSensitivityLevelsSupported</i> attribute [attribute ID <b>18</b>].
     * <p>
     * The attribute is of type {@link Integer}.
     * <p>
     * The implementation of this attribute by a device is OPTIONAL
     *
     * @return the {@link Future<CommandResult>} command result future
     */
    public Future<CommandResult> getNumberOfZoneSensitivityLevelsSupportedAsync() {
        return read(attributes.get(ATTR_NUMBEROFZONESENSITIVITYLEVELSSUPPORTED));
    }


    /**
     * Synchronously get the <i>NumberOfZoneSensitivityLevelsSupported</i> attribute [attribute ID <b>18</b>].
     * <p>
     * This method can return cached data if the attribute has already been received.
     * The parameter <i>refreshPeriod</i> is used to control this. If the attribute has been received
     * within <i>refreshPeriod</i> milliseconds, then the method will immediately return the last value
     * received. If <i>refreshPeriod</i> is set to 0, then the attribute will always be updated.
     * <p>
     * This method will block until the response is received or a timeout occurs unless the current value is returned.
     * <p>
     * The attribute is of type {@link Integer}.
     * <p>
     * The implementation of this attribute by a device is OPTIONAL
     *
     * @param refreshPeriod the maximum age of the data (in milliseconds) before an update is needed
     * @return the {@link Integer} attribute value, or null on error
     */
    public Integer getNumberOfZoneSensitivityLevelsSupported(final long refreshPeriod) {
        if(refreshPeriod > 0 && attributes.get(ATTR_NUMBEROFZONESENSITIVITYLEVELSSUPPORTED).getLastReportTime() != null) {
            long refreshTime = Calendar.getInstance().getTimeInMillis() - refreshPeriod;
            if(attributes.get(ATTR_NUMBEROFZONESENSITIVITYLEVELSSUPPORTED).getLastReportTime().getTimeInMillis() < refreshTime) {
                return (Integer) attributes.get(ATTR_NUMBEROFZONESENSITIVITYLEVELSSUPPORTED).getLastValue();
            }
        }

        return (Integer) readSync(attributes.get(ATTR_NUMBEROFZONESENSITIVITYLEVELSSUPPORTED));
    }


    /**
     * Set the <i>CurrentZoneSensitivityLevel</i> attribute [attribute ID <b>19</b>].
     * <p>
     * The attribute is of type {@link Integer}.
     * <p>
     * The implementation of this attribute by a device is OPTIONAL
     *
     * @param currentZoneSensitivityLevel the {@link Integer} attribute value to be set
     * @return the {@link Future<CommandResult>} command result future
     */
    public Future<CommandResult> setCurrentZoneSensitivityLevel(final Object value) {
        return write(attributes.get(ATTR_CURRENTZONESENSITIVITYLEVEL), value);
    }

    /**
     * Get the <i>CurrentZoneSensitivityLevel</i> attribute [attribute ID <b>19</b>].
     * <p>
     * The attribute is of type {@link Integer}.
     * <p>
     * The implementation of this attribute by a device is OPTIONAL
     *
     * @return the {@link Future<CommandResult>} command result future
     */
    public Future<CommandResult> getCurrentZoneSensitivityLevelAsync() {
        return read(attributes.get(ATTR_CURRENTZONESENSITIVITYLEVEL));
    }


    /**
     * Synchronously get the <i>CurrentZoneSensitivityLevel</i> attribute [attribute ID <b>19</b>].
     * <p>
     * This method can return cached data if the attribute has already been received.
     * The parameter <i>refreshPeriod</i> is used to control this. If the attribute has been received
     * within <i>refreshPeriod</i> milliseconds, then the method will immediately return the last value
     * received. If <i>refreshPeriod</i> is set to 0, then the attribute will always be updated.
     * <p>
     * This method will block until the response is received or a timeout occurs unless the current value is returned.
     * <p>
     * The attribute is of type {@link Integer}.
     * <p>
     * The implementation of this attribute by a device is OPTIONAL
     *
     * @param refreshPeriod the maximum age of the data (in milliseconds) before an update is needed
     * @return the {@link Integer} attribute value, or null on error
     */
    public Integer getCurrentZoneSensitivityLevel(final long refreshPeriod) {
        if(refreshPeriod > 0 && attributes.get(ATTR_CURRENTZONESENSITIVITYLEVEL).getLastReportTime() != null) {
            long refreshTime = Calendar.getInstance().getTimeInMillis() - refreshPeriod;
            if(attributes.get(ATTR_CURRENTZONESENSITIVITYLEVEL).getLastReportTime().getTimeInMillis() < refreshTime) {
                return (Integer) attributes.get(ATTR_CURRENTZONESENSITIVITYLEVEL).getLastValue();
            }
        }

        return (Integer) readSync(attributes.get(ATTR_CURRENTZONESENSITIVITYLEVEL));
    }

    /**
     * The Zone Enroll Response
     *
     * @param enrollResponseCode {@link Integer} Enroll response code
     * @param zoneId {@link Integer} Zone ID
     * @return the {@link Future<CommandResult>} command result future
     */
    public Future<CommandResult> zoneEnrollResponse(Integer enrollResponseCode, Integer zoneId) {
        ZoneEnrollResponse command = new ZoneEnrollResponse();

        // Set the fields
        command.setEnrollResponseCode(enrollResponseCode);
        command.setZoneId(zoneId);

        return send(command);
    }

    /**
     * The Zone Status Change Notification Command
     *
     * @param zoneStatus {@link Integer} Zone Status
     * @param extendedStatus {@link Integer} Extended Status
     * @return the {@link Future<CommandResult>} command result future
     */
    public Future<CommandResult> zoneStatusChangeNotificationCommand(Integer zoneStatus, Integer extendedStatus) {
        ZoneStatusChangeNotificationCommand command = new ZoneStatusChangeNotificationCommand();

        // Set the fields
        command.setZoneStatus(zoneStatus);
        command.setExtendedStatus(extendedStatus);

        return send(command);
    }

    /**
     * The Zone Enroll Request Command
     *
     * @param zoneType {@link Integer} Zone Type
     * @param manufacturerCode {@link Integer} Manufacturer Code
     * @return the {@link Future<CommandResult>} command result future
     */
    public Future<CommandResult> zoneEnrollRequestCommand(Integer zoneType, Integer manufacturerCode) {
        ZoneEnrollRequestCommand command = new ZoneEnrollRequestCommand();

        // Set the fields
        command.setZoneType(zoneType);
        command.setManufacturerCode(manufacturerCode);

        return send(command);
    }

    @Override
    public ZclCommand getCommandFromId(int commandId) {
        switch (commandId) {
            case 0: // ZONE_ENROLL_RESPONSE
                return new ZoneEnrollResponse();
            default:
                return null;
        }
    }

    @Override
    public ZclCommand getResponseFromId(int commandId) {
        switch (commandId) {
            case 0: // ZONE_STATUS_CHANGE_NOTIFICATION_COMMAND
                return new ZoneStatusChangeNotificationCommand();
            case 1: // ZONE_ENROLL_REQUEST_COMMAND
                return new ZoneEnrollRequestCommand();
            default:
                return null;
        }
    }
}
