package com.github.requestpluginsforfree.type.config;

import com.github.requestpluginsforfree.type.Type;
import com.github.requestpluginsforfree.type.extend.TypeInteger;
import com.github.requestpluginsforfree.type.extend.TypeString;

public class ConfigType<T> {
    public static final ConfigType<String> STRING = new ConfigType<>(new TypeString());
    public static final ConfigType<Integer> INTEGER = new ConfigType<>(new TypeInteger());
    private final Type<?> type;

    public ConfigType(final Type<?> type){
        this.type = type;
    }

    public T to(final Object input){
        return (T) type.accept(input);
    }
}
