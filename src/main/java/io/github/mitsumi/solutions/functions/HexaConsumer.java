
package io.github.mitsumi.solutions.functions;

import java.util.Objects;

@FunctionalInterface
public interface HexaConsumer<T, U, V, W, X, Y> {
    void accept(T t, U u, V v, W w, X x, Y y);

    /**
     * Returns a composed function that first applies this function to
     * its input, and then applies the {@code after} function to the result.
     * If evaluation of either function throws an exception, it is relayed to
     * the caller of the composed function.
     *
     * @param after the function to apply after this function is applied
     * @return a composed function that first applies this function and then
     * applies the {@code after} function
     * @throws NullPointerException if after is null
     */
    default HexaConsumer<T, U, V, W, X, Y> andThen(
        HexaConsumer<? super T, ? super U, ? super V, ? super W, ? super X, ? super Y> after
    ) {
        Objects.requireNonNull(after);

        return (t, u, v, w, x, y) -> {
            accept(t, u, v, w, x, y);
            after.accept(t, u, v, w, x, y);
        };
    }
}
