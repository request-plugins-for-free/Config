package com.github.requestpluginsforfree.type.identifier;

import org.bukkit.configuration.file.FileConfiguration;

public class ConfigIdentifier {
    public static ConfigIdentifier of(final String identifier, final FileConfiguration configuration){
        return new ConfigIdentifier(identifier, configuration);
    }
    private final String identifier;
    private FileConfiguration configuration;

    public ConfigIdentifier(final String identifier, final FileConfiguration configuration) {
        this.identifier = identifier;
        this.configuration = configuration;
    }

    public String getIdentifier() {
        return identifier;
    }

    public FileConfiguration configuration(final FileConfiguration configuration){
        this.configuration = configuration;
        return configuration;
    }

    public FileConfiguration configuration() {
        return configuration;
    }
}
