package my.way.raycast.keyboard.presentation.util

import android.inputmethodservice.InputMethodService
import android.view.inputmethod.InputConnection

fun InputConnection.getSelectedOrAllText(): String {
    // Try to get selected text
    val selectedText = this.getSelectedText(0)
    if (!selectedText.isNullOrEmpty()) {
        return selectedText.toString()
    }

    // Fallback: get all text (before + after cursor)
    val textBefore = this.getTextBeforeCursor(Int.MAX_VALUE, 0) ?: ""
    val textAfter = this.getTextAfterCursor(Int.MAX_VALUE, 0) ?: ""

    return textBefore.toString() + textAfter.toString()
}

fun InputConnection.replaceText(newText: CharSequence): Boolean {

    // Check if text is selected
    val selectedText = this.getSelectedText(0)
    if (!selectedText.isNullOrEmpty()) {
        // Replace selected text
        return this.commitText(newText, 1)
    }

    // Fallback: replace all text
    val textBefore = this.getTextBeforeCursor(Int.MAX_VALUE, 0) ?: ""
    val textAfter = this.getTextAfterCursor(Int.MAX_VALUE, 0) ?: ""
    val totalLength = textBefore.length + textAfter.length

    // Delete all text, then insert new text
    this.deleteSurroundingText(textBefore.length, textAfter.length)
    return this.commitText(newText, 1)
}

fun InputConnection.deleteText(): Boolean {
    // Check if text is selected
    val selectedText = this.getSelectedText(0)
    if (!selectedText.isNullOrEmpty()) {
        // Delete selected text by replacing with empty string
        return this.commitText("", 1)
    }

    // Fallback: normal backspace (delete 1 char before cursor)
    return this.deleteSurroundingText(1, 0)
}