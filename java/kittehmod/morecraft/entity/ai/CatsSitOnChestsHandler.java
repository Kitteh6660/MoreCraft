package kittehmod.morecraft.entity.ai;

import net.minecraft.world.entity.animal.Cat;
import net.minecraftforge.event.entity.living.LivingEvent.LivingTickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class CatsSitOnChestsHandler 
{
    @SubscribeEvent
    public void changeSittingTaskForOcelots(final LivingTickEvent evt)
    {
        if (evt.getEntity().tickCount < 5 && evt.getEntity() instanceof Cat)
        {
            Cat catEntity = (Cat) evt.getEntity();
            
            if (catEntity.goalSelector.getRunningGoals().count() > 0) {
            	catEntity.goalSelector.addGoal((int)catEntity.goalSelector.getRunningGoals().count(), new ModChestCatSitOnBlockGoal(catEntity, 0.4F));
            }
        }
    }
	
}
