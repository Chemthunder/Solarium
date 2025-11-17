package silly.chemthunder.solarium.index;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import silly.chemthunder.solarium.Solarium;

public interface SolariumItemGroups {
    RegistryKey<ItemGroup> GROUP_KEY = RegistryKey.of(RegistryKeys.ITEM_GROUP, Solarium.id("solarium"));
    ItemGroup A_GROUP = FabricItemGroup.builder()
            .icon(() -> new ItemStack(SolariumItems.MARSHMALLOW))
            .displayName(Text.translatable("itemgroup.solarium"))
            .build();

    static void init() {
        Registry.register(Registries.ITEM_GROUP, GROUP_KEY, A_GROUP);
        ItemGroupEvents.modifyEntriesEvent(GROUP_KEY).register(SolariumItemGroups::addEntries);

    }

    private static void addEntries(FabricItemGroupEntries i) {
       // itemGroup.add(ModItems.DEITYS_HANDBELL);
        i.add(SolariumItems.MARSHMALLOW);
        i.add(SolariumItems.MARSHMALLOW_ON_STICK);
        i.add(SolariumItems.CELESTEEL);
        i.add(SolariumItems.SMORE);
        i.add(SolariumItems.CHOCLATE);
    }
}
