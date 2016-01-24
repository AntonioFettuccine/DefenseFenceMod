package DefenseFence;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

@Mod(modid="DefenseFence",name="DefensefenceMod",version="1.0")

public class DefenseFenceCore
{
	public static Block blockdefense;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		blockdefense = new DefenseBlock();
		GameRegistry.registerBlock(blockdefense, "blockDefense");
		GameRegistry.addRecipe(new ItemStack(DefenseFenceCore.blockdefense,4),
				"XYX",
				"YZY",
				"XYX",
				'X',new ItemStack(Items.dye, 1, 4),
				'Y',Items.glowstone_dust,
				'Z',Items.redstone
				);

	}
}