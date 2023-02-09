package pg.com.designpatterns;

public class PhoneBuilderTest {

	public static void main(String[] args) {
		Phone phone = new Phone.PhoneBuilder("Android").setBattery(5000).setProcessor("sanpdragon")
				.setCamera(48).setSize(6).build();
        System.out.println(phone);
	}

}
