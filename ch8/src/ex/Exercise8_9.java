package ex;



class UnsupportedFuctionException extends RuntimeException{
	final private int ERR_CODE;
	final private String ERR_MESSAGE;

	UnsupportedFuctionException(String msg, int errCode){
		super(msg);
		ERR_MESSAGE = msg;
		ERR_CODE = errCode;
	}
	
	public int getErrorCode() {
		return ERR_CODE;
	}
	
	public String getMessage() {
		return "["+getErrorCode()+"]"+ERR_MESSAGE;
		
	}
}
public class Exercise8_9 {
	public static void main(String[] args) throws Exception {
		throw new UnsupportedFuctionException("지원하지 않는 기능입니다.", 100);
	}
}
