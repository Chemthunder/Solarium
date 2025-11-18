package silly.chemthunder.solarium.item;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import silly.chemthunder.solarium.index.SolariumStatusEffects;

public class EuphoricFoodItem extends Item {
    public EuphoricFoodItem(Settings settings) {
        super(settings);
    }

    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        user.addStatusEffect(new StatusEffectInstance(SolariumStatusEffects.EUPHORIA, Integer.MAX_VALUE));
        return super.finishUsing(stack, world, user);
    }
}
