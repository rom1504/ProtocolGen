package de.johni0702.mc.protocolgen.condition;

import de.johni0702.mc.protocolgen.PacketReadWriteTest;
import de.johni0702.mc.protocolgen.test.PacketTestConditionSimple;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class TestConditionSimple extends PacketReadWriteTest {
    private PacketTestConditionSimple packet;

    @Before
    public void init() {
        packet = new PacketTestConditionSimple();
    }

    @Test
    public void testReadInactive() throws IOException {
        read(packet, 1, 2);
        assertEquals(1, packet.before);
        assertEquals(0, packet.inner);
        assertEquals(2, packet.after);
    }

    @Test
    public void testReadActive() throws IOException {
        read(packet, 2, 3, 4);
        assertEquals(2, packet.before);
        assertEquals(3, packet.inner);
        assertEquals(4, packet.after);
    }

    @Test
    public void testWriteInactive() throws IOException {
        packet.before = 1;
        packet.after = 2;
        write(packet, 1, 2);
    }

    @Test
    public void testWriteActive() throws IOException {
        packet.before = 2;
        packet.inner = 3;
        packet.after = 4;
        write(packet, 2, 3, 4);
    }
}
