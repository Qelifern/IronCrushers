package ironcrushers.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class SilverCrusherConfig {

    public static ForgeConfigSpec.IntValue SPEED;

    public static void init(ForgeConfigSpec.Builder SERVER_BUILDER, ForgeConfigSpec.Builder CLIENT_BUILDER) {
        SERVER_BUILDER.comment("Silver Crusher");

        SPEED = SERVER_BUILDER
                .comment(" Number of ticks to complete one crushing operation.\n 300 ticks is what an iron crusher takes.\n Default: 240")
                .defineInRange("silver_crusher.speed", 250, 2, 72000);

    }

}
