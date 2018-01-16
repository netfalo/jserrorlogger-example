package com.netfalo.jserrorlogger;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.OffsetDateTime;

public class Error {
    private final OffsetDateTime serverTime;
    private final OffsetDateTime browserTime;
    private final String message;
    private final String fileName;
    private final String file;
    private final String lineNo;
    private final String colNo;
    private final String userAgent;
    private final String hostName;
    private final String href;

    @JsonCreator
    public Error(@JsonProperty("time") OffsetDateTime browserTime,
                 @JsonProperty("message") String message,
                 @JsonProperty("filename") String fileName,
                 @JsonProperty("file") String file,
                 @JsonProperty("lineno") String lineNo,
                 @JsonProperty("colno") String colNo,
                 @JsonProperty("useragent") String userAgent,
                 @JsonProperty("hostname") String hostName,
                 @JsonProperty("href") String href) {
        this.serverTime = OffsetDateTime.now();
        this.browserTime = browserTime;
        this.message = message;
        this.fileName = fileName;
        this.file = file;
        this.lineNo = lineNo;
        this.colNo = colNo;
        this.userAgent = userAgent;
        this.hostName = hostName;
        this.href = href;
    }

    public OffsetDateTime getServerTime() {
        return serverTime;
    }

    public OffsetDateTime getBrowserTime() {
        return browserTime;
    }

    public String getMessage() {
        return message;
    }

    public String getFileName() {
        return fileName;
    }

    public String getFile() {
        return file;
    }

    public String getLineNo() {
        return lineNo;
    }

    public String getColNo() {
        return colNo;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public String getHostName() {
        return hostName;
    }

    public String getHref() {
        return href;
    }
}
