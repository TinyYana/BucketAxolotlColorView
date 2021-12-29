package io.github.tinyyana.bucketaxolotlcolorview;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class AddVariantLore implements CommandExecutor {

    public static String variant;
    private final BACVUtil util = new BACVUtil();

    public AddVariantLore(BucketAxolotlColorView plugin) {
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player player)) {
            BACVUtil.chatSend(sender, "General.NotPlayer");
            return true;
        }
        if (util.checkAxolotlBucketInMainHand(player)) {
            ItemStack handItem = player.getEquipment().getItemInMainHand();
            util.setBucketLore(player, handItem);
        }
        if (util.checkAxolotlBucketInOffHand(player)) {
            ItemStack handItem = player.getEquipment().getItemInOffHand();
            util.setBucketLore(player, handItem);
            return true;
        }
        if (!util.checkAxolotlBucketInMainHand(player) && !util.checkAxolotlBucketInOffHand(player)) {
            BACVUtil.chatSend(player, "BucketAxolotlCommand.NotHoldingAxolotlBucket");
            return true;
        }
        return true;
    }
}
