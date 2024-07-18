package ch09;

import java.sql.Date;

public class Product {
		private int id;
		private String itemname;
		private String maker;
		private int price;
		private Date regdate;
		
		public Product() {};  //디폴트 생성자
		
		public Product(int id, String itemname, String maker, int price, Date regdate) {
			super();
			this.id = id;
			this.itemname = itemname;
			this.maker = maker;
			this.price = price;
			this.regdate = regdate;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getItemname() {
			return itemname;
		}

		public void setItemname(String itemname) {
			this.itemname = itemname;
		}

		public String getMaker() {
			return maker;
		}

		public void setMaker(String maker) {
			this.maker = maker;
		}

		public int getPrice() {
			return price;
		}

		public void setPrice(int price) {
			this.price = price;
		}

		public Date getRegdate() {
			return regdate;
		}

		public void setRegdate(Date regdate) {
			this.regdate = regdate;
		}

		
}
