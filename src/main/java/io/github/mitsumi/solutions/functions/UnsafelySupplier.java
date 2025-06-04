package io.github.mitsumi.solutions.functions;

public interface UnsafelySupplier<T> {

    T get() throws Exception;
}
