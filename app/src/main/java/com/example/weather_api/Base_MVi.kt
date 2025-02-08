package com.example.weather_api

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch

// 1
interface State

// 2
interface Action

// 3
interface Reducer<S : State, A : Action> {
    /**
     * Generates a new instance of the [State] based on the [Action]
     *
     * @param state the current [State]
     * @param action the [Action] to reduce the [State] with
     * @return the reduced [State]
     */
    fun reduce(state: S, action: A): S
}
private const val BufferSize = 64
open class MviViewModel<S : State, A : Action>(
    private val reducer: Reducer<S, A>,
    initialState: S,
) : ViewModel() {

    // 5
    private val actions = MutableSharedFlow<A>(extraBufferCapacity = BufferSize)

    // 6
    var state: S by mutableStateOf(initialState)
        private set

    init {
        // 7
        viewModelScope.launch {
            actions.collect { action ->
                state = reducer.reduce(state, action)
            }
        }
    }

    // 8
    fun dispatch(action: A) {
        val success = actions.tryEmit(action)
        if (!success) error("MVI action buffer overflow")
    }
}