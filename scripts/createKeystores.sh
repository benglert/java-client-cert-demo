#!/usr/bin/env bash

keytool -importkeystore -deststorepass password -destkeypass password -destkeystore keystore -srckeystore client.p12 -srcstoretype PKCS12 -srcstorepass password -alias client-cert

keytool -import -keystore truststore -alias server-cert -file server.crt