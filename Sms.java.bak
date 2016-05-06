package Cdp008;

import java.util.Scanner;
/**
	商品信息管理系统
	管理商品信息的（增删改查）
	单个商品信息保存到哪里？	商品对象
	所有的商品信息保存到哪里？	数组中
*/
public class Sms{
	private Commodity[] coms = new Commodity[3];//用于保存商品对象
	private int index;	//记录数组中实际商品的个数

	/**
	 * 添加商品信息
	   save 
	     coms[0] = com;  index = 1
		 coms[1] = com;  index = 2
		 coms[2] = com;	 index = 3
		 coms[3]
	 */
	public void save(Commodity commodity){
		if(index >= coms.length){
			//数组的扩展
			Commodity[] demo = new Commodity[coms.length+3];
			System.arraycopy(coms,0,demo,0,index);
			coms = demo;
		}
		coms[index++] = commodity;
	}

    /**
	 *修改商品信息
	 ords = {
		1001 Cdp,
		1003 Cdp3,
		1004 Cdp4,
		1005 Cdp5,
		1006 Cdp6,
		null
	 }
		1006 Cdp
	 */
	public void update(Commodity commodity){
		for(int i=0;i<index;i++){
			if(commodity.getNo() == coms[i].getNo()){
				coms[i].setName(commodity.getName());
			}
		}
	}

	/**
	 *删除商品信息
	 coms = new Commodity[6];
	 coms = {
		1001 Cdp,
		1003 Cdp3,
		1004 Cdp4,
		1005 Cdp5,
		1006 Cdp6,
		null
	 }
	 index = 6;
	 1002    num = 1;
	 for(int i=1;i<5;i++){
		coms[i] = coms[i+1]
		//coms[4] = coms[5]

	 }
	 */
    public void deleteByNo(long no){
		int num = getIndexByNo(no);
		for(int i=num ;i<index-1;i++){
			coms[i] = coms[i+1];
		}
		coms[--index] = null;
	}

	/**
	 *查询所有商品信息
	 */
	public Commodity[] queryAll(){
		Commodity[] demo = new Commodity[index];
		System.arraycopy(coms,0,demo,0,index);
		return demo;
	}

	/**
	 *通过id查找商品信息

	 */
	public Commodity queryByNo(long no){
		int num = getIndexByNo(no);
		return num==-1?null:coms[num];
	}

	/**
	 根据商品对象的id获取该商品对象在数组中的索引
	 coms = new Commodity[3];
	 1001 Cdp
	 1002 cdp
	 null 

	 1003
	*/
	private int getIndexByNo(long no){
		int num = -1;
		for(int i=0;i<index;i++){
			if(coms[i].getNo() == no){
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
		System.out.println("********商品信息管理系统********");
		System.out.println("*1 查询所有商品信息");
		System.out.println("*2 录入商品信息");
		System.out.println("*3 删除商品信息");
		System.out.println("*4 通过编号查找商品信息");
		System.out.println("*5 修改商品信息");
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
					System.out.println("以下是所有商品的信息：");
					Commodity[] coms = sms.queryAll();
					for(Commodity com : coms){
						System.out.println(com);
					}
					System.out.println("总共查询到"+sms.index+"个商品");
					break;
				case "2":	//录入
					while(true){
						System.out.println("请输入商品的信息【no#name#price】或输入【break】返回上一级目录");
						String comStr = sc.nextLine();
						if(comStr.equals("break")){
							break;//返回到上一级目录
						}
						//comStr 1001#Cdp#12字符串 ->对象->数组
						String[] comArr = comStr.split("#");
						//将数组中个元素转换为商品属性所需要的数据类型
						long no  = Long.parseLong(comArr[0]);
						String name = comArr[1];
						int price = Integer.parseInt(comArr[2]);
						//封装对象
						Commodity com = new Commodity(no,name,price);
						sms.save(com);
						System.out.println("保存成功！");
					}
					break;
				case "3":	//删除
					while(true){
						System.out.println("商品的编号,或者输入break返回上一级目录");
						String noStr = sc.nextLine();
						if(noStr.equals("break")){
							break;
						}
						long no = Long.parseLong(noStr);
						//查询要删除的商品信息是否存在
						Commodity com = sms.queryByNo(no);
						if(com==null){
							System.out.println("您要删除的商品信息不存在！");
							continue;
						}
						sms.deleteByNo(no);
						System.out.println("删除成功！");
					}	
					break;
				case "4":	//通过id获取
					while(true){
						System.out.println("请输入要查找商品的id,或者输入break返回上一级目录");
						String noStr = sc.nextLine();
						if(noStr.equals("break")){
							break;
						}
						long no = Long.parseLong(noStr);
						Commodity com = sms.queryByNo(no);
						System.out.println(com==null?"sorry,not found!":com);
					}	
					break;
				case "5":	//修改
					while(true){
						System.out.println("请输入要修改商品的编号,或者输入break返回上一级目录");
						String noStr = sc.nextLine();
						if(noStr.equals("break")){
							break;
						}
						long no = Long.parseLong(noStr);
						//查询要删除的商品信息是否存在
						Commodity com = sms.queryByNo(no);
						if(com==null){
							System.out.println("您要修改的商品信息不存在！");
							continue;
						}
						System.out.println("原信息为："+com);
						System.out.println("请输入新信息【name#price】：");
						// cdp#12
						String str = sc.nextLine();
						String[] comArr = str.split("#");
						String name = comArr[0];
						int price = Integer.parseInt(comArr[1]);
						Commodity newCom = new Commodity(no,name,price);
						sms.update(newCom);
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