package ru.hackaton.profiler.base

data class Measurement(
    val id: String,
    val name: String? = null,
    val library: Library? = null,
    var type: RequestType,

    var size: Long? = null,
    var url: String? = null,

    val status: Status = Status(),
    var stackTrace: Array<out StackTraceElement>? = null,
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Measurement

        if (id != other.id) return false
        if (name != other.name) return false
        if (library != other.library) return false
        if (type != other.type) return false
        if (size != other.size) return false
        if (url != other.url) return false
        if (status != other.status) return false
        if (stackTrace != null) {
            if (other.stackTrace == null) return false
            if (!stackTrace.contentEquals(other.stackTrace)) return false
        } else if (other.stackTrace != null) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + (name?.hashCode() ?: 0)
        result = 31 * result + (library?.hashCode() ?: 0)
        result = 31 * result + type.hashCode()
        result = 31 * result + (size?.hashCode() ?: 0)
        result = 31 * result + (url?.hashCode() ?: 0)
        result = 31 * result + status.hashCode()
        result = 31 * result + (stackTrace?.contentHashCode() ?: 0)
        return result
    }
}
