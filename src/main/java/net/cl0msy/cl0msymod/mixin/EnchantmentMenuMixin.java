package net.cl0msy.cl0msymod.mixin;

import net.minecraft.world.inventory.EnchantmentMenu;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(EnchantmentMenu.class)
public abstract class EnchantmentMenuMixin {

    @Shadow protected abstract ContainerLevelAccess getAccess();

    @Inject(method = "clickMenuButton", at = @At("RETURN"))
    private void cl0msy$onEnchantClick(Player player, int id, CallbackInfoReturnable<Boolean> cir) {
        // If 'cir.getReturnValue()' is true, the enchantment was successful
        if (cir.getReturnValue()) {
            this.getAccess().execute((level, pos) -> {
                // Your Woar Core logic goes here!
                // This code runs exactly when a player enchants an item.
                System.out.println("Item Enchanted at: " + pos);
            });
        }
    }
}