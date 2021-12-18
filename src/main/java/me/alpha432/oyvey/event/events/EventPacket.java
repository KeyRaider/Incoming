package me.alpha432.oyvey.event.events;

import net.minecraft.network.Packet;
import me.alpha432.oyvey.event.Event;

public class EventPacket
extends Event {
    private final Packet<?> packet;

    public EventPacket(Packet<?> packet) {
        this.packet = packet;
    }

    public <T extends Packet<?>> T getPacket() {
        return (T)this.packet;
    }

    public static final class Post
    extends EventPacket {
        public Post(Packet<?> packet) {
            super(packet);
        }
    }

    public static final class Send
    extends EventPacket {
        public Send(Packet<?> packet) {
            super(packet);
        }
    }

    public static final class Receive
    extends EventPacket {
        public Receive(Packet<?> packet) {
            super(packet);
        }
    }
}
