# Blog

Personal blog website project

Add VM options to decrypt properties

> -Djasypt.encryptor.password=<password>

### Certificate

> keytool -genkeypair -alias <alias> -keyalg RSA -keysize 2048 -storetype PKCS12 -keystore <filename>.p12 -validity 3650

### Encryption

> mvn jasypt:encrypt-value -Djasypt.encryptor.password=<password> -Djasypt.plugin.value=<value>

JVM options

> -Djasypt.encryptor.password=<password>
