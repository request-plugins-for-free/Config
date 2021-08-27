# Discord
You can join our discord here: https://discord.gg/yGkS3Dh

---
## Usage Example
```java
package com.github.requestpluginsforfree.example;

import com.github.requestpluginsforfree.config.ConfigAPI;
import com.github.requestpluginsforfree.config.type.identifier.ConfigIdentifier;
import org.bukkit.plugin.java.JavaPlugin;

public class ExampleUsage extends JavaPlugin {

    @Override
    public void onEnable() {
        saveDefaultConfig();

        // Creating both instances of ConfigIdentifier for config & messages
        // First parameter is the identifier, it has to be unique and easy to remember so you can look it up anytime
        // Second parameter is the FileConfiguration instance, it needs this for ease of use
        final ConfigIdentifier configIdentifier = new ConfigIdentifier("config", getConfig());
        final ConfigIdentifier messagesIdentifier = new ConfigIdentifier("messages", getMessageConfig());

        // Initializing the API
        ConfigAPI.initialize(configIdentifier, messagesIdentifier);

        // Getting the value from message file
        final ConfigIdentifier config = ConfigAPI.get("messages");
        getLogger().info(config.configuration().getString("message"));
    }
}
```
