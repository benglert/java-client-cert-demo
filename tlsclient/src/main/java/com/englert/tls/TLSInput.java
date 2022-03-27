package com.englert.tls;

public class TLSInput {
    private static final org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger(TLSInput.class);

    private String url;

    private String keystore;

    private String truststore;

    public TLSInput() { }

    public TLSInput(String url) {
        this.url = url;
    }

    public TLSInput(String url, String keystore, String truststore) {
        this.url = url;
        this.keystore = keystore;
        this.truststore = truststore;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getKeystore() {
        return keystore;
    }

    public void setKeystore(String keystore) {
        this.keystore = keystore;
    }

    public String getTruststore() {
        return truststore;
    }

    public void setTruststore(String truststore) {
        this.truststore = truststore;
    }
}
