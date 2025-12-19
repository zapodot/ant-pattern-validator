package org.zapodot.antpatternvalidator

import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.core.Context
import com.github.ajalt.clikt.core.main
import com.github.ajalt.clikt.parameters.arguments.argument
import org.zapodot.antpatternvalidator.fs.FileSystemWalker
import org.zapodot.antpatternvalidator.fs.getWorkingDirectory

class AntValidator : CliktCommand() {
    private val pattern by argument(help = "Ant-style pattern (e.g. **/src/*.kt)")

    override fun help(context: Context): String = "Validates files against an Ant pattern"

    override fun run() {
        FileSystemWalker.listFiles(getWorkingDirectory(), pattern) { message ->
            echo(message)
        }.forEach {
            echo("✅ Match: $it")
        }
    }
}

private fun antToRegex(pattern: String): Regex = pattern
    .replace(".", "\\.")
    .replace("**/", "(.+/)?")
    .replace("/**", "(/.+)?")
    .replace("*", "[^/]*")
    .replace("?", ".")
    .toRegex()

fun main(args: Array<String>) = AntValidator().main(args)