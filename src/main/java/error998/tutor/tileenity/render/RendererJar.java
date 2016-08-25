package error998.tutor.tileenity.render;

import error998.tutor.init.ModItems;
import error998.tutor.tileenity.TileEntityJar;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;

public class RendererJar extends TileEntitySpecialRenderer<TileEntityJar>
{	
	// Create a dummy item to use for the render
	private static final EntityItem ITEM = new EntityItem(Minecraft.getMinecraft().theWorld, 0,0,0, new ItemStack(ModItems.cheese_cracker));
	
	
	@Override
	public void renderTileEntityAt(TileEntityJar te, double x, double y, double z, float partialTicks, int destroyStage)
	{
		super.renderTileEntityAt(te, x, y, z, partialTicks, destroyStage);
		
		ITEM.hoverStart = 0;
		
		GlStateManager.pushMatrix();
		{
			GlStateManager.translate(x + 0.5f, y + 0.1f, z + 0.04f);
			GlStateManager.rotate(90, 1, 0, 0);

			for(int i = 0; i < te.getCrackerCount(); i++)
			{			
				Minecraft.getMinecraft().getRenderManager().doRenderEntity(ITEM, 0, 0, 0, 0f, 0f, false);
				GlStateManager.translate(0 ,0, -0.0625);
			}	
		}
		GlStateManager.popMatrix();
	}
}
