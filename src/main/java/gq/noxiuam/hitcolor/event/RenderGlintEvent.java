package gq.noxiuam.hitcolor.event;

import cc.polyfrost.oneconfig.events.event.CancellableEvent;
import net.minecraft.entity.Entity;

/** Called when the potion metadata is finished updating. */
public class RenderGlintEvent extends CancellableEvent {

    public final Entity entity;

    public RenderGlintEvent(Entity entity) {
        this.entity = entity;
    }
}
