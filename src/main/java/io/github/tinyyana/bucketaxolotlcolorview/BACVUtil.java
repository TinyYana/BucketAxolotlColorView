package io.github.tinyyana.bucketaxolotlcolorview;

import io.github.tinyyana.bucketaxolotlcolorview.BucketAxolotlColorView;
import io.github.tinyyana.bucketaxolotlcolorview.AddVariantLore;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Axolotl;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.AxolotlBucketMeta;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class BACVUtil {

    private final BucketAxolotlColorView plugin = BucketAxolotlColorView.instance;

    public static void chatSend(CommandSender sender, String message) {
        String content = BucketAxolotlColorView.instance.getConfig().getString("Messages." + message);
        if (content == null) return;
        if (content.equalsIgnoreCase("")) return;
        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', content));
    }

    public boolean checkAxolotlBucketInMainHand(Player player) {
        return player.getEquipment().getItemInMainHand().getType().equals(Material.AXOLOTL_BUCKET);
    }

    public boolean checkAxolotlBucketInOffHand(Player player) {
        return player.getEquipment().getItemInOffHand().getType().equals(Material.AXOLOTL_BUCKET);
    }

    public void setBucketLore(ItemStack itemStack) {
        ItemMeta meta = itemStack.getItemMeta();
        if (!(meta instanceof AxolotlBucketMeta bucketMeta)) return;
        if (!bucketMeta.hasVariant()) return;
        setVariantPlaceholder(bucketMeta);
        List<String> lore = new ArrayList<>();
        lore.add(
                PlaceholderAPI.setPlaceholders(null, plugin.getConfig().getString("Messages.ItemLore.Variant"))
        );
        meta.setLore(lore);
        itemStack.setItemMeta(meta);
    }

    public void setBucketLore(Player player, ItemStack itemStack) {
        ItemMeta meta = itemStack.getItemMeta();
        if (!(meta instanceof AxolotlBucketMeta bucketMeta)) return;
        if (!bucketMeta.hasVariant()) {
            chatSend(player, "General.NoVariant");
            return;
        }
        setVariantPlaceholder(bucketMeta);
        List<String> lore = new ArrayList<>();
        lore.add(
                PlaceholderAPI.setPlaceholders(player, plugin.getConfig().getString("Messages.ItemLore.Variant"))
        );
        meta.setLore(lore);
        itemStack.setItemMeta(meta);
    }

    public void setVariantPlaceholder(AxolotlBucketMeta meta) {
        if (meta.getVariant().equals(Axolotl.Variant.BLUE)) {
            AddVariantLore.variant = plugin.getConfig().getString("Placeholders.Blue");
        }
        if (meta.getVariant().equals(Axolotl.Variant.CYAN)) {
            AddVariantLore.variant = plugin.getConfig().getString("Placeholders.Cyan");
        }
        if (meta.getVariant().equals(Axolotl.Variant.GOLD)) {
            AddVariantLore.variant = plugin.getConfig().getString("Placeholders.Gold");
        }
        if (meta.getVariant().equals(Axolotl.Variant.LUCY)) {
            AddVariantLore.variant = plugin.getConfig().getString("Placeholders.Lucy");
        }
        if (meta.getVariant().equals(Axolotl.Variant.WILD)) {
            AddVariantLore.variant = plugin.getConfig().getString("Placeholders.Wild");
        }
    }
}
