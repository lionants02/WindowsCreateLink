# Create link for windows.

[![Build Status](https://travis-ci.org/lionants02/WindowsCreateLink.svg?branch=master)](https://travis-ci.org/lionants02/WindowsCreateLink.ini) [![Release](https://jitpack.io/v/lionants02/WindowsCreateLink.svg)](https://jitpack.io/#lionants02/WindowsCreateLink)  
[![ktlint](https://img.shields.io/badge/code%20style-%E2%9D%A4-FF4081.svg)](https://ktlint.github.io/)

เพิ่ม JitPack repository ที่ build script
```
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```

เพิ่ม dependency
```
dependencies {
    implementation "com.github.lionants02:WindowsCreateLink:$latestVersion"
}
```

ใช้
```kotlin
    val link = CreateLink(File("C:\\User"))
    link.build()
```
ถ้าไม่กำหนด parameter ใน build ตัว Default จะสร้าง link ไว้ที่ Desktop  
  
  
```kotlin
    val link = CreateLink(File("C:\\User"))
    link.build("G:\\Document\\Users")
```
สามารถกำหนด parameter ใน build ได้ โดยที่ไม่ต้องใส่นามสกุล lnk(auto .lnk)
