package com.ewake.randommeme.presentation.extensions.picasso

import android.widget.ImageView
import com.squareup.picasso.Picasso

/**
 * @author Nikolaevsky Dmitry (@d.nikolaevskiy)
 */

fun ImageView.setImage(url: String) {
    Picasso.get().load(url).fit().into(this)
}