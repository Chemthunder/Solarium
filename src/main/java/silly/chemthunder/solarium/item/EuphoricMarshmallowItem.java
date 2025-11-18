package silly.chemthunder.solarium.item;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.world.World;
import silly.chemthunder.solarium.index.SolariumItems;
import silly.chemthunder.solarium.index.SolariumStatusEffects;
import silly.chemthunder.solarium.index.SolariumTags;

public class EuphoricMarshmallowItem extends Item {
    public EuphoricMarshmallowItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        PlayerEntity player = context.getPlayer();


        if (world.getBlockState(context.getBlockPos()).isIn(SolariumTags.HEAT_SOURCES)) {
            if (player != null) {
                ItemStack stack = player.getStackInHand(player.getActiveHand());

                player.getItemCooldownManager().set(SolariumItems.MARSHMALLOW_ON_STICK, 60);

                stack.decrement(1);
                player.giveItemStack(SolariumItems.ROASTED_MARSHMALLOW_ON_STICK.getDefaultStack());

                player.playSound(SoundEvents.BLOCK_AMETHYST_BLOCK_CHIME);
                player.playSound(SoundEvents.ENTITY_GENERIC_BURN);
            }
        }
        return super.useOnBlock(context);
    }

    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        if (stack.isOf(SolariumItems.ROASTED_MARSHMALLOW_ON_STICK)) {
            user.addStatusEffect(new StatusEffectInstance(SolariumStatusEffects.EUPHORIA, Integer.MAX_VALUE));
        }
        return super.finishUsing(stack, world, user);
    }
}
