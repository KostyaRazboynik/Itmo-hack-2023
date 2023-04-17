# Способы работы с нашим SDK:

## Аннотация
```kotlin
@Measure
fun webMethod(@URL url) {
    // ...
}
```

## Ручное начало / окончание замера
```kotlin
{
    // ...
    val measurement = MeasuringService.start("name", Library.myLibrary) 
    // ... Web I/O
    MeasuringService.end(measurement)
    // ...
}
```

## Клиенты библиотек с правильными настройками
```kotlin
// Вместо...
val client = OkHttp3Client()
/// ...будем делать:
val client = profiler.okhttp3.OkHttp3Client().client
```
## HTTP - прокси
`не реализовано`
Возможности почти бесконечны, просто пропускаем траффик приложения / библиотеки через прокси

# Что реализовано с помощью нашего SDK?
- Curl - с помощью аннотаций / start/end
- ExoPlayer - клиент
- Fresco - клиент
- Glide - клиент, также можно измерить через start/end
- JNI - аннотация / start/end
- OkHttp - все 3 способа валидны
- Picasso - клиент / start/end
- Retrofit - клиент, грамотный программист также сможет измерить вручную с помощью start/end
- UrlConnection - start/end

