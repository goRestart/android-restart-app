package com.restart.restart.login.ui

import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.restart.restart.R
import com.restart.restart.shared.ui.RestartFragment
import kotlinx.android.synthetic.main.unlogged_user.*

class UnloggedUserFragment : RestartFragment(), UnloggedUserPresenter.View {
    private var presenter: UnloggedUserPresenter? = null

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.unlogged_user, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        inject()
        login_button.setOnClickListener {
            presenter?.didSelectToLogIn()
        }
    }

    override fun navigateToLogin() {
        val intent = LoginActivity.intent(context)
        ActivityCompat.startActivity(context, intent, null)
    }

    private fun inject() {
        presenter = dependencyContainer!!.login.getUnloggedUserPresenter(this)
    }

}