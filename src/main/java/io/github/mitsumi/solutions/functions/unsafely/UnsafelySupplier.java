package io.github.mitsumi.solutions.functions.unsafely;

public interface UnsafelySupplier<T> {

    T get() throws Exception;
}
