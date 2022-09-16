package oksei.media.orenburg.presentation.vm.news

sealed class ListNewsEventsState{
    object LoadingData : ListNewsEventsState()
    object HaveData : ListNewsEventsState()
    object NoHaveData : ListNewsEventsState()
}
