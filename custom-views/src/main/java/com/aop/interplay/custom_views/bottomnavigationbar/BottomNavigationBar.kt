package com.aop.interplay.custom_views.bottomnavigationbar

import android.content.Context
import android.util.AttributeSet
import android.widget.ImageButton
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.aop.interplay.custom_views.R

class BottomNavigationBar(
    context: Context?, attrs: AttributeSet? = null
) : LinearLayout(context, attrs) {

    private val fragments: MutableList<Fragment> = mutableListOf()
    private var fragmentManager: FragmentManager? = null
    private var containerFragment: Int? = null

    init {
        inflate(context, R.layout.bottom_navigation_bar_layout, this)

        findViewById<ImageButton>(R.id.nav_home).setOnClickListener {
            loadHomeFragment()
        }

        findViewById<ImageButton>(R.id.nav_discover).setOnClickListener {
            loadDiscoverFragment()
        }

        findViewById<ImageButton>(R.id.nav_new_post).setOnClickListener {
            loadNewPostFragment()
        }

        findViewById<ImageButton>(R.id.nav_course).setOnClickListener {
            loadCourseFragment()
        }

        findViewById<ImageButton>(R.id.nav_profile).setOnClickListener {
            loadProfileFragment()
        }

        postDelayed({
            loadHomeFragment()
        }, 500)
    }

    private fun loadHomeFragment() {
        containerFragment?.let {
            val tran = fragmentManager?.beginTransaction()
            tran?.replace(it, fragments[HOME_INDEX])
            tran?.commitNow()
        }
    }

    private fun loadDiscoverFragment() {
        containerFragment?.let {
            val tran = fragmentManager?.beginTransaction()
            tran?.replace(it, fragments[DISCOVER_INDEX])
            tran?.commitNow()
        }
    }

    private fun loadNewPostFragment() {
        containerFragment?.let {
            val tran = fragmentManager?.beginTransaction()
            tran?.replace(it, fragments[NEW_POST_INDEX])
            tran?.commitNow()
        }
    }

    private fun loadCourseFragment() {
        containerFragment?.let {
            val tran = fragmentManager?.beginTransaction()
            tran?.replace(it, fragments[COURSE_INDEX])
            tran?.commitNow()
        }
    }

    private fun loadProfileFragment() {
        containerFragment?.let {
            val tran = fragmentManager?.beginTransaction()
            tran?.replace(it, fragments[PROFILE_INDEX])
            tran?.commitNow()
        }
    }

    fun setupFragments(
        fragmentManager: FragmentManager, container: Int, newFragments: List<Fragment>
    ) {
        fragments.clear()
        fragments.addAll(newFragments)
        containerFragment = container
        this@BottomNavigationBar.fragmentManager = fragmentManager
    }

    companion object {
        private const val HOME_INDEX = 0
        private const val DISCOVER_INDEX = 1
        private const val NEW_POST_INDEX = 2
        private const val COURSE_INDEX = 3
        private const val PROFILE_INDEX = 4
    }
}
