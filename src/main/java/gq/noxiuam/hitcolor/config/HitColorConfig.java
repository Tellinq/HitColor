package gq.noxiuam.hitcolor.config;

import cc.polyfrost.oneconfig.config.annotations.Color;
import cc.polyfrost.oneconfig.config.annotations.Dropdown;
import cc.polyfrost.oneconfig.config.annotations.Switch;
import cc.polyfrost.oneconfig.config.core.OneColor;
import gq.noxiuam.hitcolor.HitColor;
import cc.polyfrost.oneconfig.config.Config;
import cc.polyfrost.oneconfig.config.data.Mod;
import cc.polyfrost.oneconfig.config.data.ModType;

public class HitColorConfig extends Config {

    @Switch(
            name = "Affect Armor",
            subcategory = "General Options"
    )
    public boolean affectArmor = true;

    @Switch(
            name = "Affected by Brightness",
            subcategory = "General Options"
    )
    public boolean affectedByBrightness = true;

    @Dropdown(
            name = "Animation Type",
            subcategory = "Animation Options",
            options = {
                    "None",
                    "Linear In/Out",
                    "Linear Out"
            }
    )
    public int animationType = 0;

    @Color(
            name = "Hit Color",
            subcategory = "Color Options"
    )
    public OneColor hitColor = new OneColor(0x66FF0000);

    public HitColorConfig() {
        super(new Mod(HitColor.NAME, ModType.UTIL_QOL), HitColor.MODID + ".json");
        initialize();
    }

    /**
     * Used for pages in each entity's hit color.
     *
     * Notice that Affects Armor is removed here, it will be a global option.
     */
    /*public static class HitColorConfiguration {

        @Switch(
                name = "Affected by Brightness",
                subcategory = "General Options"
        )
        public boolean affectedByBrightness = true;

        @Dropdown(
                name = "Animation Type",
                subcategory = "Animation Options",
                options = {
                        "None",
                        "Linear In/Out",
                        "Linear Out"
                }
        )
        public String animationType = "None";

        @Color(
                name = "Hit Color",
                subcategory = "Color Options"
        )
        public OneColor hitColor = new OneColor(0x66FF0000);

    }*/

}

