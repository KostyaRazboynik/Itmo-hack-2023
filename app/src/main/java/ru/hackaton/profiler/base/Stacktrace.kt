package ru.hackaton.profiler.base

object Stacktrace {
    fun getTraceback(): Array<out StackTraceElement> {
        return Thread.currentThread().stackTrace;
    }
}