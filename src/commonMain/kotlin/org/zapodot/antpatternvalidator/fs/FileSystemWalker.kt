package org.zapodot.antpatternvalidator.fs

import okio.FileSystem
import okio.Path
import okio.SYSTEM
import org.zapodot.antpatternvalidator.fs.AntPatternTranslator.antToRegex

object FileSystemWalker {

    fun listFiles(fromDirectory: Path, antPattern: String, messenger: (String) -> Unit): Sequence<Path> {
        val regex = antToRegex(antPattern)
        val fs = FileSystem.SYSTEM
        messenger("Searching for matches to: $antPattern (regex: $regex) from $fromDirectory")
        return fs.listRecursively(fromDirectory).filter { path ->
            // Convert path to relative string for matching
            val relPath = path.toString().removePrefix("./")
            regex.matches(relPath)
        }
    }
}