package iterate.ai.aop.listeners

interface VideoInteractionListener {
    fun onStarClicked(isEnabled: Boolean)
    fun onBookmarkClicked(isEnabled: Boolean)
    fun onShareClicked()
    fun onProfileClicked()
    fun onVideoClicked()
    fun onLearnClicked()
    fun onTryClicked()
    fun onDescriptionExpanded()
    fun onDescriptionCollapsed()
}