package silly.chemthunder.solarium.effect;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

public class EuphoriaEffect extends StatusEffect {
    public EuphoriaEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public int getFadeTicks() {
        return 60;
    }
}
