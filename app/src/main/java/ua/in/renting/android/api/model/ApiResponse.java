package ua.in.renting.android.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Maxim Ambroskin kkxmshu@gmail.com
 * @since 03/01/17
 */
public class ApiResponse<DATA> {

    @JsonProperty("status")
    private int mStatus;

    @JsonProperty("errors")
    private String[] mErrors;

    @JsonProperty("message")
    private String mMessage;

    @JsonProperty("data")
    private DATA mData;

    public int getStatus() {
        return mStatus;
    }

    public String[] getErrors() {
        return mErrors;
    }

    public String getMessage() {
        return mMessage;
    }

    public DATA getData() {
        return mData;
    }
}