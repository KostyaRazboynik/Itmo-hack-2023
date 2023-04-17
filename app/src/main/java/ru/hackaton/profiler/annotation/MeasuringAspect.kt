package ru.hackaton.profiler.annotation


import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import ru.hackaton.profiler.base.Library
import ru.hackaton.profiler.base.MeasurementService

@Aspect
class MeasuringAspect {
    var url: String? = null;

    @Around("execution(* *(..)) && @annotation(ru.hackaton.profiler.annotation.Measure)")
    fun log(joinPoint: ProceedingJoinPoint): Any? {
        println(joinPoint.args)
        /*val url = joinPoint.args
            .filterIsInstance<String>()
            .firstOrNull { it::class.annotations.size > 0 }*/

        val measure = MeasurementService.startMeasurement(joinPoint.toShortString(), Library.Unknown)
        val result: Any? = joinPoint.proceed()
        MeasurementService.endMeasurement(measure.id)
        measure.url = url
        return result
    }
}

/**
 * An annotation that enables logging for a method
 */
@Target(AnnotationTarget.FUNCTION)
annotation class Measure

/**
 * Annotation that marks a parameter with a URL for a function that is being logged
 */
@Target(AnnotationTarget.VALUE_PARAMETER)
annotation class URL