Android and iOS mobile testing.

For cloud tests:

1. Put your EPAM mobile cloud token into pom.xml file under a tag 'token' in 'properties' section.
2. Connect to EPAM mobile cloud.
3. To begin testing, type in commandline the following:
   "mvn test -P AndroidNativeClod" for Android native cloud test (EPAMTestApp.apk must be installed on cloud device), or
   "mvn test -P AndroidWebCloud" for Android web cloud test, or
   "mvn test -P iOSNativeCloud" for iOS native cloud test (EPAMTestApp.ipa must be installed on cloud device), or
   "mvn test -P iOSWebCloud" for iOS web cloud test.
   
For local tests:

1. Run emulated android device.
2. Start Appium server and put your Appium-server URL into pom.xml file under a tag 'ts.appium' in 'build' section.
3. To begin testing, type in commandline the following:
   "mvn test -P AndroidNative" for native test, and
   "mvn test -P AndroidWeb" for web test.
