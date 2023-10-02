package pg.com.roughTest;

public class FilterQueryFormation {

	public static void main(String[] args) {
		String url = "facility_id:10";
        StringBuilder builder = new StringBuilder();
        
        builder.append("fq").append("=").append("{!tag="+ url.substring(0, url.indexOf(":")) + "}").append(url);
        
        System.out.println(builder);
	}

}
