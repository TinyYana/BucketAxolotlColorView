package io.github.tinyyana.bucketaxolotlcolorview;

import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public final class BucketAxolotlColorView extends JavaPlugin {

    public static BucketAxolotlColorView instance;

    @Override
    public void onEnable() {
        instance = this;
        checkConfigFile();
        updateConfig();
        getCommand("bucketaxolotl").setExecutor(new AddVariantLore(this));
        getServer().getPluginManager().registerEvents(new PlayerBucketEntityListener(), this);
        new HookPlaceholder(this).register();
    }

    @Override
    public void onDisable() {
    }

    private void checkConfigFile() {
        File configFile = new File(this.getDataFolder().getPath(), File.separator + "config.yml");
        if (!configFile.exists()) {
            getConfig().options().copyDefaults(true);
            saveDefaultConfig();
        }
    }

    private void updateConfig() {
        if (!getConfig().contains("Configuration.AddLoreOnBucket")) {
            getConfig().set("Configuration.AddLoreOnBucket", true);
            getConfig().options().copyDefaults(true);
            this.saveConfig();
        }
    }
}
