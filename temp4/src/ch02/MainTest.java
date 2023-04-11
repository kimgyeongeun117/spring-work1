package ch02;

public class MainTest {

	public static void main(String[] args) {
		Button button = new Button("김버튼");
		button.setIButtonListener(new IButtonListener() {
			
			@Override
			public void clickEvent(String event) {
				System.out.println("콜백 ON "+event);
			}
		});
		
		button.click("1");
		button.click("2");
		button.click("3");
	}
}
