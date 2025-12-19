package org.zapodot.antpatternvalidator.fs

import io.kotest.core.spec.style.ShouldSpec
import okio.Path.Companion.toPath
import kotlin.io.println

class FileSystemWalkerNativeTest: ShouldSpec({
    context("File system walker") {
        should("find text files in various folders") {
            
            println("current path: ${".".toPath()}")
        }
    }
})