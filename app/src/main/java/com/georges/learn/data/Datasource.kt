package com.georges.learn.data

import com.georges.learn.R
import com.georges.learn.model.Affirm

/**
 * [Datasource] generates a list of [Affirm]
 */
class Datasource() {
    fun loadAffirmations(): List<Affirm> {
        return listOf<Affirm>(
            Affirm(R.string.affirmation1, R.drawable.image1),
            Affirm(R.string.affirmation2, R.drawable.image2),
            Affirm(R.string.affirmation3, R.drawable.image3),
            Affirm(R.string.affirmation4, R.drawable.image4),
            Affirm(R.string.affirmation5, R.drawable.image5),
            Affirm(R.string.affirmation6, R.drawable.image6),
            Affirm(R.string.affirmation7, R.drawable.image7),
            Affirm(R.string.affirmation8, R.drawable.image8),
            Affirm(R.string.affirmation9, R.drawable.image9),
            Affirm(R.string.affirmation10, R.drawable.image10))
    }
}