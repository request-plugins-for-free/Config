package com.github.requestpluginsforfree.config.type.extend;

import com.github.requestpluginsforfree.config.type.Type;

import java.util.List;

public class TypeStringList implements Type<List<String>> {
    /**
     * @param input the input
     *
     * @return casts the input to T class.
     *
     * @apiNote it lacks any checks, so be careful.
     */
    @Override
    public List<String> accept(final Object input) {
        return (List<String>) input;
    }
}
