package io.github.droidkaigi.confsched2019.action

import io.github.droidkaigi.confsched2019.model.Announcement
import io.github.droidkaigi.confsched2019.model.ErrorMessage
import io.github.droidkaigi.confsched2019.model.Lang
import io.github.droidkaigi.confsched2019.model.LoadingState
import io.github.droidkaigi.confsched2019.model.Room
import io.github.droidkaigi.confsched2019.model.SearchResult
import io.github.droidkaigi.confsched2019.model.Session
import io.github.droidkaigi.confsched2019.model.SessionContents
import io.github.droidkaigi.confsched2019.model.SessionPage
import io.github.droidkaigi.confsched2019.model.SponsorCategory
import io.github.droidkaigi.confsched2019.model.SystemProperty
import io.github.droidkaigi.confsched2019.model.Category

sealed class Action {
    class Error(val msg: ErrorMessage) : Action()

    data class SessionLoadingStateChanged(val loadingState: LoadingState) : Action()
    data class SessionContentsLoaded(
        val sessionContents: SessionContents
    ) : Action()

    data class SessionsLoaded(
        val sessions: List<Session>
    ) : Action()

    data class SessionPageSelected(val sessionPage: SessionPage) : Action()
    class SystemPropertyLoaded(val system: SystemProperty) : Action()

    open class FilterChange<T>(val value: T, open val checked: Boolean) : Action()
    data class RoomFilterChanged(
        val room: Room,
        override val checked: Boolean
    ) : FilterChange<Room>(room, checked)

    data class CategoryFilterChanged(
        val category: Category,
        override val checked: Boolean
    ) : FilterChange<Category>(category, checked)

    data class LangFilterChanged(
        val lang: Lang,
        override val checked: Boolean
    ) : FilterChange<Lang>(lang, checked)

    class FilterCleared : Action()
    class BottomSheetFilterToggled(val page: SessionPage) : Action()
    class BottomSheetFilterStateChanged(val page: SessionPage, val bottomSheetState: Int) : Action()

    data class SearchResultLoaded(val searchResult: SearchResult) : Action()

    object UserRegistered : Action()

    class AnnouncementLoadingStateChanged(val loadingState: LoadingState) : Action()
    class AnnouncementLoaded(val announcements: List<Announcement>) : Action()

    data class SponsorLoadingStateChanged(val loadingState: LoadingState) : Action()
    data class SponsorLoaded(val sponsors: List<SponsorCategory>) : Action()

    class FloorMapLoadingStateChanged(val loadingState: LoadingState) : Action()
}
