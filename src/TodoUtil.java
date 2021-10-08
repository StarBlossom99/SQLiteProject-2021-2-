import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class TodoUtil {
	
	public static void listAll(TodoList l) {
		System.out.printf("[��ü ���, �� %d��]\n", l.getCount());
		for(TodoItem item : l.getList()) {
			System.out.println(item.toString());
		}
		
	}
	
	public static void createItem(TodoList l) {
		String title, desc, category, due_date;
		Scanner sc = new Scanner(System.in);
		
		System.out.print("[�׸� �߰�]\n" + "���� > ");
		title = sc.next();
		
		if(l.isDuplicate(title)) {
			System.out.println("������ �ߺ��˴ϴ�!");
			return;
		}
		
		System.out.print("ī�װ� > ");
		category = sc.next();
		sc.nextLine();
		System.out.print("���� > ");
		desc = sc.nextLine();
		System.out.print("�������� > ");
		due_date = sc.nextLine().trim();
		
		TodoItem t = new TodoItem(title, desc, category, due_date);
		if(l.addItem(t) > 0) {
			System.out.println("�߰��Ǿ����ϴ�.");
		}
	}
	
	public static void updateItem(TodoList l) {
		String new_title, new_desc, new_category, new_due_date;
		Scanner sc = new Scanner(System.in);
		
		System.out.print("[�׸� ����]\n" + "������ �׸��� ��ȣ�� �Է��Ͻÿ� > ");
		int index = sc.nextInt();
		
		System.out.print("�� ���� > ");
		new_title = sc.next().trim();
		
		System.out.print("�� ī�װ� > ");
		new_category = sc.next();
		sc.nextLine();
		System.out.print("�� ���� > ");
		new_desc = sc.nextLine().trim();
		System.out.print("�� �������� > ");
		new_due_date = sc.nextLine().trim();
		
		TodoItem t = new TodoItem(new_title, new_desc, new_category, new_due_date);
		t.setId(index);

		if(l.updateItem(t)>0) {
			System.out.println("�����Ǿ����ϴ�.");
		}
	}
	
	public static void deleteItem(TodoList l) {
		Scanner sc = new Scanner(System.in);
		System.out.print("[�׸� ����]\n" + "������ �׸��� ��ȣ�� �Է��Ͻÿ� > ");
		
		int index = sc.nextInt();
		if(l.deleteItem(index)>0) {
			System.out.println("�����Ǿ����ϴ�.");
		}
	}
	
	public static void findList(TodoList l, String keyword) {
		int count = 0;
		for(TodoItem item : l.getList(keyword)) {
			System.out.println(item.toString());
			count ++;
		}
		System.out.printf("�� %d���� �׸��� ã�ҽ��ϴ�.\n",count);
	}
	
	public static void findCateList(TodoList l, String cate) {
		int count = 0;
		for(TodoItem item : l.getListCategory(cate)) {
			System.out.println(item.toString());
			count ++;
		}
		System.out.printf("\n�� %d���� �׸��� ã�ҽ��ϴ�.\n",count);
	}
	
	public static void listCateAll(TodoList l) {
		int count = 0;
		for(String item : l.getCategories()) {
			System.out.print(item + " ");
			count ++;
		}
		System.out.printf("\n�� %d���� ī�װ��� ��ϵǾ� �ֽ��ϴ�.\n", count);
	}
	
	public static void listAll(TodoList l, String orderby, int ordering) {
		System.out.printf("[��ü ���, �� %d��]\n", l.getCount());
		for(TodoItem item : l.getOrderedList(orderby, ordering)) {
			System.out.println(item.toString());
		}
	}
	
	public static void listAll(TodoList l, int num) {
		int count = 0;
		for(TodoItem item : l.getList(num)) {
			System.out.println(item.toString());
			count ++;
		}
		System.out.printf("�� %d���� �׸��� ã�ҽ��ϴ�.\n",count);
	}
	
	public static void completeItem(TodoList l, int number) {
		for(TodoItem item : l.getList()) {
			if(item.getId() == number) {
				String new_title = item.getTitle();
				String new_desc = item.getDesc();
				String new_category = item.getCategory();
				String new_due_date = item.getDue_date();
				
				TodoItem t = new TodoItem(new_title, new_desc, new_category, new_due_date);
				t.set_is_completed(1);
				t.setId(number);
				System.out.println(t.toString());
				if(l.completeItem(t)>0) {
					System.out.println("�ش� �׸��� �Ϸ� ó���Ǿ����ϴ�.\n");
				}
				
			}
		}
	}
	
}
