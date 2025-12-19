import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.core.Context
import com.github.ajalt.clikt.core.main
import com.github.ajalt.clikt.parameters.arguments.argument
import okio.FileSystem
import okio.Path.Companion.toPath

class AntValidator : CliktCommand() {
    private val pattern by argument(help = "Ant-style pattern (e.g. **/src/*.kt)")

    override fun help(context: Context): String = "Validates files against an Ant pattern"

    override fun run() {
        val regex = antToRegex(pattern)
        val fs = FileSystem.SYSTEM
        val currentDir = ".".toPath()

        echo("Searching for matches to: $pattern")

        fs.listRecursively(currentDir).forEach { path ->
            // Convert path to relative string for matching
            val relPath = path.toString().removePrefix("./")
            if (regex.matches(relPath)) {
                echo("✅ Match: $relPath")
            }
        }
    }
}

private fun antToRegex(pattern: String): Regex {
    val escaped = pattern
        .replace(".", "\\.")
        .replace("**/", "(.+/)?")
        .replace("/**", "(/.+)?")
        .replace("*", "[^/]*")
        .replace("?", ".")
    return Regex("^$escaped$")
}

fun main(args: Array<String>) = AntValidator().main(args)
