package gq.noxiuam.hitcolor.config;

import cc.polyfrost.oneconfig.config.Config;
import cc.polyfrost.oneconfig.config.annotations.Color;
import cc.polyfrost.oneconfig.config.annotations.Dropdown;
import cc.polyfrost.oneconfig.config.annotations.Page;
import cc.polyfrost.oneconfig.config.annotations.Switch;
import cc.polyfrost.oneconfig.config.core.OneColor;
import cc.polyfrost.oneconfig.config.data.Mod;
import cc.polyfrost.oneconfig.config.data.ModType;
import cc.polyfrost.oneconfig.config.data.PageLocation;
import gq.noxiuam.hitcolor.HitColor;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.passive.*;

public class HitColorConfig extends Config {

    // global
    @Dropdown(name = "Option Behavior", subcategory = "General", options = { "Individual", "Global", "Both" })
    public int globalOverride = 0;

    @Switch(name = "Affect Armor", subcategory = "General")
    public boolean affectArmor = true;

    @Switch(name = "Affected by Brightness", subcategory = "Global Options")
    public boolean affectedByBrightness = true;

    @Switch(name = "Remove Glint on Armor When Damaged", subcategory = "Global Options")
    public boolean removeGlintOnArmor = true;

    @Dropdown(name = "Animation Type", subcategory = "Global Options", options = { "None", "Linear In/Out", "Linear Out" }, size = 2)
    public int animationType = 0;

    @Color(name = "Hit Color", subcategory = "Global Options")
    public OneColor hitColor = new OneColor(0x66FF0000);

    // passive
    @Page(name = "Player", location = PageLocation.TOP, category = "Passive Entities")
    public HitColorConfiguration player = new HitColorConfiguration();

    @Page(name = "Pig", location = PageLocation.TOP, category = "Passive Entities")
    public HitColorConfiguration pig = new HitColorConfiguration();

    @Page(name = "Cow", location = PageLocation.TOP, category = "Passive Entities")
    public HitColorConfiguration cow = new HitColorConfiguration();

    @Page(name = "Sheep", location = PageLocation.TOP, category = "Passive Entities")
    public HitColorConfiguration sheep = new HitColorConfiguration();

    @Page(name = "Chicken", location = PageLocation.TOP, category = "Passive Entities")
    public HitColorConfiguration chicken = new HitColorConfiguration();

    @Page(name = "Horse", location = PageLocation.TOP, category = "Passive Entities")
    public HitColorConfiguration horse = new HitColorConfiguration();

    @Page(name = "Ocelot", location = PageLocation.TOP, category = "Passive Entities")
    public HitColorConfiguration ocelot = new HitColorConfiguration();

    @Page(name = "Wolf", location = PageLocation.TOP, category = "Passive Entities")
    public HitColorConfiguration wolf = new HitColorConfiguration();

    @Page(name = "Rabbit", location = PageLocation.TOP, category = "Passive Entities")
    public HitColorConfiguration rabbit = new HitColorConfiguration();

    @Page(name = "Bat", location = PageLocation.TOP, category = "Passive Entities")
    public HitColorConfiguration bat = new HitColorConfiguration();

    @Page(name = "Squid", location = PageLocation.TOP, category = "Passive Entities")
    public HitColorConfiguration squid = new HitColorConfiguration();

    @Page(name = "Mooshroom", location = PageLocation.TOP, category = "Passive Entities")
    public HitColorConfiguration mooshroom = new HitColorConfiguration();

    @Page(name = "Villager", location = PageLocation.TOP, category = "Passive Entities")
    public HitColorConfiguration villager = new HitColorConfiguration();

    // hostile
    @Page(name = "Zombie", location = PageLocation.TOP, subcategory = "Overworld", category = "Hostile Entities")
    public HitColorConfiguration zombie = new HitColorConfiguration();

    @Page(name = "Creeper", location = PageLocation.TOP, subcategory = "Overworld", category = "Hostile Entities")
    public HitColorConfiguration creeper = new HitColorConfiguration();

    @Page(name = "Skeleton", location = PageLocation.TOP, subcategory = "Overworld", category = "Hostile Entities")
    public HitColorConfiguration skeleton = new HitColorConfiguration();

    @Page(name = "Spider", location = PageLocation.TOP, subcategory = "Overworld", category = "Hostile Entities")
    public HitColorConfiguration spider = new HitColorConfiguration();

    @Page(name = "Cave Spider", location = PageLocation.TOP, subcategory = "Overworld", category = "Hostile Entities")
    public HitColorConfiguration caveSpider = new HitColorConfiguration();

    @Page(name = "Guardian", location = PageLocation.TOP, subcategory = "Overworld", category = "Hostile Entities")
    public HitColorConfiguration guardian = new HitColorConfiguration();

    @Page(name = "Slime", location = PageLocation.TOP, subcategory = "Overworld", category = "Hostile Entities")
    public HitColorConfiguration slime = new HitColorConfiguration();

    @Page(name = "Snow Golem", location = PageLocation.TOP, subcategory = "Overworld", category = "Hostile Entities")
    public HitColorConfiguration snowGolem = new HitColorConfiguration();

    @Page(name = "Silverfish", location = PageLocation.TOP, subcategory = "Overworld", category = "Hostile Entities")
    public HitColorConfiguration silverfish = new HitColorConfiguration();

    @Page(name = "Iron Golem", location = PageLocation.TOP, subcategory = "Overworld", category = "Hostile Entities")
    public HitColorConfiguration ironGolem = new HitColorConfiguration();

    @Page(name = "Giant", location = PageLocation.TOP, subcategory = "Overworld", category = "Hostile Entities")
    public HitColorConfiguration giant = new HitColorConfiguration();

    @Page(name = "Zombie Pigman", location = PageLocation.TOP, subcategory = "The Nether", category = "Hostile Entities")
    public HitColorConfiguration zombiePigman = new HitColorConfiguration();

    @Page(name = "Blaze", location = PageLocation.TOP, subcategory = "The Nether", category = "Hostile Entities")
    public HitColorConfiguration blaze = new HitColorConfiguration();

    @Page(name = "Magma Cube", location = PageLocation.TOP, subcategory = "The Nether", category = "Hostile Entities")
    public HitColorConfiguration magmaCube = new HitColorConfiguration();

    @Page(name = "Ghast", location = PageLocation.TOP, subcategory = "The Nether", category = "Hostile Entities")
    public HitColorConfiguration ghast = new HitColorConfiguration();

    @Page(name = "Wither Skeleton", location = PageLocation.TOP, subcategory = "The Nether", category = "Hostile Entities")
    public HitColorConfiguration witherSkeleton = new HitColorConfiguration();

    @Page(name = "Enderman", location = PageLocation.TOP, subcategory = "The End", category = "Hostile Entities")
    public HitColorConfiguration enderman = new HitColorConfiguration();

    @Page(name = "Endermite", location = PageLocation.TOP, subcategory = "The End", category = "Hostile Entities")
    public HitColorConfiguration endermite = new HitColorConfiguration();

    @Page(name = "Ender Dragon", location = PageLocation.TOP, subcategory = "The End", category = "Hostile Entities")
    public HitColorConfiguration enderDragon = new HitColorConfiguration();

    public HitColorConfig() {
        super(new Mod(HitColor.NAME, ModType.UTIL_QOL), HitColor.MODID + ".json");
        initialize();

        addDependency("affectedByBrightness", () -> globalOverride != 0);
        addDependency("removeGlintOnArmor", () -> globalOverride != 0);
        addDependency("animationType", () -> globalOverride != 0);
        addDependency("hitColor", () -> globalOverride != 0);
    }

    public int getAnimationTypeToUse(HitColorConfiguration e) {
        // individual only
        if (globalOverride == 0) {
            return e.animationType;
        }

        // global only
        if (globalOverride == 1) {
            return animationType;
        }

        // both only, will only be used if an individual page option is changed.
        return e.animationType == 0 ? animationType : e.animationType;
    }

    public boolean getBrightnessToUse(HitColorConfiguration e) {
        // individual only
        if (globalOverride == 0) {
            return e.affectedByBrightness;
        }

        // global only
        if (globalOverride == 1) {
            return affectedByBrightness;
        }

        // both only, will only be used if an individual page option is changed.
        return e.affectedByBrightness ? affectedByBrightness : e.affectedByBrightness;
    }

    public boolean getRemoveGlintToUse(HitColorConfiguration e) {
        // individual only
        if (globalOverride == 0) {
            return e.removeGlintOnArmor;
        }

        // global only
        if (globalOverride == 1) {
            return removeGlintOnArmor;
        }

        // both only, will only be used if an individual page option is changed.
        return e.removeGlintOnArmor ? removeGlintOnArmor : e.removeGlintOnArmor;
    }

    public OneColor getColorToUse(HitColorConfiguration e) {
        // individual only
        if (globalOverride == 0) {
            return e.hitColor;
        }

        // global only
        if (globalOverride == 1) {
            return hitColor;
        }

        // both only, will only be used if an individual page option is changed.
        return e.hitColor.getRGB() == 0x66FF0000 ? hitColor : e.hitColor;
    }

    /**
     * Finds a hit color configuration based on an Entity.
     * The code for this is very shit, however
     * <p>
     *
     * @param entity - The entity to find configurations for.
     */
    public HitColorConfiguration getEntityType(EntityLivingBase entity) {

        if (entity instanceof EntityPig) {
            return this.pig;
        } else if (entity instanceof EntityMooshroom) {
            return this.mooshroom;
        } else if (entity instanceof EntityCow) {
            return this.cow;
        } else if (entity instanceof EntitySheep) {
            return this.sheep;
        } else if (entity instanceof EntityChicken) {
            return this.chicken;
        } else if (entity instanceof EntityHorse) {
            return this.horse;
        } else if (entity instanceof EntityOcelot) {
            return this.ocelot;
        } else if (entity instanceof EntityWolf) {
            return this.wolf;
        } else if (entity instanceof EntityRabbit) {
            return this.rabbit;
        } else if (entity instanceof EntityBat) {
            return this.bat;
        } else if (entity instanceof EntitySquid) {
            return this.squid;
        } else if (entity instanceof EntityVillager) {
            return this.villager;
            // end of passive
        } else if (entity instanceof EntityPigZombie) {
            // start of the nether hostile mob category
            return this.zombiePigman;
        } else if (entity instanceof EntityZombie) {
            // start of hostile
            return this.zombie;
        } else if (entity instanceof EntitySkeleton) {
            // special case for the wither skeleton type.
            if (((EntitySkeleton) entity).getSkeletonType() == 1) {
                return this.witherSkeleton;
            } else {
                return this.skeleton;
            }
        } else if (entity instanceof EntityCreeper) {
            return this.creeper;
        } else if (entity instanceof EntityCaveSpider) {
            return this.caveSpider;
        } else if (entity instanceof EntitySpider) {
            return this.spider;
        } else if (entity instanceof EntityGuardian) {
            return this.guardian;
        } else if (entity instanceof EntityMagmaCube) {
            return this.magmaCube;
        } else if (entity instanceof EntitySlime) {
            return this.slime;
        } else if (entity instanceof EntitySnowman) {
            return this.snowGolem;
        } else if (entity instanceof EntityIronGolem) {
            return this.ironGolem;
        } else if (entity instanceof EntitySilverfish) {
            return this.silverfish;
        } else if (entity instanceof EntityGiantZombie) {
            return this.giant;
            // end of overworld
        } else if (entity instanceof EntityGhast) {
            return this.ghast;
        } else if (entity instanceof EntityBlaze) {
            return this.blaze;
        } else if (entity instanceof EntityEnderman) {
            // the start of the end ...
            return this.enderman;
        } else if (entity instanceof EntityEndermite) {
            return this.endermite;
        } else if (entity instanceof EntityDragon) {
            return this.enderDragon;
        }

        return this.player;
    }

    /**
     * Used for pages in each entity's hit color.
     * <p>
     * Notice that Affects Armor is removed here, it will be a global option.
     */
    public static class HitColorConfiguration {

        @Switch(name = "Affected by Brightness", subcategory = "General Options")
        public boolean affectedByBrightness = true;

        @Switch(name = "Remove Glint on Armor When Damaged", subcategory = "General")
        public boolean removeGlintOnArmor = true;

        @Dropdown(name = "Animation Type", subcategory = "Animation Options", options = {"None", "Linear In/Out", "Linear Out"})
        public int animationType = 0;

        @Color(name = "Hit Color", subcategory = "Color Options")
        public OneColor hitColor = new OneColor(0x66FF0000);

    }

}

