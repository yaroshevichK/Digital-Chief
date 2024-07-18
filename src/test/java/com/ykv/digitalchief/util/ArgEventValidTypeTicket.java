
package com.ykv.digitalchief.util;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;

public class ArgEventValidTypeTicket implements ArgumentsProvider {

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) {
        return Stream.of(
                Arguments.of("SIMPLE", true),
                Arguments.of("VIP", true),
                Arguments.of("VIP2", true),
                Arguments.of("WRONG", false),
                Arguments.of("", false),
                Arguments.of(null, false)
        );
    }
}
