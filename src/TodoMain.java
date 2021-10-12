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
	    	 int number = 0;
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
	        	TodoUtil.list_compAll(l,1);
	        	break;
	         
	         case "comp":
	        	number = sc.nextInt();
	        	TodoUtil.completeItem(l, number);
	        	break;
	        
	         case "imp":
		        number = sc.nextInt();
		        TodoUtil.importantItem(l, number);
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
	        	
	         case "achi":
	         	TodoUtil.showAchievement(l);
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
	        	Gson gson = new Gson();
	   	        String jsonstr = gson.toJson(l.getList());
	   	        String output_filename;
	        	String store_check;
	        	System.out.println("������ ���� ����� �����Ͻðڽ��ϱ�? (Y/N)");
	        	store_check = sc.next();
	        	if(store_check.equalsIgnoreCase("Y")) {
	        		System.out.println("���� ������ ������ ���ϸ��� �Է��ϼ��� : ");
	      	      	output_filename = sc.next();
	        	}
	        	else {
	        		output_filename = "todolist_21800777.txt";
	        	}
	        	try {
	  	    	  FileWriter writer = new FileWriter(output_filename);
	  	    	  writer.write(jsonstr);
	  	    	  writer.close();
	  	    	  System.out.println("Json�� ���� ���Ͽ� ����Ǿ����ϴ�!");
		  	    } catch (IOException e) {
		  	    	  e.printStackTrace();
		  	    }
	        	
	        	System.out.println("�ý����� �����մϴ�.");
	            quit = true;
	            break;

	         default:
	            System.out.println("�ش� ����� ��ȿ���� �ʽ��ϴ� - ����(help)");
	            break;
	         }
	         
	         if(isList) TodoUtil.listAll(l);
	      } while (!quit);
	}
}
