package br.com.matheuscarv69.forumalurastudy.configs.validation

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.util.Assert
import javax.persistence.EntityManager
import javax.persistence.Query
import javax.validation.Constraint
import javax.validation.ConstraintValidator
import javax.validation.ConstraintValidatorContext
import kotlin.annotation.AnnotationRetention.RUNTIME
import kotlin.annotation.AnnotationTarget.FIELD
import kotlin.reflect.KClass

@Target(FIELD)
@Retention(RUNTIME)
@Constraint(validatedBy = [UniqueValueValidator::class])
@MustBeDocumented
annotation class UniqueValue(
    val message: String = "The value informed already exists in database, try again with other value",
    val groups: Array<KClass<Any>> = [],
    val payload: Array<KClass<Any>> = [],
    val fieldName: String,
    val domainClass: KClass<*>
)

class UniqueValueValidator : ConstraintValidator<UniqueValue, Any> {

    lateinit var domainAttribute: String
    lateinit var aClass: KClass<*>

    @Autowired
    private lateinit var entityManager: EntityManager

    override fun initialize(constraintAnnotation: UniqueValue?) {
        super.initialize(constraintAnnotation)
        domainAttribute = constraintAnnotation!!.fieldName
        aClass = constraintAnnotation.domainClass
    }

    override fun isValid(value: Any?, constraintValidatorContext: ConstraintValidatorContext?): Boolean {
        val query: Query =
            entityManager.createQuery("select  1 from ${aClass.simpleName} where $domainAttribute =:value")
        query.setParameter("value", value)
        val list: List<*> = query.resultList

        Assert.state(list.size <= 1, "Found more a $aClass with the attribute $domainAttribute = $value")

        return list.isEmpty()
    }

}