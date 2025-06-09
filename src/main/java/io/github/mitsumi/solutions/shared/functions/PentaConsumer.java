package io.github.mitsumi.solutions.shared.functions;

import java.util.Objects;
import java.util.function.Consumer;

/**
 * Represents an operation that accepts five input arguments and returns no
 * result.  This is the five-arity specialization of {@link Consumer}.
 * Unlike most other functional interfaces, {@code PentaConsumer} is expected
 * to operate via side effects.
 *
 * <p>This is a <a href="package-summary.html">functional interface</a>
 *
 * @param <T> the type of the first argument to the operation
 * @param <U> the type of the second argument to the operation
 * @param <V> the type of the third argument to the operation
 * @param <W> the type of the fourth argument to the operation
 * @param <X> the type of the fifth argument to the operation
 *
 * @see Consumer
 */
@FunctionalInterface
@SuppressWarnings({"PMD.ShortVariable", "PMD.CommentSize"})
public interface PentaConsumer<T, U, V, W, X> {
    /**
     * Performs this operation on the given arguments.
     *
     * @param t the first input argument
     * @param u the second input argument
     * @param v the third input argument
     * @param w the fourth input argument
     * @param x the fifth input argument
     */
    void accept(T t, U u, V v, W w, X x);

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
    default PentaConsumer<T, U, V, W, X> andThen(
        final PentaConsumer<? super T, ? super U, ? super V, ? super W, ? super X> after
    ) {
        Objects.requireNonNull(after);

        return (t, u, v, w, x) -> {
            accept(t, u, v, w, x);
            after.accept(t, u, v, w, x);
        };
    }
}
