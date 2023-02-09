package pg.com.designpatterns;

public class Phone {
	String os;
	String processor;
	int size;
	int battery;
	int camera;
	public String getOs() {
		return os;
	}
	public String getProcessor() {
		return processor;
	}
	public int getSize() {
		return size;
	}
	public int getBattery() {
		return battery;
	}
	public int getCamera() {
		return camera;
	}
	
	@Override
	public String toString() {
		return "Phone [os=" + os + ", processor=" + processor + ", size=" + size + ", battery=" + battery + ", camera="
				+ camera + "]";
	}



	public static class PhoneBuilder{
		String os;
		String processor;
		int size;
		int battery;
		int camera;
		
		public String getOs() {
			return os;
		}
		public String getProcessor() {
			return processor;
		}
		public int getSize() {
			return size;
		}
		public int getBattery() {
			return battery;
		}
		public int getCamera() {
			return camera;
		}
		
		public PhoneBuilder(String os) {
			this.os = os;
		}
		
		public PhoneBuilder setProcessor(String pro) {
			this.processor = pro;
			return this;
		}
		
		public PhoneBuilder setSize(int size) {
			this.size = size;
			return this;
		}
		
		public PhoneBuilder setBattery(int battery) {
			this.battery = battery;
			return this;
		}
		
		public PhoneBuilder setCamera(int camera) {
			this.camera = camera;
			return this;
		}
		
		public Phone build() {
			Phone phone = new Phone();
			phone.os = this.os;
			phone.processor = this.processor;
			phone.size = this.size;
			phone.battery = this.battery;
			phone.camera = this.camera;
			
			return phone;
		}
	}
}
