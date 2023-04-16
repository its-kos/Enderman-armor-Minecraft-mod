package net.kats.enderarmor.event;

import net.kats.enderarmor.EnderArmor;
import net.minecraft.network.chat.Component;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.codehaus.plexus.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collection;

@Mod.EventBusSubscriber(modid = EnderArmor.MOD_ID)
public class ModEvents {
    @SubscribeEvent
    public static void onPlayerHurt(LivingHurtEvent event) {
        if (event.getEntity() instanceof Player player) {

            ArrayList<ItemStack> list = new ArrayList<ItemStack>();
            for (ItemStack item : player.getArmorSlots()) {
                list.add(item);
            }

            if (list.get(3).toString().equals("1 ender_helmet") && (event.getSource().equals(DamageSource.DROWN))) {
                player.sendSystemMessage(Component.literal(player.getName().getString() + " got shot with a projectile! They are wearing: " + list.get(3).toString() + " as helmet"));
            }
            if (event.getSource().isProjectile() && list.get(2).toString().equals("1 ender_chestplate")) {
                player.sendSystemMessage(Component.literal(player.getName().getString() + " got shot with a projectile! They are wearing: " + list.get(2).toString() + " as chestplate"));
            }
            if (event.getSource().isProjectile() && list.get(1).toString().equals("1 ender_leggings")) {
                player.sendSystemMessage(Component.literal(player.getName().getString() + " got shot with a projectile! They are wearing: " + list.get(1).toString() + " as leggings"));
            }
            if (event.getSource().isFall() && list.get(0).toString().equals("1 ender_boots")) {
                player.sendSystemMessage(Component.literal(player.getName().getString() + " got shot with a projectile! They are wearing: " + list.get(0).toString() + " as boots"));
            }
        }
    }
}
