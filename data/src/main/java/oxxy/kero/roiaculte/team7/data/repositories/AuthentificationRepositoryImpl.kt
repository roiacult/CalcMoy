package oxxy.kero.roiaculte.team7.data.repositories


import com.google.android.gms.common.api.GoogleApi
import com.google.firebase.auth.FacebookAuthProvider
import com.google.firebase.auth.GoogleAuthProvider
import oxxy.kero.roiaculte.team7.data.firebase.AuthentificationFirebase
import oxxy.kero.roiaculte.team7.domain.exception.Failure
import oxxy.kero.roiaculte.team7.domain.functional.Either
import oxxy.kero.roiaculte.team7.domain.interactors.LoginParam
import oxxy.kero.roiaculte.team7.domain.interactors.None
import oxxy.kero.roiaculte.team7.domain.interactors.RegistrationModel
import oxxy.kero.roiaculte.team7.domain.repositories.AuthentificationRepository

import javax.inject.Inject

class AuthentificationRepositoryImpl @Inject constructor(private val authentificator: AuthentificationFirebase)
    :AuthentificationRepository{
    override suspend fun registreUser(user: RegistrationModel): Either<Failure.CreatUserFailures, None> {
        return authentificator.registreUserWithEmail(user.mail , user.pass)
    }

    override suspend fun signUserOut() {
         authentificator.signUserOut()
    }

    override suspend fun signInUserCredentiel(credentiel: String, type: Int): Either<Failure.SignInCredentielFailure, None> {
        return authentificator.signInUserWithCredentiel(
            if(type== GOOGLE_CONST)GoogleAuthProvider.getCredential( credentiel, null)
        else FacebookAuthProvider.getCredential(credentiel) )

    }

    override suspend fun loginUser(param: LoginParam): Either<Failure.LoginFailure, None> {
        return authentificator.logUserIn(param.mail, param.password)
    }

    companion object {
        const val GOOGLE_CONST = 0
        const val FACEBOOK_CONST = 1
    }
}