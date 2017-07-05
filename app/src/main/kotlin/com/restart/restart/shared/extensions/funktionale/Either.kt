package com.restart.restart.shared.extensions.funktionale

import org.funktionale.either.Either

fun <L, R>Either<L, R>.onLeft(f: (L) -> Unit): Either<L, R> {
    if (isLeft()) {
        f(left().get())
    }
    return this
}

fun <L, R>Either<L, R>.onRight(f: (R) -> Unit): Either<L, R> {
    if (isRight()) {
        f(right().get())
    }
    return this
}