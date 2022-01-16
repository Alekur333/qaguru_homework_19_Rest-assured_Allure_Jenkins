package kur.alex.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;


//{
//        "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyTmFtZSI6ImFsZXgiLCJwYXNzd29yZCI6ImFzZHNhZCNmcmV3X0RGUzIiLCJpYXQiOjE2NDE5MjU0NzF9.OUwgsvVRXb25o_fwmJoV-RfF6SXH2micNJl0g73wzTY",
//        "expires": "2022-01-18T18:24:31.029Z",
//        "status": "Success",
//        "result": "User authorized successfully."
//        }

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Token {

    private Long id;
    private String expires;
    private String status;
    private String result;


 // Без lombok нужно добавлять геттеры, сеттеры

//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getExpires() {
//        return expires;
//    }
//
//    public void setExpires(String expires) {
//        this.expires = expires;
//    }
//
//    public String getStatus() {
//        return status;
//    }
//
//    public void setStatus(String status) {
//        this.status = status;
//    }
//
//    public String getResult() {
//        return result;
//    }
//
//    public void setResult(String result) {
//        this.result = result;
//    }

}
