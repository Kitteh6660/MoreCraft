package kittehmod.morecraft.ai;

import net.minecraft.entity.passive.CatEntity;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class CatsSitOnChestsHandler 
{
    @SubscribeEvent
    public void changeSittingTaskForOcelots(final LivingEvent.LivingUpdateEvent evt)
    {
        if (evt.getEntityLiving().ticksExisted < 5 && evt.getEntityLiving() instanceof CatEntity)
        {
            CatEntity catEntity = (CatEntity) evt.getEntityLiving();
            
            if (catEntity.goalSelector.getRunningGoals().count() > 0) {
            	catEntity.goalSelector.addGoal(2, new ModChestCatSitOnBlockGoal(catEntity, 0.4F));
            }
        }
    }
	
}
