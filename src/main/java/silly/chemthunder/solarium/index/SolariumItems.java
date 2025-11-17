package silly.chemthunder.solarium.index;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import silly.chemthunder.solarium.Solarium;
import silly.chemthunder.solarium.item.CelestialMagnefierItem;
import silly.chemthunder.solarium.item.MarshmallowStickItem;

import java.util.function.Function;

public interface SolariumItems {

    // Item LUCTUS = create("luctus", LuctusItem::new, new Item.Settings()
    //        .attributeModifiers(SwordItem.createAttributeModifiers(ToolMaterials.NETHERITE, 5, -3.0F))
    //        .fireproof()
    //        .maxCount(1));

    Item CELESTEEL = create("celesteel", Item::new, new Item.Settings()
    );

    Item SMORE = create("smore", Item::new, new Item.Settings()
            .maxCount(1)
    );

    Item MARSHMALLOW = create("marshmallow", Item::new, new Item.Settings()
            .maxCount(16)
    );

    Item MARSHMALLOW_ON_STICK = create("marshmallow_stick", MarshmallowStickItem::new, new Item.Settings()
            .maxCount(1)
    );

    Item CHOCLATE = create("choclate", Item::new, new Item.Settings()
            .food(
                    new FoodComponent.Builder()
                            .alwaysEdible()
                            .nutrition(1)
                            .saturationModifier(1)
                            .alwaysEdible()
                            .build())
    );

    Item CELESTIAL_MAGNIFIER = create("celestial_magnifier", CelestialMagnefierItem::new, new Item.Settings()
            .maxCount(1)
            .fireproof()
    );

    static Item create(String name, Function<Item.Settings, Item> factory, Item.Settings settings) {
        Item item = factory.apply(settings);
        if (item instanceof BlockItem blockItem) {
            blockItem.appendBlocks(Item.BLOCK_ITEMS, item);
        }

        return Registry.register(Registries.ITEM, Solarium.id(name), item);
    }

    static void init() {}
}
