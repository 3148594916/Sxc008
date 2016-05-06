package Sxc008;

import java.util.Scanner;
/**
	图书信息管理系统
	管理图书信息的（增删改查）
	单个图书信息保存到哪里？	图书对象
	所有的图书信息保存到哪里？	数组中
*/
public class Sms{
	private Books[] boos = new Books[3];//用于保存图书对象
	private int index;	//记录数组中实际图书的本数

	/**
	 * 添加图书信息
	   save 
	     boos[0] = boo;  index = 1
		 boos[1] = boo;  index = 2
		 boos[2] = boo;	 index = 3
		 boos[3]
	 */
	public void save(Books books){
		if(index >= boos.length){
			//数组的扩展
			Books[] demo = new Books[boos.length+3];
			System.arraycopy(boos,0,demo,0,index);
			boos = demo;
		}
		boos[index++] = books;
	}

    /**
	 *修改图书信息
	 ords = {
		1001 Sxc,
		1003 Sxc3,
		1004 Sxc4,
		1005 Sxc5,
		1006 Sxc6,
		null
	 }
		1006 Sxc
	 */
	public void update(Books books){
		for(int i=0;i<index;i++){
			if(books.getNo() == boos[i].getNo()){
				boos[i].setName(books.getName());
			}
		}
	}

	/**
	 *删除图书信息
	 boos = new Books[6];
	 boos = {
		1001 Sxc,
		1003 Sxc3,
		1004 Sxc4,
		1005 Sxc5,
		1006 Sxc6,
		null
	 }
	 index = 6;
	 1002    num = 1;
	 for(int i=1;i<5;i++){
		boos[i] = boos[i+1]
		//boos[4] = boos[5]

	 }
	 */
    public void deleteByNo(long no){
		int num = getIndexByNo(no);
		for(int i=num ;i<index-1;i++){
			boos[i] = boos[i+1];
		}
		boos[--index] = null;
	}

	/**
	 *查询所有图书信息
	 */
	public Books[] queryAll(){
		Books[] demo = new Books[index];
		System.arraycopy(boos,0,demo,0,index);
		return demo;
	}

	/**
	 *通过id查找图书信息

	 */
	public Books queryByNo(long no){
		int num = getIndexByNo(no);
		return num==-1?null:boos[num];
	}

	/**
	 根据图书对象的id获取该图书对象在数组中的索引
	 boos = new Books[3];
	 1001 Sxc
	 1002 Sxc
	 null 

	 1003
	*/
	private int getIndexByNo(long no){
		int num = -1;
		for(int i=0;i<index;i++){
			if(boos[i].getNo() == no){
				num = i;
				break;
			}
		}
		return num;
	}

	/**
	 * 菜单
  	 */
	public void menu(){
		System.out.println("********图书信息管理系统********");
		System.out.println("*1 查询所有图书信息");
		System.out.println("*2 录入图书信息");
		System.out.println("*3 删除图书信息");
		System.out.println("*4 通过编号查找图书信息");
		System.out.println("*5 修改图书信息");
		System.out.println("*exit 退出系统！");
		System.out.println("*help 获取帮助");
		System.out.println("********************************");
	}

	public static void main(String[] args){
		Sms sms = new Sms();
		sms.menu();
		//扫描器对象
		Scanner sc = new Scanner(System.in);
		while(true){
			System.out.print("*请输入对应指令:");
			String option = sc.nextLine();
			switch(option){
				case "1":	//查询所有
					System.out.println("以下是所有图书的信息：");
					Books[] boos = sms.queryAll();
					for(Books boo : boos){
						System.out.println(boo);
					}
					System.out.println("总共查询到"+sms.index+"本图书");
					break;
				case "2":	//录入
					while(true){
						System.out.println("请输入图书的信息【no#name#price】或输入【break】返回上一级目录");
						String booStr = sc.nextLine();
						if(booStr.equals("break")){
							break;//返回到上一级目录
						}
						//comStr 1001#Cdp#12字符串 ->对象->数组
						String[] booArr = booStr.split("#");
						//将数组中个元素转换为图书属性所需要的数据类型
						long no  = Long.parseLong(booArr[0]);
						String name = booArr[1];
						int price = Integer.parseInt(booArr[2]);
						//封装对象
						Books boo = new Books(no,name,price);
						sms.save(boo);
						System.out.println("保存成功！");
					}
					break;
				case "3":	//删除
					while(true){
						System.out.println("图书的编号,或者输入break返回上一级目录");
						String noStr = sc.nextLine();
						if(noStr.equals("break")){
							break;
						}
						long no = Long.parseLong(noStr);
						//查询要删除的图书信息是否存在
						Books boo = sms.queryByNo(no);
						if(boo==null){
							System.out.println("您要删除的图书信息不存在！");
							continue;
						}
						sms.deleteByNo(no);
						System.out.println("删除成功！");
					}	
					break;
				case "4":	//通过id获取
					while(true){
						System.out.println("请输入要查找图书的id,或者输入break返回上一级目录");
						String noStr = sc.nextLine();
						if(noStr.equals("break")){
							break;
						}
						long no = Long.parseLong(noStr);
						Books boo = sms.queryByNo(no);
						System.out.println(boo==null?"sorry,not found!":boo);
					}	
					break;
				case "5":	//修改
					while(true){
						System.out.println("请输入要修改图书的编号,或者输入break返回上一级目录");
						String noStr = sc.nextLine();
						if(noStr.equals("break")){
							break;
						}
						long no = Long.parseLong(noStr);
						//查询要删除的图书信息是否存在
						Books boo = sms.queryByNo(no);
						if(boo==null){
							System.out.println("您要修改的图书信息不存在！");
							continue;
						}
						System.out.println("原信息为："+boo);
						System.out.println("请输入新信息【name#price】：");
						// Sxc#12
						String str = sc.nextLine();
						String[] booArr = str.split("#");
						String name = booArr[0];
						int price = Integer.parseInt(booArr[1]);
						Books newBoo = new Books(no,name,price);
						sms.update(newBoo);
						System.out.println("修改成功！");
					}	
					break;
				case "exit":
					System.out.println("bye bye,欢迎再次使用！");
					System.exit(0);
				case "help":
					sms.menu();
					break;
				default:
					System.out.println("输入错误！");

			}
		}
	}
}