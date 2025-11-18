package silly.chemthunder.solarium.index;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import silly.chemthunder.solarium.Solarium;

public interface SolariumTags {
    TagKey<Block> HEAT_SOURCES = createTag("heat_sources");

    private static TagKey<Block> createTag(String id) {
        return TagKey.of(RegistryKeys.BLOCK, Identifier.of(Solarium.MOD_ID, id));
    }
}
