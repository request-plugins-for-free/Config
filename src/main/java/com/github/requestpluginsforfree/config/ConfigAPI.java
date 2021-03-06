package com.github.requestpluginsforfree.config;

import com.github.requestpluginsforfree.config.type.config.ConfigType;
import com.github.requestpluginsforfree.config.type.identifier.ConfigIdentifier;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class ConfigAPI {
    private static List<ConfigIdentifier> identifiers = new ArrayList<>();

    /**
     * Adds the identifier to list
     *
     * @param identifiers the config identifier
     * @apiNote Be aware that if the config reloads, you'll need to re-execute this command or else it'll use the old instance of Configuration.
     */
    public static void initialize(final ConfigIdentifier... identifiers){
        ConfigAPI.identifiers.addAll(Arrays.asList(identifiers));
    }

    /**
     * @param identifier config identifier
     *
     * @return If it's found ConfigIdentifier instance, otherwise null
     */
    public static ConfigIdentifier get(final String identifier){
        for (final ConfigIdentifier configIdentifier : identifiers){
            if (configIdentifier.getIdentifier().equalsIgnoreCase(identifier)) return configIdentifier;
        }
        return null;
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
    public static <T> T get(final String identifier, final String input, final ConfigType<?> type){
        final ConfigIdentifier config = get(identifier);
        if (config == null){
            throw new IllegalStateException("Configuration instance cannot be null");
        }
        return (T) type.to(config.configuration().get(input));
    }

    /**
     * This will retrieve the output by Spigot's default configuration get method
     *
     * @param input input path
     * @param defaultValue the default value
     * @param <T> the return type
     *
     * @return the output, otherwise the defaultValue
     *
     * @exception IllegalStateException if configuration instance is not set
     */
    public static <T> T get(final String identifier, final T defaultValue, final String input){
        final ConfigIdentifier config = get(identifier);
        if (config == null){
            throw new IllegalStateException("Configuration instance cannot be null");
        }
        return (T) config.configuration().get(input, defaultValue);
    }

    /**
     * The example (ctrl + click to see the code), be sure to set the FileConfiguration instance set!
     *
     * @exception IllegalStateException if configuration instance is not set
     */
    public static void example(){
        final ConfigIdentifier config = get("config");
        if (config == null){
            throw new IllegalStateException("Configuration instance cannot be null");
        }
        final String string = ConfigAPI.get("config", "string", ConfigType.STRING);
        final Integer integer = ConfigAPI.get("config", "integer", ConfigType.INTEGER);
        System.out.println("string: " + string);
        System.out.println("integer: " + integer);
    }
}
