package ironcrushers.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class GoldCrusherConfig {

    public static ForgeConfigSpec.IntValue SPEED;

    public static void init(ForgeConfigSpec.Builder SERVER_BUILDER, ForgeConfigSpec.Builder CLIENT_BUILDER) {
        SERVER_BUILDER.comment("Golden Crusher");

        SPEED = SERVER_BUILDER
                .comment(" Number of ticks to complete one crushing operation.\n 300 ticks is what an iron crusher takes.\n Default: 200")
                .defineInRange("gold_crusher.speed", 200, 2, 72000);

    }

}
