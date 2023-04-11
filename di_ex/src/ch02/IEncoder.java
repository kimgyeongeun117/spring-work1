package ch02;

public interface IEncoder {
	// URL 인코딩, Base64 인코딩
	// 문자형 데이터 (바이너리 타입을 문자열로 Base64 형태)
	String encode(String message);
}
