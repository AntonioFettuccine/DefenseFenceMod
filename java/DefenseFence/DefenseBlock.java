package DefenseFence;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.IMob;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class DefenseBlock extends Block {



	@SideOnly(Side.CLIENT)
	private IIcon TopIcon;

	@SideOnly(Side.CLIENT)
	private IIcon SideIcon;

	public DefenseBlock(){
		super(Material.cactus);
		setCreativeTab(CreativeTabs.tabDecorations);
		setBlockName("DefenseBlock");
		setBlockTextureName("antoniofettuccine:glowstone");
		setStepSound(Block.soundTypeStone);
		setTickRandomly(true);
		setLightLevel(1.0F);


	}

    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z)
    {
        float f = 0.0625F;
        return AxisAlignedBB.getBoundingBox((double)((float)x + f), (double)y, (double)((float)z + f), (double)((float)(x+ 1) - f), (double)((float)(y+ 1) - f), (double)((float)(z + 1) - f));
    }

	public void onEntityCollidedWithBlock(World world, int X, int Y, int Z, Entity Entity)
	{
		if(Entity instanceof IMob){
			Entity.attackEntityFrom(DamageSource.cactus, 1.0F);
		}
	}

@Override
@SideOnly(Side.CLIENT)
public void registerBlockIcons(IIconRegister par1IconRegister)
{
    this.TopIcon = par1IconRegister.registerIcon("antoniofettuccine:glowstone");
    this.SideIcon = par1IconRegister.registerIcon("antoniofettuccine:glowstone");
}

@SideOnly(Side.CLIENT)
public IIcon getIcon(int par1, int par2)
{
     if(par1 == 0 || par1 == 1)
     {
              return TopIcon;
     }
     else
     {
              return SideIcon;
     }
}
}