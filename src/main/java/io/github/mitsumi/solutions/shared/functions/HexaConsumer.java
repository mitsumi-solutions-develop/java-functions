
package io.github.mitsumi.solutions.shared.functions;

import java.util.Objects;
import java.util.function.Consumer;

/**
 * Represents an operation that accepts six input arguments and returns no
 * result.  This is the six-arity specialization of {@link Consumer}.
 * Unlike most other functional interfaces, {@code HexaConsumer} is expected
 * to operate via side effects.
 *
 * <p>This is a <a href="package-summary.html">functional interface</a>
 *
 * @param <T> the type of the first argument to the operation
 * @param <U> the type of the second argument to the operation
 * @param <V> the type of the third argument to the operation
 * @param <W> the type of the fourth argument to the operation
 * @param <X> the type of the fifth argument to the operation
 * @param <Y> the type of the six argument to the operation
 *
 * @see Consumer
 */
@SuppressWarnings({"PMD.ShortVariable", "PMD.CommentSize"})
@FunctionalInterface
public interface HexaConsumer<T, U, V, W, X, Y> {

    /**
     * Performs this operation on the given arguments.
     *
     * @param t the first input argument
     * @param u the second input argument
     * @param v the third input argument
     * @param w the fourth input argument
     * @param x the fifth input argument
     * @param y the sixth input argument
     */
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
        final HexaConsumer<? super T, ? super U, ? super V, ? super W, ? super X, ? super Y> after
    ) {
        Objects.requireNonNull(after);

        return (t, u, v, w, x, y) -> {
            accept(t, u, v, w, x, y);
            after.accept(t, u, v, w, x, y);
        };
    }
}
