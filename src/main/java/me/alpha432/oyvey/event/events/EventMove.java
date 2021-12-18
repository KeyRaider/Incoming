package me.alpha432.oyvey.event.events;

import net.minecraft.entity.MoverType;
import me.alpha432.oyvey.event.Event;

public class EventMove
extends Event {
    public MoverType moverType;
    public double motionX;
    public double motionY;
    public double motionZ;

    public EventMove(MoverType moverType, double motionX, double motionY, double motionZ) {
        this.moverType = moverType;
        this.motionX = motionX;
        this.motionY = motionY;
        this.motionZ = motionZ;
    }
}
