package org.zapodot.antpatternvalidator.fs

import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.cinterop.refTo
import kotlinx.cinterop.toKStringFromUtf8
import okio.Path.Companion.toPath
import platform.posix.getcwd

@OptIn(ExperimentalForeignApi::class)
actual fun getWorkingDirectory(): okio.Path {
    val buffer = ByteArray(1024)
    return getcwd(buffer.refTo(0), buffer.size)?.toKStringFromUtf8()?.toPath() ?: error("Could not find a working directory")

}