package commandline_todo.com;
import java.util.*;
public class Td{
	static HashMap<Integer, String> todomap=new HashMap<>();
	static int index=1;
	static int complete=0;
	public static void todoAdd(String s){
		todomap.put(index, s);
	}
	public static void todolist(){
		for(int itr=index; itr>=1 ; itr--){
			if(todomap.containsKey(itr)){
				System.out.println("["+itr+"]"+ " "+todomap.get(itr));
			}
		}
	}
	public static void todoDel(int i){
		todomap.remove(i);
		for(int itr=i+1; itr<todomap.size() ; itr++){
			if(todomap.containsKey(itr)){
				todomap.put(itr-1,todomap.get(itr));
			}
		}
	}
	public static void todoDone(int mark){
		todomap.remove(mark);
		for(int itr=mark+1; itr<todomap.size() ; itr++){
			if(todomap.containsKey(itr)){
				todomap.put(itr-1,todomap.get(itr));
			}
		}
		complete++;
		System.out.println("Marked todo #"+mark+" as done");
	}
	public static void todoReport(){
		System.out.println("pending: "+todomap.size()+" Complted: "+complete);
	}
	public static void main(String[] args){
		while(true){
			System.out.print("-> ~/Coronasafe/todo-txt-cli git:(develop) ");
			Scanner sc=new Scanner(System.in);
			String str1=sc.next();
			String str2=sc.next();
			if(str1.equals("./todo") && str2.equals("add")) {
				String str3=sc.next();
				todoAdd(str3);
				System.out.println("Added todo:" + "\""+str3+"\"");
				index++;
			}
			else if(str1.equals("./todo") && str2.equals("ls")) {
				todolist();
			}
			else if(str1.equals("./todo") && str2.equals("del")) {
				String str3=sc.next();
				todoDel(Integer.parseInt(str3));
			}
			else if(str1.equals("./todo") && str2.equals("done")) {
				String str3=sc.next();
				todoDone(Integer.parseInt(str3));
			}
			else if(str1.equals("./todo") && str2.equals("report")) {
				todoReport();
			}
			else if((str1.equals("./todo")) || 
					(str1.equals("./todo") && str2.equals("help"))) {
				System.out.println("Usage:-"+ "\n"+
				"$ ./todo add \"todo item\"\t\t"  +"  # Add a new todo\n"
			   +"$ ./todo ls                 "+"# show remaining todos\n"
			   +"$ ./todo del NUMBER         "+"# Delete a todo\n"
			   +"$ ./todo done NUMBER        "+"# Complete a todo\n"
			   +"$ ./todo help               "+"# show usage\n"
			   +"$ ./todo report             "+"# Statistics\n");
			}
		}
	}
}
