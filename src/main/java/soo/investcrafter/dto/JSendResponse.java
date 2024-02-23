package soo.investcrafter.dto;

import lombok.Getter;

@Getter
public class JSendResponse<T> {
    private String status;
    private T data;
    private String message;

    // 성공 응답 생성자
    public JSendResponse(String status, T data) {
        this.status = status;
        this.data = data;
    }

    // 에러 응답 생성자
    public JSendResponse(String status, String message) {
        this.status = status;
        this.message = message;
    }


    // 성공 응답 편의 메서드
    public static <T> JSendResponse<T> success(T data) {
        return new JSendResponse<>("success", data);
    }

    // 실패 응답 편의 메서드
    public static <T> JSendResponse<T> fail(T data) {
        return new JSendResponse<>("fail", data);
    }

    // 에러 응답 편의 메서드
    public static JSendResponse<String> error(String message) {
        return new JSendResponse<>("error", message);
    }
}
