package io.github.mitsumi.solutions.functions;
public interface UnsafelyConsumer<T> {

    void accept(T value) throws Exception;
}
