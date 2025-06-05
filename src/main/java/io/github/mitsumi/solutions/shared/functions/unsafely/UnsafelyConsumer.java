package io.github.mitsumi.solutions.shared.functions.unsafely;

public interface UnsafelyConsumer<T> {

    /**
     * Performs this operation on the given argument.
     *
     * @param value the input argument
     * @throws Exception if an error occurs while performing this operation.
     */
    void accept(T value) throws Exception;
}
