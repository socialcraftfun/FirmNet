package fun.socialcraft.economy.firmnet;

import fun.socialcraft.economy.firmnet.commands.CommandCreateInvest;
import fun.socialcraft.economy.firmnet.commands.CommandInvest;
import org.bukkit.plugin.java.JavaPlugin;

public final class FirmNetPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        registerCommands();
    }

    public void registerCommands() {
        CommandCreateInvest createInvestCommand = new CommandCreateInvest();
        getCommand("createinvest").setExecutor(createInvestCommand);
        getCommand("createinvest").setTabCompleter(createInvestCommand);

        CommandInvest investCommand = new CommandInvest();
        getCommand("invest").setExecutor(investCommand);
        getCommand("invest").setTabCompleter(investCommand);
    }


    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
