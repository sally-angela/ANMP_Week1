package com.sally.anmp_week1

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections

public class ResultFragmentDirections private constructor() {
  public companion object {
    public fun actionMainFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_main_fragment)
  }
}
