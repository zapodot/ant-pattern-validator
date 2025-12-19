package org.zapodot.antpatternvalidator.fs

import io.kotest.core.spec.style.ShouldSpec

class FileSystemWalkerCommonTest: ShouldSpec({
    context("File system walker") {
        should("find text files in various folders") {
            
            println("current path: ${getWorkingDirectory()}")
        }
    }
})