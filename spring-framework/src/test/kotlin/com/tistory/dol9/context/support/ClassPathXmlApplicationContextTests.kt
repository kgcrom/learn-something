package com.tistory.dol9.context.support

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.support.BeanDefinitionBuilder
import org.springframework.context.ApplicationContext
import org.springframework.context.support.ClassPathXmlApplicationContext
import org.springframework.context.support.GenericApplicationContext
import kotlin.test.assertContains
import kotlin.test.assertEquals

class ClassPathXmlApplicationContextTests {

    @Test
    fun xmlApplicationContextTest() {
        // create and configure beans
        val context: ApplicationContext = ClassPathXmlApplicationContext(SINGLE_CONTEXT)

        // retrieve configured instance
        val service: PetStore = context.getBean("petStore", PetStore::class.java)

        // use configured instance
        val userList = service.userName
        assertEquals(2, userList.size)
        assertContains(userList, "dol9", "doesn't contain dol9 text")
    }

    @Test
    fun genericApplicationContextTest() {
        val context = GenericApplicationContext()
        val beanDefinition = BeanDefinitionBuilder.genericBeanDefinition(PetStore::class.java).beanDefinition
        context.registerBeanDefinition("petStore", beanDefinition)
        context.refresh()

        val service: PetStore = context.getBean("petStore", PetStore::class.java)
        val userList = service.userName
        assertEquals(2, userList.size)
        assertContains(userList, "dol9", "doesn't contain dol9 text")
    }

    companion object {
        private const val PATH = "/com/tistory/dol9/context/support/"
        private const val SINGLE_CONTEXT = PATH + "test/singleContext.xml"
        private const val CONTEXT_A = PATH + "test/contextA.xml"
        private const val CONTEXT_B = PATH + "test/contextB.xml"
        private const val CONTEXT_C = PATH + "test/contextC.xml"
    }
}
