package net.kats.enderarmor.item;

import net.kats.enderarmor.EnderArmor;
import net.kats.enderarmor.ModArmorMaterial;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.stream.Stream;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, EnderArmor.MOD_ID);

    public static final RegistryObject<ArmorItem> ENDER_HELMET = ITEMS.register("ender_helmet",
            () -> new ArmorItem(ArmorTiers.ENDERPEARL, EquipmentSlot.HEAD, new Item.Properties()));
    public static final RegistryObject<ArmorItem> ENDER_CHESTPLATE= ITEMS.register("ender_chestplate",
            () -> new ArmorItem(ArmorTiers.ENDERPEARL, EquipmentSlot.CHEST, new Item.Properties()));
    public static final RegistryObject<ArmorItem> ENDER_LEGGINGS = ITEMS.register("ender_leggings",
            () -> new ArmorItem(ArmorTiers.ENDERPEARL, EquipmentSlot.LEGS, new Item.Properties()));
    public static final RegistryObject<ArmorItem> ENDER_BOOTS = ITEMS.register("ender_boots",
            () -> new ArmorItem(ArmorTiers.ENDERPEARL, EquipmentSlot.FEET, new Item.Properties()));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

    public static class ArmorTiers {
        public static final ArmorMaterial ENDERPEARL = new ModArmorMaterial(
                "enderpearl",
                500,
                new int[]{20, 40, 50, 10},
                300,
                SoundEvents.ENDER_DRAGON_GROWL,
                0.0f,
                0.0f,
                () -> Ingredient.fromValues((Stream<? extends Ingredient.Value>) Items.ENDER_PEARL)
        );
    }
}