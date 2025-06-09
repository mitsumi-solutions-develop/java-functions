package io.github.mitsumi.solutions.shared.functions.models;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true, fluent = true)
public class User {

    private String username;
}
