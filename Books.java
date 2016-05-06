package Sxc008;

/**
  图书类是用来创建商品对象的，图书对象是用来存储该商品的信息的
*/
public class Books{
	private long no;
	private String name;
	private int price;

	
	public Books(long no,String name,int price){
		this.no = no;
		this.name = name;
		this.price = price;
	}
	public void setNo(long no){
		this.no = no;
	}
	public long getNo(){
		return this.no;
	}
	public void setName(String name){
		this.name = name;
	}
	public String getName(){
		return this.name;
	}
	public void setPrice(int price){
		this.price = price;
	}
	public int getPrice(){
		return this.price;
	}

	public String toString(){
		return "Student[no:"+this.no+",name:"+this.name+",price:"+this.price+"]";
	}
}