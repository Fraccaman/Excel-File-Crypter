# Excel-File-Crypter

An implementation of a simple Excel encryptor / decipherer.

## Feature

- Values are crypted with AES standard cypher.
- Key can be generated using a PRNG.

## Usage

- Run `mvn clean compile assembly:single` .
- Execute `java -jar target/exel-cryptographer-1.0-SNAPSHOT-jar-with-dependencies.jar` .

##  Issues

- Only works for .xls files.
