package com.englert.tls;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.net.ssl.HttpsURLConnection;
import java.net.URL;

@Controller
public class TLSController {
    private static final org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger(TLSController.class);

    @Value("${location.keytstore}")
    private String keystoreLocation;
    @Value("${location.truststore}")
    private String truststoreLocation;
    @Value("${target.url}")
    private String targetUrl;

    @GetMapping("/tls")
    public String tls(Model model) {

        LOGGER.info("tls:url={},keystore={},truststore={}", targetUrl, keystoreLocation, truststoreLocation);

        model.addAttribute("input", new TLSInput(targetUrl, keystoreLocation, truststoreLocation));

        return "index";
    }
    @PostMapping("/tls")
    public String tlsSubmit(@ModelAttribute TLSInput input, Model model) {
        setTlsProperties(input.getKeystore(), input.getTruststore());

        String httpsUrl = input.getUrl();

        int responseCode = 0;
        String result = "SUCCESS";

        try {
            URL url = new URL(httpsUrl);
            HttpsURLConnection con = (HttpsURLConnection) url.openConnection();
            con.getResponseCode();
            responseCode = con.getResponseCode();
        } catch (Exception exc) {
            result = exc.getMessage();
        }

        model.addAttribute("tlsResponse", result);
        model.addAttribute("tlsResponseCode", String.valueOf(responseCode));
        model.addAttribute("input", input);

        return "index";
    }
    private void setTlsProperties(String keystore, String truststore) {

        System.out.println("Keystore=" + keystore + ",Truststore=" + truststore);

        System.setProperty("javax.net.ssl.trustStore", truststore);
        System.setProperty("javax.net.ssl.trustStorePassword", "password");
        System.setProperty("javax.net.ssl.trustStoreType", "pkcs12");


        System.setProperty("javax.net.ssl.keyStore", keystore);
        System.setProperty("javax.net.ssl.keyStorePassword", "password");
        System.setProperty("javax.net.ssl.keyStoreType", "pkcs12");
    }
}
