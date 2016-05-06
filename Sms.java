package Sxc008;

import java.util.Scanner;
/**
	ͼ����Ϣ����ϵͳ
	����ͼ����Ϣ�ģ���ɾ�Ĳ飩
	����ͼ����Ϣ���浽���	ͼ�����
	���е�ͼ����Ϣ���浽���	������
*/
public class Sms{
	private Books[] boos = new Books[3];//���ڱ���ͼ�����
	private int index;	//��¼������ʵ��ͼ��ı���

	/**
	 * ���ͼ����Ϣ
	   save 
	     boos[0] = boo;  index = 1
		 boos[1] = boo;  index = 2
		 boos[2] = boo;	 index = 3
		 boos[3]
	 */
	public void save(Books books){
		if(index >= boos.length){
			//�������չ
			Books[] demo = new Books[boos.length+3];
			System.arraycopy(boos,0,demo,0,index);
			boos = demo;
		}
		boos[index++] = books;
	}

    /**
	 *�޸�ͼ����Ϣ
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
	 *ɾ��ͼ����Ϣ
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
	 *��ѯ����ͼ����Ϣ
	 */
	public Books[] queryAll(){
		Books[] demo = new Books[index];
		System.arraycopy(boos,0,demo,0,index);
		return demo;
	}

	/**
	 *ͨ��id����ͼ����Ϣ

	 */
	public Books queryByNo(long no){
		int num = getIndexByNo(no);
		return num==-1?null:boos[num];
	}

	/**
	 ����ͼ������id��ȡ��ͼ������������е�����
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
	 * �˵�
  	 */
	public void menu(){
		System.out.println("********ͼ����Ϣ����ϵͳ********");
		System.out.println("*1 ��ѯ����ͼ����Ϣ");
		System.out.println("*2 ¼��ͼ����Ϣ");
		System.out.println("*3 ɾ��ͼ����Ϣ");
		System.out.println("*4 ͨ����Ų���ͼ����Ϣ");
		System.out.println("*5 �޸�ͼ����Ϣ");
		System.out.println("*exit �˳�ϵͳ��");
		System.out.println("*help ��ȡ����");
		System.out.println("********************************");
	}

	public static void main(String[] args){
		Sms sms = new Sms();
		sms.menu();
		//ɨ��������
		Scanner sc = new Scanner(System.in);
		while(true){
			System.out.print("*�������Ӧָ��:");
			String option = sc.nextLine();
			switch(option){
				case "1":	//��ѯ����
					System.out.println("����������ͼ�����Ϣ��");
					Books[] boos = sms.queryAll();
					for(Books boo : boos){
						System.out.println(boo);
					}
					System.out.println("�ܹ���ѯ��"+sms.index+"��ͼ��");
					break;
				case "2":	//¼��
					while(true){
						System.out.println("������ͼ�����Ϣ��no#name#price�������롾break��������һ��Ŀ¼");
						String booStr = sc.nextLine();
						if(booStr.equals("break")){
							break;//���ص���һ��Ŀ¼
						}
						//comStr 1001#Cdp#12�ַ��� ->����->����
						String[] booArr = booStr.split("#");
						//�������и�Ԫ��ת��Ϊͼ����������Ҫ����������
						long no  = Long.parseLong(booArr[0]);
						String name = booArr[1];
						int price = Integer.parseInt(booArr[2]);
						//��װ����
						Books boo = new Books(no,name,price);
						sms.save(boo);
						System.out.println("����ɹ���");
					}
					break;
				case "3":	//ɾ��
					while(true){
						System.out.println("ͼ��ı��,��������break������һ��Ŀ¼");
						String noStr = sc.nextLine();
						if(noStr.equals("break")){
							break;
						}
						long no = Long.parseLong(noStr);
						//��ѯҪɾ����ͼ����Ϣ�Ƿ����
						Books boo = sms.queryByNo(no);
						if(boo==null){
							System.out.println("��Ҫɾ����ͼ����Ϣ�����ڣ�");
							continue;
						}
						sms.deleteByNo(no);
						System.out.println("ɾ���ɹ���");
					}	
					break;
				case "4":	//ͨ��id��ȡ
					while(true){
						System.out.println("������Ҫ����ͼ���id,��������break������һ��Ŀ¼");
						String noStr = sc.nextLine();
						if(noStr.equals("break")){
							break;
						}
						long no = Long.parseLong(noStr);
						Books boo = sms.queryByNo(no);
						System.out.println(boo==null?"sorry,not found!":boo);
					}	
					break;
				case "5":	//�޸�
					while(true){
						System.out.println("������Ҫ�޸�ͼ��ı��,��������break������һ��Ŀ¼");
						String noStr = sc.nextLine();
						if(noStr.equals("break")){
							break;
						}
						long no = Long.parseLong(noStr);
						//��ѯҪɾ����ͼ����Ϣ�Ƿ����
						Books boo = sms.queryByNo(no);
						if(boo==null){
							System.out.println("��Ҫ�޸ĵ�ͼ����Ϣ�����ڣ�");
							continue;
						}
						System.out.println("ԭ��ϢΪ��"+boo);
						System.out.println("����������Ϣ��name#price����");
						// Sxc#12
						String str = sc.nextLine();
						String[] booArr = str.split("#");
						String name = booArr[0];
						int price = Integer.parseInt(booArr[1]);
						Books newBoo = new Books(no,name,price);
						sms.update(newBoo);
						System.out.println("�޸ĳɹ���");
					}	
					break;
				case "exit":
					System.out.println("bye bye,��ӭ�ٴ�ʹ�ã�");
					System.exit(0);
				case "help":
					sms.menu();
					break;
				default:
					System.out.println("�������");

			}
		}
	}
}