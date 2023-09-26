package com.arman.myapplication

import androidx.lifecycle.ViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class MainViewModel @Inject constructor(
    @ApplicationContext context: ApplicationContext
) : ViewModel() {
}