package io.github.tinyyana.bucketaxolotlcolorview;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBucketEntityEvent;
import org.bukkit.inventory.ItemStack;

public class PlayerBucketEntityListener implements Listener {
    BACVUtil util = new BACVUtil();

    @EventHandler(priority = EventPriority.LOW, ignoreCancelled = true)
    public void onEntityBucket(PlayerBucketEntityEvent event) {
        ItemStack entityBucket = event.getEntityBucket();
        if (!BucketAxolotlColorView.instance.getConfig().getBoolean("Configuration.AddLoreOnBucket")) return;
        if (!event.getPlayer().hasPermission("BucketAxolotlColorView.AddLore")) return;
        if (!entityBucket.getType().equals(Material.AXOLOTL_BUCKET)) return;
        util.setBucketLore(entityBucket);
    }
}
