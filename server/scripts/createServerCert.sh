#!/usr/bin/env bash

outputDir=/tmp/certs

mkdir ${outputDir}

openssl genrsa -aes256 -out ${outputDir}/ca.key -passout pass:password 4096
openssl req -new -x509 -key ${outputDir}/ca.key -days 365 -sha256 -subj "/C=US/ST=PA/L=Philadelphia/O=NA/OU=NA/CN=test.local" -out ${outputDir}/ca.crt -passin pass:password

openssl genrsa -aes256 -out ${outputDir}/server.key -passout pass:password 4096
openssl req -subj "/CN=test.local" -sha256 -new -key ${outputDir}/server.key -out ${outputDir}/server.csr  -passin pass:password
openssl x509 -req -days 365 -sha256 -in ${outputDir}/server.csr -CA ${outputDir}/ca.crt -CAkey ${outputDir}/ca.key -CAcreateserial -out ${outputDir}/server.crt  -passin pass:password