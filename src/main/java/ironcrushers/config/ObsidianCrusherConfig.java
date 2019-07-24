package ironcrushers.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class ObsidianCrusherConfig {

    public static ForgeConfigSpec.IntValue SPEED;

    public static void init(ForgeConfigSpec.Builder SERVER_BUILDER, ForgeConfigSpec.Builder CLIENT_BUILDER) {
        SERVER_BUILDER.comment("Obsidian Crusher");

        SPEED = SERVER_BUILDER
                .comment(" Number of ticks to complete one crushing operation.\n 300 ticks is what an iron crusher takes.\n Default: 60")
                .defineInRange("obsidian_crusher.speed", 60, 2, 72000);

    }

}
