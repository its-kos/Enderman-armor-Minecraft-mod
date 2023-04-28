package net.kats.enderarmor.event;

import net.kats.enderarmor.EnderArmor;
import net.minecraft.network.chat.Component;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.wrapper.PlayerMainInvWrapper;

import java.util.ArrayList;

@Mod.EventBusSubscriber(modid = EnderArmor.MOD_ID)
public class ModEvents {
    @SubscribeEvent
    public static void onPlayerHurt(LivingHurtEvent event) {
        if (event.getEntity() instanceof Player player) {

            ArrayList<ItemStack> list = new ArrayList<>();
            for (ItemStack item : player.getArmorSlots()) {
                list.add(item);
            }

            ItemStack pearls = new ItemStack(Items.ENDER_PEARL);
            int pearlNum = player.getInventory().countItem(Items.ENDER_PEARL);

            if (list.get(3).toString().equals("1 ender_helmet") && pearlNum > 0 && (event.getSource().equals(DamageSource.DROWN))) {
                IItemHandler inventory = new PlayerMainInvWrapper(player.getInventory());
                for(int i = 0; i < inventory.getSlots(); i++) {
                    if(inventory.getStackInSlot(i).getItem() == Items.ENDER_PEARL) {
                        inventory.extractItem(i, 1, false);
                        break;
                    }
                }
                event.setCanceled(true);
            }

            if (event.getSource().isProjectile() && player.getInventory().countItem(Items.ENDER_PEARL) > 0 && list.get(2).toString().equals("1 ender_chestplate")) {
                IItemHandler inventory = new PlayerMainInvWrapper(player.getInventory());
                for(int i = 0; i < inventory.getSlots(); i++) {
                    if(inventory.getStackInSlot(i).getItem() == Items.ENDER_PEARL) {
                        inventory.extractItem(i, 1, false);
                        break;
                    }
                }
            }

            if (event.getSource().isProjectile() && player.getInventory().countItem(Items.ENDER_PEARL) > 0 && list.get(1).toString().equals("1 ender_leggings")) {
                IItemHandler inventory = new PlayerMainInvWrapper(player.getInventory());
                for(int i = 0; i < inventory.getSlots(); i++) {
                    if(inventory.getStackInSlot(i).getItem() == Items.ENDER_PEARL) {
                        inventory.extractItem(i, 1, false);
                        break;
                    }
                }
            }

            if (event.getSource().isFall() && player.getInventory().countItem(Items.ENDER_PEARL) > 0 && list.get(0).toString().equals("1 ender_boots")) {
                IItemHandler inventory = new PlayerMainInvWrapper(player.getInventory());
                for(int i = 0; i < inventory.getSlots(); i++) {
                    if(inventory.getStackInSlot(i).getItem() == Items.ENDER_PEARL) {
                        inventory.extractItem(i, 1, false);
                        break;
                    }
                }
            }

        }
    }
}
