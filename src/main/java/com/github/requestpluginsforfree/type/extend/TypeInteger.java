package com.github.requestpluginsforfree.type.extend;

import com.github.requestpluginsforfree.type.Type;

public class TypeInteger implements Type<Integer> {

    /**
     * @param input the input
     *
     * @return casts the input to T class.
     * @apiNote it lacks any checks, so be careful.
     */
    @Override
    public Integer accept(final Object input) {
        return (Integer) input;
    }
}
