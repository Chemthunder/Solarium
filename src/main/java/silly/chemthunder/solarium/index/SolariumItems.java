package silly.chemthunder.solarium.index;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import silly.chemthunder.solarium.Solarium;
import silly.chemthunder.solarium.item.CelestialMagnefierItem;
import silly.chemthunder.solarium.item.EuphoricFoodItem;
import silly.chemthunder.solarium.item.EuphoricMarshmallowItem;

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
            .food(new FoodComponent.Builder()
                    .nutrition((int) 5.0f)
                    .saturationModifier(3.5f)
                    .snack()
                    .build()
            )
    );

    Item MARSHMALLOW = create("prismallow", EuphoricMarshmallowItem::new, new Item.Settings()
            .maxCount(16)
            .food(new FoodComponent.Builder()
                    .nutrition((int) 1.0f)
                    .saturationModifier(0.5f)
                    .alwaysEdible()
                    .snack()
                    .build()
            )
    );

    Item MARSHMALLOW_ON_STICK = create("prismallow_stick", EuphoricMarshmallowItem::new, new Item.Settings()
            .maxCount(1)

            .food(
                    new FoodComponent.Builder()
                            .alwaysEdible()
                            .nutrition(1)
                            .saturationModifier(1.0f)
                            .build()
            )
    );

    Item ROASTED_MARSHMALLOW_ON_STICK = create("roasted_prismallow_stick", EuphoricMarshmallowItem::new, new Item.Settings()
            .maxCount(1)

            .food(
                    new FoodComponent.Builder()
                            .alwaysEdible()
                            .nutrition(6)
                            .saturationModifier(2.5f)
                            .build()
            )
    );

    Item CHOCLATE = create("chocolate", Item::new, new Item.Settings()
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

    Item MOON_PIE = create("moon_pie", EuphoricFoodItem::new, new Item.Settings()
            .food(new FoodComponent.Builder()
                    .nutrition((int) 2.5f)
                    .saturationModifier(1.5f)
                    .snack()
                    .build()
            )
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
