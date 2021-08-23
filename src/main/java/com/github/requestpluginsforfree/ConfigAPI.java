package com.github.requestpluginsforfree;

import com.github.requestpluginsforfree.type.config.ConfigType;
import org.bukkit.configuration.file.FileConfiguration;

public final class ConfigAPI {
    private static FileConfiguration configuration;

    /**
     * Sets the FileConfiguration instance, to gather information from the config
     *
     * @param configuration FileConfiguration instance
     * @apiNote Be aware that if the config reloads, you'll need to re-execute this command or else it'll use the old instance of Configuration.
     */
    public static void initialize(final FileConfiguration configuration){
        ConfigAPI.configuration = configuration;
    }

    /**
     * This will retrieve the output by Spigot's default configuration get method
     *
     * @param input input path
     * @param type output return type
     * @param <T> the return type
     *
     * @return the output, otherwise null
     *
     * @exception IllegalStateException if configuration instance is not set
     */
    public static <T> T get(final String input, final ConfigType<?> type){
        if (configuration == null){
            throw new IllegalStateException("Configuration instance cannot be null");
        }
        return (T) type.to(configuration.get(input));
    }

    /**
     * The example (ctrl + click to see the code), be sure to set the FileConfiguration instance set!
     *
     * @exception IllegalStateException if configuration instance is not set
     */
    public static void example(){
        if (configuration == null){
            throw new IllegalStateException("Configuration instance cannot be null");
        }
        final String string = ConfigAPI.get("string", ConfigType.STRING);
        final Integer integer = ConfigAPI.get("integer", ConfigType.INTEGER);
        System.out.println("string: " + string);
        System.out.println("integer: " + integer);
    }
}
