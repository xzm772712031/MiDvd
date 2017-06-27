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
		dvds[0] = new DVDSet("�������", 1, "�ѽ��", "2013-7-1", 1);
		dvds[1] = new DVDSet("�������", 2, "δ���", "", 0);
		dvds[2] = new DVDSet("��������", 3, "δ���", "", 0);
	}
	public void startMenu() { 
		
		System.out.println("��ӭʹ������DVD������");
		System.out.println("------------------------------");
		System.out.println("0.������а�");
		System.out.println("1.����DVD");
		System.out.println("2.�鿴DVD");
		System.out.println("3.ɾ��DVD");
		System.out.println("4.���DVD");
		System.out.println("5.�黹DVD");
		System.out.println("6.�˳�DVD");
		System.out.println("------------------------------");
		System.out.print("��ѡ��");
		int choice = 0;
        choice = input.nextInt();
		switch (choice) {
		case 0:
			System.out.println("---������а�");
			/*list();*/
			returnMain();
			break;
		case 1:
			System.out.println("---����DVD");
			add();
			returnMain();
			break;
		case 2:
			System.out.println("---�鿴DVD");
			searchdvd();
			returnMain();
			break;
		case 3:
			System.out.println("---ɾ��DVD");
			deleteDvd();
			returnMain();
			break;
		case 4:
			System.out.println("---���DVD");
			rent();
			returnMain();
			break;
		case 5:
			System.out.println("---�黹DVD");
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
		System.out.print("����0���أ�");
		int choice = input.nextInt();
		if (choice == 0) {
			startMenu();
		}
	}
	public void returnDvd() {
		String name ="";
		long zuji = 0;
		System.out.print("������DVD���ƣ�");
		
			name = input.nextLine();
		
			
		for (DVDSet dvdset : dvds)
			if (dvdset == null) {
				break;
			} else if (dvdset.getName().equals(name)) {
				System.out.println("������黹����");
				String date = input.nextLine();
				dvdset.setState("δ���");
				zuji = datecharge(dvdset.getDate(), date);
				System.out.println("\n�黹" + name + "�ɹ�!");
				System.out.println("�������Ϊ��" + dvdset.getDate());
				System.out.println("�黹����Ϊ��" + date);
				System.out.println("Ӧ�����Ԫ����" + zuji);
				break;
			} else {
				System.out.println("��DVDû�б�������޷����й黹������");
				break;
			}
	}
	public void deleteDvd() {
		System.out.println("������Ҫɾ����DVD����:");
		int index = -1;
		String delName = input.next();
		for (int i = 0; i < dvds.length; i++) {
			
			if(dvds[i]==null) {
				System.out.println("��DVD�����ڡ�");
				break;
			}
			else {
			if (dvds[i].getName().equals(delName)) {
				if (dvds[i].getState().equals("�ѽ��")) {
					System.out.println("��DVD�Ѿ���������޷�ɾ����");
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
			System.out.println("ɾ��" + delName + "�ɹ���");
		}
		returnMain();
	}
	public void rent() {
		System.out.print("������DVD���ƣ�");
		String name = input.nextLine();
		for (DVDSet dvdset : dvds)
			if (dvdset == null) {
				break;
			} else if (dvdset.getName().equals(name)) {
				if (dvdset.getState().equals("δ���")) {
					System.out.println("������������");
					String date = input.nextLine();
					dvdset.setState("�ѽ��");
					dvdset.setDate(date);
					count++;
					dvdset.setCount(count);
				} else {
					System.out.println("��DVD�ѽ��");
				}
			}else {
				System.out.println("�����ڸ�DVD");
			}
	}
	public void searchdvd() {
		System.out.println("���\t״̬\t����\t�������\t");
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
			System.out.print("\n������DVD���ƣ�");
			String name = input.next();
			for (int i = 0; i < dvds.length; i++) {
				if (dvds[i] == null) {
					break;
				} 
				
				
				else {	
						int id = (index + 1);
						String state = "δ���";
						String date = "";
						int count = 0;
						dvds[index] = new DVDSet(name, id, state, date, count);	
					}
				}
		} else {
			System.out.println("�ֿ�����");
		}
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
