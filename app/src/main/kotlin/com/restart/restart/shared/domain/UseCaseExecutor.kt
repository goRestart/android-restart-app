package com.restart.restart.shared.domain

import android.os.Handler
import org.funktionale.either.Either
import java.util.concurrent.ExecutorService

class UseCaseExecutor(
    private val executor: ExecutorService,
    private val handler: Handler
) {
    fun <I, O, E> execute(useCase: UseCase<I, O, E>, input: I): Response<E, O> {
        val response = Response<E, O>()
        executor.execute {
            val result = useCase.execute(input)
            processResult(response, result)
        }
        return response
    }

    private fun <E, O> processResult(response: Response<E, O>, result: Either<E, O>) {
        handler.post {
            when (result) {
                is Either.Right -> response.successCallback?.let { it(result.right().get()) }
                is Either.Left -> response.errorCallback?.let { it(result.left().get()) }
            }
        }
    }

    class Response<E, O> {
        var successCallback: ((output: O) -> Unit)? = null
        var errorCallback: ((error: E) -> Unit)? = null

        fun onSuccess(callback: (output: O) -> Unit): Response<E, O> {
            successCallback = callback
            return this
        }

        fun onError(callback: (error: E) -> Unit): Response<E, O> {
            errorCallback = callback
            return this
        }
    }
}