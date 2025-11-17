package silly.chemthunder.solarium;

import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import silly.chemthunder.solarium.util.LootTableModifiers;
import silly.chemthunder.solarium.index.SolariumItemGroups;
import silly.chemthunder.solarium.index.SolariumItems;

public class Solarium implements ModInitializer {
	public static final String MOD_ID = "solarium";

    public static Identifier id (String path){
        return Identifier.of(MOD_ID, path); }
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
        SolariumItems.init();
        SolariumItemGroups.init();
        LootTableModifiers.init();

		LOGGER.info("Hello Fabric world!");
	}
}