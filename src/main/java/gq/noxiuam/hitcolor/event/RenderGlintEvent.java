package gq.noxiuam.hitcolor.event;

import cc.polyfrost.oneconfig.events.event.CancellableEvent;
import net.minecraft.entity.Entity;

public class RenderGlintEvent extends CancellableEvent {

    public final Entity entity;

    public RenderGlintEvent(Entity entity) {
        this.entity = entity;
    }
}
