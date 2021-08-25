package com.github.requestpluginsforfree.config.type;

public interface Type<T> {
    /**
     * @param input the input
     *
     * @return casts the input to T class.
     * @apiNote it lacks any checks, so be careful.
     */
    T accept(final Object input);
}
