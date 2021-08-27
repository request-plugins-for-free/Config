package com.github.requestpluginsforfree.config.type.extend;

import com.github.requestpluginsforfree.config.type.Type;

public class TypeBoolean implements Type<Boolean> {
    @Override
    public Boolean accept(final Object input) {
        return (Boolean) input;
    }
}
