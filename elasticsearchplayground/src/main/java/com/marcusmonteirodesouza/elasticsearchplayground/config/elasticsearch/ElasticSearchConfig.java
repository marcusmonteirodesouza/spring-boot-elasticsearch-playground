package com.marcusmonteirodesouza.elasticsearchplayground.config.elasticsearch;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.elc.ElasticsearchConfiguration;

@Configuration
public class ElasticSearchConfig extends ElasticsearchConfiguration {
    private final String host;
    private final String port;
    private final String username;
    private final String password;
    private final String certFingerprint;

    public ElasticSearchConfig(
            @Value("${elasticsearch.host}") String host,
            @Value("${elasticsearch.port}") String port,
            @Value("${elasticsearch.username}") String username,
            @Value("${elasticsearch.password}") String password,
            @Value("${elasticsearch.cert.fingerprint}") String certFingerprint) {
        this.host = host;
        this.port = port;
        this.username = username;
        this.password = password;
        this.certFingerprint = certFingerprint;
    }

    @Override
    public ClientConfiguration clientConfiguration() {
        var hostAndPort = String.format("%s:%s", host, port);

        return ClientConfiguration.builder()
                .connectedTo(hostAndPort)
                .usingSsl(certFingerprint)
                .withBasicAuth(username, password)
                .build();
    }
}
