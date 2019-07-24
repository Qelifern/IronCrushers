package ironcrushers.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class CopperCrusherConfig {

    public static ForgeConfigSpec.IntValue SPEED;

    public static void init(ForgeConfigSpec.Builder SERVER_BUILDER, ForgeConfigSpec.Builder CLIENT_BUILDER) {
        SERVER_BUILDER.comment("Copper Crusher");

        SPEED = SERVER_BUILDER
                .comment(" Number of ticks to complete one crushing operation.\n 300 ticks is what an iron crusher takes.\n Default: 320")
                .defineInRange("copper_crusher.speed", 320, 2, 72000);

    }

}
