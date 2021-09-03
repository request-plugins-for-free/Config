package com.github.requestpluginsforfree.config.type.config;

import com.github.requestpluginsforfree.config.type.Type;
import com.github.requestpluginsforfree.config.type.extend.TypeBoolean;
import com.github.requestpluginsforfree.config.type.extend.TypeInteger;
import com.github.requestpluginsforfree.config.type.extend.TypeString;
import com.github.requestpluginsforfree.config.type.extend.TypeStringList;

import java.util.List;

public class ConfigType<T> {
    public static final ConfigType<String> STRING = new ConfigType<>(new TypeString());
    public static final ConfigType<Integer> INTEGER = new ConfigType<>(new TypeInteger());
    public static final ConfigType<Boolean> BOOLEAN = new ConfigType<>(new TypeBoolean());
    public static final ConfigType<List<String>> STRING_LIST = new ConfigType<>(new TypeStringList());
    private final Type<?> type;

    public ConfigType(final Type<?> type){
        this.type = type;
    }

    public T to(final Object input){
        return (T) type.accept(input);
    }
}
