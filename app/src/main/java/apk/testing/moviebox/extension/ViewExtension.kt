package apk.testing.moviebox.extension

import android.widget.ImageView
import apk.testing.moviebox.R
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions

fun ImageView.loadUrl(url: String?) =
    if(url != null){
        Glide.with(this.context.applicationContext)
            .load(url)
            .transition(DrawableTransitionOptions.withCrossFade())
            .into(this)
    }else{
        Glide.with(this.context.applicationContext)
            .load(R.drawable.default_poster)
            .transition(DrawableTransitionOptions.withCrossFade())
            .into(this)
    }