package oxxy.kero.roiaculte.team7.domain.interactors

import oxxy.kero.roiaculte.team7.domain.exception.Failure
import oxxy.kero.roiaculte.team7.domain.functional.CouroutineDispatchers
import oxxy.kero.roiaculte.team7.domain.functional.Either
import oxxy.kero.roiaculte.team7.domain.models.Semestre
import oxxy.kero.roiaculte.team7.domain.repositories.MainRepository
import sun.rmi.runtime.Log
import javax.inject.Inject

class MainGetSemestre  @Inject constructor(dispatchers: CouroutineDispatchers , val repo: MainRepository)
    : EitherInteractor<None ,MainGetSemestreResult , Failure.MainInfoFailure > {
    override val dispatcher =dispatchers.io
    override val ResultDispatcher = dispatchers.main
    override suspend fun invoke(executeParams: None): Either<Failure.MainInfoFailure, MainGetSemestreResult> {
        println("entered")
          return repo.getMainInfoSemestre()
     }
}
data class MainGetSemestreResult(val numberSemestre :Int , val semestres: List<Semestre>)
