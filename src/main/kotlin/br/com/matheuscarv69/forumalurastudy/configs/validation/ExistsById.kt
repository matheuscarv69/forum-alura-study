package br.com.matheuscarv69.forumalurastudy.configs.validation

import org.springframework.beans.factory.annotation.Autowired
import javax.persistence.EntityManager
import javax.persistence.Query
import javax.validation.Constraint
import javax.validation.ConstraintValidator
import javax.validation.ConstraintValidatorContext
import javax.validation.Payload
import kotlin.annotation.AnnotationRetention.RUNTIME
import kotlin.annotation.AnnotationTarget.FIELD
import kotlin.reflect.KClass

@Target(FIELD)
@Retention(RUNTIME)
@Constraint(validatedBy = [ExistsByIdValidator::class])
@MustBeDocumented
annotation class ExistsById(
    val message: String = "This object already exists",
    val groups: Array<KClass<Any>> = [],
    val payload: Array<KClass<Payload>> = [],
    val fieldName: String = "id",
    val domainClass: KClass<*>
)

class ExistsByIdValidator : ConstraintValidator<ExistsById, Any> {

    lateinit var domainAttribute: String
    lateinit var aClass: KClass<*>

    @Autowired
    private lateinit var entityManager: EntityManager

    override fun initialize(constraintAnnotation: ExistsById?) {
        super.initialize(constraintAnnotation)
        domainAttribute = constraintAnnotation!!.fieldName
        aClass = constraintAnnotation.domainClass

    }

    override fun isValid(value: Any?, constraintValidatorContext: ConstraintValidatorContext?): Boolean {
        if (value != null) {
            val query: Query =
                entityManager.createQuery("select 1 from " + aClass.simpleName + " where " + domainAttribute + " = :value")
            query.setParameter("value", value)
            val list: List<*> = query.resultList

            return list.isNotEmpty()
        }

        return true
    }


}

