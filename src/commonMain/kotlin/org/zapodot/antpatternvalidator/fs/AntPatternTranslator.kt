package org.zapodot.antpatternvalidator.fs

object AntPatternTranslator {
    fun antToRegex(pattern: String): Regex = pattern
        .replace(".", "\\.")
        .replace("**/", "(.+/)?")
        .replace("/**", "(/.+)?")
        .replace("*", "[^/]*")
        .replace("?", ".")
        .toRegex()
}