package anabada.semi.common;

public class XSS {
	// 크로스 사이트 스크립트 공격을 방지 하기 위한 메소드
	public static String replaceParameter(String parameter) {
		
		if(parameter != null) {
			parameter = parameter.replace("&", "&amp;");
			parameter = parameter.replace("<", "&lt;");
			parameter = parameter.replace(">", "&gt;");
			parameter = parameter.replace("\"", "&quot;");
		}

		return parameter;
		
	}
}
