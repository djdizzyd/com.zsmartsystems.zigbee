/**
 * Copyright (c) 2016-2017 by the respective copyright holders.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package com.zsmartsystems.zigbee.dongle.ember.ash;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.zsmartsystems.zigbee.transport.ZigBeePort;
import org.junit.Test;

/**
 *
 * @author Chris Jackson
 *
 */
public class AshFrameHandlerTest {

    private class ZigBeePortLocal implements ZigBeePort {

        @Override
        public boolean open() {
            return false;
        }

        @Override
        public void close() {

        }

        @Override
        public OutputStream getOutputStream() {
            return null;
        }

        @Override
        public InputStream getInputStream() {
            return myStream;
        }

        private ByteArrayInputStream myStream;

        public void setMyStream(ByteArrayInputStream myStream1) {
            myStream = myStream1;
        }
    }
    private int[] getPacket(int[] data) {
        ZigBeePortLocal zbp = new ZigBeePortLocal();
        AshFrameHandler frameHandler = new AshFrameHandler(null, zbp);
        byte[] bytedata = new byte[data.length];
        int cnt = 0;
        for (int value : data) {
            bytedata[cnt++] = (byte) value;
        }
        ByteArrayInputStream stream = new ByteArrayInputStream(bytedata);

        zbp.setMyStream(stream);

        Method privateMethod;
        try {
            privateMethod = AshFrameHandler.class.getDeclaredMethod("getPacket", null);
            privateMethod.setAccessible(true);

            return (int[]) privateMethod.invoke(frameHandler, null);
        } catch (NoSuchMethodException | SecurityException | IllegalArgumentException | IllegalAccessException
                | InvocationTargetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return null;
    }

    @Test
    public void testReceivePacket() {
        int[] response = getPacket(new int[] { 0x01, 0x02, 0x03, 0x04, 0x7E });
        assertNotNull(response);
        assertEquals(4, response.length);
        assertEquals(0x01, response[0]);
    }

    @Test
    public void testReceivePacket_FlagStart() {
        int[] response = getPacket(new int[] { 0x7E, 0x01, 0x02, 0x03, 0x04, 0x7E });
        assertNotNull(response);
        assertEquals(4, response.length);
        assertEquals(0x01, response[0]);
    }

    @Test
    public void testReceivePacket_IgnoreXonXoff() {
        int[] response = getPacket(new int[] { 0x7E, 0x01, 0x02, 0x11, 0x03, 0x13, 0x04, 0x7E });
        assertNotNull(response);
        assertEquals(4, response.length);
        assertEquals(0x01, response[0]);
    }

    @Test
    public void testReceivePacket_Cancel() {
        int[] response = getPacket(new int[] { 0x7E, 0x01, 0x02, 0x1A, 0x03, 0x04, 0x05, 0x06, 0x07, 0x7E });
        assertNotNull(response);
        assertEquals(5, response.length);
        assertEquals(0x03, response[0]);
    }

    @Test
    public void testReceivePacket_Substitute() {
        int[] response = getPacket(new int[] { 0x7E, 0x01, 0x02, 0x18, 0x03, 0x04, 0x7E, 0x05, 0x06, 0x07, 0x7E });
        assertNotNull(response);
        assertEquals(3, response.length);
        assertEquals(0x05, response[0]);
    }

    @Test
    public void testRunning() {
        AshFrameHandler frameHandler = new AshFrameHandler(null, null);
        frameHandler.start();
        assertTrue(frameHandler.isAlive());
        frameHandler.close();
        assertFalse(frameHandler.isAlive());
    }

}
