package assign1;

public class Assign1 {
	
	public static void main(String[] args) {
		Menu menu = new Menu();
		FileUtils file = new FileUtils();
		
		file.openFile();
		menu.menu();
		file.closeFile();

    }//end main
}
