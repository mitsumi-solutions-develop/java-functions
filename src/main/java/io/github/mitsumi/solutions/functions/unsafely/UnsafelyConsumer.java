package io.github.mitsumi.solutions.functions.unsafely;
public interface UnsafelyConsumer<T> {

    void accept(T value) throws Exception;
}
