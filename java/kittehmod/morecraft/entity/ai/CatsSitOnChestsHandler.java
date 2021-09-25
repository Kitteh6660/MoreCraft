package kittehmod.morecraft.entity.ai;

import net.minecraft.world.entity.animal.Cat;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class CatsSitOnChestsHandler 
{
    @SubscribeEvent
    public void changeSittingTaskForOcelots(final LivingEvent.LivingUpdateEvent evt)
    {
        if (evt.getEntityLiving().tickCount < 5 && evt.getEntityLiving() instanceof Cat)
        {
            Cat catEntity = (Cat) evt.getEntityLiving();
            
            if (catEntity.goalSelector.getRunningGoals().count() > 0) {
            	catEntity.goalSelector.addGoal((int)catEntity.goalSelector.getRunningGoals().count(), new ModChestCatSitOnBlockGoal(catEntity, 0.4F));
            }
        }
    }
	
}
