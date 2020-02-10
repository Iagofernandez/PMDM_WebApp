package com.example.website.dummy

import java.util.ArrayList
import java.util.HashMap

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 *
 * TODO: Replace all uses of this class before publishing your app.
 */
object DummyContent {

    /**
     * An array of sample (dummy) items.
     */
    val ITEMS: MutableList<DummyItem> = ArrayList()

    val ITEM_MAP: MutableMap<String, DummyItem> = HashMap()

    /**
     * A map of sample (dummy) items, by ID.
     */

    init {
        // Aqui se añaden los y se inician los tres objetos de nuestro array
        // Se almacenan id, nombre de la página web y url
        addItem(DummyItem("1","eBookFrenzy","http://www.ebookfrenzy.com"))
        addItem(DummyItem("2","Amazon","http://www.amazon.com"))
        addItem(DummyItem("3", "New York Times",
            "http://www.nytimes.com"))


    }

    private fun addItem(item: DummyItem) {
        ITEMS.add(item)
        ITEM_MAP.put(item.id, item)


    }

    private fun createDummyItem(position: Int): DummyItem {
        return DummyItem(position.toString(), "Item " + position, makeDetails(position))
    }

    private fun makeDetails(position: Int): String {
        val builder = StringBuilder()
        builder.append("Details about Item: ").append(position)
        for (i in 0..position - 1) {
            builder.append("\nMore details information here.")
        }
        return builder.toString()
    }

    /**
     * A dummy item representing a piece of content.
     */
    data class DummyItem(val id: String, val web_nome: String, val web_url: String) {
        override fun toString(): String = web_nome
    }
}
