package io.github.mitsumi.solutions.shared.functions.unsafely;

public interface UnsafelyRunner {

    /**
     * Performs this operation.
     *
     * @throws Exception if an error occurs while performing this operation.
     */
    void run() throws Exception;
}
