package me.mical.sshouse.command;

import me.mical.sshouse.SSHouse;
import me.mical.sshouse.utils.WorldEditUtil;
import org.bukkit.entity.Player;
import org.serverct.parrot.parrotx.command.BaseCommand;
import org.serverct.parrot.parrotx.command.CommandHandler;
import org.serverct.parrot.parrotx.command.subcommands.DebugCommand;
import org.serverct.parrot.parrotx.command.subcommands.HelpCommand;
import org.serverct.parrot.parrotx.command.subcommands.ReloadCommand;
import org.serverct.parrot.parrotx.command.subcommands.VersionCommand;
import org.serverct.parrot.parrotx.data.autoload.annotations.PAutoload;

@PAutoload
public class CmdHandler extends CommandHandler {

    public CmdHandler() {
        super(SSHouse.getInstance(), "sshouse");
        register(new HelpCommand(plugin));
        register(new ReloadCommand(plugin, ".reload"));
        register(new DebugCommand(plugin, ".reload"));
        register(new VersionCommand(plugin));
        register(new BaseCommand(plugin, "paste", 0) {
            @Override
            protected void call(String[] args) {
                if (sender instanceof Player) {
                    WorldEditUtil.pasteSchematic(((Player) sender).getLocation());
                }
            }
        });
    }
}
