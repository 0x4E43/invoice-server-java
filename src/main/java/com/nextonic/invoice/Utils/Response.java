package com.nextonic.invoice.Utils;

import java.io.Serializable;

import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@JsonIgnoreProperties
public class Response implements Serializable {

    private static Logger logger = LoggerFactory.getLogger(Response.class);

    @JsonInclude(Include.NON_NULL)
    SuccessVO success = null;

    @JsonInclude(Include.NON_NULL)
    ErrorVO error = null;

    static JSONObject json;

    public SuccessVO getSuccess() {
        return success;
    }

    public void setSuccess(SuccessVO success) {
        this.success = success;
    }

    public ErrorVO getError() {
        return error;
    }

    public void createSuccess() {
        success = new SuccessVO();
    }

    public synchronized static String success(String message) {
        try {
            json = new JSONObject();
            json.put("success", objectToJSONObject(new SuccessVO(message)));
            // logger.info("===response==="+json.toString());
            return json.toString();
        } catch (Exception e) {
            logger.error("Exception thrown : ", e);
            return Response.error("error while getting data from server.");
        }
    }

    public synchronized static String success(int code, String message) {
        try {
            json = new JSONObject();
            json.put("success", objectToJSONObject(new SuccessVO(code, message)));
            // logger.info("===response==="+json.toString());
            return json.toString();
        } catch (Exception e) {
            logger.error("Exception thrown : ", e);
            return Response.error("error while getting data from server.");
        }
    }

    public synchronized static String success(String message, Object data) {
        try {
            json = new JSONObject();
            json.put("success", objectToJSONObject(new SuccessVO(message, data)));
            // logger.info("===response==="+json.toString());
            return json.toString();
        } catch (Exception e) {
            logger.error("Exception thrown : ", e);
            return Response.error("error while getting data from server.");
        }
    }

    public synchronized static String success(int code, String message, Object data) {
        try {
            json = new JSONObject();
            json.put("success", objectToJSONObject(new SuccessVO(code, message, data)));
            // logger.info("===response==="+json.toString());
            return json.toString();
        } catch (Exception e) {
            logger.error("Exception thrown : ", e);
            return Response.error("error while getting data from server.");
        }
    }

    public void createError() {
        error = new ErrorVO();
    }

    public synchronized static String error(String message) {
        try {
            json = new JSONObject();
            json.put("error", objectToJSONObject(new ErrorVO(message)));
            // logger.info("===response==="+json.toString());
            return json.toString();
        } catch (Exception e) {
            logger.error("Exception thrown : ", e);
        }
        return message;
    }

    public synchronized static String error(int code, String message) {
        try {
            json = new JSONObject();
            json.put("error", objectToJSONObject(new ErrorVO(code, message)));
            // logger.info("===response==="+json.toString());
            return json.toString();
        } catch (Exception e) {
            logger.error("Exception thrown : ", e);
        }
        return message;
    }

    public void setSuccessMessage(String message) {
        this.success.setMessage(message);
    }

    public void setSuccessCode(int code) {
        this.success.setCode(code);
    }

    public void setSuccessData(Object data) {
        this.success.setData(data);
    }

    public void setErrorMessage(String message) {
        this.error.setMessage(message);
    }

    public void setErrorCode(int code) {
        this.error.setCode(code);
    }

    public void setError(ErrorVO error) {
        this.error = error;
    }

    public static JSONObject objectToJSONObject(Object obj) throws JSONException {
        Gson gson = new Gson();
        GsonBuilder builder = new GsonBuilder();
        gson = builder.serializeNulls().create();

        return new JSONObject(gson.toJson(obj));
    }

    /**
     * 
     * This method is added to globally handle the unknown values send in the json
     * input to web services
     *
     * @param key
     * @param value
     * @author Sandeep
     */
    @JsonAnySetter
    public void handleUnknown(String key, Object value) {
        // logger.debug("Unknown Property :"+key );
    }

    public synchronized static String success(int code, String message, Object data, int noOfRecords) {
        try {
            json = new JSONObject();
            json.put("success", objectToJSONObject(new SuccessVO(code, message, data, noOfRecords)));
            // logger.info("===response==="+json.toString());
            return json.toString();
        } catch (Exception e) {
            logger.error("Exception thrown : ", e);
            return Response.error("error while getting data from server.");
        }
    }

    public synchronized static String success(int code, String message, Object data, int noOfRecords, int pageNo) {
        try {
            json = new JSONObject();
            json.put("success",
                    objectToJSONObject(new SuccessVO(code, message, data, noOfRecords, pageNo)));
            // logger.info("===response==="+json.toString());
            return json.toString();
        } catch (Exception e) {
            logger.error("Exception thrown : ", e);
            return Response.error("error while getting data from server.");
        }
    }

}
