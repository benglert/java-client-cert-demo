#!/usr/bin/env bash

openssl pkcs12 -export -in client.crt -inkey client.key -out client.p12 -name client-cert -CAfile ca.crt -caname root

keytool -importkeystore -deststorepass password -destkeypass password -destkeystore keystore -srckeystore client.p12 -srcstoretype PKCS12 -srcstorepass password -alias client-cert
