#!/usr/bin/env bash

certRoot=/etc/certs
keystoreDir=/etc/keystore

mkdir -p -v ${keystoreDir}

keytool -importkeystore -deststorepass password -destkeypass password -destkeystore ${keystoreDir}/keystore -srckeystore ${certRoot}/client.p12 -srcstoretype PKCS12 -srcstorepass password -alias client-cert

keytool -import -keystore ${keystoreDir}/truststore -alias server-cert -file ${certRoot}/server.crt -storepass password -noprompt