package io.github.tinyyana.bucketaxolotlcolorview;

import io.github.tinyyana.bucketaxolotlcolorview.BACVUtil;
import io.github.tinyyana.bucketaxolotlcolorview.BucketAxolotlColorView;
import io.github.tinyyana.bucketaxolotlcolorview.AddVariantLore;
import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class HookPlaceholder extends PlaceholderExpansion {
    private final BucketAxolotlColorView plugin;
    private final BACVUtil util = new BACVUtil();

    public HookPlaceholder(BucketAxolotlColorView plugin) {
        this.plugin = plugin;
    }

    @Override
    public @NotNull String getIdentifier() {
        return "BucketAxolotlColorView";
    }

    @Override
    public @NotNull String getAuthor() {
        return plugin.getDescription().getAuthors().toString();
    }

    @Override
    public @NotNull String getVersion() {
        return plugin.getDescription().getVersion();
    }

    @Override
    public boolean canRegister() {
        return true;
    }

    @Override
    public boolean persist() {
        return true;
    }

    @Override
    public String onPlaceholderRequest(Player player, @NotNull String params) {
        if (params.equals("variant")){
            return AddVariantLore.variant;
        }
        return null;
    }
}
