package com.github.requestpluginsforfree.config.type.extend;

import com.github.requestpluginsforfree.config.type.Type;

public class TypeString implements Type<String> {

    /**
     * @param input the input
     *
     * @return casts the input to T class.
     * @apiNote it lacks any checks, so be careful.
     */
    @Override
    public String accept(final Object input) {
        return (String) input;
    }
}
