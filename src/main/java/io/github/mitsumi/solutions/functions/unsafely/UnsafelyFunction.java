package io.github.mitsumi.solutions.functions.unsafely;

public interface UnsafelyFunction<T, R> {

    /**
     * Applies this function to the given argument.
     *
     * @param value the function argument.
     * @return the function result.
     * @throws Exception if an error occurs while performing this operation.
     */
    R apply(T value) throws Exception;
}
