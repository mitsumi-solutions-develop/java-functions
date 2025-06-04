package io.github.mitsumi.solutions.functions.unsafely;
public interface UnsafelyFunction<T, R> {

    R apply(T value) throws Exception;
}
