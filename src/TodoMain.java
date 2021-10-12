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
	    	 System.out.print("실행할 명령을 입력하세요  >");
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
	        	System.out.println("제목순으로 정렬하였습니다.");
	        	TodoUtil.listAll(l, "title", 1);
	        	break;

	         case "ls_name_desc":
	        	System.out.println("제목역순으로 정렬하였습니다.");
		        TodoUtil.listAll(l, "title", 0);
		        break;
	            
	         case "ls_date":
	        	System.out.println("날짜순으로 정렬하였습니다.");
		        TodoUtil.listAll(l, "due_date", 1);
		        break;
	           
	         case "ls_date_desc":
	        	System.out.println("날짜역순으로 정렬하였습니다.");
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
	        	System.out.println("파일을 새로 만들어 저장하시겠습니까? (Y/N)");
	        	store_check = sc.next();
	        	if(store_check.equalsIgnoreCase("Y")) {
	        		System.out.println("새로 저장할 파일의 파일명을 입력하세요 : ");
	      	      	output_filename = sc.next();
	        	}
	        	else {
	        		output_filename = "todolist_21800777.txt";
	        	}
	        	try {
	  	    	  FileWriter writer = new FileWriter(output_filename);
	  	    	  writer.write(jsonstr);
	  	    	  writer.close();
	  	    	  System.out.println("Json을 통해 파일에 저장되었습니다!");
		  	    } catch (IOException e) {
		  	    	  e.printStackTrace();
		  	    }
	        	
	        	System.out.println("시스템을 종료합니다.");
	            quit = true;
	            break;

	         default:
	            System.out.println("해당 명령은 유효하지 않습니다 - 도움말(help)");
	            break;
	         }
	         
	         if(isList) TodoUtil.listAll(l);
	      } while (!quit);
	}
}
