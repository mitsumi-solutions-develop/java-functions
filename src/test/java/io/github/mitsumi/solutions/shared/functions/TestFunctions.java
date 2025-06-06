package io.github.mitsumi.solutions.shared.functions;

import io.github.mitsumi.solutions.shared.functions.models.User;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class TestFunctions {
    private final Functions functions = Functions.build();

    @Test
    public void test_accept() {
        var user = new User();
        var actualValue = functions.accept(() -> "username", user::username);
        var actualUsername = user.username();

        assertThat(actualValue, is("username"));
        assertThat(actualUsername, is("username"));
    }
}
