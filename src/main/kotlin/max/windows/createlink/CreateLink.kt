package max.windows.createlink

import java.io.File

class CreateLink(val source: File) {
    val homeUserPath get() = System.getProperty("user.home") + "\\"
    val userWindowsStartupPath = "${homeUserPath}AppData\\Roaming\\Microsoft\\Windows\\Start Menu\\Programs\\Startup\\"
    val userDesktop = "${homeUserPath}Desktop\\"
    internal val shutcutTemplate =
        "powershell \"" +
                "\$s=(New-Object -COM WScript.Shell).CreateShortcut('_Shortcut_.lnk');" +
                "\$s.TargetPath='_Target_';" +
                "\$s.Save()\""

    fun build(shortcut: File = File(userDesktop + source.name), override: Boolean = false) {
        val shortCutAbsloutePath = shortcut.absolutePath.replace(Regex("""\.lnk$"""), "")
        val checkLink = File("$shortCutAbsloutePath.lnk")

        require(source.isAbsolute) { "Source wrong format." }
        require(source.isFile || source.isDirectory) { "Have not source." }
        require(checkLink.isAbsolute) { "Shutcut wrong format. .build(File(\"C:\\test\"))" }
        require(!checkLink.isFile || override) { "Have shortcuts." }

        val command = shutcutTemplate
            .replaceFirst("_Shortcut_", shortCutAbsloutePath)
            .replaceFirst("_Target_", source.absolutePath)

        commandExc(command)
    }

    private fun commandExc(cmd: String) {
        val command = Runtime.getRuntime().exec(cmd)
        print(command.inputStream.reader().readLines())
        print(command.errorStream.reader().readLines())
        while (command.isAlive) {
            print(command.inputStream.reader().readLines())
            print(command.errorStream.reader().readLines())
            Thread.sleep(50)
        }
    }
}
