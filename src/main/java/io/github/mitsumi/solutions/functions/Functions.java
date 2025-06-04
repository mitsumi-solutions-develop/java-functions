package io.github.mitsumi.solutions.functions;

import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.function.*;

@NoArgsConstructor(staticName = "build")
public class Functions {

    /**
     * run runnable if the supplier returns true.
     *
     * @param supplier boolean supplier.
     * @param runnable runnable to run.
     * @param <T> type of the supplier.
     */
    public <T> void runIf(final Supplier<Boolean> supplier, final Runnable runnable) {
        if (supplier.get()) {
            runnable.run();
        }
    }

    /**
     * run runnable if the predicate returns true.
     *
     * @param supplier value supplier.
     * @param predicate predicate to test.
     * @param runnable runnable to run.
     * @param <T> type of the supplier.
     */
    public <T> void runIf(final Supplier<T> supplier, final Predicate<T> predicate, final Runnable runnable) {
        if (predicate.test(supplier.get())) {
            runnable.run();
        }
    }

    /**
     * run runnable if the predicate returns true.
     *
     * @param supplier value supplier.
     * @param predicate predicate to test.
     * @param runnable runnable to run.
     * @param other runnable to run if the predicate returns false.
     * @param <T> type of the supplier.
     */
    public <T> void runElse(final Supplier<T> supplier, final Predicate<T> predicate, final Runnable runnable,
                            final Runnable other) {
        if (predicate.test(supplier.get())) {
            runnable.run();
        } else {
            other.run();
        }
    }

    /**
     * run runnable if the supplier returns true.
     *
     * @param supplier boolean supplier.
     * @param runnable runnable to run.
     * @param other runnable to run if the supplier returns false.
     * @param <T> type of the supplier.
     */
    public <T> void runElse(final Supplier<Boolean> supplier, final Runnable runnable, final Runnable other) {
        if (supplier.get()) {
            runnable.run();
        } else {
            other.run();
        }
    }

    /**
     * throws the specified exception if the predicate returns true.
     *
     * @param conditionSupplier boolean supplier.
     * @param exceptionSupplier exception supplier.
     * @param <T> type of the exception.
     */
    public <T extends RuntimeException> void throwsIf(final Supplier<Boolean> conditionSupplier,
                                                      final Supplier<T> exceptionSupplier) {
        if (conditionSupplier.get()) {
            throw exceptionSupplier.get();
        }
    }

    /**
     * throws the specified exception if the predicate returns true.
     *
     * @param supplier value supplier.
     * @param predicate predicate to test.
     * @param exceptionSupplier exception supplier.
     * @param <T> type of the supplier.
     * @param <U> type of the exception.
     */
    public <T, U extends RuntimeException> void throwsIf(final Supplier<T> supplier, final Predicate<T> predicate,
                                                         final Supplier<U> exceptionSupplier) {
        if (predicate.test(supplier.get())) {
            throw exceptionSupplier.get();
        }
    }

    /**
     * apply the specified arguments supplier to the function.
     *
     * @param supplier value supplier.
     * @param function function to apply.
     * @return the result of the function.
     * @param <T> type of the supplier.
     * @param <R> type of the function result.
     */
    public <T, R> R apply(final Supplier<T> supplier, final Function<T, R> function) {
        return function.apply(supplier.get());
    }

    /**
     * apply the specified arguments supplier to the function.
     *
     * @param supplierT value supplier.
     * @param supplierU value supplier.
     * @param function function to apply.
     * @return the result of the function.
     * @param <T> type of the supplier.
     * @param <U> type of the supplier.
     * @param <R> type of the function result.
     */
    public <T, U, R> R apply(final Supplier<T> supplierT, final Supplier<U> supplierU,
                             final BiFunction<T, U, R> function) {
        return function.apply(supplierT.get(), supplierU.get());
    }

    /**
     * apply the specified arguments supplier to the function.
     *
     * @param supplierT value supplier.
     * @param supplierU value supplier.
     * @param supplierV value supplier.
     * @param function function to apply.
     * @return the result of the function.
     * @param <T> type of the supplier.
     * @param <U> type of the supplier.
     * @param <V> type of the supplier.
     * @param <R> type of the function result.
     */
    public <T, U, V, R> R apply(final Supplier<T> supplierT, final Supplier<U> supplierU, final Supplier<V> supplierV,
                                final TriFunction<T, U, V, R> function) {
        return function.apply(supplierT.get(), supplierU.get(), supplierV.get());
    }

    /**
     * apply the specified arguments supplier to the function.
     *
     * @param supplierT value supplier.
     * @param supplierU value supplier.
     * @param supplierV value supplier.
     * @param supplierW value supplier.
     * @param function function to apply.
     * @return the result of the function.
     * @param <T> type of the supplier.
     * @param <U> type of the supplier.
     * @param <V> type of the supplier.
     * @param <W> type of the supplier.
     * @param <R> type of the function result.
     */
    public <T, U, V, W, R> R apply(final Supplier<T> supplierT, final Supplier<U> supplierU,
                                   final Supplier<V> supplierV, final Supplier<W> supplierW,
                                   final QuadFunction<T, U, V, W, R> function) {
        return function.apply(supplierT.get(), supplierU.get(), supplierV.get(), supplierW.get());
    }

    /**
     * apply the specified arguments supplier to the function.
     *
     * @param supplierT value supplier.
     * @param supplierU value supplier.
     * @param supplierV value supplier.
     * @param supplierW value supplier.
     * @param supplierX value supplier.
     * @param function function to apply.
     * @return the result of the function.
     * @param <T> type of the supplier.
     * @param <U> type of the supplier.
     * @param <V> type of the supplier.
     * @param <W> type of the supplier.
     * @param <X> type of the supplier.
     * @param <R> type of the function result.
     */
    public <T, U, V, W, X, R> R apply(final Supplier<T> supplierT, final Supplier<U> supplierU,
                                      final Supplier<V> supplierV, final Supplier<W> supplierW,
                                      final Supplier<X> supplierX, final PentaFunction<T, U, V, W, X, R> function) {
        return function.apply(supplierT.get(), supplierU.get(), supplierV.get(), supplierW.get(), supplierX.get());
    }

    /**
     * apply the specified arguments supplier to the function.
     *
     * @param supplierT value supplier.
     * @param supplierU value supplier.
     * @param supplierV value supplier.
     * @param supplierW value supplier.
     * @param supplierX value supplier.
     * @param supplierY value supplier.
     * @param function function to apply.
     * @return the result of the function.
     * @param <T> type of the supplier.
     * @param <U> type of the supplier.
     * @param <V> type of the supplier.
     * @param <W> type of the supplier.
     * @param <X> type of the supplier.
     * @param <Y> type of the supplier.
     * @param <R> type of the function result.
     */
    public <T, U, V, W, X, Y, R> R apply(final Supplier<T> supplierT, final Supplier<U> supplierU,
                                         final Supplier<V> supplierV, final Supplier<W> supplierW,
                                         final Supplier<X> supplierX, final Supplier<Y> supplierY,
                                         final HexaFunction<T, U, V, W, X, Y, R> function) {
        return function.apply(supplierT.get(), supplierU.get(), supplierV.get(), supplierW.get(), supplierX.get(),
            supplierY.get());
    }

    /**
     * apply the specified arguments supplier to the function if the condition is true.
     * @param condition condition to test.
     * @param supplierT value supplier.
     * @param function function to apply.
     * @param supplierR value supplier.
     * @return the result of the function.
     * @param <T> type of the supplier.
     * @param <R> type of the function result.
     */
    public <T, R> R applyOrElse(final boolean condition, final Supplier<T> supplierT, final Function<T, R> function,
                                final Supplier<R> supplierR) {
        return condition ? function.apply(supplierT.get()) : supplierR.get();
    }

    /**
     * apply the specified arguments supplier to the function if the condition is true.
     *
     * @param condition condition to test.
     * @param supplierT value supplier.
     * @param supplierU value supplier.
     * @param function function to apply.
     * @param supplierR value supplier.
     * @return the result of the function.
     * @param <T> type of the supplier.
     * @param <U> type of the supplier.
     * @param <R> type of the function result.
     */
    public <T, U, R> R applyOrElse(final boolean condition, final Supplier<T> supplierT, final Supplier<U> supplierU,
                                   final BiFunction<T, U, R> function, final Supplier<R> supplierR) {
        return condition ? function.apply(supplierT.get(), supplierU.get()) : supplierR.get();
    }

    /**
     * apply the specified arguments supplier to the function if the condition is true.
     *
     * @param condition condition to test.
     * @param supplierT value supplier.
     * @param supplierU value supplier.
     * @param supplierV value supplier.
     * @param function function to apply.
     * @param supplierR value supplier.
     * @return the result of the function.
     * @param <T> type of the supplier.
     * @param <U> type of the supplier.
     * @param <V> type of the supplier.
     * @param <R> type of the function result.
     */
    public <T, U, V, R> R applyOrElse(final boolean condition, final Supplier<T> supplierT, final Supplier<U> supplierU,
                                      final Supplier<V> supplierV, final TriFunction<T, U, V, R> function,
                                      final Supplier<R> supplierR) {
        return condition ? function.apply(supplierT.get(), supplierU.get(), supplierV.get()) : supplierR.get();
    }

    /**
     * apply the specified arguments supplier to the function if the condition is true.
     *
     * @param condition condition to test.
     * @param supplierT value supplier.
     * @param supplierU value supplier.
     * @param supplierV value supplier.
     * @param supplierW value supplier.
     * @param function function to apply.
     * @param supplierR value supplier.
     * @return the result of the function.
     * @param <T> type of the supplier.
     * @param <U> type of the supplier.
     * @param <V> type of the supplier.
     * @param <W> type of the supplier.
     * @param <R> type of the function result.
     */
    public <T, U, V, W, R> R applyOrElse(final boolean condition, final Supplier<T> supplierT,
                                         final Supplier<U> supplierU, final Supplier<V> supplierV,
                                         final Supplier<W> supplierW, final QuadFunction<T, U, V, W, R> function,
                                         final Supplier<R> supplierR) {
        return condition ? function.apply(supplierT.get(), supplierU.get(), supplierV.get(), supplierW.get()) :
            supplierR.get();
    }

    /**
     * apply the specified arguments supplier to the function if the condition is true.
     *
     * @param condition condition to test.
     * @param supplierT value supplier.
     * @param supplierU value supplier.
     * @param supplierV value supplier.
     * @param supplierW value supplier.
     * @param supplierX value supplier.
     * @param function function to apply.
     * @param supplierR value supplier.
     * @return the result of the function.
     * @param <T> type of the supplier.
     * @param <U> type of the supplier.
     * @param <V> type of the supplier.
     * @param <W> type of the supplier.
     * @param <X> type of the supplier.
     * @param <R> type of the function result.
     */
    public <T, U, V, W, X, R> R applyOrElse(final boolean condition, final Supplier<T> supplierT,
                                            final Supplier<U> supplierU, final Supplier<V> supplierV,
                                            final Supplier<W> supplierW, final Supplier<X> supplierX,
                                            final PentaFunction<T, U, V, W, X, R> function,
                                            final Supplier<R> supplierR) {
        return condition ?
            function.apply(supplierT.get(), supplierU.get(), supplierV.get(), supplierW.get(), supplierX.get()) :
            supplierR.get();
    }

    /**
     * apply the specified arguments supplier to the function if the condition is true.
     *
     * @param condition condition to test.
     * @param supplierT value supplier.
     * @param ifTrue function to apply if the condition is true.
     * @param other function to apply if the condition is false.
     *
     * @return the result of the function.
     * @param <T> type of the supplier.
     * @param <R> type of the function result.
     */
    public <T, R> R applyOrElse(final boolean condition, final Supplier<T> supplierT, final Function<T, R> ifTrue,
                                final Function<T, R> other) {
        return condition ? ifTrue.apply(supplierT.get()) : other.apply(supplierT.get());
    }

    /**
     * performs the specified action if the condition is true.
     *
     * @param condition condition to test.
     * @param supplierT value supplier.
     * @param consumer action to perform.
     * @param <T> type of the supplier.
     */
    public <T> void acceptIf(final boolean condition, final Supplier<T> supplierT, Consumer<T> consumer) {
        if (condition) {
            consumer.accept(supplierT.get());
        }
    }

    /**
     * performs the specified action if the condition is true.
     *
     * @param condition condition to test.
     * @param t value supplier.
     * @param v value supplier.
     * @param consumer action to perform.
     * @param <T> type of the supplier.
     * @param <V> type of the supplier.
     */
    public <T, V> void acceptIf(final boolean condition, final Supplier<T> t, final Supplier<V> v,
                                    final BiConsumer<T, V> consumer) {
        if (condition) {
            consumer.accept(t.get(), v.get());
        }
    }

    /**
     * performs the specified action if the condition is true.
     *
     * @param condition condition to test.
     * @param supplierT value supplier.
     * @param consumer action to perform.
     * @param other action to perform if the condition is false.
     * @param <T> type of the supplier.
     */
    public <T> void acceptOrElse(final boolean condition, final Supplier<T> supplierT, Consumer<T> consumer,
                                 final Consumer<T> other) {
        if (condition) {
            consumer.accept(supplierT.get());
        } else {
            other.accept(supplierT.get());
        }
    }

    /**
     * gets the value from the specified supplier if the condition is true.
     *
     * @param condition condition to test.
     * @param supplier value supplier.
     * @param other value supplier.
     * @return the value from the specified supplier if the condition is true.
     * @param <T> type of the supplier.
     */
    public <T> T getOrElse(final boolean condition, final Supplier<T> supplier, final Supplier<T> other) {
        return condition ? supplier.get() : other.get();
    }

    /**
     * performs the specified action if the condition is true.
     *
     * @param supplierT value supplier.
     * @param consumer action to perform.
     * @param <T> type of the supplier.
     */
    public <T> T accept(final Supplier<T> supplierT, final Consumer<T> consumer) {
        var value = supplierT.get();

        consumer.accept(value);

        return value;
    }

    /**
     * performs the specified action.
     *
     * @param t value supplier.
     * @param v value supplier.
     * @param consumer action to perform.
     * @param <T> type of the supplier.
     * @param <V> type of the supplier.
     */
    public <T, V> void accept(final Supplier<T> t, final Supplier<V> v, final BiConsumer<T, V> consumer) {
        consumer.accept(t.get(), v.get());
    }

    /**
     * performs the specified action.
     *
     * @param t value supplier.
     * @param u value supplier.
     * @param v value supplier.
     * @param consumer action to perform.
     * @param <T> type of the supplier.
     * @param <U> type of the supplier.
     * @param <V> type of the supplier.
     */
    public <T, U, V> void accept(final Supplier<T> t, final Supplier<U> u, final Supplier<V> v,
                                 final TriConsumer<T, U, V> consumer) {
        consumer.accept(t.get(), u.get(), v.get());
    }

    /**
     * performs the specified action.
     *
     * @param t value supplier.
     * @param u value supplier.
     * @param v value supplier.
     * @param w value supplier.
     * @param consumer action to perform.
     * @param <T> type of the supplier.
     * @param <U> type of the supplier.
     * @param <V> type of the supplier.
     * @param <W> type of the supplier.
     */
    public <T, U, V, W> void accept(final Supplier<T> t, final Supplier<U> u, final Supplier<V> v, final Supplier<W> w,
                                    final QuadConsumer<T, U, V, W> consumer) {
        consumer.accept(t.get(), u.get(), v.get(), w.get());
    }

    /**
     * performs the specified action.
     *
     * @param t value supplier.
     * @param u value supplier.
     * @param v value supplier.
     * @param w value supplier.
     * @param x value supplier.
     * @param consumer action to perform.
     * @param <T> type of the supplier.
     * @param <U> type of the supplier.
     * @param <V> type of the supplier.
     * @param <W> type of the supplier.
     * @param <X> type of the supplier.
     */
    public <T, U, V, W, X> void accept(final Supplier<T> t, final Supplier<U> u, final Supplier<V> v,
                                       final Supplier<W> w, final Supplier<X> x,
                                       final PentaConsumer<T, U, V, W, X> consumer) {
        consumer.accept(t.get(), u.get(), v.get(), w.get(), x.get());
    }

    /**
     * performs the specified action.
     *
     * @param supplierT value supplier.
     * @param consumers action to perform.
     * @return the value from the specified supplier.
     * @param <T> type of the supplier.
     */
    @SafeVarargs
    public final <T> T accept(final Supplier<T> supplierT, final Consumer<T>... consumers) {
        return accept(supplierT, t -> List.of(consumers).forEach(consumer -> consumer.accept(t)));
    }

    /**
     * performs the specified action if the specified value is not null.
     *
     * @param supplierT value supplier.
     * @param consumers action to perform.
     * @return the value from the specified supplier.
     * @param <T> type of the supplier.
     */
    @SafeVarargs
    public final <T> T acceptNonNull(final Supplier<T> supplierT, final Consumer<T>... consumers) {
        return accept(
            supplierT,
            t -> Optional.ofNullable(t)
                .ifPresent(val -> List.of(consumers).forEach(consumer -> consumer.accept(t))));

    }
}
