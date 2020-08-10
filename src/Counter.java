import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Counter class contains of readfile method to sums the datas value read from a file and count
 * how many values have been read.
 * 
 * @author KongtappV
 *
 */
public class Counter {
	
	private int count = 0;
	private double total = 0;
	
	/**
	 * read file and sums data values read from a file and counts how many values have been read.
	 * data is read in each line of the file if line is start with "#" that line doesn't count
	 * and if blank line that line doesn't count
	 * 
	 * @param filename string of the filename you want to read
	 */
	public void readfile(String filename) {
		File file = new File(filename);
        if (!file.exists() || !file.isFile()) {
        	System.out.println("File not found: " + filename);
        	System.exit(1);        	
        }
        
        try {
			Scanner sc = new Scanner(file);
			while (sc.hasNextLine()) {
				String line = sc.nextLine();
				if (line.isEmpty() || line.contains("#")) {
					continue;
				} else {
					double num = Double.parseDouble(line);
					count++;
					total += num;					
				}
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
        
	}
	
	/**
	 * return the number of data value from readfile.
	 * @return count the number of data in file
	 */
	public int getCount() {
		return count;
	}
	
	/**
	 * return the total value of data from readfile
	 * @return total sum of all data in file
	 */
	public double getTotal() {
		return total;		
	}
	
}
