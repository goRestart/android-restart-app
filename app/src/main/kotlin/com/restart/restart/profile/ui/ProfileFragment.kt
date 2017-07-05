package com.restart.restart.profile.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.restart.restart.R
import com.restart.restart.shared.ui.RestartFragment
import kotlinx.android.synthetic.main.profile.*

class ProfileFragment : RestartFragment() {
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.profile, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        logout.setOnClickListener { dependencyContainer!!.login.logout.execute() }
    }
}