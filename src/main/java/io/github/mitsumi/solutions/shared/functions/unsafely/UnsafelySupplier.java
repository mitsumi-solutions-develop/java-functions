package io.github.mitsumi.solutions.shared.functions.unsafely;

public interface UnsafelySupplier<T> {

    /**
     * Gets a result.
     *
     * @return a result.
     * @throws Exception if an error occurs while getting a result.
     */
    T get() throws Exception;
}
