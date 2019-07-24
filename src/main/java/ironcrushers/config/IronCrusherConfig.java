package ironcrushers.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class IronCrusherConfig {

    public static ForgeConfigSpec.IntValue SPEED;

    public static void init(ForgeConfigSpec.Builder SERVER_BUILDER, ForgeConfigSpec.Builder CLIENT_BUILDER) {
        SERVER_BUILDER.comment("Iron Crusher");

        SPEED = SERVER_BUILDER
                .comment(" Number of ticks to complete one crushing operation.\n 300 ticks is what an iron crusher takes.\n Default: 300")
                .defineInRange("iron_crusher.speed", 300, 2, 72000);

    }

}
