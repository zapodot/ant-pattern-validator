package org.zapodot.antpatternvalidator.fs

import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.shouldNotBe

class FsUtilNativeTest: ShouldSpec({
    context("finding working folder on the native platform") {
        should("be able to resolve working folder") {
            val workingFolderPath = getWorkingDirectory()
            workingFolderPath shouldNotBe null
        }
    }
})