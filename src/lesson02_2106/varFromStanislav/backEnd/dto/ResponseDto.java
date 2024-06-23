package lesson02_2106.varFromStanislav.backEnd.dto;

import java.util.List;

public class ResponseDto <T>{
    private Integer responceCode;
    private T result;
    private List<String> errors;

    public ResponseDto(Integer responceCode, T result, List<String> errors) {
        this.responceCode = responceCode;
        this.result = result;
        this.errors = errors;
    }

    public Integer getResponceCode() {
        return responceCode;
    }

    public T getResult() {
        return result;
    }

    public List<String> getErrors() {
        return errors;
    }

    @Override
    public String toString() {
        return "ResponseDto{" +
                "responceCode=" + responceCode +
                ", result=" + result +
                ", errors=" + errors +
                '}';
    }
}
