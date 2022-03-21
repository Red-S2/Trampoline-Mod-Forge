package com.red_s2.trampoline.setup;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraft.core.RegistryAccess.RegistryEntry;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static com.red_s2.trampoline.TrampolineMod.MODID;

import com.red_s2.trampoline.Blocks.White;
import com.red_s2.trampoline.setup.ModSetup;
import net.minecraft.world.item.BlockItem;

public class Registration {

    private static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);
    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);

    public static void init() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        BLOCKS.register(bus);
        ITEMS.register(bus);
    }

    public static final BlockBehaviour.Properties TRAMPOLINE = BlockBehaviour.Properties.of(Material.METAL).jumpFactor(2).strength(2);
    public static final Item.Properties ITEM_PROPERTIES = new Item.Properties().tab(ModSetup.ITEM_GROUP);
    
    //Blöcke
    public static final RegistryObject<Block> WHITE = BLOCKS.register("white", () -> new White());

    //ITEMS
    public static final RegistryObject<Item> WHITE_TRAMPOLINE_ITEM = fromBlock(WHITE);



    public static <B extends Block> RegistryObject<Item> fromBlock(RegistryObject<B> block) {
        return ITEMS.register(block.getId().getPath(), () -> new BlockItem(block.get(), ITEM_PROPERTIES));
    }
}
/**/
