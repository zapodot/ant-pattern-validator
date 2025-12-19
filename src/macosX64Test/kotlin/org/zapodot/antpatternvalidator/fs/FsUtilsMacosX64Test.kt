package org.zapodot.antpatternvalidator.fs

import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.nulls.beNull
import io.kotest.matchers.shouldNot

class FsUtilsMacosX64Test: ShouldSpec({
    context("Resolving working directory on MacosX64") {
        should("resolve working folder") {
            val workingFolderPath = getWorkingDirectory()
            workingFolderPath shouldNot beNull()
        }
    }
})