package silly.chemthunder.solarium.index;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import silly.chemthunder.solarium.Solarium;
import silly.chemthunder.solarium.effect.EuphoriaEffect;

public interface SolariumStatusEffects {
    RegistryEntry<StatusEffect> EUPHORIA = create("euphoria", new EuphoriaEffect(StatusEffectCategory.NEUTRAL, 0x0000));

    private static RegistryEntry<StatusEffect> create(String name, StatusEffect statusEffect) {
        return Registry.registerReference(Registries.STATUS_EFFECT, Solarium.id(name), statusEffect);
    }

    static void init() {
    }
}
