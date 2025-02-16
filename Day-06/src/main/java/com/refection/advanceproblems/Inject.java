package com.refection.advanceproblems;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)  // Can be used on fields
@Retention(RetentionPolicy.RUNTIME)  // Available at runtime
public @interface Inject {
}
