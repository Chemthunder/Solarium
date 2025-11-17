package silly.chemthunder.solarium.util;

import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTables;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import silly.chemthunder.solarium.index.SolariumItems;

public class LootTableModifiers {



  public   static void init() {
        LootTableEvents.MODIFY.register((key, tableBuilder, source, registry) -> {
            if (LootTables.SIMPLE_DUNGEON_CHEST.equals(key)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(UniformLootNumberProvider.create(1.0F, 2.0F))
                        .conditionally(RandomChanceLootCondition.builder(0.25F))
                        .with(ItemEntry.builder(SolariumItems.CELESTEEL));

                tableBuilder.pool(poolBuilder);
            }
        });
    }
}
