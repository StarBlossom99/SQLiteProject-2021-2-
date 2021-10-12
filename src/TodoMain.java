import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import com.google.gson.Gson;


public class TodoMain {
	public static void start() throws IOException{
		
		  Scanner sc = new Scanner(System.in);
	      TodoList l = new TodoList();

	      boolean isList = false;
	      boolean quit = false;
	      Menu.displaymenu();
	      do {
	    	 System.out.print("������ ����� �Է��ϼ���  >");
	         isList = false;
	         String choice = sc.next();
	         
	         switch (choice) {

	         case "add":
	            TodoUtil.createItem(l);
	            break;
	         
	         case "del":
	            TodoUtil.deleteItem(l);
	            break;
	            
	         case "edit":
	            TodoUtil.updateItem(l);
	            break;
	            
	         case "ls":
	            TodoUtil.listAll(l);
	            break;
	            
	         case "ls_comp":
	        	TodoUtil.listAll(l,1);
	        	break;
	         
	         case "comp":
	        	int number = sc.nextInt();
	        	TodoUtil.completeItem(l, number);
	        	break;
	        	
	         case "ls_name":
	        	System.out.println("��������� �����Ͽ����ϴ�.");
	        	TodoUtil.listAll(l, "title", 1);
	        	break;

	         case "ls_name_desc":
	        	System.out.println("���񿪼����� �����Ͽ����ϴ�.");
		        TodoUtil.listAll(l, "title", 0);
		        break;
	            
	         case "ls_date":
	        	System.out.println("��¥������ �����Ͽ����ϴ�.");
		        TodoUtil.listAll(l, "due_date", 1);
		        break;
	           
	         case "ls_date_desc":
	        	System.out.println("��¥�������� �����Ͽ����ϴ�.");
		        TodoUtil.listAll(l, "due_date", 0);
		        break;
		        	
	         case "help":
	        	Menu.prompt();
	        	break;
	         
	         case "find":
	        	String keyword = sc.nextLine().trim();
	        	TodoUtil.findList(l, keyword);
	        	break;
	        	
	         case "find_cate":
	        	String cate = sc.nextLine().trim();
	        	TodoUtil.findCateList(l, cate);
	        	break;
	        	
	         case "ls_cate":
			    TodoUtil.listCateAll(l);
			    break;
			       	
	         case "exit":
	        	System.out.println("�ý����� �����մϴ�.");
	            quit = true;
	            break;

	         default:
	            System.out.println("�ش� ����� ��ȿ���� �ʽ��ϴ� - ����(help)");
	            break;
	         }
	         
	         if(isList) TodoUtil.listAll(l);
	      } while (!quit);
	      
	      Gson gson = new Gson();
	      String jsonstr = gson.toJson(l.getList());
	      
	      try {
	    	  FileWriter writer = new FileWriter("21800777.txt");
	    	  writer.write(jsonstr);
	    	  writer.close();
	    	  System.out.println("Json�� ���� ���Ͽ� ����Ǿ����ϴ�!");
	      } catch (IOException e) {
	    	  e.printStackTrace();
	      }
	}
}
