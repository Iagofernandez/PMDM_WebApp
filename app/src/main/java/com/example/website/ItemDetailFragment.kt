package com.example.website

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import com.example.website.dummy.DummyContent
import kotlinx.android.synthetic.main.activity_item_detail.*
import kotlinx.android.synthetic.main.item_detail.view.*

/**
 * A fragment representing a single Item detail screen.
 * This fragment is either contained in a [ItemListActivity]
 * in two-pane mode (on tablets) or a [ItemDetailActivity]
 * on handsets.
 */
class ItemDetailFragment : Fragment() {

    /**
     * The dummy content this fragment is presenting.
     */
    private var mItem: DummyContent.DummyItem? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            if (it.containsKey(ARG_ITEM_ID)) {
                // Carga el dummy object especificado por el fragment
                // arguments. En el mundo real se us ael Loader
                // para cargar la informacion
                mItem = DummyContent.ITEM_MAP[it.getString(ARG_ITEM_ID)]
                // Se modifico el mItem?.

                activity?.toolbar_layout?.title = mItem?.web_nome
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.item_detail, container, false)

        // Show the dummy content as text in a TextView.
        mItem?.let {
            val webView: WebView = rootView.findViewById(R.id.website_detail)

            webView.webViewClient = object : WebViewClient() {
                override fun shouldOverrideUrlLoading(
                    view: WebView, request: WebResourceRequest
                ): Boolean {
                    return super.shouldOverrideUrlLoading(
                        view, request)
                }
            }
            webView.settings.javaScriptEnabled = true
            webView.loadUrl(mItem?.web_url)
        }


        return rootView
    }

    companion object {
        /**
         * The fragment argument representing the item ID that this fragment
         * represents.
         */
        const val ARG_ITEM_ID = "item_id"
    }
}
