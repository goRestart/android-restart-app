package com.restart.restart.shared.domain

import org.funktionale.either.Either

interface UseCase<in I, out O, out E> {
    fun execute(input: I): Either<E, O>

    abstract class WithNoError<I, O> : UseCase<I, O, Unit> {
        abstract fun executeNoError(input: I): O
        override fun execute(input: I): Either<Unit, O> {
            return Either.right(executeNoError(input))
        }
    }

    abstract class WithNoInput<O, E> : UseCase<Unit, O, E> {
        abstract fun executeNoInput(): Either<E, O>
        override fun execute(input: Unit): Either<E, O> {
            return executeNoInput()
        }
    }

    abstract class WithNoInputNoError<O> : UseCase<Unit, O, Unit> {
        abstract fun executeNoInputNoError(): O
        override fun execute(input: Unit): Either<Unit, O> {
            return Either.right(executeNoInputNoError())
        }
    }
}