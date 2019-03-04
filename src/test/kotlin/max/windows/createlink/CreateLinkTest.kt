package max.windows.createlink

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
}
