package max.windows.createlink

import org.junit.Ignore
import org.junit.Test
import java.io.File

class CreateLinkTest {

    val createLink = CreateLink(File(""))
    @Test
    fun getHomeDirectory() {
        println(createLink.homeUserPath)
    }

    @Test
    fun windowsStartupParth() {
        println(createLink.userWindowsStartupPath)
    }

    @Ignore("How to use.")
    fun build() {
        val link = CreateLink(File("G:\\Pictures\\spec server"))
        link.build()
    }
}
