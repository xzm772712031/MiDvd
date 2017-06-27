import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
public class DVDMgr {
	int i;
	int count = 0;
	DVDSet dvds[] = new DVDSet[4];
	Scanner input = new Scanner(System.in);
	public void initial() {
		dvds[0] = new DVDSet("罗马假日", 1, "已借出", "2013-7-1", 1);
		dvds[1] = new DVDSet("风声鹤唳", 2, "未借出", "", 0);
		dvds[2] = new DVDSet("浪漫满屋", 3, "未借出", "", 0);
	}
	public void startMenu() { 
		
		System.out.println("欢迎使用迷你DVD管理器");
		System.out.println("------------------------------");
		System.out.println("0.借出排行榜");
		System.out.println("1.新增DVD");
		System.out.println("2.查看DVD");
		System.out.println("3.删除DVD");
		System.out.println("4.借出DVD");
		System.out.println("5.归还DVD");
		System.out.println("6.退出DVD");
		System.out.println("------------------------------");
		System.out.print("请选择：");
		int choice = 0;
        choice = input.nextInt();
		switch (choice) {
		case 0:
			System.out.println("---借出排行榜");
			list();
			returnMain();
			break;
		case 1:
			System.out.println("---新增DVD");
			add();
			returnMain();
			break;
		case 2:
			System.out.println("---查看DVD");
			searchdvd();
			returnMain();
			break;
		case 3:
			System.out.println("---删除DVD");
			deleteDvd();
			returnMain();
			break;
		case 4:
			System.out.println("---借出DVD");
			rent();
			returnMain();
			break;
		case 5:
			System.out.println("---归还DVD");
			returnDvd();
			returnMain();
			break;
		case 6:
			returnMain();
			break;
		default:
			break;
		}}
	
	public void returnMain() {
		System.out.print("输入0返回：");
		int choice = input.nextInt();
		if (choice == 0) {
			startMenu();
		}
	}
	public void returnDvd() {
		String name ="";
		long zuji = 0;
		System.out.print("请输入DVD名称：");
		
			name = input.nextLine();
		
			
		for (DVDSet dvdset : dvds)
			if (dvdset == null) {
				break;
			} else if (dvdset.getName().equals(name)) {
				System.out.println("请输入归还日期");
				String date = input.nextLine();
				dvdset.setState("未借出");
				zuji = datecharge(dvdset.getDate(), date);
				System.out.println("\n归还" + name + "成功!");
				System.out.println("借出日期为：" + dvdset.getDate());
				System.out.println("归还日期为：" + date);
				System.out.println("应付租金（元）：" + zuji);
				break;
			} else {
				System.out.println("该DVD没有被借出！无法进行归还操作。");
				break;
			}
	}
	public void deleteDvd() {
		System.out.println("请输入要删除的DVD名称:");
		int index = -1;
		String delName = input.next();
		for (int i = 0; i < dvds.length; i++) {
			
			if(dvds[i]==null) {
				System.out.println("该DVD不存在。");
				break;
			}
			else {
			if (dvds[i].getName().equals(delName)) {
				if (dvds[i].getState().equals("已借出")) {
					System.out.println("该DVD已经被借出，无法删除。");
					break;
				}
				index = i;
				break;
			}}
		}
		if (index != -1) {
			for (int i = index; i < dvds.length; i++) {
				if (i < dvds.length - 1) {
					
					dvds[i] = dvds[i + 1];
				} else {
					dvds[i] = null;
				}
			}
			System.out.println("删除" + delName + "成功！");
		}
		returnMain();
	}
	public void rent() {
		System.out.print("请输入DVD名称：");
		String name = input.nextLine();
		for (DVDSet dvdset : dvds)
			if (dvdset == null) {
				break;
			} else if (dvdset.getName().equals(name)) {
				if (dvdset.getState().equals("未借出")) {
					System.out.println("请输入借出日期");
					String date = input.nextLine();
					dvdset.setState("已借出");
					dvdset.setDate(date);
					count++;
					dvdset.setCount(count);
				} else {
					System.out.println("该DVD已借出");
				}
			}else {
				System.out.println("不存在该DVD");
			}
	}
	public void searchdvd() {
		System.out.println("序号\t状态\t名称\t借出日期\t");
		for (DVDSet dvdset : dvds)
			if (dvdset == null) {
				break;
			} else {
				System.out.println(
						dvdset.getId() + "\t" + dvdset.getState() + "\t" + dvdset.getName() + "\t" + dvdset.getDate());
			}
	}
	public void add() {
		int index = -1;
		for (int i = 0; i < dvds.length; i++) {
			if (dvds[i] == null) {
				index = i;
				break;
			} else {
				
			}
		}
		if (index != -1) {
			System.out.print("\n请输入DVD名称：");
			String name = input.next();
			for (int i = 0; i < dvds.length; i++) {
				if (dvds[i] == null) {
					break;
				} 
				
				
				else {	
						int id = (index + 1);
						String state = "未借出";
						String date = "";
						int count = 0;
						dvds[index] = new DVDSet(name, id, state, date, count);	
					}
				}
		} else {
			System.out.println("仓库已满");
		}
	}
	public void list() {
		String[] listname = new String[50];
		int[] listcount = new int[50];
		for (i = 0; i < dvds.length; i++) {
			if (dvds[i] == null) {
				break;
			} else {
				listname[i] = dvds[i].getName();
				listcount[i] = dvds[i].getCount();
			}
		}
		for (int i = 0; i < listname.length; i++) {
			for (int j = i + 1; j < listname.length; j++) {
				if (listcount[i] > listcount[j]) {
					int tempc = listcount[i];
					listcount[i] = listcount[j];
					listcount[j] = tempc;
					String temp = listname[i];
					listname[i] = listname[j];
					listname[j] = temp;
				}
			}
		}
		System.out.println("---> 排行榜\n");
		System.out.println("**************************");
		System.out.println("次数\t名称");
		for (int i = listname.length - 1; i >= 0; i--) {
			if (listname[i] != null) {
				System.out.println(listcount[i] + "\t<<" + listname[i] + ">>");
			}
		}
		returnMain();
	}
	public long datecharge(String dstr1, String dstr2) {
		long charge = 0;
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date d1 = sd.parse(dstr1);
			Date d2 = sd.parse(dstr2);
			charge = (d2.getTime() - d1.getTime()) / (24 * 60 * 60 * 1000);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return charge;
	}
}
