package io.github.mitsumi.solutions.functions;

import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.function.*;

@NoArgsConstructor(staticName = "build")
public class Functions {

    public <T> void runIf(final Supplier<Boolean> supplier, final Runnable runnable) {
        if (supplier.get()) {
            runnable.run();
        }
    }

    public <T> void runIf(final Supplier<T> supplier, final Predicate<T> predicate, final Runnable runnable) {
        if (predicate.test(supplier.get())) {
            runnable.run();
        }
    }

    public <T> void runElse(final Supplier<T> supplier, final Predicate<T> predicate, final Runnable runnable,
                            final Runnable other) {
        if (predicate.test(supplier.get())) {
            runnable.run();
        } else {
            other.run();
        }
    }

    public <T> void runElse(final Supplier<Boolean> supplier, final Runnable runnable, final Runnable other) {
        if (supplier.get()) {
            runnable.run();
        } else {
            other.run();
        }
    }

    public <T extends RuntimeException> void throwsIf(final Supplier<Boolean> conditionSupplier,
                                                      final Supplier<T> exceptionSupplier) {
        if (conditionSupplier.get()) {
            throw exceptionSupplier.get();
        }
    }

    public <T, U extends RuntimeException> void throwsIf(final Supplier<T> supplier, final Predicate<T> predicate,
                                                         final Supplier<U> exceptionSupplier) {
        if (predicate.test(supplier.get())) {
            throw exceptionSupplier.get();
        }
    }

    public <T, R> R apply(final Supplier<T> supplier, final Function<T, R> function) {
        return function.apply(supplier.get());
    }

    public <T, U, R> R apply(final Supplier<T> supplierT, final Supplier<U> supplierU,
                             final BiFunction<T, U, R> function) {
        return function.apply(supplierT.get(), supplierU.get());
    }

    public <T, U, V, R> R apply(final Supplier<T> supplierT, final Supplier<U> supplierU, final Supplier<V> supplierV,
                                final TriFunction<T, U, V, R> function) {
        return function.apply(supplierT.get(), supplierU.get(), supplierV.get());
    }

    public <T, U, V, W, R> R apply(final Supplier<T> supplierT, final Supplier<U> supplierU,
                                   final Supplier<V> supplierV, final Supplier<W> supplierW,
                                   final QuadFunction<T, U, V, W, R> function) {
        return function.apply(supplierT.get(), supplierU.get(), supplierV.get(), supplierW.get());
    }

    public <T, U, V, W, X, R> R apply(final Supplier<T> supplierT, final Supplier<U> supplierU,
                                      final Supplier<V> supplierV, final Supplier<W> supplierW,
                                      final Supplier<X> supplierX, final PentaFunction<T, U, V, W, X, R> function) {
        return function.apply(supplierT.get(), supplierU.get(), supplierV.get(), supplierW.get(), supplierX.get());
    }


    public <T, U, V, W, X, Y, R> R apply(final Supplier<T> supplierT, final Supplier<U> supplierU,
                                         final Supplier<V> supplierV, final Supplier<W> supplierW,
                                         final Supplier<X> supplierX, final Supplier<Y> supplierY,
                                         final HexaFunction<T, U, V, W, X, Y, R> function) {
        return function.apply(supplierT.get(), supplierU.get(), supplierV.get(), supplierW.get(), supplierX.get(),
            supplierY.get());
    }

    public <T, R> R applyOrElse(final boolean condition, final Supplier<T> supplierT, final Function<T, R> function,
                                final Supplier<R> supplierR) {
        return condition ? function.apply(supplierT.get()) : supplierR.get();
    }

    public <T, U, R> R applyOrElse(final boolean condition, final Supplier<T> supplierT, final Supplier<U> supplierU,
                                   final BiFunction<T, U, R> function, final Supplier<R> supplierR) {
        return condition ? function.apply(supplierT.get(), supplierU.get()) : supplierR.get();
    }

    public <T, U, V, R> R applyOrElse(final boolean condition, final Supplier<T> supplierT, final Supplier<U> supplierU,
                                      final Supplier<V> supplierV, final TriFunction<T, U, V, R> function,
                                      final Supplier<R> supplierR) {
        return condition ? function.apply(supplierT.get(), supplierU.get(), supplierV.get()) : supplierR.get();
    }

    public <T, U, V, W, R> R applyOrElse(final boolean condition, final Supplier<T> supplierT,
                                         final Supplier<U> supplierU, final Supplier<V> supplierV,
                                         final Supplier<W> supplierW, final QuadFunction<T, U, V, W, R> function,
                                         final Supplier<R> supplierR) {
        return condition ? function.apply(supplierT.get(), supplierU.get(), supplierV.get(), supplierW.get()) :
            supplierR.get();
    }

    public <T, U, V, W, X, R> R applyOrElse(final boolean condition, final Supplier<T> supplierT,
                                            final Supplier<U> supplierU, final Supplier<V> supplierV,
                                            final Supplier<W> supplierW, final Supplier<X> supplierX,
                                            final PentaFunction<T, U, V, W, X, R> function,
                                            final Supplier<R> supplierR) {
        return condition ?
            function.apply(supplierT.get(), supplierU.get(), supplierV.get(), supplierW.get(), supplierX.get()) :
            supplierR.get();
    }

    public <T, R> R applyOrElse(final boolean condition, final Supplier<T> supplierT, final Function<T, R> ifTrue,
                                final Function<T, R> other) {
        return condition ? ifTrue.apply(supplierT.get()) : other.apply(supplierT.get());
    }

    public <T> void acceptIf(final boolean condition, final Supplier<T> supplierT, Consumer<T> consumer) {
        if (condition) {
            consumer.accept(supplierT.get());
        }
    }

    public <T, V> void acceptIf(final boolean condition, final Supplier<T> t, final Supplier<V> v,
                                    final BiConsumer<T, V> consumer) {
        if (condition) {
            consumer.accept(t.get(), v.get());
        }
    }


    public <T> void acceptOrElse(final boolean condition, final Supplier<T> supplierT, Consumer<T> consumer,
                                 final Consumer<T> other) {
        if (condition) {
            consumer.accept(supplierT.get());
        } else {
            other.accept(supplierT.get());
        }
    }

    public <T> T getOrElse(final boolean condition, final Supplier<T> supplier, final Supplier<T> other) {
        return condition ? supplier.get() : other.get();
    }

    public <T> T accept(final Supplier<T> supplierT, final Consumer<T> consumer) {
        var value = supplierT.get();

        consumer.accept(value);

        return value;
    }

    public <T, V> void accept(final Supplier<T> t, final Supplier<V> v, final BiConsumer<T, V> consumer) {
        consumer.accept(t.get(), v.get());
    }

    public <T, U, V> void accept(final Supplier<T> t, final Supplier<U> u, final Supplier<V> v,
                                 final TriConsumer<T, U, V> consumer) {
        consumer.accept(t.get(), u.get(), v.get());
    }

    public <T, U, V, W> void accept(final Supplier<T> t, final Supplier<U> u, final Supplier<V> v, final Supplier<W> w,
                                    final QuadConsumer<T, U, V, W> consumer) {
        consumer.accept(t.get(), u.get(), v.get(), w.get());
    }

    public <T, U, V, W, X> void accept(final Supplier<T> t, final Supplier<U> u, final Supplier<V> v,
                                       final Supplier<W> w, final Supplier<X> x,
                                       final PentaConsumer<T, U, V, W, X> consumer) {
        consumer.accept(t.get(), u.get(), v.get(), w.get(), x.get());
    }

    @SafeVarargs
    public final <T> T accept(final Supplier<T> supplierT, final Consumer<T>... consumers) {
        return accept(supplierT, t -> List.of(consumers).forEach(consumer -> consumer.accept(t)));
    }

    @SafeVarargs
    public final <T> T acceptNonNull(final Supplier<T> supplierT, final Consumer<T>... consumers) {
        return accept(
            supplierT,
            t -> Optional.ofNullable(t)
                .ifPresent(val -> List.of(consumers).forEach(consumer -> consumer.accept(t))));

    }
}
